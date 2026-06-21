USE BankingSystem;

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END UpdateCustomerLastModified;
/

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        AuditID,
        TransactionID,
        AccountID,
        TransactionDate,
        Amount,
        TransactionType,
        LoggedAt
    ) VALUES (
        auditlog_seq.NEXTVAL,
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.TransactionDate,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE
    );
END LogTransaction;
/

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance          NUMBER;
    invalid_deposit    EXCEPTION;
    insufficient_funds EXCEPTION;
BEGIN
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE invalid_deposit;
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_Balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_Balance THEN
            RAISE insufficient_funds;
        END IF;
    END IF;

EXCEPTION
    WHEN invalid_deposit THEN
        RAISE_APPLICATION_ERROR(-20001, 'ERROR: Deposit amount must be positive.');
    WHEN insufficient_funds THEN
        RAISE_APPLICATION_ERROR(-20002, 'ERROR: Withdrawal amount exceeds account balance.');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20003, SQLERRM);
END CheckTransactionRules;
/
