Code_Review
===
```java
int result = Math.sqrt(n); // n: 16
System.out.println(result); // result: 4
```
```java
my_string.replace(str, "");
my_string.replace("[^0-9]", ""); // 숫자를 제외한 문자는 ""처리.
```
```java
System.out.println("*".repeat(n)); // "*"를 n번 반복함
```
```java
StringBuilder[] strArray = new StringBuilder[my_string.length()]; // StringBuilder는 언제 사용하는지 확인할 것.
```
```java
char[] ch = my_string.toCharArray(); // String -> Array
```
.charAt()의 반환값은 char이다.
그러므로
```java
string.charAt(n)=='n'
```
으로 확인하면 된다.  
```java
int num = 12345;
String.valueOf(num) -> "12345"
```
```java
str = "now days";
str.indexOf(n) // n의 첫 인덱스를 반환
```

```java
public String solution(int age) {
        StringBuilder sb = new StringBuilder();

        while(age > 0) {
            sb.insert(0, (char) ((age % 10) + (int)'a'));
            age /= 10;
        }

        return sb.toString();
}
```
