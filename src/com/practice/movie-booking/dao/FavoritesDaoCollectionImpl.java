package com.cognizant.moviecrusier.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.Movie;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		List<Movie> movieList = new ArrayList<Movie>();
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			userFavorites.put(1L, new Favorites(movieList, 0));
		}
	}

	public void addFavoritesItem(long userId, long movieId) throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);
		List<Movie> movieList = new ArrayList<Movie>();
		Favorites userFavoritesTemp;
		if (userFavorites.containsKey(userId)) {
			userFavoritesTemp = userFavorites.get(userId);
			movieList = userFavoritesTemp.getMovieList();
			if (!movieList.contains(movie))
				movieList.add(movie);
			userFavoritesTemp.setMovieList(movieList);
			userFavorites.put(userId, userFavoritesTemp);
		} else {
			movieList = new ArrayList<Movie>();
			movieList.add(movie);
			Favorites userFavorite = new Favorites(movieList, 0);
			userFavorites.put(userId, userFavorite);
		}
	}

	public Favorites getAllFavoritesItems(long userId) throws FavoritesEmptyException {
		List<Movie> movieList;
		Favorites favorites = userFavorites.get(userId);
		movieList = favorites.getMovieList();
		int noOfFavorites = movieList.size();
		if (movieList.isEmpty())
			throw new FavoritesEmptyException();

		favorites.setNoOfFavorites(noOfFavorites);

		return favorites;
	}

	public void removeFavoritesItem(long userId, long movieId) {

		List<Movie> movieList = new ArrayList<Movie>();
		Favorites favorites = userFavorites.get(userId);
		System.out.println(favorites.getMovieList());
		try {
			movieList = favorites.getMovieList();
			if (movieList.isEmpty())
				throw new FavoritesEmptyException();
			else {
				for (int i = 0; i < movieList.size(); i++) {
					if (movieList.get(i).getId() == movieId) {
						movieList.remove(i);
					}
				}

			}
		} catch (FavoritesEmptyException e) {
			System.out.println("Favorites is empty.Nothing to Remove.");
			e.printStackTrace();
		}

	}
}
