<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<title>Colarinho Branco - Login</title>
</head>
<body>

	<div class="container">

		<div class="row" style="margin-top: 20px">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form role="form" action="login" method="post">
					<fieldset>
						<h2>Entrar</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="text" name="login" id="login"
								class="form-control input-lg" placeholder="Login">
						</div>
						<div class="form-group">
							<input type="password" name="senha" id="senha"
								class="form-control input-lg" placeholder="Senha">
						</div>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6" align="center">
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="Login">
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>

</body>
</html>