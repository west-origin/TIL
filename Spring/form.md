form
===

form으로 제출할 시에 refresh가 되므로 다시 돌아갈 경로가 필요합니다.   
form으로 보낸 값은 @modelAttribute로 바인딩 가능하지만 
ajax로 보낸 값은 @RequestBody로 바인딩 해야 합니다.    

js confirm, selectOne
```html
<form id="form">
    <input type="text" name="username" value="JohnDoe">
    <input type="password" name="password" value="1234">
    <input type="checkbox" name="subscribe" value="yes" checked>
    <input type="text" name="age" value="30">
</form>
var formData = {};
jQuery.each(jQuery("#form :input").serializeArray(), function() {
    formData[this.name] = this.value;
});

console.log(formData);
{
    username: "JohnDoe",
    password: "1234",
    subscribe: "yes",
    age: "30"
}
```
결과값은 이런 식으로 들어감.  
