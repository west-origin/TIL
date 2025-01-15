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
processing : true, //true로 설정하면, 데이터가 로드되는 동안 "처리 중"을 나타내는 로딩 인디케이터가 표시됩니다.
severSide: false,
useSelectAll : true,
editRender : true, // 데이터 편집을 위한 기능을 활성화합니다. 특정 열에 대해 편집 UI를 제공할 수 있습니다.
info : false,  
paging : false, // 페이지네이션(페이지 나누기) 기능을 비활성화
ordering : false, // 정렬기능
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
columns : 
    [
    {
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
        }
    },
    {
        data: "prstdate",
        className : ...,
        render : CommonRender.dateFormat({
            format : "yymmdd",
            displayFormat : "yy-mm-dd"
        })
    }
    
    ]
})
```
Math.abs()는 음수 값을 양수로 변환하고, 양수 값은 그대로 반환합니다.  
```sql
WITH date_range AS (
    SELECT TO_DATE(#{searchRsvsDate}, 'YYYYMMDD') + LEVEL - 1 AS insertdate
    FROM DUAL
    CONNECT BY LEVEL <= TO_DATE(#{searchRsveDate}, 'YYYYMMDD') - TO_DATE(#{searchRsvsDate}, 'YYYYMMDD') + 1
)
```
with이란 뭐지?  

