package com.cognizant.moviecrusier.model;

import java.util.List;

public class Favorites {

	private List<Movie> movieList;
	private int noOfFavorites;

	// Constructors
	public Favorites(List<Movie> movieList, int noOfFavorites) {
		super();
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	// Getters and Setters
	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(noOfFavorites);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (Double.doubleToLongBits(noOfFavorites) != Double.doubleToLongBits(other.noOfFavorites))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[ " + movieList + " ]";
	}

}
