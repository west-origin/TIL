memo
===
1. 알고리즘 : 필요개념 & 플레티넘 이상
2. 프로젝트 : 지원자격, 우대사항에 나오는 개념들 깊게 숙지하기
3. CS: 중요한 것 모두 외우기
----------------------------------------------------  
4. 오픈소스: star 1만 이상의 기여자  

### 합배열 생성하기
S[i] = S[i-1] + A[i]
### 구간합 구하기
i ~ j 범위 값을 알고 싶을 때  
S[j] - S[i-1]

잘못 알고 있던 개념.  
도커를 통하여 인터넷에 배포를 하는 줄 알았지만 아님.  
도커는 컨테이너를 개설하여 각각의 컨테이너에 독립적인 애플리케이션 실행 환경을 제공해주는 역할.  
도커는 효율적인 애플리케이션 격리 기술.  
큰 프로젝트를 세분화하여 여러 개의 컨테이너로 배포.  
이와 비슷하게 헷갈렸던 개념 배포툴.  
배포툴은 서버에 애플리케이션을 적재함.  
특정 배포툴은 형상관리 개념도 있어 팀원 간에 애플리케이션 관리를 용이하게 함.  
빌드, 테스트, 배포 등의 단계를 자동화하여 개발과 운영을 더 효율적으로 만들어줍니다.

### BufferedReader
Scanf보다 훨씬 빠른 입출력 제어기  
```java
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받음
StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // bufferedReader.readLine()을 사용하여 한 줄의 문자열을 읽음. StringTokenizer를 사용하여 공백을 기준으로 문자열을 나눔.
Integer.parseInt(stringTokenizer.nextToken()); //  토큰 단위(공백으로 나눈 단어)로 문자열을 반환.
```
### 배열 합을 이용하여 문제 풀기
```java
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        
        long[] S = new long[suNo+1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        // 합배열 만들기
        for(int i = 1 ; i <= suNo ; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        
        // 질의 횟수
        for(int q = 0 ; q < quizNo ; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            
            System.out.println(S[j] - S[i-1]);
        }
    }
}
```
어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1<= N<= 10,000,000)을 몇 개의 연속된 자연수의
합으로 나타내는 가지수를 알고 싶다. 이때 사용하는 자연수는 N이어야 한다. 예를 들어 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5이다. 반면, 10을 나타내는 방법은 10, 1+2+3+4이다. N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
```java
package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int start_index = 1;
        int end_index = 1;
        int cnt = 1;
        int sum = 1;

        while(end_index != N) {
            if(sum < N) {
                end_index++;
                sum += end_index;
            } else if(sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
```
clipreport
매개변수 parameter.example 데이터 data.example

<c:import url로 호출한 페이지와 동일한 ajax를 시도해보고 있는데 @responsebody로 할시,
@ResponseBody를 컨트롤러의 메서드에 선언하면 해당 메서드는 View를 반환하지 않고, 응답 본문(body)으로 데이터를 직접 반환하는 방식이므로 동일한 방식으로 할수 없다

Tomcat admin port 톰캣 종료할때 필요한 포트
HTTP/1.1 웹브라우저에서 접근하기 위한 포트
AJP/1.3  

Break Point란 디버깅 할 때 값을 알고 싶을 때, 에러가 발생하는 지점에 설정해 두면 된다 브레이크 포인트를 설정하지 않았을 경우, 디버그 모드에서 Variables의 값은 출력되지 않으니 꼭 브레이크 포인트를 지정해 둘 것. 

### null 반환값 역참조란?
responsebody가 붙으면 페이지간의 전환은 불가하다

### 오름차수 스택 연습 예제
```java
package main;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        
        for(int i = 0 ; i < A.length ; i++) {
            A[i] = sc.nextInt();
        }
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        for(int i=0; i < A.length ; i++) {
            int su = A[i];
            if(su >= num) {
                while (su >= A[i]) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        } 
        if(result == true ) {
            sb.toString();
        }
    }
}
```
