window.onload = navIconAnimation;

function navIconAnimation() {

	let icon = document.querySelector('.nav-icon-menu');
	
	icon.addEventListener('click', (event) => {
	    icon.classList.toggle("open");
	  });
}

$(document).ready(function(){

	$('#collapsibleNavbar').on('show.bs.collapse', function () {
	  $('.login-icon').css('display', 'none');
	  $('.nav-languages').css('display', 'none');
	});

	$('#collapsibleNavbar').on('hidden.bs.collapse', function () {
	  $('.login-icon').css('display', 'inline');
	  $('.nav-languages').css('display', 'flex');
	});
	
});

$(window).on('orientationchange',function(){

	if(window.innerHeight > window.innerWidth){
    	//portrait
	}
	
	if(window.innerWidth > window.innerHeight){
    	//landscape
    	
   	  $('.login-icon').css('display', 'inline');
	  $('.nav-languages').css('display', 'flex');
	}

});