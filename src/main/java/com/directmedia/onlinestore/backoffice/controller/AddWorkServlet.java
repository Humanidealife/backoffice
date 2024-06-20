/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author wangq
 */
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Bien évidemment avant de fournir une réponse, il va fallor que l'on crée cette nouvelle oeuvre et 
        //  que l'on l'ajoute au catalogue. 
        //Pour créer l'oeuvre, on peut profiter de la construction de cette nouvelle oeuvre 
        //  pour passer en paramètre le titre de l'oeuvre. 
        //  Et le paramètre qui nous a envoyé au travers de la requête en provenance du formulaire s'appelle "title"
        Work nouvelleOeuvre = new Work (request.getParameter("title"));
        //On va également valoriser toutes les autres propriétés de nouvelleOeuvre
        nouvelleOeuvre.setGenre(request.getParameter("genre"));
        //Il faut transformer cette String en "int", on peut noter ici que le "Integer.parseInt" peut ne pas fonctionner, 
        //  si l'administrateur entre dans le champ de saisie HTML n'importe quoi, par exemple les lettres, "Interger.parseInt"
        //  va générer une exception. (En général, on préfère que l'utilisateur reçoive un message pour lui dire que une année de 
        //  sortie devrait être au format numérique. Mais ce message pourrait être généré au niveau du formulaire ou au niveau BD ! )
        nouvelleOeuvre.setRelease(Integer.parseInt(request.getParameter("release")));
        nouvelleOeuvre.setSummary(request.getParameter("summary"));
        //Alors ici, il va falloir instancier un Objet de type "Artist", parce que'il faut que l'on passe un Objet de type "Artist" 
        //  en paramètre afin de créer la propriété "mainArtist" pour la "nouvelleOeuvre".
        //  Et dasn le constructeur de "Artist", on passe en paramètre "artist" qui est récupéré par le formulaire.
        nouvelleOeuvre.setMainArtist(new Artist(request.getParameter("artist")));
        
        //Maintenant on va ajouter cette "nouvelleOeuvre" au "Catalogue", il ne faut pas se tromper de Class 
        //  (à importer pour "Catalogue") qui vient de "core.entity"
        //En ce qui concerne l'"id", notre "nouvelleOeuvre" n'a pas encore de "id"
        //Mais comme ce qui est indiqué dans le sujet, on va essayer de fournir une solution qui permet automatiquement d'attribuer
        //  un "id" à ces nouvelles oeuvres (mais pour faire cela, il faut retourner dans le module "core" et puis dans la CLass "Work")
        Catalogue.listOfWorks.add(nouvelleOeuvre);
        
        
        response.setContentType("text/html;charset=UTF-8");
        //Comme on pourrait avoir beaucoup de ligne de code HTML, il serait plus lisible d'écrire ces lignes de HTML
        //  avec un "text blocks"
        try (PrintWriter out = response.getWriter()){
            String htmlReponse = """
                <!DOCTYPE html>
                <!--
                Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
                Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
                -->
                <html>
                    <head>
                        <!-- cette balise "title" correspond au title qui va s'affichier dans le navigateur pour cette page -->
                        <title>Ėtat d'ajout de l'oeuvre</title>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    </head>
                    <body>
                        L'oeuvre a été ajoutée avec succès !<br>
                        <a href="home">Cliquer ici pour retourner à la page d'accueil</a>
                    </body>
                </html>
                                 """;
            out.println(htmlReponse);
        }
        
    }

}
