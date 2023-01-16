window.addEventListener('load', function () {
    onYouTubeIframeAPIReady('player1', '_3NBwCrC8R4');
    onYouTubeIframeAPIReady('player2', 'DAEK5GrLb_Y');
})

function onYouTubeIframeAPIReady(id, youtube_Id) {
    var player = new YT.Player(id, {
        videoId: youtube_Id,
        playerVars: {
            autoplay: true,
            controls: false,
            loop: true,
            playlist: youtube_Id, //반복재생할 유튜브영상 id를 다시적음
            //loop:true일때는 반복할 목록을 다시한번 적어야한다
        },
        events: {
            //영상이 준비되면 함수가 실행됨
            'onReady': function (event) {
                event.target.mute(); //음소거, target는 영상자체
            },
        }
    });
}