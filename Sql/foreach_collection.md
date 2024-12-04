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
  
아직 어떤 식으로 구현되는지 완벽히 이해는 못했지만 추후에 더 알게되면 수정.