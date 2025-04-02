<%-- 
    Document   : clientes
    Created on : 1 de abr. de 2025, 19:38:46
    Author     : alunocmc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.Date"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Controle de Clientes</h1>
        <%
            Cliente cli = new Cliente();
            cli.setCod(Integer.parseInt(request.getParameter("cod")));
            cli.setNome( request.getParameter("nome"));
            cli.setRenda(Double.parseDouble(request.getParameter("renda")));
            cli.setNasc( new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("nascimento")));

            ClienteDAO clienteDao = new ClienteDAO();
            if (clienteDao.inserir(cli)){
                out.println("Cliente inserido com Sucesso!");
            }else{
                out.println("Cliente não Cadastrado");
            }
                
        %>
    </body>
</html>
