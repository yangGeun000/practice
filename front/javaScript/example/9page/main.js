var button = document.querySelectorAll('button');
var contentWrap = document.querySelectorAll('.contentWrap');
var title = document.querySelector('h1');
var pageNum = 0;
var totoalNum = contentWrap.length; //전체 페이지 수

window.addEventListener('load', function () {
    pageSetFunc();
    button[0].addEventListener('click', function () {
        pageNum = (pageNum + totoalNum - 1) % totoalNum;
        pageSetFunc();
    }); // prev 버튼
    button[1].addEventListener('click', function () {
        pageNum = ++pageNum % totoalNum;
        pageSetFunc();
    }); // next 버튼
});

function pageSetFunc() {
    contentWrap.forEach(function (e) {
        e.classList.remove('active');
        e.querySelectorAll('img').forEach(function (e) {
            e.classList.remove('active');
        })
    }) // active 클래스 모두 지우기
    contentWrap[pageNum].classList.add('active');
    for (var i = 0; i < 4; i++) {
        contentWrap[pageNum].querySelectorAll('img')[i].classList.add('active');
    }
    // 현재 페이지에 active 클래스 부여
    title.innerHTML = "PAGE : " + (pageNum + 1);
    // 현재 페이지번호갱신
}

