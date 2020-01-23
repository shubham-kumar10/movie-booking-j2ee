package com.cognizant.moviecrusier.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecrusier.dao.MovieDao;
import com.cognizant.moviecrusier.dao.MovieDaoSqlImpl;
import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
		boolean isActive = Boolean.parseBoolean(request.getParameter("active"));
		System.out.println(isActive);
		String date = request.getParameter("date");
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") == null ? false : true;
		System.out.print(id);
		Date dateOfLaunch = null;
		try {
			dateOfLaunch = DateUtil.convertToDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Movie newMovie = new Movie(id, title, boxOffice, isActive, dateOfLaunch, genre, hasTeaser);
		MovieDao menuItemDao = new MovieDaoSqlImpl();
		menuItemDao.modifyMovie(newMovie);
		RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
		rd.forward(request, response);
	}

}
