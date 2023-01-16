// 배열
//let arr = ['일길동','이말자','삼식이','사가지'];
//배열안에 입력된 값을 요소라고 한다.
//console.log(arr);
//console.log(arr[2]);
//배열안에 요소들 각각의 할일
//arr.forEach(function(요소를가져올변수){});
// arr.forEach(function(item){
//     console.log(item +" 안녕~")
// });

var allVideos = document.querySelectorAll('.video');
var allplay = document.querySelector('#play-all');
console.log(allVideos);

allVideos.forEach(function (v) {
    v.addEventListener('mouseover', function () {
        //.video안의 테그이름video를 불러옴
        var video = v.querySelector('video');
        var content = v.querySelector('.video-content');
        var view = v.querySelector('.view');
        var time = v.querySelector('.video-time');
        v.style.zIndex = '50';
        content.style.zIndex = '100';
        view.style.zIndex = '100';
        v.style.height = '200px';
        content.style.transform = 'translateY(120px)';
        view.style.transform = 'translateY(119px)';
        time.style.opacity = '0';
        video.play();
    })
    v.addEventListener('mouseleave', function () {
        //.video안의 테그이름video를 불러옴
        var video = v.querySelector('video');
        var content = v.querySelector('.video-content');
        var view = v.querySelector('.view');
        var time = v.querySelector('.video-time');
        v.style.removeProperty('z-index');
        content.style.removeProperty('z-index');
        view.style.removeProperty('z-index');
        v.style.height = '125px';
        content.style.transform = 'translateY(0)';
        view.style.transform = 'translateY(0)';
        time.style.opacity = '1';
        video.pause();
        video.currentTime = 0;
    })

});

allplay.addEventListener('click', function () {
    //클래스on를 가지고 있는가?
    if (allplay.classList.contains('on')) {
        allVideos.forEach(function (v) {
            var video = v.querySelector('video');
            video.play();
        });
        document.querySelector('.play-all').innerHTML = 'pause all';
        allplay.classList.remove('on');
    } else {
        allVideos.forEach(function (v) {
            var video = v.querySelector('video');
            video.pause();
        });
        document.querySelector('.play-all').innerHTML = 'play all';
        allplay.classList.add('on');
    }
})