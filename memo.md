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
```sql
WITH date_range AS (
    SELECT TO_DATE(#{searchRsvsDate}, 'YYYYMMDD') + LEVEL - 1 AS insertdate
    FROM DUAL
    CONNECT BY LEVEL <= TO_DATE(#{searchRsveDate}, 'YYYYMMDD') - TO_DATE(#{searchRsvsDate}, 'YYYYMMDD') + 1
)
SELECT
    dr.insertdate AS insertDate,
    b.category_name AS categoryName,
    c.item_description AS itemDescription,
    c.method_description AS methodDescription,
    b.category_id AS categoryId,
    c.item_id AS itemId,
    a.status AS status,
    a.memo AS memo
FROM 
    date_range dr
LEFT JOIN 
    portal.tb_dc_check a ON dr.insertdate = a.insertdate
                          AND a.category_id = #{categoryId}
LEFT JOIN 
    portal.tb_dc_categories b ON a.category_id = b.category_id
LEFT JOIN 
    portal.tb_dc_check_items c ON a.item_id = c.item_id
ORDER BY
    dr.insertdate;
```
전체

