@modelAttribute
--   
@RequestParam은 사용자가 요청시 전달하는 값을 1:1 매핑할 때 사용하는 어노테이션입니다. 

```java
@controller
public class TestController{
    @RequestMappinig(value="/ftc/sdm/...")
    public String getDailyCheckError(@RequestParam(name = "itemId") String itemId){
        System.out.println("itemId: " +  itemId);
        return test;
    }
}
```

이런 형식으로 하는데 @RequestParam(name="...")을 하던 @RequestParam(value="...")을 하던 상관은 없다고 합니다.  
비슷한 형식으로 @ModelAttribute가 있는데 사용자가 요청하는 값을 Object 형태로 매핑해주는 어노테이션입니다.   
```java
@controller
public class TestController{
    @RequestMappinig(value="/ftc/sdm/...")
    public String getDailyCheckError(@ModelAttribute CategoryVO categoryVO){
        System.out.println("itemId: " +  itemId);
        System.out.println("itemDescription: " + itemDescription);
        return test;
    }
}
```
예를 들어 CategoryVO라는 객체가 존재하고 이를 매개변수로 받기 위해서 ?itemId=1&itemDescription=사이트점검내역
로 요청하면 각각의 값이 CategoryVO 객체에 바인딩 됩니다.  

@RequestParam과 @ModelAttribute의 가장 큰 차이점은  
@RequestParam은 1:1 매핑이라는 점 @ModelAttribute는 객체 매핑이라는 점

왜 굳이 객체 매핑을 사용하는가?

```java
@RestController
public class TestController {
    @GetMapping("/")
    public String getTestPage(@RequestParam int id,
                              @RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String phone,
                              Model model) {
        List<User> userList = userService.search(id, name, email, phone);
        model.addAttribute("userList", userList);
        return "test";
    }
}
```
매개변수가 많아지는 경우, 매개변수의 타입이 같은 경우, 순서가 바뀐다면 이는 매우 위험한 에러가 발생할 수도 있습니다.  
이를 @modelAttribute를 사용하면 해결이 됩니다.  

단순한 데이터(한두 개의 값) → @RequestParam  
복잡한 데이터 구조(객체 단위의 데이터 처리, 검증 필요) → @ModelAttribute  

우선 이 정도로 이해하고 있어야겠습니다.  