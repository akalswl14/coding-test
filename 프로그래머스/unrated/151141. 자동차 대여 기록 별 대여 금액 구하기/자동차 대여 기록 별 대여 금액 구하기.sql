WITH T AS (
    SELECT 
    history.HISTORY_ID, 
    car.CAR_TYPE, 
    CASE 
        WHEN TIMESTAMPDIFF(DAY, history.START_DATE, history.END_DATE) + 1 < 7 
        THEN null
        WHEN TIMESTAMPDIFF(DAY, history.START_DATE, history.END_DATE) + 1 < 30 
        THEN '7일 이상' 
        WHEN TIMESTAMPDIFF(DAY, history.START_DATE, history.END_DATE) + 1 < 90 
        THEN '30일 이상' 
    ELSE '90일 이상' END AS DURATION_TYPE,
    (car.DAILY_FEE * (TIMESTAMPDIFF(DAY, history.START_DATE, history.END_DATE) + 1)) AS TOTAL_FEE 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS history
    INNER JOIN CAR_RENTAL_COMPANY_CAR AS car ON history.CAR_ID = car.CAR_ID 
    WHERE car.CAR_TYPE = '트럭'
)
SELECT 
    HISTORY_ID, 
    FLOOR(t.TOTAL_FEE * (100 - IFNULL(discount.DISCOUNT_RATE,0)) / 100) AS FEE
FROM T
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS discount 
ON t.CAR_TYPE = discount.CAR_TYPE AND t.DURATION_TYPE = discount.DURATION_TYPE 
ORDER BY FEE DESC, HISTORY_ID DESC; 