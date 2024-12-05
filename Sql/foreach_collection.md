SQL 동적 쿼리
========
```sql
INSERT INTO TB_DC_ERROR(item_id, error_date) VALUES (#{itemlist}, error_date)
```
#{ itemlist }에 배열 형식으로 여러가지 값이 들어가야 함.  
#{ itemlist }의 값만 바뀌면서 값을 넣어야하는데 foreach를 사용하면 해결할 수 있음.  
```sql
<foreach collection="list" item="item" open="(" close=")" separator=",">
    INSERT INTO TB_DC_ERROR (item_id, error_date) VALUES 
    (#{item}, error_date)
</foreach>
```
이렇게 실행한 결과값.
```sql
INSERT INTO TB_DC_ERROR (item_id, error_date) VALUES 
(1, error_date), 
(2, error_date), 
(3, error_date), 
(4, error_date)
```
우선 각 속성들을 살펴 보자.
* collection - 어떠한 리스트, 배열, 문자열 등 컬렉션 값
* item - 반복문에서 각 항목을 나타내는 변수
* open - 반복된 항목들 앞에 추가할 문자열
* close - 반복된 항목들 뒤에 추가할 문자열
* separator - 각 항목 사이에 넣을 구분자를 지정하는 속성
  
```sql
INSERT INTO TB_DC_ERROR (item_id, error_date) VALUES 
(1, error_date), 
(2, error_date), 
(3, error_date), 
(4, error_date)
```
이런 식은 Mysql에서 가능하고 오라클에서는 지원되지 않는 형식이다.  
오라클 형식은 이러함.  
```sql
INSERT ALL
    INTO TB_DC_ERROR (item_id, error_date) VALUES ('1', DATE)
    INTO TB_DC_ERROR (item_id, error_date) VALUES ('2', DATE)
    INTO TB_DC_ERROR (item_id, error_date) VALUES ('3', DATE)
SELECT 1 FROM DUAL;
```
form
====
form으로 제출할 시에 refresh가 될 수 밖에 없다.  
refresh가 되면 다시 돌아갈 경로가 필요함.
form으로 보낸 값은 @modelAttribute로 바인딩 가능하지만 
ajax로 보낸 값은 @RequestBody로 바인딩 해야 함.

error
====
Error creating bean name '...' defined in file  
main -> resources -> properties -> omnione.proeprties   
app.sp-keymanger-path 경로 문제.

직렬화
===
