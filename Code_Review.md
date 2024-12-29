Code_Review
===
```java
int result = Math.sqrt(n); // n: 16
System.out.println(result); // result: 4
```
```java
my_string.replace(str, ""); // str을 ""로 바꿈
```
```java
System.out.println("*".repeat(n)); // "*"를 n번 반복함
```
```java
public int solution(int n) {
    int cnt = 0;
    for(int i = 1 ; i <= n ; i++ ) {
        if(n%i==0) {
            cnt++;
        }
    }
    return cnt;
}
```