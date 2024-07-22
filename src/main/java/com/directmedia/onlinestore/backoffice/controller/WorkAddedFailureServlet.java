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
@WebServlet(name = "WorkAddedFailureServlet", urlPatterns = {"/work-added-failure"})
public class WorkAddedFailureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body> Une erreur est survenue, l'oeuvre n'a pas été ajoutée !<br>");
        out.print("<a href=\"home.jsp\">Cliquer ici pour retourner à la page d'accueil</a></body></html>");
    }
}
