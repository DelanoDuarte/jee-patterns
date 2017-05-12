<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Notícia</title>
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

</head>
<body>
	<jsp:include page="/WEB-INF/snippets/site-header.jsp">
		<jsp:param name="pageTitle" value="Notícia" />
	</jsp:include>
	<aside>
		<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
	</aside>
	<main>
	<div id="site-content">
		<article class="news">
			<h1 class="title">${news.title}</h1>
			<img
				src="${pageContext.request.contextPath}/image?newsId=${news.id}&imageFileName=${news.headlineImage}"
				alt="Eike Batista deixa presídio Bangu">
			<div class="news-text">
				<pre>${news.content}</pre>
			</div>
		</article>
	</div>
	</main>
</body>
</html>