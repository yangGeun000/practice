var button;
var contentWrap;
var imgArr;
var title;
var pageNum =0;
var totalNum=0;

//window.onload=function(){}
//window.addEventListener('load',function(){})

window.onload=function(){
    contentWrap = document.querySelectorAll('.contentWrap');
    //console.log(contentWrap);
    totalNum=contentWrap.length;//전체 페이지 수

    button = document.querySelectorAll('button');
    //console.log(button);
    imgArr =document.querySelectorAll('img');
    //console.log(imgArr);
    title = document.querySelector('h1');

    // var arr = ['첫째','둘째'];
    // console.log(arr[0])//첫째
    // console.log(arr[1])//둘째

    // button[0].addEventListener('click',function(){
    //     prevFunc();
    // })
    button[0].addEventListener('click',prevFunc)
    button[1].addEventListener('click',nextFunc)
    pageSetFunc();
}

function prevFunc(){
    if(pageNum>0){
        pageNum--;
    }else{
        pageNum =totalNum - 1;
    }
    pageSetFunc();
}
function nextFunc(){
    if(pageNum < totalNum - 1){
        pageNum++;
    }else{
        pageNum = 0;
    }
    pageSetFunc();
}

function pageSetFunc(){
    console.log(pageNum)//0
    for(var i=0; i<contentWrap.length;i++){
        contentWrap[i].classList.remove('active');
    }
    for(var i=0; i<imgArr.length;i++){
        imgArr[i].classList.remove('active');
    }
   contentWrap[pageNum].classList.add('active');
   for(var i=0; i<4;i++){
    contentWrap[pageNum].getElementsByTagName('img')[i].classList.add('active')
}
//페이지 넘버
title.innerHTML = "PAGE : " + (pageNum + 1)
}

