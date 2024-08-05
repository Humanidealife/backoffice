<%-- 
    Document   : home
    Created on : 22 juil. 2024, 21:41:37
    Author     : wangq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Onlinestore - Accueil du back-office</title>
    </head>
    <body>
        <h1>OnlineStore - Gestion de la boutique</h1>
        <!-- Ce qui est dynamique est le nom venant de l'attribut "login" dans la Sessoin utilisateur. Comme il s'agit simplement 
        d'afficher quelque chose, on va pourvoir utiliser "="
        L'objectif final est de n'afficher cette page d'accueil qu'après "Authentification".
        Mais on sait que pour l'instant, rien n'oblige l'utilisateur à passer par la page "login" avant d'aller sur la page "home".
        L'authentification ne sert donc pas à grande chose, si ce n'est juste de connaître l'identité de l'aministrateur.
        La page authentification ne protège de rien.
        On pourrait, l'histoire d'utiliser un peu les "scriptlet", dire que l'on n'affiche "Bonjour" avec l'identité de l'aministrateur 
        que cette personne est réellement identifié.(Ceci n'est pas demandé dans l'exercice)
        -->
        
        <%
            //On va mettre le "login" dans une variable, mais on est le seul à savoir que le "login" est un String, 
            //  il faut castrer le résultat.
            String login = (String)session.getAttribute("login");
            //Dans le cas la personne est identifiée, on ferme notre "scriptlet"
            if(login!=null){%>
            Bonjour ${sessionScope.login}
                <button onclick="window.location.href='logout'">Déconnexion</button><br>
            <%}%>
        <a href="catalogue.jsp">Catalogue des oeuvres</a><br>
        <a href="add-work-form.html">Ajouter une oeuvre au catalogue</a>
    </body>
</html>
