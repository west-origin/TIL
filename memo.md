memo
===

```java
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");
        for(int i=0; i<my_string.length(); i++){
            answer += str[i].repeat(n);
        }
        return answer;
    }
}
```
### str[i].repeat(n)
*  str[i]을 n번 반복 함.

### sql trunc
SELECT *
FROM your_table
WHERE TRUNC(insertdate) = TO_DATE('2024-12-21', 'YYYY-MM-DD');

SELECT CASE 
    WHEN EXISTS (
        SELECT 1 
        FROM my_table 
        WHERE id = #{id}
    ) THEN 1 
    ELSE 0 
END AS result
FROM dual;

