USE BankingSystem;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance      = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Monthly interest of 1% applied to all Savings accounts. ' ||
        SQL%ROWCOUNT || ' account(s) updated.'
    );

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END ProcessMonthlyInterest;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department   IN VARCHAR2,
    p_BonusPercent IN NUMBER
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE(
            'No employees found in department: ' || p_Department
        );
    ELSE
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(
            SQL%ROWCOUNT || ' employee(s) in ' || p_Department ||
            ' received a ' || p_BonusPercent || '% bonus.'
        );
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END UpdateEmployeeBonus;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) AS
    v_SourceBalance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    IF v_SourceBalance < p_Amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance      = Balance - p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_FromAccountID;

    UPDATE Accounts
    SET Balance      = Balance + p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_ToAccountID;

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (transactions_seq.NEXTVAL, p_FromAccountID, SYSDATE, p_Amount, 'Withdrawal');

    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (transactions_seq.NEXTVAL, p_ToAccountID, SYSDATE, p_Amount, 'Deposit');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Transfer of $' || p_Amount ||
        ' from AccountID ' || p_FromAccountID ||
        ' to AccountID ' || p_ToAccountID || ' completed.'
    );

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
            'ERROR: Insufficient balance in AccountID ' || p_FromAccountID || '.'
        );
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: Source account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END TransferFunds;
/
