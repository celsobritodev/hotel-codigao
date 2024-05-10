<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dominio.Lider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="persistencia.LiderBD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de lideres</title>
</head>
<body>
 <h1> Lista de Lideres</h1>
 
 <table>
  <thead>
     <tr>
      <th>CPF</th>
      <th>Nome</th>
      <th>Data de Nascimento</th>
      <th></th>
     
     </tr>
     
  </thead>
  
  <tbody>
 <%
 
  
   SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
 
   ArrayList<Lider> lideres = LiderBD.listar();
 
   for(int i=0; i< lideres.size(); i++) {
	   Lider cadaLider = lideres.get(i);
	   String dataNascimento ="";
	   if (cadaLider.getDataNascimento()!=null) {
		   dataNascimento = formato.format(cadaLider.getDataNascimento());
	   }
	   %>
	    <tr>
	    
	     <td><%=cadaLider.getCpf() %></td>
	     <td><%=cadaLider.getNome() %></td>
         <td><%=dataNascimento %></td>
	     <td>
	      <a href="cadastrar.jsp?cpf=<%=cadaLider.getCpf()%>">Alterar</a>
	      <a href="excluir.jsp?cpf=<%=cadaLider.getCpf()%>" onclick="return confirm('Exclui?')">Excluir</a>
	     </td>
	    </tr>
	   <%
	   
	   out.println(cadaLider.getNome());
   }
 
  
 %>
 </tbody>

 </table>
 
 
</body>
</html>