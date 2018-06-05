<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Manuel López Reviriego">
    <!-- <link rel="icon" href="https://getbootstrap.com/favicon.ico">-->
    <link rel="stylesheet" href="styles/font-awesome.min.css">
    
    <!-- Bootstrap core CSS -->
    <link href="styles/bootstrap.css" rel="stylesheet">
    
    <link rel="stylesheet" href="styles/Prototipo.css"/>

    <!-- Custom styles for this template -->
    <link href="styles/dashboard.css" rel="stylesheet">
  	<style type="text/css">/* Chart.js */
	@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}
	</style>
    
	
	<title>IntelliDiet - <%= session.getValue("username") %></title>
</head>

  <body style="background-color: white">
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
                <a class="nav-link active" href="#">
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
            <h1 class="h2">Sugerencia de su asistente personal</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <div class="btn-group mr-2">
                <!--<button class="btn btn-sm btn-outline-secondary">Share</button>
                <button class="btn btn-sm btn-outline-secondary">Export</button>-->
              </div>
            </div>
          </div>
         </main>
         
         <%@ page import="java.util.*, prCompumatica.*, java.io.*" %>
         
         <div id="main-panel" class="col-md-9 ml-sm-auto col-lg-10">
         	 <div class="dish-panel">
		        <img class="dish-panel-img" src="<%= "images/dishes/" + session.getValue("breakfast") + ".jpg" %>" style="top: -50px;"></img>
		        <div class="dish-panel-footer"><%= session.getValue("breakfast")%><span class="label breakfast">DESAYUNO</span> 
		        <br>
		        <label style="font-weight: normal"><%= session.getValue("breakfast_cal") %> cal</label> • 
		        <label style="font-weight: normal"><%= session.getValue("breakfast_carbo") %> g de carbohidratos</label> • 
		        <label style="font-weight: normal"><%= session.getValue("breakfast_prot") %> g de proteínas</label> • 
		        <label style="font-weight: normal"><%= session.getValue("breakfast_gras") %> g de grasas</label>
		        </div>
			 </div>
			 
			 <div class="dish-panel">
		        <img class="dish-panel-img" src="<%= "images/dishes/" + session.getValue("lunch") + ".jpg" %>" style="top: -50px;"></img>
		        <div class="dish-panel-footer"><%= session.getValue("lunch")%><span class="label lunch">ALMUERZO</span> 
		        <br>
		        <label style="font-weight: normal"><%= session.getValue("lunch_cal") %> cal</label> • 
		        <label style="font-weight: normal"><%= session.getValue("lunch_carbo") %> g de carbohidratos</label> • 
		        <label style="font-weight: normal"><%= session.getValue("lunch_prot") %> g de proteínas</label> • 
		        <label style="font-weight: normal"><%= session.getValue("lunch_gras") %> g de grasas</label>
		        </div>
			 </div>
			 
			 <div class="dish-panel">
		        <img class="dish-panel-img" src="<%= "images/dishes/" + session.getValue("snack") + ".jpg" %>" style="top: -50px;"></img>
		        <div class="dish-panel-footer"><%= session.getValue("snack")%><span class="label snack">MERIENDA</span> 
		        <br>
		        <label style="font-weight: normal"><%= session.getValue("snack_cal") %> cal</label> • 
		        <label style="font-weight: normal"><%= session.getValue("snack_carbo") %> g de carbohidratos</label> • 
		        <label style="font-weight: normal"><%= session.getValue("snack_prot") %> g de proteínas</label> • 
		        <label style="font-weight: normal"><%= session.getValue("snack_gras") %> g de grasas</label>
		        </div>
			 </div>
			 
			 <div class="dish-panel">
		        <img class="dish-panel-img" src="<%= "images/dishes/" + session.getValue("dinner") + ".jpg" %>" style="top: -50px;"></img>
		        <div class="dish-panel-footer"><%= session.getValue("dinner")%><span class="label dinner">CENA</span> 
		        <br>
		        <label style="font-weight: normal"><%= session.getValue("dinner_cal") %> cal</label> • 
		        <label style="font-weight: normal"><%= session.getValue("dinner_carbo") %> g de carbohidratos</label> • 
		        <label style="font-weight: normal"><%= session.getValue("dinner_prot") %> g de proteínas</label> • 
		        <label style="font-weight: normal"><%= session.getValue("dinner_gras") %> g de grasas</label>
		        </div>
			 </div>
         </div>

      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-3.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.js"></script>

    <!-- Icons -->
    <script src="js/feather.js"></script>
    <script>
      feather.replace()
    </script>
  

</body>
</html>