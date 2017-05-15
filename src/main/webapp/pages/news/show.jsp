<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Notícia</title>

<%@ include file="/WEB-INF/snippets/head-includes.jsp"%>

</head>


<body>
	<jsp:include page="/WEB-INF/snippets/site-header.jsp">
		<jsp:param name="pageTitle" value="Notícia" />
	</jsp:include>
	<aside>
		<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>
	</aside>


	<div class="container">

		<div class="row">

			<!-- Blog Post Content Column -->
			<div class="col-lg-8">

				<!-- Blog Post -->

				<!-- Title -->
				<h1>${news.title}</h1>

				<!-- Author -->
				<p class="lead">
					by <a href="#">Start Bootstrap</a>
				</p>

				<hr>

				<!-- Date/Time -->
				<p>
					<span class="glyphicon glyphicon-time"> Postado em
						${news.date}</span>
				</p>

				<hr>

				<!-- Preview Image -->
				<img
					src="${pageContext.request.contextPath}/image?newsId=${news.id}&imageFileName=${news.headlineImage}"
					alt="Eike Batista deixa presídio Bangu" width="900px"
					height="300px">

				<hr>

				<!-- Post Content -->
				<p>${news.content}</p>

				<hr>

				<!-- Blog Comments -->

				<!-- Comments Form -->
				<div class="well">
					<h4>Deixe seu Comentário:</h4>
					<form role="form"
						action="${pageContext.request.contextPath}/news/show"
						method="post">
						<div class="form-group">
							<textarea class="form-control" rows="3" name="comment"></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>

				<hr>

				<c:forEach items="${comments}" var="item" varStatus="status">
					<div class="media">
						<a class="pull-left" href="#"> <img class="media-object"
							src="http://placehold.it/64x64" alt="">
						</a>

						<div class="media-body">

							<h4 class="media-heading">
								Start Bootstrap <small>August 25, 2014 at 9:30 PM</small>
							</h4>
							${item.comment}

						</div>

					</div>
				</c:forEach>


			</div>

		</div>


	</div>
	<%-- 
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
				</main> --%>
</body>
</html>