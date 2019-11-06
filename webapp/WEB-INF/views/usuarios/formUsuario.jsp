<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<title>Creacion de Usuarios</title>
		<spring:url value="/resources" var="urlPublic" />
		<spring:url value="/usuarios/save" var="urlForm" />
		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
	</head>

	<body>

		<jsp:include page="../includes/menu.jsp" />

		<div class="container theme-showcase" role="main">

			<h3 class="blog-title"><span class="label label-success">Datos del Usuario</span></h3>  

			<form:form action="${urlForm}" method="post" modelAttribute="usuario">
			  <form:hidden class="form-control" path="id"/>
				<div class="row">         
					<div class="col-sm-3">
						<div class="form-group">
							<label for="perfil" class="control-label">PERFIL</label>              
							<select id="perfil" name="perfil" class="form-control">
							  <c:choose>
							    <c:when test="${perfil.perfil eq 'EDITOR' }">
								<option value="EDITOR">${perfil.perfil}</option>
								<option value="GERENTE">GERENTE</option>
							    </c:when>	
					             <c:when test="${perfil.perfil eq 'GERENTE' }">
								<option value="GERENTE">${perfil.perfil}</option>
								<option value="EDITOR">EDITOR</option>
								</c:when>		
								<c:otherwise>
								<option value="GERENTE">GERENTE</option>	
								<option value="EDITOR">EDITOR</option>	
							    </c:otherwise>
	                         </c:choose>								
							</select>             
						</div> 
					</div>
					<div class="col-sm-3">
					 <label for="estatus" class="control-label">Estatus</label>
					  <form:select id="genero" path="activo" class="form-control">
						<form:option value="1">Activo</form:option>
						<form:option value="0">Inactivo</form:option>
					 </form:select>
				  </div>
				</div>	
				<div class="row"> 	
					<div class="col-sm-3">
						<div class="form-group">
							<label for="cuenta">Cuenta</label>             
							<form:input type="text" class="form-control" path="cuenta" id="cuenta" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="pwd">Password</label>             
							<form:input type="password" class="form-control" path="pwd" id="pwd" required="required"/>
						</div>  
					</div>
					
					<div class="col-sm-3">
						<div class="form-group">
							<label for="email">Email</label>
							<form:input type="text" class="form-control" path="email" id="email" placeholder="Correo electrónico" required="required"/>
						</div>  
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label for="telefono">Teléfono</label>
							<form:input type="text" class="form-control" path="telefono" id="telefono" required="required"/>
						</div>  
					</div>
				</div>

				<button type="submit" class="btn btn-danger" >Guardar</button>
			</form:form> 

			<hr class="featurette-divider">

			<jsp:include page="../includes/footer.jsp" />	

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>    
	</body>
</html>
