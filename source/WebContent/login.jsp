<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>IntelliDiet - Iniciar sesión</title>

    <!-- Bootstrap core CSS -->
    <link href="styles/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="styles/floating-labels.css" rel="stylesheet">
  </head>

  <body>
    <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/login">
      <div class="text-center mb-4">
        <!--<img class="mb-4" src="Floating%20labels%20example%20for%20Bootstrap_files/bootstrap-solid.html" alt="" width="72" height="72">-->
        <h1 class="h3 mb-3 font-weight-normal">IntelliDiet</h1>
        <p></p>
      </div>

      <div class="form-label-group">
        <input name="username" id="inputEmail" class="form-control" placeholder="Nombre de usuario" required="" autofocus="" type="text">
        <label for="inputEmail">Nombre de usuario</label>
      </div>

      <div class="form-label-group">
        <input name="password" id="inputPassword" class="form-control" placeholder="Password" required="" type="password">
        <label for="inputPassword">Contraseña</label>
      </div>

      <div class="checkbox mb-3">
        <label>
          <input value="remember-me" type="checkbox"> No cerrar sesión
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesión</button>
      <p class="mt-5 mb-3 text-muted text-center">© 2018-2019</p>
    </form>
  

</body></html>