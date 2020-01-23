package com.cognizant.moviecrusier.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieDao;
import com.cognizant.moviecrusier.dao.MovieDaoSqlImpl;

@WebServlet("/ShowEditMovie")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MovieDao movieDao = new MovieDaoSqlImpl();
		long movieId = Long.parseLong(request.getParameter("movieId"));
		request.setAttribute("movie", movieDao.getMovie(movieId));
		RequestDispatcher rd = request.getRequestDispatcher("edit-movie.jsp");
		rd.forward(request, response);
	}

}
