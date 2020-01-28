package com.cognizant.moviecrusier.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecrusier.model.Favorites;
import com.cognizant.moviecrusier.model.Movie;

public class FavoritesDaoSqlImpl implements FavoritesDao {
	public void addFavoritesItem(long userId, long movieId) {
		Connection connection = null;
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "INSERT INTO moviecrusier.favorites(fv_us_id,fv_pr_id) VALUES(?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			pst.setLong(2, movieId);
			pst.executeUpdate();

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// Changed MovieList to Favorites return type
	public Favorites getAllFavoritesItems(long userId) throws FavoritesEmptyException {

		Connection connection = null;
		Favorites Favorites = new Favorites(null, 0);
		try {

			connection = ConnectionHandler.getConnection();
			String sql = "SELECT movie.* FROM Favorites " + "JOIN movie ON movie.mv_id = Favorites.fv_pr_id "
					+ "JOIN user ON user.us_id = Favorites.fv_us_id " + "WHERE user.us_id=?";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet rs = pst.executeQuery();
			ArrayList<Movie> MovieList = new ArrayList<Movie>();
			Movie Movie;
			while (rs.next()) {
				Movie = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				MovieList.add(Movie);
			}

			sql = "SELECT COUNT(*) AS No_of_favorites FROM favorites WHERE fv_us_id=?";
			if (MovieList.isEmpty())
				throw new FavoritesEmptyException();
			pst = connection.prepareStatement(sql);
			pst.setLong(1, userId);
			rs = pst.executeQuery();
			Favorites.setMovieList(MovieList);
			if (rs.next())
				Favorites.setNoOfFavorites(rs.getInt(1));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return Favorites;
	}

	public void removeFavoritesItem(long userId, long movieId) {
		Connection connection = null;
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "DELETE FROM Favorites WHERE Favorites.fv_pr_id=? and Favorites.fv_us_id=? LIMIT 1";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, movieId);
			pst.setLong(2, userId);
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
