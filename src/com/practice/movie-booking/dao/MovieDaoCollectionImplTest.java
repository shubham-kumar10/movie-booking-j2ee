package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

public class MovieDaoCollectionImplTest {
	public static void main(String args[]) throws ParseException {

		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
	}

	public static void testGetMovieListAdmin() throws ParseException {
		System.out.println("---------------------Admin List----------------------------------");
		MovieDao movieDao = new MovieDaoCollectionImpl();

		List<Movie> movieList = movieDao.getMovieListAdmin();
		// Iteration
		Iterator<Movie> itr = movieList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void testGetMovieListCustomer() throws ParseException {

		System.out.println("---------------------Customer List----------------------------------");
		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();
		for (Movie itr : movieList) {
			System.out.println("[" + itr.getTitle() + " , " + itr.getBoxOffice() + " , " + itr.getGenre() + " , "
					+ itr.isHasTeaser() + " ]");
		}
	}

	public static void testModifyMovie() throws ParseException {

		System.out.println("---------------------Modifying Id 1----------------------------------");
		Movie movie = new Movie(1, "The Lion King", 123345787L, true, DateUtil.convertToDate("15/03/2017"), "Fiction",
				true);

		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovie(movie);
		System.out.println(movieDao.getMovie(1));
	}

	public static void testGetMovie() {

	}

}
