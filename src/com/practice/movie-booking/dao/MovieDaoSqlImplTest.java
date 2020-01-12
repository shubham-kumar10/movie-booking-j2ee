package com.cognizant.moviecrusier.dao;

import java.util.Iterator;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

public class MovieDaoSqlImplTest {
	public static void main(String args[]) throws Exception {
		System.out.println("----------Admin List-----------");
		testGetMovieListAdmin();
		System.out.println("----------Customer List-----------");
		testGetMovieListCustomer();
		/*
		 * System.out.println("----------Edit List-----------");
		 * testModifyMovie();
		 */
		System.out.println("----------Admin List-----------");
		testGetMovieListAdmin();

	}

	public static void testGetMovieListAdmin() throws Exception {

		MovieDao menuItemDao = new MovieDaoSqlImpl();

		List<Movie> menuItemList = menuItemDao.getMovieListAdmin();
		// Iteration
		Iterator<Movie> itr = menuItemList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void testGetMovieListCustomer() throws Exception {
		MovieDao menuItemDao = new MovieDaoSqlImpl();
		List<Movie> menuItemList = menuItemDao.getMovieListCustomer();
		for (Movie itr : menuItemList) {
			System.out.println(itr);
		}
	}

	public static void testModifyMovie() throws Exception {
		Movie menuItem = new Movie(1, "Avatar", 99L, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true);
		MovieDao menuItemDao = new MovieDaoSqlImpl();
		menuItemDao.modifyMovie(menuItem);
		System.out.println(menuItemDao.getMovie(1));
	}
}
