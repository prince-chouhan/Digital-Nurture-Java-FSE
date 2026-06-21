USE BankingSystem;

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) AS
    v_FromBalance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    IF v_FromBalance < p_Amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_Amount || ' successful.');

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(
            'ERROR: Insufficient funds in AccountID ' || p_FromAccountID ||
            '. Transfer aborted.'
        );
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END SafeTransferFunds;
/

CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) AS
    v_Count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_Count
    FROM Employees
    WHERE EmployeeID = p_EmployeeID;

    IF v_Count = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Salary updated for EmployeeID ' || p_EmployeeID ||
        ' by ' || p_Percentage || '%.'
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(
            'ERROR: EmployeeID ' || p_EmployeeID || ' does not exist.'
        );
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END UpdateSalary;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name       IN VARCHAR2,
    p_DOB        IN DATE,
    p_Balance    IN NUMBER
) AS
    duplicate_customer EXCEPTION;
    PRAGMA EXCEPTION_INIT(duplicate_customer, -1);
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_Name || ' added successfully.');

EXCEPTION
    WHEN duplicate_customer THEN
        DBMS_OUTPUT.PUT_LINE(
            'ERROR: CustomerID ' || p_CustomerID ||
            ' already exists. Insertion aborted.'
        );
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
END AddNewCustomer;
/
