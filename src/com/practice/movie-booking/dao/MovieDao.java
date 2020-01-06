package com.cognizant.moviecrusier.dao;

import java.util.List;

import com.cognizant.moviecrusier.model.Movie;

public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId);

	public List<Movie> getMovieListCustomer();

}
