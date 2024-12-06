Ajax 사용 법
===
```java
var formData = {};
formData.checkedList = [1,2] // ex
$.ajax({
  method: "post",
  url: "<c:url value='...'>",
  dataType: "json",
  contentType: "application/json",
  data: JSON.stringify(formData)
})
```
이런 array형식으로 받아도 된다.  
대신 받아주는 controller에서는 꼭 @ReqeustBody로 받아 준다.  
```java
// ex
@ResponseBody
@RequestMapping(value="...")
public void getCheckedList (@RequestBody CategoryVO categoryVO) throws Exception{
  ...
}
```
물론 CategoryVO에는 이런 형식으로 존재해야 한다.    
```java
private <String> name;
private <String> title;
private <integer> checkedList;
//getter, setter
```