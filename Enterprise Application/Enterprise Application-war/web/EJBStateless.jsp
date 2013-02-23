<%-- 
    Document   : EJBStateless
    Created on : Dec 21, 2012, 2:42:05 PM
    Author     : Calebe de Paula Bianchini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EJB Stateless</title>
    </head>
    <body>
        <h1>EJB Stateless</h1>
        <h2>Entre com os valores:</h2>
        <form action="EJBStatelessServlet" method="post">
            <table>
                <tr>
                    <td>String</td>
                    <td>Double</td>
                    <td>Int</td>
                </tr>
                <tr>
                    <td><input name="string_value" type="text" size="50"/></td>
                    <td><input name="double_value" type="text" size="5"/></td>
                    <td><input name="int_value" type="text" size="2"/></td>
                </tr>
            </table>
            <input type="submit" value="Enviar"/>
            <br/><br/>
            <a href=".">Voltar</a>
        </form>
    </body>
</html>
