<%-- 
    Document   : calculadora
    Created on : Oct 12, 2018, 1:37:44 AM
    Author     : atomsk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String result="";
    if(request.getAttribute("result") != null){
	result=(String) request.getAttribute("result");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet">
        <title>Menú de Cookies</title>
    </head>
    <body class="calc-input">
         <main>
            <h1>Calculadora MVC</h1>
            <section>
                <div class="show-message"></div>
            </section>
            <form class="botonera" method="get" action="Controlador">
		<input type="number" name="val1" value="">
		<div>
		    <input type="radio" name="op" id="suma" value="suma"><label for="suma"></label>
		    <input type="radio" name="op" id="resta" value="resta"><label for="resta"></label>
		    <br>
		    <input type="radio" name="op" id="prod" value="prod"><label for="prod"></label>
		    <input type="radio" name="op" id="div" value="div"><label for="div"></label>
		    <br>
		    <input type="submit" name="send" value="=">
		</div>
		<input type="number" name="val2" value="">
            </form>
	    <section class="result"><%=result%></section>
        </main>
    </body>
</html>
