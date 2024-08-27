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
        
        <!-- 
        Dans cette balise on va exprimer la condition dans un attribut qui s'appelle "test", et on va exprimer cette condition au
          travers des JSP EL. Ce qui nous intéresse ici en l'occurence, c'est de savoir qu'il existe bien en Session un attribut qui
          s'appelle "login". "not empty login" sigifie "vérifier qu'il existe dans un Scope, n'importe lequel, un attribut qui n'est 
          pas vide (si c'est une String vide, cela ne marcherait pas) qui s'appelle "login".
        Cette syntaxe "not empty login", on ne peut pas l'inventer. Pour référence, on peut consulter une documentation officielle pour 
          syntaxe des JSP EL. On a certain mots clés comme "empty" ou autre.
        Lorsque la condition est respectée, on pourrait faire certain nombre de choses, par exemple, "afficher du contenu".
        -->
        <c:if test="${not empty login}">
        
            Bonjour ${sessionScope.login}
                <button onclick="window.location.href='logout'">Déconnexion</button><br>
        <!-- Pour terminer la balise de "if" -->
        </c:if>
        <a href="catalogue">Afficher le catalogue des oeuvres</a><br>
        <a href="add-work-form.html">Ajouter une oeuvre au catalogue</a>
    </body>
</html>
