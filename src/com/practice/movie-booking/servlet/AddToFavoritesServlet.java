package com.cognizant.moviecrusier.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.FavoritesDao;
import com.cognizant.moviecrusier.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecrusier.dao.MovieDao;
import com.cognizant.moviecrusier.dao.MovieDaoSqlImpl;

/**
 * Servlet implementation class AddToFavoritesServlet
 */
@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long userId = 1;
		long menuItemId = Long.parseLong(request.getParameter("movieId"));
		try {
			FavoritesDao cart = new FavoritesDaoSqlImpl();
			cart.addFavoritesItem(userId, menuItemId);
			MovieDao menuItemDao = new MovieDaoSqlImpl();
			request.setAttribute("movieList", menuItemDao.getMovieListCustomer());
			request.setAttribute("addFavoritesStatus", true);
			RequestDispatcher rd = request.getRequestDispatcher("movie-list-customer.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
