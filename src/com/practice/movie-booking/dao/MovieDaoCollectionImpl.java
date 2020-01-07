package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;
import com.cognizant.moviecrusier.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() throws ParseException {
		if (movieList == null) {
			movieList = new ArrayList<Movie>();
			movieList.add(new Movie(1, "Avatar", 2787965087L, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2, "The Avengers", 1518812988L, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieList.add(
					new Movie(3, "Titanic", 2187463944L, true, DateUtil.convertToDate("21/03/2018"), "Romance", false));
			movieList.add(new Movie(4, "Jurassic World", 1671713208L, false, DateUtil.convertToDate("02/07/2017"),
					"Science", true));
			movieList.add(new Movie(5, "Avengers: End Game", 2750760348L, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));
		}
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<Movie> getMovieListAdmin() {
		return movieList;
	}

	public List<Movie> getMovieListCustomer() {
		ArrayList<Movie> movieListCustomer = new ArrayList<Movie>();
		for (Movie itr : getMovieListAdmin()) {
			if (itr.isActive() && !itr.getDateOfLaunch().after(new Date())) {
				movieListCustomer.add(itr);
			}
		}
		return movieListCustomer;
	}

	public void modifyMovie(Movie movie) {

		for (Movie itr : movieList) {
			if (itr.getId() == (movie.getId())) {
				itr.setTitle(movie.getTitle());
				itr.setGenre(movie.getGenre());
				itr.setHasTeaser(movie.isHasTeaser());
				itr.setBoxOffice(movie.getBoxOffice());
				itr.setActive(movie.isActive());
				itr.setDateOfLaunch(movie.getDateOfLaunch());
			}

		}
	}

	public Movie getMovie(long movieId) {

		Iterator<Movie> itr = movieList.iterator();
		while (itr.hasNext()) {
			Movie movie = itr.next();
			if (movie.getId() == movieId)
				return movie;
		}
		return null;
	}
}
