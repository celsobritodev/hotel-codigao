<%@page import="persistencia.LiderBD"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.Lider"%>
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
    String nome = request.getParameter("nome");
    String cpf = request.getParameter("cpf");
    String telefone = request.getParameter("telefone");
    String dataNascimento = request.getParameter("dataNascimento");
    String cidade = request.getParameter("cidade");
    String estado = request.getParameter("estado");
    
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date data = formato.parse(dataNascimento);
    java.sql.Date sqlDate = new java.sql.Date(data.getTime()); 
  
    
    Lider lider = new Lider();
    lider.setNome(nome);
    lider.setCpf(cpf);
    lider.setCidade(cidade);
    lider.setEstado(estado);
    lider.setDataNascimento(sqlDate);
    lider.setTelefone(telefone);
    LiderBD.inserir(lider);
    
  %>
   Lider cadastrado com sucesso!
  <br/>

</body>
</html>