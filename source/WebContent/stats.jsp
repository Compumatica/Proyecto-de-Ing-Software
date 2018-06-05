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
    <link rel="stylesheet" href="styles/font-awesome.min.css">
    
    <!-- Bootstrap core CSS -->
    <link href="styles/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="styles/dashboard.css" rel="stylesheet">
  	<style type="text/css">/* Chart.js */
	@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}
	</style>
	
	<script type="text/javascript" src="js/gstatic/loader.js"></script>
	<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart', 'line']});
      google.charts.setOnLoadCallback(drawChart1);
      google.charts.setOnLoadCallback(drawChart2);

      function drawChart1(){
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
      
      function drawChart2() {
		  var data = new google.visualization.DataTable();
		  data.addColumn('string', 'Día');
		  data.addColumn('number', 'Calorías consumidas');
		  data.addColumn('number', 'Calorías recomendadas');
			
		  data.addRows([
			  ["Miércoles",  2000, 2200],
			  ["Jueves",  2107, 2200],
			  ["Viernes",  2215, 2200],
			  ["Sábado",  2130, 2200],
			  ["Domingo",  2163, 2200],
			  ["Lunes",  2317, 2200],
			  ["Martes",  2220, 2200],
		  ]);
		
		  var options = {
			title : 'Calorías consumidas por día',
			width: 900,
		  	height: 500
		  };
		
		  var chart = new google.charts.Line(document.getElementById('chart2_div'));
			
		  chart.draw(data, google.charts.Line.convertOptions(options));
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
                <a class="nav-link active" href="#">
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
                <a class="nav-link" href="contact.jsp">
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

		<!-- Estadísticas -->
		<main id="stats-panel"  role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
		<div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Estadísticas</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <div class="btn-group mr-2">
                <button class="btn btn-sm btn-outline-secondary">Compartir</button>
                <button class="btn btn-sm btn-outline-secondary">Exportar</button>
              </div>
            </div>
          </div>
         </main>
         <div >
         	<div id="chart_div" style="margin-left: 30%;display: block; width: 900px; height: 500px;"></div>
         	<div id="chart2_div" style="margin-left: 30%;display: block; width: 900px; height: 500px;"></div>
         </div>
      </div>
    </div>
</body>
</html>