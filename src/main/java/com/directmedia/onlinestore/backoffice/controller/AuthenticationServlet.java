/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.directmedia.onlinestore.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author wangq
 */
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //On va récupérer les valeurs des deux champs de saisie.
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        //On va donc vérifier 
        if (login.equals("michel")&&password.equals("123456")||login.equals("caroline")&&password.equals("abcdef")){
           
            //Quand l'authentification est un succès, on écrit un lien pour retourner à l'accueil
           out.print("Bonjour " + login + " ! Vous êtes connecté(e) avecc succès !<br>");
           //Dans le bloc qui correspond à une authentification avec succès
           //On va d'abord récupérer cet Objet de Session. Pour rappel, "request.getSession()" va récupérer une Session existante si celle-ci a déjà été générée; 
           //  dans le cas contraire "request.getSession()" va en créer une nouvelle. 
            HttpSession session = request.getSession();
           //Dans cet Objet de Session "session" on va stocker le "login" de l'utilisateur connecté (c'est le deuxième argument de cette méthode, c'est donc login)
           //  grâce à "setAttribute()". La "clé" est complètemet libre, icic on la met en "login".
           session.setAttribute("login", login);
           out.print("<a href=\"home\">Retourner à la page d'accueil</a>");
        }
        else{
           out.print("l'identifiant et/ou le mot de passe erroné(s)<br>");
           out.print("<a href=\"login.html\">Vous pouvez réessayer de vous connecter en cliquant sur ce lien !</a>");
        }
        out.print("</body></html>");
    }

}
