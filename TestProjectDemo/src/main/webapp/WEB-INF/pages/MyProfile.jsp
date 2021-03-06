<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>


<html>
<head>
<link rel="icon"
	href="http://localhost:8080/ORS_Proj0/resources/img/Title_Icon.png">
<title>My Profile</title>
<style type="text/css">
#userImage {
	display: inline-block;
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: 5px;
	transition: 0.3s;
}

#userImage:hover {
	box-shadow: 0 0 15px 5px rgba(0, 140, 186, 0.5);
}
</style>

</head>
<body
	style="background-image: url('http://localhost:8080/ORS_Proj0/resources/img/contact-form-step1-background.jpg');">
	<div class="container">

		<sf:form action="myProfile" commandName="form" method="post"
			class="well">
			<div class="text-center">

				<h1 class="text-primary">
					<s:message code="label.myProfile"></s:message>
				</h1>
				<br>
				<c:if test="${not empty success }">
					<div class="alert alert-success" role="alert">
						<span class="glyphicon glyphicon-saved"></span> ${success }
					</div>
				</c:if>
				<c:if test="${not empty error }">
					<div class="alert alert-danger" role="alert">
						<span class="glyphicon glyphicon-alert"></span> ${error }
					</div>
				</c:if>
			</div>
			<br>
			<sf:hidden path="id" />
			<sf:hidden path="createdBy" />
			<sf:hidden path="modifiedBy" />
			<sf:hidden path="createdDatetime" />
			<sf:hidden path="modifiedDatetime" />


			<div class="container">
				<div class="form-group row">
					<label class="col-md-4 text-right control-label"><s:message
							code="label.login"></s:message><font color="red">*</font></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<sf:input path="login" cssClass="form-control"
								placeholder="Login Id" readonly="true" />

						</div>
						<label class="control-label text-danger" id="font5"><sf:errors
								path="login"></sf:errors></label>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 text-right control-label"><s:message
							code="label.firstName"></s:message><font color="red">*</font></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<sf:input path="firstName" cssClass="form-control"
								placeholder="First Name" />
						</div>
						<label class="control-label text-danger" id="font5"><sf:errors
								path="firstName"></sf:errors></label>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 text-right control-label"><s:message
							code="label.lastName"></s:message><font color="red">*</font></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<sf:input path="lastName" cssClass="form-control"
								placeholder="Last Name" />
						</div>
						<label class="control-label text-danger" id="font5"><sf:errors
								path="lastName"></sf:errors></label>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-4 text-right control-label"><s:message
							code="label.dob"></s:message><font color="red">*</font> </label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-calendar"></i></span>
							<sf:input path="dob" placeholder="mm/dd/yyyy" id="datepicker"
								cssClass="form-control" readonly="readonly"></sf:input>
						</div>
						<label id="font5" class="control-label text-danger"><sf:errors
								path="dob"></sf:errors></label>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-md-4 text-right control-label"><s:message
							code="label.gender"></s:message><font color="red">*</font></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<sf:select path="gender" cssClass="form-control">
								<sf:option value="">Select</sf:option>
								<sf:option value="Male">
									<s:message code="label.male"></s:message>
								</sf:option>
								<sf:option value="Female">
									<s:message code="label.female"></s:message>
								</sf:option>
							</sf:select>
						</div>
						<label id="font5" class="control-label text-danger"><sf:errors
								path="gender"></sf:errors></label>
					</div>
				</div>

				<div class="form-group row">
					<label class="col-md-4 text-right control-label"><s:message
							code="label.mobileNo"></s:message><font color="red">*</font></label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-phone"></i></span>
							<sf:input path="mobileNo" cssClass="form-control" maxlength="10"
								placeholder="Mobile Number" />
						</div>
						<label id="font5" class="control-label text-danger"><sf:errors
								path="mobileNo"></sf:errors></label>
					</div>
				</div>

				<div class="col-md-7 col-md-offset-4" style="padding-left: 55px;">
					<button class="btn btn-primary col-md-2" type="submit"
						name="operation" value="Save">
						<s:message code="label.save"></s:message>
					</button>

					<button class="btn btn-danger col	-md-2 col-md-offset-1"
						type="submit" name="operation" value="Cancel">
						<s:message code="label.cancel"></s:message>
					</button>
				</div>
			</div>
			<br>
			<br>
		</sf:form>
	</div>
</body>
</html>
