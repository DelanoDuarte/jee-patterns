<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ include file="/WEB-INF/snippets/directives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Notícias</title>
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

<link
	href="${pageContext.request.contextPath}/resources/styles/news-list.css"
	rel="stylesheet" type="text/css">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<script src="https://use.fontawesome.com/07b0ce5d10.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/snippets/site-header.jsp">
		<jsp:param name="pageTitle" value="Notícias" />
	</jsp:include>
	<%@ include file="/WEB-INF/snippets/site-navbar.jsp"%>

	<div class="container">

		<div class="col-lg-6 col-md-6">
			<c:forEach items="${news}" var="item" varStatus="status">
				<aside>
					<img
						src="${pageContext.request.contextPath}/image?newsId=${item.id}&imageFileName=${item.headlineImage}"
						class="img-responsive">
					<div class="content-title">
						<div class="text-center">
							<h3>
								<a
									href="
								<c:url value='/news/show'>
									<c:param name='newsId' value='${item.id}' />
								</c:url>">
									${item.title} </a>
							</h3>
						</div>
					</div>
					<div class="content-footer">
						<img class="user-small-img"
							src="https://www.atomix.com.au/media/2015/06/atomix_user31.png">
						<span style="font-size: 16px; color: #fff;">Informações de
							quem postou !</span> <span class="pull-right"> <a href="#"
							data-toggle="tooltip" data-placement="left" title="Comments"><i
								class="fa fa-comments"></i> ${item.comments.size()}</a> <a href="#"
							data-toggle="tooltip" data-placement="right" title="Loved"><i
								class="fa fa-heart"></i> ${item.likes}</a>
						</span>
						<div class="user-ditels">
							<div class="user-img">
								<img
									src="https://www.atomix.com.au/media/2015/06/atomix_user31.png"
									class="img-responsive">
							</div>
							<span class="user-full-ditels">
								<h3>Informações de que postou !</h3>
							</span>
							<div class="social-icon">
								<a href="#"><i class="fa fa-facebook" data-toggle="tooltip"
									data-placement="bottom" title="Facebook"></i></a> <a href="#"><i
									class="fa fa-twitter" data-toggle="tooltip"
									data-placement="bottom" title="Twitter"></i></a> <a href="#"><i
									class="fa fa-google-plus" data-toggle="tooltip"
									data-placement="bottom" title="Google Plus"></i></a> <a href="#"><i
									class="fa fa-youtube" data-toggle="tooltip"
									data-placement="bottom" title="Youtube"></i></a> <a href="#"><i
									class="fa fa-github" data-toggle="tooltip"
									data-placement="bottom" title="Github"></i></a>
							</div>
						</div>
					</div>
				</aside>
			</c:forEach>
		</div>




		<div class="col-lg-4">
			<div class="widget-sidebar">
				<h2 class="title-widget-sidebar">Posts Recentes</h2>
				<div class="content-widget-sidebar">
					<ul>
						<c:forEach items="${news}" var="item" varStatus="status">
							<li class="recent-post">
								<div class="post-img">
									<img
										src="${pageContext.request.contextPath}/image?newsId=${item.id}&imageFileName=${item.headlineImage}"
										class="img-responsive">
								</div> <a
								href="
								<c:url value='/news/show'>
									<c:param name='newsId' value='${item.id}' />
								</c:url>">
									${item.title} </a>
								<p>
									<small><i class="fa fa-calendar" data-original-title=""
										title=""></i> ${item.date} </small>
								</p>
							</li>
						</c:forEach>
						<hr>
					</ul>
				</div>
			</div>
		</div>

	</div>
</body>
</html>