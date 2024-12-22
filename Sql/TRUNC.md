TRUNC
===
TRUNC는 주로 소수점 절사 및 날짜의 시간을 없앨 때 사용한다.

```sql
SELECT SYSDATE AS 현재시간,
       TRUNC(SYSDATE) AS 시간절사,
       TRUNC(SYSDATE, 'DD') AS 시간절사2, --TRUNC(SYSDATE)와 동일
       TRUNC(SYSDATE, 'HH24') AS 분초자르기,
       TRUNC(SYSDATE, 'MI') AS 초자르기,
       TRUNC(SYSDATE, 'YEAR') AS 월일초기화, -- TRUNC(SYSDATE, 'YYYY')와 동일
       TRUNC(SYSDATE, 'MM') AS 일초기화, --TRUNC(SYSDATE, 'MONTH')와 동일
       TRUNC(SYSDATE, 'DAY') AS 요일초기화 --해당 주의 일요일로 초기화 
       FROM DUAL;
```
```sql
--숫자 절사
SELECT 1234.567 AS 주어진수,
       TRUNC(1234.567) AS 소수점절사,
       TRUNC(1234.567, '1') AS 소수점첫째자리절사, -- 기본적으로 반올림하지않는다.
       TRUNC(1234.567, '2') AS 소수점둘째자리절사,
       TRUNC(1234.567, '-1'), -- 1단위절사
       TRUNC(1234.567, '-2'), -- 10단위절사
       TRUNC(1234.567, '-3') -- 100단위절사 
       FROM DUAL;
```