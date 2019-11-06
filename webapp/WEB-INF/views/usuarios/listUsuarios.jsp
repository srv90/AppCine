<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Usuarios</title>
    <spring:url value="/resources" var="urlPublic"></spring:url>
	<spring:url value="/usuarios/create" var="urlCreate" ></spring:url>
	<spring:url value="/usuarios/edit" var="urlEdit" ></spring:url>
	<spring:url value="/usuarios/delete" var="urlDelete" ></spring:url>

    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
	<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

    
  </head>

  <body>

    <!-- Fixed navbar -->
     <jsp:include page="../includes/menu.jsp"></jsp:include>


    <div class="container theme-showcase" role="main">

      <h3>Listado de Usuarios</h3>
      
      <a href="${urlCreate}" class="btn btn-success" role="button" title="Nuevo Usuario" >Nuevo usuario</a><br><br>
        <c:if test="${msg !=null }">        
    		<div class='alert alert-success' role='alert'>${msg}</div>
        </c:if>	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Cuenta</th>
                <th>Password</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Perfil</th>
                <th>Activo</th>
                <th>Opciones</th>
            </tr>
           <c:forEach var="usuario" items="${usuarios}">
            <c:forEach var="perfil" items="${perfiles}">
             <c:if test="${usuario.cuenta eq perfil.cuenta }">
              <tr>
                <td>${usuario.cuenta}</td>
                <td>${usuario.pwd}</td>
                <td>${usuario.email}</td>
                <td>${usuario.telefono}</td>
                <td>${perfil.perfil}</td>
                <c:choose>
                 <c:when test="${usuario.activo eq '1'}">
                  <td><span class="label label-success">Activo</span></td>
                 </c:when>
                 <c:otherwise>
                  <td><span class="label label-danger">Inactivo</span></td>
                 </c:otherwise>
                </c:choose>
                <td>
                    <a href="${urlEdit}/${usuario.id}/${perfil.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${usuario.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" onclick='return confirm("¿Estas seguro?")' ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
 			</c:if>
        </c:forEach>
       </c:forEach>
      
      
        </table>
      </div>
          
      <hr class="featurette-divider">

      <!-- FOOTER -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>


    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>
