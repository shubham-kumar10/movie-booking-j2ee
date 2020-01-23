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

/**
 * Servlet implementation class ShowMovieListCustomerServlet
 */
@WebServlet("/ShowMovieListCustomer")
public class ShowMovieListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MovieDao movieDao = new MovieDaoSqlImpl();
		request.setAttribute("movieList", movieDao.getMovieListCustomer());
		RequestDispatcher rd = request.getRequestDispatcher("movie-list-customer.jsp");
		rd.forward(request, response);
	}

}
