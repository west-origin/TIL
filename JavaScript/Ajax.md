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
```java
function fn_submit_check() {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: '/...', 
            method: 'GET',
            success: function (data) {
                if (data) {
                    resolve(true);
                } else {
                    resolve(false);
                }
            },
            error: function (error) {
                reject(error); // 에러 발생 시 Promise 거부
            }
        });
    });
}

fn_submit_check().then((result) => {
    console.log(result); // true 또는 false
    var flag = result;
    console.log("flag:", flag);
}).catch((error) => {
    console.error("에러 발생:", error);
});
이렇게 해야 성공적으로 값을 사용할 수 있다.
```