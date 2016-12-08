 $(document).ready(function() {


/*---------------------------------------------------------------- One Page Navigation -------------------------------*/


	$('.nav').onePageNav({
	filter: ':not(.external)',
	scrollThreshold: 0.25,
	scrollOffset: 177
	});
         
       



/*---------------------------------------------------------------- Nivo Slider -------------------------------*/

    $(window).load(function() {
        $('#slider').nivoSlider();
    });


/*--------------------------------------------------------------------------- ToTop -------------------------------*/

     $(window).scroll(function(){
         if ($(this).scrollTop() > 100) {
             $('.scrollup').fadeIn();
         } else {
             $('.scrollup').fadeOut();
         }
     });

     $('.scrollup').click(function(){
         $("html, body").animate({ scrollTop: 0 }, 600);
         return false;
     });
     var screen= window.innerWidth;
     if(screen>=980){
         $('.scrollup').removeClass('hidden');
     }else{
         $('.scrollup').addClass('hidden');
     }

     $(window).resize(function(){
         var screen= window.innerWidth;
         if(screen>=980){
             $('.scrollup').removeClass('hidden');
         }else{
             $('.scrollup').addClass('hidden');
         }
     });




/*------------------------------------ Select customer---------------------------------------------------------------*/
     $('.chzn-select').chosen({
         disable_search_threshold: 10,
         no_results_text: "Oops, nothing found!",
         width: "100%"
     });



/*------------------------------------ Tooltip ---------------------------------------------------------------*/

     jQuery('.copyright  li').tooltip();



/*------------------------------------ Accordeon---------------------------------------------------------------*/
     jQuery(".accordion-body").live({
         show:function(){
             jQuery(this).parent().find(".accordion-heading a").addClass("open");
             jQuery(this).parent().find(".accordion-heading a i").addClass("icon-minus");
             jQuery(this).parent().find(".accordion-heading a i").removeClass("icon-plus");
         },
         hide:function(){
             jQuery(this).parent().find(".accordion-heading a").removeClass("open");
             jQuery(this).parent().find(".accordion-heading a i").removeClass("icon-minus");
             jQuery(this).parent().find(".accordion-heading a i").addClass("icon-plus");
         }
     });




/*------------------------------------ Google Map ---------------------------------------------------------------*/
    if ($('#map').length) {
        
        var map;
        map = new GMaps({
            div: '#map',
            lat: 41.8902624,
            lng: 12.4923096
        });

        map.addMarker({
            lat: 41.8902624,
            lng: 12.4923096,
            title: 'Contanct',
            infoWindow: {
                content: '15rd Avenue, New York,<br /> 156408, US<br /> <br /> Email: info@company.com <br /> Web: company.com'
            }
        });

    }


/*------------------------------------ Bxslider ---------------------------------------------------------------*/
     $('.bxslider').bxSlider({
         minSlides: 2,
         maxSlides: 12,
         slideWidth: 63,
         slideMargin: 23,
         moveSlides: 1,
         pager: false,
         auto:true,
         onSliderLoad: function(){
             // do funky JS stuff here
             jQuery('.console_img a').tooltip();
         },
         nextText:'next',
         prevText:'prev'
     });
	
	
	
	


/*---------------------------------------------------------------- Responsive Video -------------------------------*/

    $(".video").fitVids();


	
	
	   
});
