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

/**
 *
 * @author wangq
 */
@WebServlet(name = "WorkAddedSuccessServlet", urlPatterns = {"/work-added-success"})
public class WorkAddedSuccessServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.print("<html><head>Ėtat d'ajout de l'oeuvre<title></title></head>");
        //On complète le message avec une concaténation de l'attribut en portée "requet" 
        //  qui s'appelle "identifiantOeuvre". Cet attribut est fourni évidemment par la Servlet "AddWorkServlet"
        out.print("<body>L'oeuvre a été ajoutée avec succès ! Son identifiant (interne) est :");
        out.print(" "+request.getAttribute("identifiantOeuvre")+"</body></html>");
    }
}
