Function(e)
===

function(e)는 어떠한 이벤트가 발생했을 때 사용하는 함수다.   
우선 보통의 function()과 어떠한 차이점이 있는지 보자.   
```java
$('#searchArea').on("change",function(){
   console.log("searchArea의 값이 변경되었습니다.");
});
```
이와 같은 단순한 로직은 function(e)가 필요로 하지 않는다.  
하지만 이벤트가 발생하는 경우 function(e)가 필요하다.    
```html
<button type="button" value="1">
<button type="button" value="2">
<button type="button" value="3">
<button type="button" value="4">
<button type="button" value="5">
```
```java
$("button").on("click", function(e){
    var value = $(e.taget).val();
    alert("클릭된 버튼의 value:", value);
});
```
