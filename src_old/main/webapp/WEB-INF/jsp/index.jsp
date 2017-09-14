<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head lang="en">
<meta charset="utf-8">
<title>USCS Appointment Creator</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/main.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>" />

</head>
<body>
<div id="page">
		<!-- HEADER END -->
		<div id="header">
			<div id="headerText">Appointment Tool</div>
		</div>
	<c:if test="${badData == true}">
  	 	<div class="alert alert-danger" role="alert" align="center">  
  	 		<span class="glyphicon glyphicon-remove-sign"></span><label>Receipt not valid please use only numbers!</label><%-- <spring:message code="label.test"></spring:message> --%><br>
  		 </div>	
  </c:if>
  <c:if test="${noReceipt == true}">
  	 	<div class="alert alert-danger" role="alert" align="center">  
  	 		<span class="glyphicon glyphicon-remove-sign"></span><label>Receipt was not found for that warehouse!</label><%-- <spring:message code="label.test"></spring:message> --%><br>
  		 </div>	
</c:if>
<c:if test="${error == true}">
  	 	<div class="alert alert-danger" role="alert" align="center">  
  	 		<span class="glyphicon glyphicon-remove-sign"></span><label>There was an error with the process!</label><%-- <spring:message code="label.test"></spring:message> --%><br>
  		 </div>	
</c:if>
<c:if test="${success == true}">
		<div class="alert alert-success" role="alert" align="center">  
  	 		<span class="glyphicon glyphicon-ok-sign"></span><label>Receipt now has an appointment linked to it!</label><%-- <spring:message code="label.test"></spring:message> --%><br>
  		 </div>	
</c:if>

		<div class="panel-body">
	 <!--  <div class="wrapper"> -->  
   	<div class="panel-body">
						<!-- INNER DATA BEGIN-->
						<form:form  class="form-horizontal" action="createAppointment"
							method="post">							
							<div class="padBtm">
								<div class="lblAlign">
									<label>Select Warehouse</label>
								</div>
								<select id="whseSysId" name="whseSysId" title="Select Warehouse "
									class="myCombo searchBoxWidth" required="">
									<option value="" selected="selected"></option>
									<c:if test="${warehouseList.size() > 0}">
										<option value="0">--Please Select--</option>
										<c:forEach items="${warehouseList}" var="warehouseList">
											<option id="warehouse" value="${warehouseList.whseSysId}">
												<c:out value="${warehouseList.whseName}" />
											</option>
										</c:forEach>
									</c:if>
								</select>
							</div>	
							<div class="spacerVereticalSm"></div>
							<label>Enter up to 3 Receipt numbers</label>
							<div class="spacerVereticalSm"></div>				
								<div class="form-group row">
								<div class="col-sm-4">
									<input type="text" class="searchBoxWidth" name="reNumber1"
										placeholder="Receipt Number" data-toggle="tooltip"
										title="Enter a USCS Receipt Number" required="required"
										autofocus maxlength="10">
								</div>
							</div>				
								<div class="form-group row">
								<div class="col-sm-4">
									<input type="text" class="searchBoxWidth" name="reNumber2"
										placeholder="Receipt Number" data-toggle="tooltip"
										title="nter a USCS Receipt Number" 
										autofocus maxlength="10">
								</div>
							</div>				
								<div class="form-group row">
								<div class="col-sm-4">
									<input type="text" class="searchBoxWidth" name="reNumber3"
										placeholder="Receipt Number" data-toggle="tooltip"
										title="nter a USCS Receipt Number" 
										autofocus maxlength="10">
								</div>
							</div>
							<div class="spacerVereticalSm"></div>
							<label>Enter an existing appointment number to link receipt to it.</label>
							<div class="spacerVereticalSm"></div>				
								<div class="form-group row">
								<div class="col-sm-4">
									<input type="text" class="searchBoxWidth" name="apptNumber"
										placeholder="Appointment Number" data-toggle="tooltip"
										title="nter a USCS Appointment Number" 
										autofocus maxlength="10">
								</div>
							</div>
							<div class="spacerVereticalSm"></div>				
													
							<button type="reset" class="btn btn">
								<div class="warningText">Clear Form</div>
							</button>
							<button type="submit" class="btn btn-primary" id="createAppointmentBtn">Create</button>
							<div class="spacerVereticalSm"></div>
						</form:form>
						<!--INNER DATA END-->
					</div>
				</div>
   
   
  </div>
	</div>
	<script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
</body>
</html>
