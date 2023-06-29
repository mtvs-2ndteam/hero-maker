function clickBtn() {
    var id = document.getElementById("uid")
    var pw = document.getElementById("pw")

    if (id.value == "") {
        alert("아이디를 입력하세요")
        id.focus();
        return false;
    }
    if (pw.value == "") {
        alert("비밀번호 입력하세요")
        pw.focus();
        return false;
    }

    document.getElementById('login-form').submit();
}