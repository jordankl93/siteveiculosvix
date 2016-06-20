function loginSubmit() {
	var login = document.getElementsByName("login")[0].value;
	var senha = document.getElementsByName("senha")[0].value;
	
    if (login != "admin" || senha != "123")    {
		alert("usuário ou senha incorretos");
		return false;		
    } else {
        return true;
    }
}