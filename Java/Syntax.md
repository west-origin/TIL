생각 정리 노트
===

### 객체
현실 세계에서의 객체는 어떠한 사물을 지칭합니다.  
프로그래밍에서의 객체란 클래스로 인해 만들어진 인스턴스를 객체라고 불리웁니다.  
객체의 특징으로는 객체의 속성(변수), 메서드(행동)이 존재합니다.
* 객체를 왜 사용하는가?  
객체를 생성하면 재사용성과 유지보수에 용이합니다.  

### 생성자
생성자란 어떠한 객체를 생성할 때 초기화 하는 메서드입니다.  
주요 특징으로는 클래스명과 생성자의 명이 일치해야 합니다.  
생성자는 반환형이 없습니다.  때문에 void도 사용할 수 없습니다.  
생성자의 역할은 속성(변수)을 초기화 하는 역할만 수행합니다.
생성자를 호출할 때는 항상 클래스 new 클래스()와 함께 호출해야 합니다.  
생성자는 오버로딩이 가능합니다. (당연히 어떠한 값으로 초기화할려면 오버로딩이 되어야 함.)  

### 접근 제어자(public, private)
접근 제어자는 클래스, 메서드, 변수 등의 구성 요소에 대한 접근을 제어하는 키워드입니다.  
public은 프로그램 어디에서든 접근할 수 있도록 하는 접근 제어자입니다.  
반면, private는 같은 클래스 내에서만 접근할 수 있도록 제한하는 접근 제어자입니다.  

### 메서드
메서드는 항상 클래스 내부에 선언되는 어떤 행동의 코드 블록입니다.  
메서드는 객체를 생성한 후에 명시적으로 호출하여 불러낼 수 있습니다.  
```java
class Car {
    void drive() {
        System.out.println("The car is driving.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();  // 객체 생성
        car.drive();  // 메서드 호출
    }
}
```
메서드는 클래스의 동작을 결정합니다.

### 함수
함수란 어떠한 매개변수를 받아 반환하는 코드 블록을 함수라 칭합니다.  
자바에선 클래스 밖에 함수를 정의할 수가 없고 이로 인해 자바에선 메서드와 함수가 같은 의미로 사용됩니다.  

### static
static이란 객체를 만들지 않겠다는 의미입니다.  
이 의미는 static은 클래스에 종속됩니다.  
static으로 선언한 메서드나 변수 등은 이를 참조하는 모든 객체에서 동일한 값을 지니게 됩니다.  
static은 객체를 생성하지 않고, 클래스에 속하는 멤버를 정의하는 키워드입니다.
static은 클래스에 속하며, 객체 인스턴스화 없이 클래스명으로 직접 접근할 수 있습니다.
static으로 선언된 메서드나 변수는 클래스의 모든 객체에서 공유되며, 동일한 값을 가집니다.  
아래는 이해를 위해 static으로 선언했을 경우와 static으로 선언하지 않았을 경우의 예시입니다.  
```java
class Car {
    static int count = 0;  // static 변수

    public Car() {
        count++;  // 생성할 때마다 count 증가
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        
        System.out.println(Car.count);  // 2 (모든 객체가 동일한 count 값을 공유)
    }
}
```  
static int count로 선언했기에 Car클래스로 만들어진 객체들은 모두 동일한 count를 공유합니다.  
그러므로 Car car1 = new Car(); Car car2 = new Car(); 선언할 때마다 동일한 count가 1씩 증가하게 되어 결과값 2를 도출합니다.  
```java
class Car {
    int count = 0;  // 인스턴스 변수

    public Car() {
        count++;  // 생성할 때마다 count 증가
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        
        System.out.println(car1.count);  // 1 (car1 객체의 count 값)
        System.out.println(car2.count);  // 1 (car2 객체의 count 값)
    }
}
```
동일하게 System.out.println(car1.count);로 디버깅해 보았을 때 변수명만 같을 뿐 다른 count를 사용하기에 각각 1의 값을 도출합니다.  

### public static void main(String args[])?
지금까지 접근 제어자, static에 대해서 살펴 봤습니다.  
그렇다면 public static void main(String args[])는 무슨 의미일까요?  
public public은 접근 제어자로, 이 메서드가 어디서든 호출될 수 있도록 허용합니다.  
main 메서드는 자바 프로그램이 시작될 때 JVM(Java Virtual Machine)에 의해 호출되므로 public으로 선언되어야 합니다.  
static으로 선언된 main 메서드는 클래스 수준에서 실행되며, 객체를 생성하지 않고도 호출될 수 있습니다.  
자바 애플리케이션이 시작될 때 객체 생성 없이 main 메서드가 실행되기 때문에 static으로 선언되어야 합니다.  
void 반환 타입이 없다는 뜻입니다.  
main은 자바 애플리케이션에서 프로그램이 실행될 때 JVM이 첫 번째로 호출하는 메서드의 이름입니다. 지정된 이름이라고 할 수 있습니다. 
String args[]는 명령줄 인수를 받을 수 있는 배열입니다. 명령어를 받지 않아도 main 메서드는 실행되며, args 배열은 비어 있을 수 있습니다.
자바에서 프로그램을 실행할 때 문자열로 받기때문에 String[] args로써 받습니다.  
만약 명령어를 받을 생각이 없다면 String[] args가 없다고 해도 프로그램은 정상적으로 실행 될 것 입니다.  

### field
필드란 어떠한 클래스 안의 데이터 집합 장소이다.  
인스턴스 필드와 정적 필드가 존재합니다.  

### 지역변수
초기화를 무조건 해줘야 합니다.  
필드는 객체의 속성을 지칭하고 해당 객체가 사라질 때까지 메모리에 데이터가 남아있지만 지역변수는 해당 스코프 밖으로 가면 사라집니다.

### this
this란 인스턴스 변수와 매개변수를 구별, 지정하는 키워드입니다.  
this를 사용해서 클래스 내의 생성자를 불러 올 수 있습니다.  
this를 사용할 때와 사용하지 않을 때의 차이점을 확인하겠습니다.  
```java
// this를 사용한 경우.  
class Person {
    private String name;

    // 생성자
    public Person(String name){
        this.name = name;
    }
}
```
this를 사용한 경우 this.name으로 이는 객체의 값이라는 것을 표시합니다.  
this.name은 private String name 즉, 멤버변수를 가르킵니다.  
```java
// this를 사용하지 않은 경우.
class Person {
    private String name;

    public Person (String name){
        name = name;
    }
}
```
이렇게 선언한다면 매개변수를 매개변수 값으로 지정하겠다는 의미입니다.  
즉, 멤버 변수 name에 값이 할당되지 않으며, 멤버 변수는 초기값 null로 남게 됩니다.  

### 내부 클래스
내부 클래스란 어떤 클래스와 밀접한 관련이 있을 때 사용하는 클래스입니다.  

### 캡슐화
캡슐화란 외부에서 직접적으로 데이터의 값을 수정할 수 없도록 하고,  
메서드를 통해서만 데이터의 값에 접근할 수 있도록 하여 무결성을 보장합니다.  


### 모듈
모듈이란 특정 기능을 제공하는 코드의 집합입니다.  
모듈은 여러 함수, 클래스, 변수 등을 포함할 수 있습니다.
모듈의 특징 중 하나는 재사용성이 용이하다는 것입니다. 여러 프로그램에서 모듈을 재사용할 수 있어 코드 유지보수가 용이합니다.  

