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
import com.cognizant.moviecrusier.model.Favorites;

@WebServlet("/ShowFavorites")
public class ShowFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;

		FavoritesDao favorites = new FavoritesDaoSqlImpl();
		Favorites userFavorites;
		try {
			userFavorites = favorites.getAllFavoritesItems(userId);
			request.setAttribute("favorites", userFavorites);
			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
		} catch (FavoritesEmptyException e) {
			RequestDispatcher fwd = request.getRequestDispatcher("favorites-empty.jsp");
			fwd.forward(request, response);
		}

	}

}
