package com.cognizant.moviecrusier.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.Movie;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavoritesItem()
			throws ParseException, FavoritesEmptyException, ClassNotFoundException, IOException, SQLException {
		FavoritesDao cartDao = new FavoritesDaoSqlImpl();
		cartDao.addFavoritesItem(1, 1);
		cartDao.addFavoritesItem(1, 2);
		Favorites cart = cartDao.getAllFavoritesItems(1);
		for (Movie itr : cart.getMovieList()) {
			System.out.println(itr);
		}
	}

	public static void testRemoveFavoritesItem() {

		try {
			FavoritesDao cartDao = new FavoritesDaoSqlImpl();
			System.out.println("remove 1");
			cartDao.removeFavoritesItem(1, 1);
			cartDao.removeFavoritesItem(1, 2);
			cartDao.removeFavoritesItem(1, 2);
			for (Movie itr : cartDao.getAllFavoritesItems(1).getMovieList())
				System.out.println(itr);
		} catch (FavoritesEmptyException e) {
			System.out.println("Favorites is Empty now");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		testAddFavoritesItem();
		testRemoveFavoritesItem();
	}
}
