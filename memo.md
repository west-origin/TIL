memo
===
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
