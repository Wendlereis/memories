$(function(){   
	var nav = $('#menu');   
	$(window).scroll(function () { 
		if ($(this).scrollTop() > 250) { 
			nav.addClass("menu-fixo"); 
		} else { 
			nav.removeClass("menu-fixo"); 
		} 
	});

	$(document).ready(function(){
	    $("#seta1").click(function(){
	        $("#sec01").fadeOut("slow");
	        $("#sec02").fadeIn("slow");	        
	    });

	     $("#seta2").click(function(){
	        $("#sec01").fadeIn("slow");
	        $("#sec02").fadeOut("slow");	        
	    });
	});
});

