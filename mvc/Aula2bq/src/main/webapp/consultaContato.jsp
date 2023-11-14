<%@page import="utils.Conexao"%>
<%@page import="models.Contato"%>
<%@page import="java.util.List"%>
<%@page import="controllers.ContatoController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta Contato</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
    <div class="container">
      <%@ include file="./menu.jsp" %>
      
         <table class="table table-striped table-hover">
            <thead class="table-info">
               <tr>
                  <th>Id</th>
                  <th>Nome</th>
                  <th>Email</th>
                  <th>Ações</th>
               </tr>
            </thead>
            <tbody>
               <!-- preenche de forma dinamica -->
               <%
                   ContatoController cc = new ContatoController(); 
                   List<Contato> contatos = cc.getContatos();
                   String linhas = "";
                   for(int i = 0; i < contatos.size(); i++){
                	  Contato ct = contatos.get(i); 
                	  linhas += "<tr><td>"+ct.getId()+"</td><td>"+ct.getNome()+"</td><td>"+ct.getEmail()+"</td></tr>";
                   }
                   out.print(linhas);
               %>
               <%
                  if(Conexao.conectar() != null){
                	  out.print("conectao");
                  }
               %>
             
             <!--    
             <tr>
                   <td>1</td>
                   <td>Maria</td>
                   <td>maria@gmail.com</td>
                   <td><a href="#">Editar</a> <a href="#">Excluir</a> </td>
               </tr>
                <tr>
                   <td>2</td>
                   <td>jose</td>
                   <td>jose@gmail.com</td>
                   <td><a href="#">Editar</a> <a href="#">Excluir</a> </td>
               </tr>
                <tr>
                   <td>3</td>
                   <td>joao</td>
                   <td>joao@gmail.com</td>
                   <td><a href="#">Editar</a> <a href="#">Excluir</a> </td>
               </tr> 
               -->
            </tbody>
         </table>
    </div>
</body>
</html>