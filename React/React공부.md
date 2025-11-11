### 리액트 문법

```javascript
import React, { useState } from 'react';

function App() {
  let [글제목, 글제목변경] = useState(['남자코트 추천', '강남 우동 맛집']);

  return (
    <div className="App">
      <h2>{글제목[0]}</h2>
      <h2>{글제목[1]}</h2>

      <button onClick={() => {
        let copy = 글제목;        // 같은 주소를 가리킴
        글제목[0] = '테스트';     // 내부 값만 변경됨
        글제목변경(copy);          // 같은 주소를 전달 → React는 변화 인식 못 함
      }}>
        글수정
      </button>
    </div>
  );
}

export default App;

```
해당 버튼을 눌러도 새로운 렌더링이 되지 않는다.  
이유는 해당 버튼을 누를 때 글제목변경(copy)의 state값이 변경되지 않으면 렌더링 하지 않도록 함.  
