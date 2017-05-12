<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Enviar notícia</title>
<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>
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

<script src="https://use.fontawesome.com/07b0ce5d10.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/snippets/site-header.jsp">
		<jsp:param name="pageTitle" value="Enviar notícia" />
	</jsp:include>
	<aside>
		<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
	</aside>
	<div class="row">
		<div class="col-md-12">

			<div class="page-header" align="center">
				<h1>Nova Noticia</h1>
			</div>

			<div class="container">
				<form method="post"
					action="${pageContext.request.contextPath}/news/save"
					enctype="multipart/form-data">

					<div class="form-group">
						<label for="title">Título:</label> <input id="title" name="title"
							class="form-control" type="text" placeholder="Título"
							maxlength="75" required autofocus>
					</div>

					<div class="form-group">
						<label for="date">Data e horário:</label>
						<div class="input-group date" id="datetimepicker1">
							<input id="date" class="form-control" name="date"
								type="datetime-local" required> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label for="headline-content">Conteúdo:</label>
						<textarea id="headline-content" name="headline-content" rows="3"
							class="form-control" placeholder="Manchete" maxlength="350"
							required></textarea>
					</div>

					<div class="form-group">
						<label for="news-content">Conteúdo:</label>
						<textarea id="news-content" name="content" rows="10"
							class="form-control" placeholder="Conteúdo" required></textarea>
					</div>

					<div class="form-group">
						<label for="headline-image">Imagem da manchete:</label> <input
							id="headline-image" name="headline-image" class="form-control"
							type="file" accept=".jpg,jpeg,.png" required>
					</div>

					<div align="center">
						<button type="submit" class="btn btn-success">
							<strong><span class="glyphicon glyphicon-floppy-disk">
							</span>Salvar Post !</strong>
						</button>

						<button type="reset" class="btn btn-danger">
							<strong><span class="glyphicon glyphicon-trash">
							</span>Limpar !</strong>
						</button>
					</div>
				</form>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker();
		});
	</script>
</body>
</html>