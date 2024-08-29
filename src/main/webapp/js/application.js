/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function(){
    $('a[href=catalogue').on('click', function (event){
        event.preventDefault();
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
