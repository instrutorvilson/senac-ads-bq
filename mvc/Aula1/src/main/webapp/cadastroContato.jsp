<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadaastro de Contatos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
        <%@ include file="./menu.jsp" %>
	    <hr>
		<h1 class="text-center mt-5 mb-5">Cadastrar Contatos</h1>
		<form action="recebeDados.jsp" method="POST">
			<div>
				<label class="form-label">Informe nome</label> <input
					class="form-control" type="text" placeholder="Informe nome"
					name="nome">
			</div>
            <div class="mt-3">
                <label class="form-label">Informe idade</label> 
                <input class="form-control" type="number" placeholder="Informe idade" name="idade">
            </div>
            <div class="mt-5 d-flex justify-content-between">
               <button class="btn btn-outline-primary">Enviar</button>
               <input type="reset" class="btn btn-outline-danger" />
            </div>	
		</form>
	</div>
</body>
</html>