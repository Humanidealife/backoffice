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
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

   

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (Catalogue.listOfWorks.isEmpty()){
        
        //Il va s'agir de créer 3 oeuvres artistiques (Artist compris)
        //Pour instancier Artise, il faut faire l'import
        Artist tomCruise = new Artist("Tom Cruise");
        Artist michaelJackson = new Artist("Michael Jackson");
        Artist louisDeFunes = new Artist("Louis De Funès");
        
        //Et 3 oeuvres associées
        Work minorityReport = new Work("Minority Report");
        Work bad = new Work("Bad");
        Work leGendarmeDeSaintTropez = new Work("Le gendarme de Saint-Tropez");
        
        minorityReport.setMainArtist(tomCruise);
        bad.setMainArtist(michaelJackson);
        leGendarmeDeSaintTropez.setMainArtist(louisDeFunes);
        
        minorityReport.setRelease(2002);
        bad.setRelease(1987);
        leGendarmeDeSaintTropez.setRelease(1964);
        
        minorityReport.setSummary("En 2054, la société du futur a éradiqué les crimes en se dotant d'un système de prévention, de détection et de répression le plus sophistiqué du monde. Dissimulés de tous, trois extras-lucides transmettent les images des crimes à venir aux policiers de la Précrime. ");
        bad.setSummary("un jeune homme originaire d'un quartier pauvre et malfamé de la ville de New York, revient de son école privée pour garçons pour les vacances d'hiver. Il retrouve sa bande avec qui il faisait des mauvais coups");
        leGendarmeDeSaintTropez.setSummary("Suite à une promotion, le gendarme Cruchot doit quitter son petit village provençal pour aller s'installer à Saint-Tropez. Une fois sur place, le gendarme fait preuve de beaucoup d'ambition et de dynamisme. Folle de joie, sa fille le suit et ne tarde pas à se faire de nouvelles relations parmi les estivants. Au grand désarroi de son père, elle se fait passer pour la fille d'un milliardaire, ce qui va lui valoir de sacrés ennuis.");
        
        minorityReport.setGenre("Science Fiction");
        bad.setGenre("Pop");
        leGendarmeDeSaintTropez.setGenre("Comédie");
        
        //Il ne ous reste à rajouter ces oeuvres au "Catalogue"
        Catalogue.listOfWorks.add(minorityReport);
        Catalogue.listOfWorks.add(bad);
        Catalogue.listOfWorks.add(leGendarmeDeSaintTropez);
        }
        
        out.print("<html><body><h1>Oeuvres au catalogue</h1><BR/><BR/>");
        
        for (Work work : Catalogue.listOfWorks) {
            out.println(work.getTitle()+ "("+work.getRelease()+ ")<BR/>");
        }
        
        out.print("</body></html>");
    }
        

}
