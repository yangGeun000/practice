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

allVideos.forEach(function(v){
    v.addEventListener('mouseover',function(){
        //.video안의 테그이름video를 불러옴
        var video = v.querySelector('video');
        video.play();
    })
    v.addEventListener('mouseleave',function(){
        //.video안의 테그이름video를 불러옴
        var video = v.querySelector('video');
        video.pause();
    })

});



allplay.addEventListener('click',function(){
    //클래스on를 가지고 있는가?
    if(allplay.classList.contains('on')){
        console.log("on포함");

        allVideos.forEach(function(v){
            var video = v.querySelector('video');
            video.play();
        });
        document.querySelector('.play-all').innerHTML = "pause All";
        allplay.classList.remove('on');
    }else{
        allVideos.forEach(function(v){
            var video = v.querySelector('video');
            video.pause();
        });
        document.querySelector('.play-all').innerHTML = "play All";
        allplay.classList.add('on');

    }
})