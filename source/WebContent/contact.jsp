<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Manuel López Reviriego">
    <!-- <link rel="icon" href="https://getbootstrap.com/favicon.ico">-->
    
    <!-- Bootstrap core CSS -->
    <link href="styles/bootstrap.css" rel="stylesheet">
    
    <link rel="stylesheet" href="styles/contact.css">
    <link rel="stylesheet" href="styles/font-awesome.min.css">

    <!-- Custom styles for this template -->
    <link href="styles/dashboard.css" rel="stylesheet">
  	<style type="text/css">/* Chart.js */
	@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}
	</style>
	
	<script type="text/javascript" src="gstatic/loader.js"></script>
	<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
         ['Semana',            'Carbohidratos (g)', 'Proteínas (g)', 'Grasas (g)'],
         ['21 al 27 de mayo',               2011,        657,             110],
         ['28 al 3 de mayo',                1977,         628,            126],
      ]);

    var options = {
      title : 'Macronutrientes por semana',
      vAxis: {title: ''},
      hAxis: {title: ''},
      seriesType: 'bars',
      series: {5: {type: 'line'}}
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    	chart.draw(data, options);
  	}
    </script>
    
    <!-- jQuery library -->
	<script src="js/google_api/jquery.min.js"></script>
    <script>
    	$(document).ready(function(){
    		//typeWriter();
    	});
    	
    	var i = 0;
    	var txt = 'Bienvenido, soy tu asistente personal de IntelliDiet. En el menú lateral izquierdo, encontrarás varias opciones que te podrán ser de utilidad.'; /* The text */
    	var txt2 = "Si haces click sobre 'Asistente personal', te propondré una dieta adecuada para ti, dada tu condición física, sexo, alergias, etc.";
    	var txt3= "En la sección 'Estadísticas' te mostraré información que te podría resultar interesante."
    	var delay = 10; /* The speed/duration of the effect in milliseconds */
    	var phase = 0;    	
    	
    	function typeWriter() {
    		if(phase == 0){
	    	  if (i < txt.length) {
	    	    $("#demo").append(txt.charAt(i));
	    	    i++;
	    	  	setTimeout(typeWriter, delay);
	    	  } else{
	    		phase++;
	    		i = 0;
	    		$("#demo").append("<ul>");
	    		$("#demo").append("<li id='fst-li'>");
			  	setTimeout(typeWriter, delay*100);
	    	  }
    		} else if(phase == 1){
    			if (i < txt.length) {
    	    	    $("#fst-li").append(txt2.charAt(i));
    	    	    i++;
    	    	  	setTimeout(typeWriter, delay);
				} else{
					phase++;
					i = 0;
					$("#demo").append("<li>");
					setTimeout(typeWriter, delay*100);					
				}
    		} else if(phase == 2){
    			if (i < txt.length) {
    	    	    $("#demo").append(txt3.charAt(i));
    	    	    i++;
    	    	  	setTimeout(typeWriter, delay);
				} else{
					phase++;
					i = 0;
					$("#demo").append("</li>");
					setTimeout(typeWriter, 1000);					
				}
    		}
    	}

    </script>
	
	<title>IntelliDiet - <%= session.getValue("username") %></title>
</head>

  <body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">IntelliDiet</a>
      <input class="form-control form-control-dark w-100" placeholder="Buscar" aria-label="Search" type="text">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Cerrar sesión</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link" href="user.jsp">
                  <i class="fa fa-home" aria-hidden="true"></i>
                  Inicio <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/ai">
                  <i class="fa fa-commenting"></i>
                  Asistente personal
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="stats.jsp">
                  <i class="fa fa-pie-chart"></i>
                  Estadísticas
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <i class="fa fa-plus-circle"></i>
                  Platos personalizados
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <i class="fa fa-gear" aria-hidden="true"></i>
                  Configuración
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="#">
                  <i class="fa fa-envelope"></i>
                  Contacta con nosotros
                </a>
              </li>
            </ul>

            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Últimas sugerencias</span>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                  3 de junio de 2018
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file-text"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line x1="16" y1="13" x2="8" y2="13"></line><line x1="16" y1="17" x2="8" y2="17"></line><polyline points="10 9 9 9 8 9"></polyline></svg>
                  24 de mayo de 2018
                </a>
              </li>
            </ul>
          </div>
        </nav>

		<main id="stats-panel"  role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
		<div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Contacta con nosotros</h1>
          </div>
         </main>

		<!-- The Contact Section -->
		<div class="col-md-9 ml-sm-auto col-lg-10 px-4">
		<div class="w3-container w3-content" style="max-width:1000px" id="contact">
		  <div class="w3-row w3-padding-32">
		    <div class="w3-col m6 w3-large w3-margin-bottom">
		      <i class="fa fa-map-marker" style="width:30px"></i> Málaga, España<br>
		      <i class="fa fa-phone" style="width:30px"></i> Teléfono: +34 xxx xx xx xx<br>
		      <i class="fa fa-envelope" style="width:30px"> </i> Email: <a href="mailto:compumatica.uma@gmail.com" target="_top">compumatica.uma@gmail.com</a><br>
		    </div>
		    <div class="w3-col m6">
		      <form style="width: auto" action="/action_page.php" target="_blank">
		        <textarea class="w3-input w3-border" placeholder="Tu mensaje" required name="Message"></textarea>
		        <button class="w3-button w3-black w3-section w3-right" type="submit">ENVIAR</button>
		      </form>
		    </div>
		  </div>
		</div>
      </div>
      </div>
    </div>
    
    <div class="col-md-9 ml-sm-auto col-lg-10 px-4" id="googleMap" style="height:400px; filter:grayscale(100%)" class="w3-grayscale-max"></div>
	<script>
	function myMap() {
	  myCenter=new google.maps.LatLng(36.714995, -4.478639);
	  var mapOptions= {
	    center:myCenter,
	    zoom:14, scrollwheel: false, draggable: false,
	    mapTypeId:google.maps.MapTypeId.ROADMAP
	  };
	  var map=new google.maps.Map(document.getElementById("googleMap"),mapOptions);
	
	  var marker = new google.maps.Marker({
	    position: myCenter,
	  });
	  marker.setMap(map);
	}
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjiSzVmncGu2tr5eFx60OILctEFLRqf34&callback=myMap"></script>


</body></html>