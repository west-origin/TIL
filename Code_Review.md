Code_Review
===
```java
// 제곱근 
int result = Math.sqrt(n); // n: 16
System.out.println(result); // result: 4
```
```java
// replace
my_string.replace(str, ""); // str을 ""로 바꿈
```
```java
// repeat
System.out.println("*".repeat(n)); // "*"를 n번 반복함
```
```java
// 이렇게 하는 방법도 있네
int[] answer = new int[10];
int index = 0;
for(int i = 0 ; i <= n ; i++){
    answer[index++] = i;
}
```
```java
//stream을 사용하여 List를 array형식으로 변환
List<integer> answer = ArrayList<>();
return answer.stream().mapToInt(x->x).toArray();
```
```java
//contains
return (str1.contains(str2)? 1: 2);
```
```java
substring(i,x) // i번째부터 x개를 반환
```



