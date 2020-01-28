package com.cognizant.moviecrusier.dao;

import java.text.ParseException;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.Movie;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoritesItem() throws ParseException, FavoritesEmptyException {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.addFavoritesItem(1, 1);
		favoriteDao.addFavoritesItem(1, 1);
		favoriteDao.addFavoritesItem(1, 1);
		favoriteDao.addFavoritesItem(1, 2);
		Favorites favorite = favoriteDao.getAllFavoritesItems(1);
		System.out.println("---------------------Add List----------------------------------");
		for (Movie itr : favorite.getMovieList()) {
			System.out.println(itr);
		}

	}

	public static void testRemoveFavoritesItem() throws ParseException, FavoritesEmptyException {
		System.out.println("---------------------Remove List----------------------------------");
		try {
			FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
			favoriteDao.removeFavoritesItem(1, 1);
			favoriteDao.removeFavoritesItem(1, 2);
			favoriteDao.removeFavoritesItem(1, 2);
			for (Movie itr : favoriteDao.getAllFavoritesItems(1).getMovieList())
				System.out.println(itr);
		} catch (FavoritesEmptyException e) {
			System.out.println("Favorites is Empty now");
		}

	}

	public static void main(String[] args) throws Exception {
		testAddFavoritesItem();
		testRemoveFavoritesItem();
	}
}
