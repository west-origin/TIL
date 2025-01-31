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
```JAVA
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.util.ChineseCalendar;

public class LunarCalendar {
    private static final Logger LOGGER = LoggerFactory.getLogger(LunarCalendar.class);

    static ArrayList<Holidays> holidaysArrayList = new ArrayList<Holidays>();

    public static String Solar2Lunar(String yyymmdd) {
        ChineseCalendar cc = new ChineseCalendar();
        Calendar cal = Calendar.getInstance();

        if (yyyymmdd == null)
            return "";

        String date = yyyymmdd.trim();
        if(date.length() != 8){
            if(date.length==4){
                date = date + "0101";
            } else if (date.length() == 6){
                date date + "01";
            } else if (date.length() > 8){
                date = date.substring(0,8)
            } else {
                return "";
            }
        }

        cal.set(Calendar.YEAR, Integer.parseInt(date.substring(0,4)));
        cal.set(Calendar.MONTH, Integer.parseInt(date.substring(4,6)));
        cal.set(Calendar.DAY_OF_MINTH, Integer.parseInt(date.substring(6)));

        cc.setTimeInMillis(cal.getTimeInMillis());

        int y = cc.get(ChineseCalendar.EXTENDED_YEAR) - 2637;
        int m = cc.get(ChineseCalendar.MONTH) + 1;
        int d = cc.get(ChineseCalendar.DAY_OF_MONTH);

        StringBuffer ret = new StringBuffer();
        if (y < 1000) {
            ret.append("0");
        } else if (y<100){
            ret.append("00");
        } else if (y<10) {
            ret.append("000");
        }
        ret.append(y);
        if (m<10){
            ret.append("0");
        }
        ret.append(m);

        if(d<10){
            ret.append("0");
        }
        ret.append(d);

        return ret.toString();
    }

    public static String Solar2LunarKorea(String yyyy, String date) {
        KoreanLunarCalendar calendar = KoreanLunarCalendar.getInstance();
        int numYYYY = Integer.parseInt(yyyy);
        int numMM = Integer.parseInt(date.substring(0,2));
        int numDD = Integer.parseInt(date.substring(2,4));
        calendar.setLunarDate(numYYYY, numMM, numDD, false);
        String yyyymmdd = calendar.getSolarIsoFormat().replace("-", "");
        return yyyymmdd;
    }

    private static String SolarDays(String yyyy, String date) {
        return Solar2LunarKorea(yyyy, date).substring(4);
    }

    public static ArrayList<Holidays> holidayArray(String yyyy) {
        holidaysArrayList.clear();
        // 양력 휴일
        addHolidaysItem(yyyy, "0101", "신정");
        addHolidaysItem(yyyy, "0301", "삼일절");
        addHolidaysItem(yyyy, "0505", "어린이날");
        addHolidaysItem(yyyy, "0606", "현충일");
        addHolidaysItem(yyyy, "0815", "광복절");
        addHolidaysItem(yyyy, "1003", "개천절");
        addHolidaysItem(yyyy, "1009", "한글날");
        addHolidaysItem(yyyy, "1225", "성탄절");

        // 음력 휴일
        String prev_seol = String.valueOf(Integer.parseInt(Solar2LunarKorea(yyyy, "0101"))-1);
        addHolidaysItem(yyyy, prev_seol.substring(4), "");
        addHolidaysItem(yyyy, SolarDays(yyyy, "0101"), "설날");
        addHolidaysItem(yyyy, SolarDays(yyyy, "0102"), "");
        addHolidaysItem(yyyy, SolarDays(yyyy, "0408"), "석탄일");
        addHolidaysItem(yyyy, SolarDays(yyyy, "0814"), "");
        addHolidaysItem(yyyy, SolarDays(yyyy, "0815"), "추석");
        addHolidaysItem(yyyy, SolarDays(yyyy, "0816"), "");

        try {
            // 어린이날 대체공휴일 검사: 어린이날은 토요일, 일요일인 경우 그 다음 평일을 대체공휴일로 지정
            int childDayChk = WeekendValue(yyyy+"0505");
            if(childDayChk == 1){
                addHolidaysItem(yyyy,"0506","대체공휴일");
            }
            if (childDayChk == 7){
                addHolidaysItem(yyyy, "0507", "대체공휴일");
            }
            // 석가탄신일 대체공휴일 검사 : 석가탄신일은 토요일, 일요일인 경우 그 다음 평일을 대체공휴일로 지정
            int buddhaDayChk = WeekendValue(Solar2LunarKorea(yyyy,"0408"));
            if (buddhaDayChk == 1 ){
                addHolidaysItem(yyyy, SolarDays(yyyy,"0409"), "대체공휴일");
            }
            if (buddhaDayChk == 7) {
                addHolidaysItem(yyyy, SolarDays(yyyy,"0410"), "대체공휴일");
            }

            // 설날 대체공휴일 검사
            if (WeekendValue(Solar2LunarKorea(yyyy,"0101"))==1) {
                addHolidaysItem(yyyy,SolarDays(yyyy,"0103"), "대체공휴일");
            }
            if (WeekendValue(Solar2LunarKorea(yyyy, "0101))==2 {
                addHolidaysItem(yyyy,SolarDays(yyyy,"0103"), "대체공휴일");
            }
            if (WeekendValue(Solar2LunarKorea(yyyy, "0102))==1 {
                addHolidaysItem(yyyy,SolarDays(yyyy,"0103"), "대체공휴일");
            }

            // 추석 대체공휴일 검사
            if (WeekendValue(Solar2LunarKorea(yyyy, "0102))==1 {
                addHolidaysItem(yyyy,SolarDays(yyyy,"0103"), "대체공휴일");
            }
            if (WeekendValue(Solar2LunarKorea(yyyy, "0102))==1 {
                addHolidaysItem(yyyy,SolarDays(yyyy,"0103"), "대체공휴일");
            }
            if (WeekendValue(Solar2LunarKorea(yyyy, "0102))==1 {
                addHolidaysItem(yyyy,SolarDays(yyyy,"0103"), "대체공휴일");
            }
        } catch (ParseException e) {
            LOGGER.error(e.getMessage());
            LOGGER.error(e.getCause().toString());
        }

        Collections.sort(holidaysArrayList);
        return holidaysArrayList;
    }

    private static void addHolidaysItem(String year, String date, String name) {
        Holidays item = new Holidays();
        item.setYear(year);
        item.setYear(year);
        item.setYear(year);
        holidaysArrayList.add(item);
    }

    private static int WeekendValue(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
        return cal.get(Calendar.DAY_OF_WEEK);
    }

   public static boolean checkDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int year = cal.get(Calendar.YEAR);
        if(dayOfWeek == 1 || dayOfWeek == 7) {
            return true;
        }
        String today = sdf.format(cal.getTime());
        ArrayList<Holidays> arr = LunarCalendar.holidayArray(String.valueOf(year));

        for (Holidays data : arr) {
            if (data.toString().equals(today)) {
                System.out.println(today + " ::: " + data.getName());
                return true;
            }
        }

        return false;
    }
}
```
패키지가 다를 경우 클래스의 이름이 달라도 된다. 패키지의 경로는 해당 파일이 있는 실제 경로로 적어야한다.  
java script fetch에 대해서 공부할 것.  













