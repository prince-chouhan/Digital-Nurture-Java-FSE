USE BankingSystem;

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer (
        p_CustomerID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_DOB        IN DATE,
        p_Balance    IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails (
        p_CustomerID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_DOB        IN DATE
    );

    FUNCTION GetCustomerBalance (
        p_CustomerID IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddNewCustomer (
        p_CustomerID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_DOB        IN DATE,
        p_Balance    IN NUMBER
    ) AS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer ' || p_Name || ' added successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: CustomerID ' || p_CustomerID || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    END AddNewCustomer;

    PROCEDURE UpdateCustomerDetails (
        p_CustomerID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_DOB        IN DATE
    ) AS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: CustomerID ' || p_CustomerID || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Customer ' || p_CustomerID || ' updated successfully.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance (
        p_CustomerID IN NUMBER
    ) RETURN NUMBER AS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;
        RETURN v_Balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: CustomerID ' || p_CustomerID || ' not found.');
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee (
        p_EmployeeID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_Position   IN VARCHAR2,
        p_Salary     IN NUMBER,
        p_Department IN VARCHAR2,
        p_HireDate   IN DATE
    );

    PROCEDURE UpdateEmployeeDetails (
        p_EmployeeID IN NUMBER,
        p_Position   IN VARCHAR2,
        p_Department IN VARCHAR2
    );

    FUNCTION CalculateAnnualSalary (
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_EmployeeID IN NUMBER,
        p_Name       IN VARCHAR2,
        p_Position   IN VARCHAR2,
        p_Salary     IN NUMBER,
        p_Department IN VARCHAR2,
        p_HireDate   IN DATE
    ) AS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee ' || p_Name || ' hired successfully.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: EmployeeID ' || p_EmployeeID || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails (
        p_EmployeeID IN NUMBER,
        p_Position   IN VARCHAR2,
        p_Department IN VARCHAR2
    ) AS
    BEGIN
        UPDATE Employees
        SET Position = p_Position, Department = p_Department
        WHERE EmployeeID = p_EmployeeID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: EmployeeID ' || p_EmployeeID || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Employee ' || p_EmployeeID || ' details updated.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary (
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER AS
        v_MonthlySalary NUMBER;
    BEGIN
        SELECT Salary INTO v_MonthlySalary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;
        RETURN v_MonthlySalary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: EmployeeID ' || p_EmployeeID || ' not found.');
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount (
        p_AccountID   IN NUMBER,
        p_CustomerID  IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_InitBalance IN NUMBER
    );

    PROCEDURE CloseAccount (
        p_AccountID IN NUMBER
    );

    FUNCTION GetTotalBalance (
        p_CustomerID IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount (
        p_AccountID   IN NUMBER,
        p_CustomerID  IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_InitBalance IN NUMBER
    ) AS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_InitBalance, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(
            p_AccountType || ' account (ID: ' || p_AccountID ||
            ') opened for CustomerID ' || p_CustomerID || '.'
        );
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: AccountID ' || p_AccountID || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount (
        p_AccountID IN NUMBER
    ) AS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: AccountID ' || p_AccountID || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Account ' || p_AccountID || ' closed successfully.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
    END CloseAccount;

    FUNCTION GetTotalBalance (
        p_CustomerID IN NUMBER
    ) RETURN NUMBER AS
        v_Total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_Total
        FROM Accounts
        WHERE CustomerID = p_CustomerID;
        RETURN v_Total;
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
            RETURN NULL;
    END GetTotalBalance;

END AccountOperations;
/
