package com.cognizant.moviecrusier.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecrusier.model.Movie;

public class MovieDaoSqlImpl implements MovieDao {

	public List<Movie> getMovieListAdmin() {

		Connection connection;
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		Movie movie;
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "SELECT * FROM moviecrusier.movie";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				movie = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				movieList.add(movie);
			}
			System.out.println("from Admin " + movieList);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		return movieList;

	}

	public List<Movie> getMovieListCustomer() {

		Connection connection;
		Movie movie;
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "SELECT * FROM moviecrusier.movie WHERE mv_date_of_launch<=CURRENT_DATE() AND mv_active = 'YES'";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				movie = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				movieList.add(movie);
			}
			System.out.println("from Customer " + movieList);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movieList;
	}

	public Movie getMovie(long movieId) {

		Connection connection = null;
		Movie movie = null;
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "SELECT * FROM moviecrusier.movie WHERE mv_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setLong(1, movieId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				movie = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		return movie;
	}

	public void modifyMovie(Movie movie) {

		Connection connection;
		try {
			connection = ConnectionHandler.getConnection();
			String sql = "UPDATE moviecrusier.movie SET mv_title=?,mv_box_office=?,mv_active=?,mv_date_of_launch=?,mv_genre=?,mv_has_teaser=? WHERE mv_id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, movie.getTitle());
			pst.setFloat(2, movie.getBoxOffice());
			pst.setString(3, movie.isActive() ? "YES" : "NO");
			pst.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
			pst.setString(5, movie.getGenre());
			pst.setBoolean(6, movie.isHasTeaser());
			pst.setLong(7, movie.getId());
			pst.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
