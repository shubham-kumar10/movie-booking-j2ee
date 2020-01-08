<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Menu Items</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<header>
		<font id="movie-crusier-logo">Movie Crusier</font> <img id="logo"
			src="images/logo.png" alt="logo" width="55" height="55"> <a
			id="menulink" href="ShowMovieListAdmin">Movies</a>
	</header>
	<br />
	<br />
	<br />
	<form name="movieForm" method="post"
		onsubmit="return validateMovieForm();" action="EditMovieServlet">
		<table class="edittable">
			<caption id="menu">Edit Movie</caption>
			<tr>
				<td colspan=4>
					<h3>Name</h3> <label for="title"> <input id="title"
						type="text" style="width: 100%;" name="title"
						value="${movie.title}">
				</label>
				</td>
			</tr>
			<tr>
				<td>
					<h3>Gross ($)</h3> <label for="boxOffice"> <input
						id="boxOffice" type="text" name="boxOffice"
						value="${movie.boxOffice}">
				</label>
				</td>
				<td>
					<h3>Active</h3>
					<label for="active"><input id="active" type="radio"
						name="active" value="true"
						${movie.active? 'checked="checked"' : ''}>Yes <input
						id="active" type="radio" name="active" value="false"
						${movie.active? '' : 'checked="checked"'}>No </label>
				</td>
				<td>
					<h3>Date of Launch</h3> <label for="dateOflaunch"> <input
						id="dateOflaunch" type="text" name="date"
						value='<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${movie.dateOfLaunch}'/>'>
				</label>
				</td>
				<td>
					<h3>Genre</h3> <label for="genre"> <select name="genre">
							<option value="Superhero"
								<c:if test="${movie.genre eq 'Superhero'}">selected</c:if>>Superhero</option>
							<option value="Science Fiction"
								<c:if test="${movie.genre eq 'Science Fiction'}">selected</c:if>>Science
								Fiction</option>
							<option value="Romance"
								<c:if test="${movie.genre eq 'Romance'}">selected</c:if>>Romance</option>
							<option value="Comedy"
								<c:if test="${movie.genre eq 'Comedy'}">selected</c:if>>Comedy</option>
							<option value="Adventure"
								<c:if test="${movie.genre eq 'Adventure'}">selected</c:if>>Adventure</option>
							<option value="Thriller"
								<c:if test="${movie.genre eq 'Thriller'}">selected</c:if>>Thriller</option>
					</select>
				</label>
				</td>
			</tr>
			<tr>
				<td><label for="hasTeaser"> <input id="hasTeaser"
						class="chkbox" type="checkbox" name="hasTeaser"
						${movie.hasTeaser? 'checked="checked" value="true"': 'value="false"'}>&nbsp;
						<font size="5"><b>Has Teaser</b></font>
				</label> <input type="hidden" value="${movie.id}" name="id" /></td>
			</tr>
			<tr>
				<td>
					<button id="save-button">Save</button>
				</td>
			</tr>
		</table>
	</form>
	<footer>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2019</footer>
	<script src="js/script.js"></script>
</body>
</html>
</body>
</html>