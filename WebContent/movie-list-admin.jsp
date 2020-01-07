<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	
%>
<title>Admin Movie List</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<header>
		<font id="movie-crusier-logo"> MovieCrusier</font><img id="logo"
			src="images/logo.png" alt="logo" width="55" height="55"> <a
			id="menulink" href="ShowMovieListAdmin">Movies</a>
	</header>
	<h1 id="menu">Movies</h1>
	<table class="menutable">
		<tr>
			<th class="th_leftaln">Title</th>
			<th class="th_rightaln">Box Office</th>
			<th class="th_center">Active</th>
			<th class="th_center">Date of Launch</th>
			<th class="th_center">Genre</th>
			<th class="th_center">Has Teaser</th>
			<th class="th_center">Action</th>
		</tr>
		<c:forEach items="${movieList}" var="movie">
			<tr>
				<td class="th_leftaln"><c:out value="${movie.title}" /></td>
				<td class="th_rightaln">&nbsp;<fmt:formatNumber type="currency"
						maxFractionDigits="0" value="${movie.boxOffice}" /></td>
				<td class="th_center"><c:out
						value="${movie.active? 'Yes' : 'No'}" /></td>
				<td class="th_center"><fmt:formatDate type="date"
						pattern="dd/MM/yyyy" dateStyle="short"
						value="${movie.dateOfLaunch}" /></td>
				<td class="th_center"><c:out value="${movie.genre}" /></td>
				<td class="th_center"><c:out
						value="${movie.hasTeaser == true ? 'Yes' : 'No'}" /></td>
				<td class="th_center"><a
					href="ShowEditMovie?movieId=${movie.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
</body>
</html>