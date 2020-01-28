package com.cognizant.moviecrusier.dao;

import java.text.ParseException;

import com.cognizant.moviecrusier.model.Favorites;

public interface FavoritesDao {
	public void addFavoritesItem(long userId, long movieId) throws ParseException;

	public Favorites getAllFavoritesItems(long userId) throws FavoritesEmptyException;

	public void removeFavoritesItem(long userId, long movieId);
}
