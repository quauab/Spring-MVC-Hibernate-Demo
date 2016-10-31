<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">	
		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
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
						<a id="about" class="noanchor" href="#">
							<span class="glyphicon glyphicon-user"> Customers</span>
						</a>
					</li>
				</ul>					
			</div>
		</nav>		
        
        <div class="content">
            <h3 class="header">Customer List</h3>
            <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#formModal">
                Add Customer
            </button>
                <hr>
        <c:forEach var="tempCustomer" items="${customers}">
                <div class="panel-group">
                
                    <div class="panel panel-default">                    
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                ${tempCustomer.firstName}
                                <a data-toggle="collapse" href="#customer_${tempCustomer.id}"> 
                                    <span  class="glyphicon glyphicon-triangle-bottom pull-right" aria-hidden="true"></span>
                                </a>
                            </h4>
                        </div>
                        
                        <div id="customer_${tempCustomer.id}" class="panel-collapse collapse">                        
                            <div class="panel-body">
                                <div class="row rowBody">                                
                                    <div class="col-md-4">
                                        <h3>Name</h3>
                                        <p>${tempCustomer.firstName} ${tempCustomer.lastName }</p>
                                    </div>
                                    
                                    <div class="col-md-4">
                                        <h3>Email</h3>
                                        <p>${tempCustomer.email}</p>
                                    </div>                                    
                                </div>
                            </div>
                            
                            <div class="panel-footer">                            
                                <button
                                    class="btn btn-default edit-customer"
                                    data-toggle="modal"
                                    data-target="#editFormModal"
                                    data-id="${tempCustomer.id}"
                                    data-first_name="${tempCustomer.firstName}"
                                    data-last_name="${tempCustomer.lastName}"
                                    data-email="${tempCustomer.email}">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </button>                                
                                &nbsp;                                
                                <button
                                    class="btn btn-danger delete-customer pull-right"
                                    data-toggle="modal"
                                    data-target="#deleteFormModal"
                                    data-id="${tempCustomer.id}"
                                    data-first_name="${tempCustomer.firstName}"
                                    data-last_name="${tempCustomer.lastName}"
                                    data-email="${tempCustomer.email}">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>                                
                            </div>                            
                        </div>                        
                    </div>
                    
                </div>
            </c:forEach>
            
        </div>
        
        <div class="modal fade" id="formModal" tabindex="-1" role="dialog" aria-labeledby="formModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
    
                    <form method="post" action="addCustomer">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Add Customer</h4>
                        </div>
    
                        <div class="modal-body">
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text" class="form-control" name="first_name" required />
                            </div>
    
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text" class="form-control" name="last_name" required/>
                            </div>
    
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" required/>
                            </div>
                        </div>
    
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" value="Save" />
                        </div>
                    </form>
    
                </div>
            </div>
        </div>
    
        <div class="modal fade" id="editFormModal" tabindex="-1" role="dialog" aria-labeledby="editFormModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
    
                    <form method="get" action="editCustomer">
                        <input type="hidden" id="edit-customer_id" name="id" />
    
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Edit Customer</h4>
                        </div>
    
                        <div class="modal-body">
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text" class="form-control" name="first_name" required 
                                id="edit-customer_first_name"/>
                            </div>
    
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text" class="form-control" name="last_name" required
                                id="edit-customer_last_name"/>
                            </div>
    
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" required
                                id="edit-customer_email" />
                            </div>
                        </div>
    
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" value="Save" />
                        </div>
                    </form>
    
                </div>
            </div>
        </div>
        
        <div class="modal fade" id="deleteFormModal" tabindex="-1" role="dialog" aria-labeledby="editFormModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
    
                    <form method="get" action="deleteCustomer">
                        <input type="hidden" id="delete-customer_id" name="id" />
    
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Delete Customer</h4>
                        </div>
    
                        <div class="modal-body">
                            <div class="form-group">
                                <label>First Name</label>
                                <input type="text" class="form-control" name="first_name" readOnly 
                                id="delete-customer_first_name"/>
                            </div>
    
                            <div class="form-group">
                                <label>Last Name</label>
                                <input type="text" class="form-control" name="last_name" readOnly 
                                id="delete-customer_last_name"/>
                            </div>
    
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" readOnly 
                                id="delete-customer_email" />
                            </div>
                        </div>
    
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <input type="submit" class="btn btn-primary" value="Delete" />
                        </div>
                    </form>
    
                </div>
            </div>
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
        <script>
            (function() {        	
            	$('.delete-customer').on('click', function(){
            		$('#delete-customer_first_name').val($(this).data('first_name'));
            		$('#delete-customer_last_name').val($(this).data('last_name'));
            		$('#delete-customer_email').val($(this).data('email'));
            		$('#delete-customer_id').val($(this).data('id'));
            	});	
    
            	$('.edit-customer').on('click', function(){
            		$('#edit-customer_first_name').val($(this).data('first_name'));
            		$('#edit-customer_last_name').val($(this).data('last_name'));
            		$('#edit-customer_email').val($(this).data('email'));
            		$('#edit-customer_id').val($(this).data('id'));
            	});	
            })();
        </script>
</html>