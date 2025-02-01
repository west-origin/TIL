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
```java
$.ajax({
  async : false, // 비동기화 -> 동기화로 변환
  method: "post",
  ...
})
```
AJAX (Asynchronous JavaScript and XML)  
AJAX는 비동기적으로 서버와 데이터를 주고받는 기술을 의미하는 광범위한 개념이다. 예전에는 XMLHttpRequest (XHR) 객체를 활용하여 AJAX 요청을 보냈지만, 현재는 fetch API가 등장하면서 더 현대적인 방식으로 대체되고 있다.  

fetch API  
fetch는 AJAX를 수행할 수 있는 최신 API로, Promise 기반의 비동기 요청을 지원한다. 기존 XMLHttpRequest보다 코드가 간결하고 사용하기 편리하다.

fetch 예제
```java
fetch('https://api.example.com/data')
  .then(response => response.json()) // JSON 변환
  .then(data => console.log(data))  // 데이터 출력
  .catch(error => console.error('Fetch error:', error)); // 에러 처리
```

