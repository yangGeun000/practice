let human;
let text3d;
let bg;
let pipe;
let x = 0;
let y = 0;
let mx = 0;
let my = 0;
let speed = 0.009;



window.onload = function () {
    human = document.getElementsByClassName('human')[0];
    text3d = document.getElementsByClassName('text3d')[0];
    bg = document.getElementsByClassName('bg')[0];
    pipe = document.getElementsByClassName('pipe')[0];

    // window.addEventListener('mousemove', function(){monuseFunc();}); 밑에와 동일한 명령어
    window.addEventListener('mousemove', monuseFunc);

    function monuseFunc(e) {
        // console.log(window.innerWidth); -> 화면의 넓이
        x = e.clientX - window.innerWidth / 2;
        y = e.clientY - window.innerHeight / 2;
    }
    loop();
}

function loop() {
    mx += (x - mx) * speed;
    my += (y - my) * speed;
    human.style.transform = 'translate(' + -(mx / 9) + 'px,' + (my / 9) + 'px)';
    bg.style.transform = 'translate(' + (mx / 8) + 'px,' + -(my / 8) + 'px)';
    pipe.style.transform = 'translate(' + (mx / 4) + 'px,' + (my / 4) + 'px)';
    // 3D 텍스트
    text3d.style.transform = 'translate3d(' + -(mx/2) + 'px,' + -(my/2) + 'px, 0px) rotate3d( 0, 1, 0, ' + (mx/30) + 'deg)';


    window.requestAnimationFrame(loop);
}