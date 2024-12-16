DOM
===
Document Object Model
Html 코드가 다 읽고 이를 객체화 한 것이 DOM이다.  

자주 볼 수 있는 $(document).ready(function {})은 이 DOM이 다 준비가 되면 (Html 코드를 다 읽어 들이면) 객체화 하여 Html을 제어할 수 있도록 한다.  

$(document).ready(function {})는 DOM이 준비가 완료되면 딱 한 번 실행하는 함수이다.  
\$(document).ready(function {}) 안에는 주로 DOM과 관련이 있는 이벤트 함수들만 선언하는 것이 좋다.  
DOM과 관련 없는 함수는 ready 밖에 선언하는 것이 추후에 유지보수 성에 훨씬 유용하다.  
