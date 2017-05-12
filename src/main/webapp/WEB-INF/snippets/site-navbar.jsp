<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="collapse navbar-collapse">
	<ul class="nav navbar-nav">
		<li><a href="<c:url value='/news/list'/>">Notícias</a></li>
		<li><a href="<c:url value='/pages/news/edit.jsp'/>">Enviar</a></li>
	</ul>

	<ul class="nav navbar-nav navbar-right">
		<li><a href="<c:url value='/logout'/>">Logout</a></li>
	</ul>

</nav>