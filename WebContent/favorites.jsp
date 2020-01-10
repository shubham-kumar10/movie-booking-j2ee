<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorites</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<header>
		<font id="movie-crusier-logo"> Movie Crusier</font><img id="logo"
			src="images/logo.png" alt="logo" width="55" height="55"> <a
			id="menulink" href="ShowFavorites">Favorites</a> <a id="menulink"
			href="ShowMovieListCustomer">Movies</a>
	</header>
	<br />
	<br />
	<br />
	<p id="menu">Favorites</p>

	<c:if test="${removeFavoritesStatus}">
		<center>
			<p id="greentxt">Item removed from cart successfully</p>
		</center>
	</c:if>
	<table class="edittable">
		<tr>

			<th class="th_leftaln">Title</th>
			<th class="th_rightaln">Box Office</th>
			<th class="th_center">Genre</th>
			<th class="th_center"></th>

		</tr>
		<c:forEach items="${favorites.movieList}" var="movie">
			<tr>
				<td class="th_leftaln"><c:out value="${movie.title}" /></td>
				<td class="th_rightaln"><fmt:formatNumber
						value="${movie.boxOffice}" type="currency" maxFractionDigits="0" /></td>
				<td class="th_center"><c:out value="${movie.genre}" /></td>
				<td class="th_center"><a
					href="RemoveFavoritesItem?movieId=${movie.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr></tr>
		<tr></tr>
		<tr>
			<td class="leftaln"><b>No. of Favorites:</b>&nbsp;&nbsp; <b><fmt:formatNumber
						type="number" maxFractionDigits="0"
						value="${favorites.noOfFavorites}" /></b></td>
			<td class="center"><a href="favorites-notification.jsp"></a></td>
		</tr>
	</table>
	<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
</body>
</html>

</body>
</html>