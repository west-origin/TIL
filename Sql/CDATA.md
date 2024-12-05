\<![CDATA[...]]>
===
쿼리를 작성할 때, '<', '>', '&'를 사용해야하는 경우가 생기는데 xml에서 사용할 경우 태그로 인식하는 경우가 종종 있습니다.  
이럴 경우 에러를 뱉어내기 때문에 '태그가 아니라 실제 쿼리에 필요한 코드'라고 알려줘야 합니다.  
이럴 때 사용하는 것이 \<![CDATA[...]]>입니다.  

```sql
<select id="memberList" resultType="">
    SELECT * 
    FROM member
    WHERE memberId <![CDATA[ < ]]> 5;
</select>
```
에러가 발생하지 않습니다.  하지만 아래와 같이 실행할 경우는 에러가 발생합니다.  
```sql
<select id="memberList" resultType="">
    SELECT * 
    FROM member
    WHERE memberId < 5;
</select>
```
