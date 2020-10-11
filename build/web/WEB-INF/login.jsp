<%-- 
    Document   : login
    Created on : 11-Oct-2020, 12:09:51 PM
    Author     : cprg352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login page</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action="login" method="post">
            Username: <input type="string" name="username"></br>
            Password: <input type="string" name="password"></br>
            <input type="submit" value="login">
        </form>
    </body>
</html>
