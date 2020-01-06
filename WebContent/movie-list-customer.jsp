<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer item list</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<header>
		<font id="movie-crusier-logo"> MovieCrusier</font><img id="logo"
			src="images/logo.png" alt="logo" width="55" height="55"> <a
			id="menulink" href="ShowFavorites">Favorites</a> <a id="menulink"
			href="ShowMovieListCustomer">Movies</a>
	</header>
	<h1 id="menu">Movies</h1>
	<c:if test="${addFavoritesStatus}">
		<center>
			<p id="greentxt">Movie added to Favorites successfully</p>
		</center>
	</c:if>
	<table class="menutable">
		<tr>
			<th class="th_leftaln">Title</th>
			<th class="th_rightaln">Box Office</th>
			<th class="th_center">Genre</th>
			<th class="th_center">Has Teaser</th>
			<th class="th_center">Action</th>
		</tr>
		<c:forEach items="${movieList}" var="movie">
			<tr>
				<td class="th_leftaln"><c:out value="${movie.title}" /></td>
				<td class="th_rightaln"><fmt:formatNumber
						value="${movie.boxOffice}" type="currency" maxFractionDigits="0" /></td>
				<td class="th_center"><c:out value="${movie.genre}" /></td>
				<td class="th_center"><c:out
						value="${movie.hasTeaser == true ? 'Yes' : 'No'}" /></td>
				<td class="th_center"><a
					href="AddToFavorites?movieId=${movie.id}">Add to Favorites</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
</body>
</html>