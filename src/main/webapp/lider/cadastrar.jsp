<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Lideres</title>
</head>
<body>
  <h1>Cadastro de Lideres</h1>
  <form name="frmCadastro" method="post" action="salvar.jsp">
    <label>Nome</label>
    <input type="text" name="nome" value=""/>
    <br/>
    <label>CPF</label>
    <input type="text" name="cpf" value=""/>
    <br/>
    <label>Telefone</label>
    <input type="text" name="telefone" value=""/>
    <br/>
    <label>Cidade</label>
    <input type="text" name="cidade" value=""/>
    <br/>
    <label>Estado</label>
    <select name="estado">
      <option value="SP">Sao Paulo</option>
      <option value="RJ">Rio de Janeiro</option>    
    </select>
    <br/>
    <label>Data de Nascimento</label>
    <input type="text" name="dataNascimento" value=""/>
    <br/>
    <input type="submit" name="salvar" value="Salvar"/>
  </form>



</body>
</html>