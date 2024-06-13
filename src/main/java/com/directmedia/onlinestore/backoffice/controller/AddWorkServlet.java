/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.directmedia.onlinestore.backoffice.controller;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Bien évidemment avant de fournir une réponse, il va fallor que l'on crée cette nouvelle oeuvre et 
        //  que l'on l'ajoute au catalogue. 
        //Pour créer l'oeuvre, on peut profiter de la construction de cette nouvelle oeuvre 
        //  pour passer en paramètre le titre de l'oeuvre. 
        //  Et le paramètre qui nous a envoyé au travers de la requête en provenance duformulaire s'appelle "title"
        Work nouvelleOeuvre = new Work (request.getParameter("title"));
        
        
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
