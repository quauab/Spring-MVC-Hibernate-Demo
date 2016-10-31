<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">	
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.slim.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/resources.js"></script>
		<title>Spring MVC Demo</title>
	</head>
	<body class="container-fluid">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<span class="navbar-brand" id="navbarheadertop">Dashboard</span>
				</div>
				<ul class="nav navbar-nav">
					<li><a id="home" class="noanchor" href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a id="about" class="noanchor" href="about">About</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">					
					<li>
						<a id="about" class="anchor" href="user/showForm">
							<span class="glyphicon glyphicon-registration-mark"> Register</span>
						</a>
					</li>
				</ul>					
			</div>
		</nav>		
        
        <div class="row  content">
            <h3 class="header">Customer List</h3>
            <div class="col-md-6">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tempCustomer" items="${customers}">
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <footer class="footer" id="footer"></footer>
		
		<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<span class="navbar-brand" id="navbarheaderbottom"></span>
				</div>
			</div>
		</nav>	
	</body>		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style_a.css">
		<script src="${pageContext.request.contextPath}/resources/js/start.js"></script>		
</html>