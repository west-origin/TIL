formData
===
onok, bindingresult, array와 list의 차이점   
[function(e)](https://velog.io/@ssarr_i/js-functione%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC)  

ajax, json
===
자꾸 헷갈릴까봐 적어둡니다.  
```java
var formData = {};
formData.checkedList = [1,2] // ex
$.ajax({
  method: 'post',
  url: '<c:url value="...">,
  dataType: 'json',
  contentType: 'application/json',
  data: JSON.stringify(formData)
})
```
이런 array형식으로 받아도 됩니다.  
대신 받아주는 controller에서는 꼭 @ReqeustBody로 받아 줍니다.  
```java
// ex
@ResponseBody
@RequestMapping(value="...")
public void getCheckedList (@RequestBody CategoryVO categoryVO) throws Exception{
  ...
}
```
물론 CategoryVO에는 이런 형식으로 존재해야 합니다.  
```java
private <String> name;
private <String> title;
private <integer> checkedList;
//getter, setter
```

