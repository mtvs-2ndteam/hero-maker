let btn=document.getElementById("submit");

function clickBtn(){
    console.log('나오니')
    var id= document.getElementById("uid")
    var pw =document.getElementById("pw")
    var nickname = document.getElementById("nickname")
    var phone =  document.getElementById("phone")
    var mail = document.getElementById("mail")

    var regIdPw = /^[a-zA-Z0-9]{4,12}$/;
    var regName = /^[가-힣a-zA-Z]{2,15}$/;
    var regMail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
    var regYear = /^[1-2]{1}[0-9]{0,4}$/;
    var regPhone = /^01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}$/;


    if(id.value ==""){
        alert("아이디를 입력하세요")
        id.focus();
        return false;
}
    else if(!regIdPw.test(id.value)){
        alert("4~12자 영문 대소문자 숫자만 입력하세요")
        id.focus();
        return false;
}
    if(pw.value == ""){
        alert("비밀번호 입력하세요")
        pw.focus();
        return false;
}
    else if(!regIdPw.test(pw.value)){
    alert("4~12자 영문 대소문자 숫자만 입력하세요")
    pw.focus();
    return false;
} else if(pw.value==id.value){
    alert("아이디와 비밀번호를 사용할 수 없습니다")
    pw.focus();
    return false;
}
    if(!regPhone.test(phone.value)){
        alert("핸드폰 번호를 사용할 수 없습니다")
       phoneRule.focus();
        return false;
    }

    //메일주소 확인
    if(mail.value.length == 0){
    alert("메일주소를 입력하세요.")
    mail.focus();
    return false;
}

    else if(!regMail.test(mail.value)){
    alert("잘못된 이메일 형식입니다.")
    mail.focus();
    return false;
}
    if(nickname.value == ""){
    alert("이름을 입력하세요.")
    nickname.focus();
    return false;
}

    else if(!regName.test(nickname.value)){
    alert("최소 2글자 이상, 한글과 영어만 입력하세요.")
    nickname.focus();
    return false;
}
    document.getElementById('login-form').submit();

}

