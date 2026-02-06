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

```javascript
const handleSearch = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/search", {
        params: { keyword, category },
      });

      console.log("검색 결과:", response.data);
    } catch (error) {
      console.error("검색 요청 실패:", error);
    }
  };
```
동기 방식은 데이터가 변경되면 페이지를 새로고침해야만 최신 데이터를 확인할 수 있다.  
반면, 비동기 방식(async)으로 통신하면 페이지 전체를 새로고침하지 않고도 서버에서 필요한 데이터만 가져와 화면을 업데이트할 수 있다.  
여기서 await는 서버에서 데이터를 받아오는 Promise가 완료될 때까지 기다리도록 해주기 때문에, 데이터가 준비되기 전에 접근해서 발생할 수 있는 오류를 방지할 수 있다.  
또한 await 뒤에는 반드시 Promise를 반환하는 함수가 와야 하며, await는 그 함수가 Promise를 반환할 때까지 기다린다.  
```javascript
function Shop(){

  const {keyword, category} = location.state() || {keyword:"", category:"전체"}
  const [items, setItems] = useState([]);
  const [currentPage, setCurrentPage] = useState(0);
  const itemPerPage = 10;

  const fetchItems = useCallback( async (page) => {
    try{
      const response = await axios.get(`http://localhost:8080/shop?page=${page}`);
      setItems(res.data);
    } catch (error) {
      console.log("error: ", error);
    }
  },[keyword, category]);
  
  useEffect(()=>{
    setCurrentPage(0);
    setItems([]);
    fetchItems();
  },[currentPage, keyword, category]);

  //이벤트가 있을 때 사용할 거리
  const handlePageChange = (selectedItem) => {

  };
  
}
적용해가면서 공부 중.. 나중에 마저 수정
```
let const의 차이 let은 재정의가 가능하고 const는 불가능하다.
