/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function(){
    $('a[href=catalogue').on('click', function (event){
        //Cela veut dire que lorsque l'on clique sur le lien, le comportement normal (c'est-à-dire aller vers une autre page)
        //  est annulé.
        event.preventDefault();
        //Cette condition est pour s'assurer que lorsque l'on clique sur le lien, le catalogue n'est pas déjà affiché pour éviter 
        //  des doublons d'affichage de catalogue.
        if ($('body').children().length<6){
            $.ajax({
                url:"catalogue",
                success: function(result){
                    $("a[href=catalogue]").after('<br>'+result);
                }
            });
        }
    });
});
