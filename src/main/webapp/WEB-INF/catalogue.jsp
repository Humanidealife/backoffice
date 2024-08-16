<%-- 
    Document   : catalogue
    Created on : 25 juil. 2024, 17:42:53
    Author     : wangq
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catalogue</title>
    </head>
    <body>
        <h1>Oeuvres au catalogue</h1>
        <!-- 
        On va remplacer cette section de code Java par de la JSTL.
        La variable qui se trouve dans le Scope "request" s'appelle "listeDEsOeuvres".
        On va donner un nom à la variable qui va récupérer chaque élément de l'itération, "work".
        -->
        <c:forEach items="${requestScope.listeDesOeuvres}" var="work">
            ${work.title} (${work.release})<BR/>
        </c:forEach>
        <a href="home.jsp">Retourner à la page d'accueil</a><br>    
    </body>
</html>
