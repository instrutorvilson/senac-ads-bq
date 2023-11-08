<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>hello world</h1>
    <form action="recebeDados.jsp" method="POST">
       <label>Informe nome</label>
       <input type="text" placeholder="Informe nome" name="nome">
       
       <label>Informe idade</label>
       <input type="number" placeholder="Informe idade" name="idade">
       <button>Enviar</button>
    </form>
</body>
</html>