var id =document.querySelector('#id');
var pw1 =document.querySelector('#pw1');
var pwMsg =document.querySelector('#alertTxt');
var pwImg1 =document.querySelector('#pw1_img1');
var pw2 =document.querySelector('#pw2');
var pwImg2 =document.querySelector('#pw2_img1');
var username = document.querySelector('#name');
var birth = document.querySelector('#bir_wrap');
var gender = document.querySelector('#gender');
var email = document.querySelector('#email');
var phone = document.querySelector('#phoneNo');
var error = document.querySelectorAll('.error_next_box');

id.addEventListener('focusout',checkId);
pw1.addEventListener('focusout',checkPw1);
pw2.addEventListener('focusout',checkPw2);
username.addEventListener('focusout',checkName);
birth.addEventListener('focusout',checkDate);
gender.addEventListener('focusout',checkGender);
email.addEventListener('focusout',checkEmail);
phone.addEventListener('focusout',checkPhone);


function checkId(){
    var idPattern = /^[a-zA-Z0-9-_]{5,20}$/;
    // 정규식.test() 메소드는 주어진 문자열이 정규 표현식을 만족하는지 판별하고 결과를 true, false로 반환
    if(id.value === ""){
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
        error[0].style.color = "red";
    }
    else if(idPattern.test(id.value)){
        error[0].innerHTML = "멋진 아이디네요.";
        error[0].style.display = "block";
        error[0].style.color = "#08a600";
    }
    else{
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.display = "block";
        error[0].style.color = "red";
    }
}

function checkPw1(){
    var pw1Pattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
    if(pw1.value === ""){
        error[1].innerHTML = "필수 정보입니다.";
        error[1].style.display = "block";
        pwMsg.style.display = "none";
        pwImg1.src="img/m_icon_pass.png";

    }
    else if(pw1Pattern.test(pw1.value)){
        error[1].style.display = "none";
        pwMsg.innerHTML = "안전"
        pwMsg.style.color = "#03c75a";
        pwMsg.style.display = "block";
        pwImg1.src="img/m_icon_safe.png";
    }
    else{
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        error[1].style.display = "block";
        pwMsg.innerHTML = "사용불가"
        pwMsg.style.color = "red";
        pwMsg.style.display = "block";
        pwImg1.src="img/m_icon_not_use.png";
    }
}

function checkPw2(){
    if(pw2.value === ""){
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
        pwImg2.src="img/m_icon_check_disable.png";
    }
    else if(pw2.value === pw1.value){
        error[2].style.display = "none";
        pwImg2.src="img/m_icon_check_enable.png";
    }
    else{
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
        pwImg2.src="img/m_icon_check_disable.png";
    }
}

function checkName(){
    var namePattern = /^[a-zA-Z가-힣]+$/;
    if(username.value === ""){
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
        error[3].style.color = "red";
    }
    else if(namePattern.test(username.value)){
        error[3].style.display = "none";
    }
    else{
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
        error[3].style.color = "red";
    }
}

function checkDate(){
    var year = birth.querySelector('#yy');
    var month = birth.querySelector('#sel');
    var day = birth.querySelector('#dd');
    var yearPattern = /^[0-9]{4}$/
    var monthPattern = /^[0-9]{2}$/
    var dayPattern = /^[0-9]{1,2}$/
    if(yearPattern.test(year.value) && monthPattern.test(month.value) && dayPattern.test(day.value)){
        error[4].style.display = "none";
    }
    else{
        error[4].innerHTML = "생년월일을 다시 확인해주세요.";
        error[4].style.display = "block";
        error[4].style.color = "red";
    }
}

function checkGender(){
    if(gender.value ==="성별"){
        error[5].innerHTML = "필수 정보입니다.";
        error[5].style.display = "block";
        error[5].style.color = "red";
    }
    else{
        error[5].style.display = "none";
    }
}

function checkEmail(){
    var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    if(email.value == "" || emailPattern.test(email.value)){
        error[6].style.display = "none";
    }
    else{
        error[6].innerHTML = "이메일 주소를 다시 확인해주세요.";
        error[6].style.display = "block";
        error[6].style.color = "red";
    }
}

function checkPhone(){
    var phonePattern = /^[0-9]+$/;
    if(phone.value === ""){
        error[7].innerHTML = "필수 정보입니다.";
        error[7].style.display = "block";
        error[7].style.color = "red";
    }
    else if(phonePattern.test(phone.value)){
        error[7].style.display = "none";
    }
    else{
        error[7].innerHTML = "숫자만 사용하세요.";
        error[7].style.display = "block";
        error[7].style.color = "red";
    }
}