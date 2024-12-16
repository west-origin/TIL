memo
===
jQuery(document).ready(function(){}에 대해서 자세히 공부하기.  

oracle sql
===
시퀀스, 트리거에 대한 공부하기.
```sql
CREATE SEQUENCE tb_dc_categories_seq
START WITH 9        -- 현재 최대값(8) + 1
INCREMENT BY 1      -- 1씩 증가
NOCACHE;            -- 캐시 비활성화 (필요시 변경 가능)
```
```sql
CREATE OR REPLACE TRIGGER trg_tb_dc_categories_id
BEFORE INSERT ON tb_dc_categories
FOR EACH ROW
BEGIN
    IF :NEW.category_id IS NULL THEN
        :NEW.category_id := tb_dc_categories_seq.NEXTVAL;
    END IF;
END;
/
```
안될 경우 확인하는 방법.  
```sql
SELECT * 
FROM USER_ERRORS 
WHERE NAME = 'TRG_TB_DC_CATEGORIES_ID';
```
존재하지 않을 시에 새로 시퀀스 추가.  

