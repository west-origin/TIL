memo
===

```java
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");
        for(int i=0; i<my_string.length(); i++){
            answer += str[i].repeat(n);
        }
        return answer;
    }
}
```
### str[i].repeat(n)
*  str[i]을 n번 반복 함.

### dataTable
```java
demandDeptTable = jQuery("demandDeptTable").DataTable({
processing : true,
severSide: false,
useSelectAll : true,
editRender : true,
info : false,
paging : false,
ordering : false,
ajaxDataProp : 'data',
scrollY : 191,
ajax: {
    method : 'post',
    dataType : 'json'
    contentType : 'application/json',
    url : '<c:url value="..."/>'
    data: function() {
        var formData = {};
        formData.rqseq = rqseq;
        return JSON.stringify(formData);
    }
},
rowId: 'extn',
columns : [{
    render: CommonRender.select()
},
{
    data : "deptname",
    className : "text-center align-middle"
},
{
    data: "deptname",
    className : "text-center align-middle"
},
{
    data : "gubun",
    className : "text-center align-middle",
    render : EditRender.checkbox({
        disabled : false,
        checkValue : "Y",
        trueValue : "Y",
        falseValue : "N",
        click : function(data,type,row,meta){
            fn_gubun_save(row.rqseq, row.deptcode, meta.row);
        }
    })
},
{
    data : "nonprstyn",
    className : "text-center align-middle",
    render : function(data, type, row, meta) {
        var isChecked = data == "Y" ? "checked" : "";
        return "<input type='checkbox' class='check' id='nonprstyn_' + meta.row + '_'+meta.col + '"data-render="nonprstyn" value="'+data + '" ' +isChecked+'title="선택"
},
{
    data: "prstdate",
    className : ...,
    render : CommonRender.dateFormat({
        format : "yymmdd",
        displayFormat : "yy-mm-dd"
    })
}
```

