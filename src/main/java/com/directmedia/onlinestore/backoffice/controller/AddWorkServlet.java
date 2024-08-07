/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;

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
        //On va d'abord créer un "boolean" qui s'appelle "succcess" et il est initialisé en "true".
        boolean success = true;
        
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
        
        //On va tester que l'année de parution soit bien un entier en utilisant un "try" "catch" autour de l'instruction qui effectue
        //  la conversion "Integer.parseInt"
        try{
            nouvelleOeuvre.setRelease(Integer.parseInt(request.getParameter("release")));
        }
        //Dans ce cas d'exception, on va passer simplment "success" à "false"
        catch(NumberFormatException nfe){
            success = false;
        }
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
        
        //Deuxième critère à vérifier, vérifier que l’œuvre que l’on souhaite ajouter au catalogue n’existe pas déjà dans notre catalogue. 
        //Pour ce faire, il faut aller voir dans le catalogue s'il existe une autre oeuvre qui a des mêmes attributs. 
        //On doit donc itérer sur le catalogue, (On va faire avec et sans l'API "stream")
        
        //1. Sans l'API "stream"
        /*for (Work work : Catalogue.listOfWorks){
            if (work.getTitle().equals(nouvelleOeuvre.getTitle()) && work.getRelease() == nouvelleOeuvre.getRelease() && 
                    work.getMainArtist().getName().equals(nouvelleOeuvre.getMainArtist().getName())){
                success = false;
            }
        }*/
        
        //2. Avec l'API "stream". Il va s'agir de filtrer les oeuvres du Catalogue en recherchant une oeuvre qui respecterait les
        //  conditions que l'on avait utilisées.
        Optional<Work> optionalWork = Catalogue.listOfWorks.stream().filter(work -> work.getTitle().equals(nouvelleOeuvre.getTitle()) && 
                work.getRelease() == nouvelleOeuvre.getRelease() && work.getMainArtist().getName().equals(nouvelleOeuvre.getMainArtist().getName())).findAny();
        //S'il existe effectivement déjà une oeuvre au cataolgue avec ces critères, on va passer "success" à "false".
        if (optionalWork.isPresent()){
            success = false;
        }
        
        //On veut maintenant produire un résultat en fonction des états de « success » : « true » ou « false ».
        
        //On ne va bien sûr ajouter l'oeuvre au catalogue que si "success" vaut "true"
        
        RequestDispatcher disp = null;
        if (success){
            Catalogue.listOfWorks.add(nouvelleOeuvre);
            //On va donc nous diriger vers la Servlet "WorkAddedSuccessServlet"
            
            //Juste avant d'utiliser le "RequestDispatcher" on va ajouter
            request.setAttribute("identifiantOeuvre", nouvelleOeuvre.getId());
            disp = request.getRequestDispatcher("/work-added-success");    
        }
        //Dans le cas d'échec
        else{
            disp = request.getRequestDispatcher("work-added-failure");
        }
        
        disp.forward(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
    }
}
