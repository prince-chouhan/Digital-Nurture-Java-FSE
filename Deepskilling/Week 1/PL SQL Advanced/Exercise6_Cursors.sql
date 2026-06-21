USE BankingSystem;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID, c.Name, t.TransactionID,
               t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.CustomerID, t.TransactionDate;

    v_CurrentCustomer NUMBER := -1;
BEGIN
    FOR rec IN GenerateMonthlyStatements LOOP
        IF rec.CustomerID != v_CurrentCustomer THEN
            DBMS_OUTPUT.PUT_LINE('-----------------------------');
            DBMS_OUTPUT.PUT_LINE('Statement for: ' || rec.Name ||
                                 ' (ID: ' || rec.CustomerID || ')');
            DBMS_OUTPUT.PUT_LINE('Month: ' || TO_CHAR(SYSDATE, 'Month YYYY'));
            DBMS_OUTPUT.PUT_LINE('-----------------------------');
            v_CurrentCustomer := rec.CustomerID;
        END IF;

        DBMS_OUTPUT.PUT_LINE(
            TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD') ||
            ' | ' || RPAD(rec.TransactionType, 12) ||
            ' | $' || rec.Amount
        );
    END LOOP;
END;
/

DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE OF Balance;

    v_AnnualFee NUMBER := 50;
BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance      = rec.Balance - v_AnnualFee,
            LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee of $' || v_AnnualFee ||
            ' deducted from AccountID ' || rec.AccountID ||
            '. New Balance: $' || (rec.Balance - v_AnnualFee)
        );
    END LOOP;

    COMMIT;
END;
/

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate
        FROM Loans
        FOR UPDATE OF InterestRate;

    v_NewRate NUMBER;
BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        IF rec.LoanAmount > 10000 THEN
            v_NewRate := 6;
        ELSE
            v_NewRate := 8;
        END IF;

        UPDATE Loans
        SET InterestRate = v_NewRate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE(
            'LoanID ' || rec.LoanID ||
            ': Rate updated from ' || rec.InterestRate ||
            '% to ' || v_NewRate || '%.'
        );
    END LOOP;

    COMMIT;
END;
/
