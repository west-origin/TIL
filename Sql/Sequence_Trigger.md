시퀀스, 트리거
=== 

SEQUENCE란 일련의 숫자를 자동으로 만들어 주는 객체이다.  
TRIGGER란 DB에서 특정 이벤트가 발생했을 때 자동으로 실행되는 프로그램 단위이다.  
이벤트는 데이터의 CRUD등과 같은 데이터 조작 작업에 의해 발생할 수 있다.  

### INSERT 시 자동으로 시퀀스 증가
 - - -
INSERT 할 때마다 SEQ가 증가되어야 할 때,
TRIGGER를 이용하여 자동으로 해당 컬럼에 증가값이 설정 될 수 있도록 한다.  

1. 예제 테이블 생성  
```SQL
CREATE TABLE departments(
    ID              NUMBER(10) NOT NULL,
    DESCRIPTION     VARCHAR(50) NOT NULL
);
ALTER TABLE departments ADD(
    CONSTRAINT dept_pk PRIMARY KEY (ID)
);
```
2. 시퀀스 생성
```SQL
CREATE SEQUENCE dept_seq 
START WITH 1;
INCREMENT BY 1;
```
3. 트리거 생성
```SQL
CREATE OR REPLACE TRIGGER dept_bir
-- 기존에 같은 이름을 가진 트리거가 있다면 그것을 덮어쓰고, 없으면 새로 생성.
BEFORE INSERT ON departments
-- 트리거는 INSERT 작업이 departments 테이블에 수행되기 전에 실행. 즉, 데이터가 실제로 삽입되기 전에 트리거가 발동.
FOR EACH ROW
-- 이 트리거는 행 단위로 실행. 즉, departments 테이블에 여러 행이 한 번에 삽입될 경우, 각 행에 대해 이 트리거가 한 번씩 실행.
BEGIN --BEGIN ... END 트리거의 실행할 작업은 BEGIN과 END; 사이에 작성. 이 부분에서 트리거가 실제로 수행할 SQL 문을 정의.
    SELECT dept_seq.NEXTVAL -- dept_seq객체의 다음 값 ex) ID의 값이 8이었다면 9를 선택
    INTO :NEW.id -- new.id에 dept_seq.NEXTVAL 값을 into로 할당.
    FROM dual;
END;
/
```
트리거 에러 확인
```sql
SELECT *
FROM user_errors
WHERE name='...'
```
트리거가 유효한 상태인지 확인
```sql
SELECT trigger_name, status
FROM user_triggers
WHERE trigger_name = 'trg_tb_dc_categories_id'
```
시퀀스가 제대로 존재하는지 확인
```sql
SELECT sequnce_name
FROM user_sequences
WHERE sequnce_name ='...'
```



