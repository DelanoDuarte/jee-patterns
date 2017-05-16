<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/news/list'/>">Notícias</a></li>
				<li><a href="<c:url value='/pages/news/edit.jsp'/>">Enviar</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/logout'/>"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>


</body>

</html>