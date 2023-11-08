<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  String nome = request.getParameter("nome");
  int idade = Integer.parseInt(request.getParameter("idade"));
  
  String msg = "maior";
  if(idade < 18){
	  msg = "menor";
  }
  
  out.print("Seu nome é: " + nome + " vc tem " + idade + " e vc é " + msg);
%>