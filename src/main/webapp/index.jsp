<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


 <%
   String erro = request.getParameter("erro");
   if(erro!=null) {
    if (erro.equals("USUARIO_NAO_EXISTE")) {
	   %>
	    Esse usuário não existe
	   <%
    }
    }
 %>

  <form name="frmLogin" method="post" action="logar.jsp">
    <label>Login</label>
    <input type="text" name="login"/><br>
    <label>Senha</label>
    <input type="password" name="senha"/>
    <input type="submit" name="entrar" value="Entrar"/>
  
  
  </form>
</body>
</html>