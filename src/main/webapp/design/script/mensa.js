window.onload = navIconAnimation;

// Use declared function i.s.o. anonymous function, otherwise window.onload will be overridden!
function navIconAnimation() {

	let icon = document.querySelector('.navbar-toggler-icon-animated');
	
	icon.addEventListener('click', (event) => {
	    icon.classList.toggle("open");
	  });
}

// Needed for conditional rendering depending on menu collapsed state
$(document).ready(function(){

	$('#collapsibleNavbar').on('show.bs.collapse', function () {
      $('.nav-languages').css('display', 'flex');
	});

	$('#collapsibleNavbar').on('hidden.bs.collapse', function () {
      $('.nav-languages').css('display', 'none');
	});
	
});

// Needed for conditional rendering depending on screen size
$(window).on('orientationchange',function(){

	if(window.innerHeight > window.innerWidth){
    	//portrait
    	
      $('.nav-languages').css('display', 'none');
	}
	
	if(window.innerWidth > window.innerHeight){
    	//landscape
    	
	  $('.nav-languages').css('display', 'flex');
	}

});
