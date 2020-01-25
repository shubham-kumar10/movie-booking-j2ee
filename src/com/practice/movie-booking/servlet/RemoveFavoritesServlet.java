package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.FavoritesDao;
import com.cognizant.moviecrusier.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecrusier.dao.FavoritesEmptyException;

/**
 * Servlet implementation class RemoveFavoritesServlet
 */
@WebServlet("/RemoveFavoritesItem")
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long movieId = Long.parseLong(request.getParameter("movieId"));
		FavoritesDao userFavorites = new FavoritesDaoSqlImpl();
		long userId = 1;
		userFavorites.removeFavoritesItem(userId, movieId);
		request.setAttribute("removeFavoritesStatus", true);
		try {
			request.setAttribute("favorites", userFavorites.getAllFavoritesItems(userId));
			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
		} catch (FavoritesEmptyException e) {
			RequestDispatcher favoritesempty = request.getRequestDispatcher("favorites-empty.jsp");
			favoritesempty.forward(request, response);
		}
	}

}
