```sql
-- 카테고리 테이블 생성
create table tb_dc_categories(
    category_id number(4) primary key,
    category_name varchar2(50) not null
)
-- 카테고리 테이블 값 확인
select category_id, category_name from tb_dc_categories order by category_id asc
-- 카테고리 테이블에 값 추가
insert into tb_dc_categories (category_name) values ('유지보수');
-- 시퀀스 삭제
drop sequence tb_dc_categories_seq
-- 시퀀스 생성
create sequence tb_dc_categories_seq
    start with 5
    increment by 1
-- 트리거 생성
create or replace trigger trg_tb_dc_categories
before insert on tb_dc_categories
for each row
begin 
    select tb_dc_categories_seq.nextval
    into :new.category_id
    from dual;
end;
/
-- 카테고리 트리거 잘 생성됐나 확인
select *
from user_errors
where name = 'trg_tb_dc_categories'
-- 아이템 테이블 생성
create table tb_dc_check_items(
    item_id number(4) primary key,
    category_id number(4) not null,
    item_description varchar2(50),
    method_id number(4)
)
-- 외래키 지정
alter table tb_dc_check_items
add constraint fk_category_id foreign key (category_id)
references tb_dc_categories(category_id)

-- 시퀀스 생성
create sequence tb_dc_check_items_seq
start with 1
increment by 1
    
-- 트리거 생성
create or replace trigger trg_tb_dc_check_items
before insert on tb_dc_check_items
for each row
begin
    select tb_dc_check_items_seq.nextval
    into :new.item_id
    from dual;
end;
/
-- 아이템 테이블에 값 추가
insert into tb_dc_check_items (category_id) values ()
-- 아이템 수정하기
UPDATE tb_dc_check_items
SET item_description = '오마카세', 
    category_id = 4
WHERE item_id = 22;
--items 전체값 보이기
select * from tb_dc_check_items
select category_id, category_name from tb_dc_categories order by category_id asc
--
delete from tb_dc_check_items where item_id =22
    
CREATE OR REPLACE TRIGGER trg_delete_category
AFTER DELETE ON tb_dc_check_items
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    -- 삭제된 행의 category_id 값이 자식 테이블에 더 남아 있는지 확인
    SELECT COUNT(*) INTO v_count
    FROM tb_dc_check_items
    WHERE category_id = :OLD.category_id;

    -- 만약 더 이상 남아있는 행이 없다면 부모 테이블의 category_id 삭제
    IF v_count = 0 THEN
        DELETE FROM tb_dc_categories
        WHERE category_id = :OLD.category_id;
    END IF;
END;
/
```


