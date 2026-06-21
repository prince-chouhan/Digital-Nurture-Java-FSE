USE BankingSystem;

BEGIN
    FOR rec IN (
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate - 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Discount applied to CustomerID: ' || rec.CustomerID ||
            ', LoanID: ' || rec.LoanID ||
            ', New Rate: ' || (rec.InterestRate - 1) || '%'
        );
    END LOOP;

    COMMIT;
END;
/

DECLARE
    v_IsVIP BOOLEAN;
BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance
        FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            v_IsVIP := TRUE;
            DBMS_OUTPUT.PUT_LINE(
                'CustomerID: ' || rec.CustomerID ||
                ' is promoted to VIP status. Balance: $' || rec.Balance
            );
        ELSE
            v_IsVIP := FALSE;
        END IF;
    END LOOP;

    COMMIT;
END;
/

BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'REMINDER: Dear ' || rec.Name ||
            ', your Loan (ID: ' || rec.LoanID ||
            ') is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') || '.'
        );
    END LOOP;
END;
/
