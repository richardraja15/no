<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<style type="text/css">
.mine {
	text-align: center;
	margin-top: 10%;
}
</style>
</head>
<body>
	<div class="mine">
		<h1 class="display-3">Thank You!</h1>
		<p class="lead">
			<strong>Your payment has been successfully done</strong>
		<p class="lead">
			<strong> Account Holder Name: <%
				out.print(request.getParameter("acc_holder_name"));
			%></strong>
		<p class="lead">
			<strong>Transaction Id: <%
				out.print(request.getParameter("trn_id"));
			%></strong>
		<p class="lead">
			<strong>Transaction Status: <%
				out.print(request.getParameter("trn_status"));
			%></strong> <br>
			<br> <a class="btn btn-primary btn-sm" href="LogoutController"
				role="button">Continue to homepage</a>
		</p>
	</div>
</body>
</html>