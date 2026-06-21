USE BankingSystem;

CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
) RETURN NUMBER AS
    v_Age NUMBER;
BEGIN
    v_Age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
    RETURN v_Age;
END CalculateAge;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount    IN NUMBER,
    p_InterestRate  IN NUMBER,
    p_DurationYears IN NUMBER
) RETURN NUMBER AS
    v_MonthlyRate NUMBER;
    v_NumPayments NUMBER;
    v_Installment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 100 / 12;
    v_NumPayments := p_DurationYears * 12;

    IF v_MonthlyRate = 0 THEN
        v_Installment := p_LoanAmount / v_NumPayments;
    ELSE
        v_Installment :=
            p_LoanAmount *
            (v_MonthlyRate * POWER(1 + v_MonthlyRate, v_NumPayments)) /
            (POWER(1 + v_MonthlyRate, v_NumPayments) - 1);
    END IF;

    RETURN ROUND(v_Installment, 2);
END CalculateMonthlyInstallment;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount    IN NUMBER
) RETURN NUMBER AS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(
            'ERROR: AccountID ' || p_AccountID || ' not found.'
        );
        RETURN 0;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLERRM);
        RETURN 0;
END HasSufficientBalance;
/
