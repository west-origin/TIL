Static
===

static으로 선언할 시, static으로 선언된 변수는 heap 영역이 아닌 메소드 영역에 적재되게 된다.  
이는 garbage collecter의 관리 밖의 대상이며 이로 인해 프로그램이 종료될 때 까지 메소드 영역에 잔재해 있게 된다.  그러므로 static의 무분별한 사용은 성능 저하의 원인이 될 수 있다.  
static, final, method, thread, 메모리 영역, 힙 영역, 스택 영역, 메서드 영역, 접근 지정자  
접근 제어자 private, public이란?  
private를 사용하고 public getter, setter을 사용하는 것과 public으로 인해 직접적으로 데이터에 접근 했을 경우의 차이점을 설명할 수 있어야 한다.   
* setter를 사용했을 경우 추가적인 제어를 통해 데이터의 무결성을 지킬 수 있다.  
* 직접적으로 값을 설정하게 될 경우, 데이터의 무결성을 유지할 수 없게 된다.  
VO에서 private String categoryId를 사용하는 이유는 private를 사용하여 외부 클래스에서 접근할 수 없도록 하고, getter와 setter를 통해서 데이터가 순환 될 수 있도록 한다.  이때 setter를 통해 데이터의 무결성을 보장한다.  
### static을 좀 더 이해하기 위한 문장
앞서 언급했던 private String categoryId에 static을 붙이지 않는 이유.  
* static을 쓰는 순간 이를 참조하는 모든 객체는 동일한 값을 가지게 되므로, 이는 VO를 쓰는 목적성과 위배된다.  
### final
`final`은 "더 이상 변경할 수 없음"을 의미하며, 변수, 메서드, 클래스 등 여러 곳에 사용할 수 있습니다.

1. **변수에 final 사용**
   - 한 번 초기화된 변수의 값을 변경할 수 없습니다.
   - 예: `final int number = 10;` → number의 값은 이후 변경할 수 없습니다.
   - 객체 참조형 변수의 경우, 참조 대상(주소)은 변경할 수 없지만 객체 내부 상태는 변경될 수 있습니다.
     예: 
     ```java
     final List<String> list = new ArrayList<>();
     list.add("A"); // 가능
     list = new ArrayList<>(); // 불가능
     ```

2. **클래스에 final 사용**
   - 해당 클래스를 상속받는 자식 클래스를 생성할 수 없습니다.
   - 예: 
     ```java
     final class Animal {}
     class Dog extends Animal {} // 컴파일 에러
     ```

3. **메서드에 final 사용**
   - 자식 클래스에서 해당 메서드를 재정의(Override)할 수 없습니다.
   - 예:
     ```java
     class Parent {
         final void show() {
             System.out.println("부모 메서드");
         }
     }
     class Child extends Parent {
         void show() { // 컴파일 에러
             System.out.println("자식 메서드");
         }
     }
     ```

`final`은 불변성을 보장하거나 중요한 코드의 재정의를 막기 위해 사용됩니다.
