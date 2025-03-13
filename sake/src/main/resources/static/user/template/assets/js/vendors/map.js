fetch('http://127.0.0.1:5500/FreshCart-1.4.0/cart-sake/jp.json')  // jp.json 경로
  .then(response => {
    if (!response.ok) {
      throw new Error('파일을 불러오는 데 실패했습니다. 상태 코드: ' + response.status);
    }
    return response.json();  // JSON 데이터를 반환
  })
  .then(data => {
    try {
      // GeoJSON 객체가 유효한지 확인하고, 지도에 추가
      L.geoJSON(data).addTo(map);  // GeoJSON 데이터 추가
      console.log('GeoJSON 데이터 로드 성공');
    } catch (e) {
      console.error('GeoJSON 객체 오류:', e);
    }
  })
  .catch(error => {
    console.error('GeoJSON 로드 오류:', error);
  });
var map = L.map('map').setView([35.6762, 139.6503], 5);  // 일본 중심 좌표, 줌 레벨 5

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);


var Ibaraki = L.polygon([// 이바라키현 좌표
 
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">이바라키현</a>');

var tochigi = L.polygon([ // 도치기현 좌표
  
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">도치기현</a>');

var gunma = L.polygon([ // 군마현 좌표
  
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">군마현</a>');

var saitama = L.polygon([ // 사이타마현 좌표
  
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">사이타마현</a>');

var chiba = L.polygon([// 치바현 좌표
  
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">치바현</a>');

var kanagawa = L.polygon([  // 가나가와현 좌표
  
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">가나가와현</a>');

var tokyo = L.polygon([  // 도쿄도 좌표
  
]).addTo(map).bindPopup('<a href="./pages/shop-grid.html">도쿄도</a>');







// 각 지역 버튼 클릭 시 지도에서 해당 위치로 이동하는 함수들
function showIbaraki() {
  map.setView([36.3418, 140.4467], 12);  // 이바라키현으로 이동
  highlightRegion(Ibaraki);
}

function showTochigi() {
  map.setView([36.5658, 139.8836], 12);  // 도치기현으로 이동
  highlightRegion(tochigi);
}

function showGunma() {
  map.setView([36.3911, 139.0605], 12);  // 군마현으로 이동
  highlightRegion(gunma);
}

function showSaitama() {
  map.setView([35.8561, 139.6489], 12);  // 사이타마현으로 이동
  highlightRegion(saitama);
}

function showChiba() {
  map.setView([35.6074, 140.1061], 12);  // 치바현으로 이동
  highlightRegion(chiba);
}

function showKanagawa() {
  map.setView([35.4478, 139.6425], 12);  // 가나가와현으로 이동
  highlightRegion(kanagawa);
}

function showTokyo() {
  map.setView([35.6762, 139.6503], 12);  // 도쿄도로 이동
  highlightRegion(tokyo);
}

// 특정 지역 강조 (다른 지역들은 기본 스타일로 변경)
function highlightRegion(region) {
  // 모든 지역의 스타일을 기본으로 설정
  ibaraki.setStyle({ color: 'blue', weight: 2 });
  tochigi.setStyle({ color: 'blue', weight: 2 });
  gunma.setStyle({ color: 'blue', weight: 2 });
  saitama.setStyle({ color: 'blue', weight: 2 });
  chiba.setStyle({ color: 'blue', weight: 2 });
  kanagawa.setStyle({ color: 'blue', weight: 2 });
  tokyo.setStyle({ color: 'blue', weight: 2 });

  // 선택된 지역 강조
  region.setStyle({ color: 'red', weight: 5 });  // 선택된 지역 빨간색 강조
}