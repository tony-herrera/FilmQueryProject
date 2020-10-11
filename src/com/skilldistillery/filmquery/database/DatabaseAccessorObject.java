package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = new Actor();
		String sql = "SELECT * FROM actor WHERE id = ?";

		// Establish connection to database
		Connection conn = DriverManager.getConnection(URL, user, pass);

		// Prepared Statement
		PreparedStatement stmt = conn.prepareStatement(sql);

		// Execute Query
		stmt.setInt(1, actorId);
		ResultSet rs = stmt.executeQuery();

		// Process Data
		if (rs.next()) {
			int id = rs.getInt("id");
			actor.setId(id);
			actor.setFirstName(rs.getString("first_name"));
			actor.setLastName(rs.getString("last_name"));
		}
		stmt.close();
		conn.close();
		return actor;
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = new Film();

		// Establish connection to database
		Connection conn = DriverManager.getConnection(URL, user, pass);

		// SQL Query
		String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE film.id = ?";

		// Prepared Statement
		PreparedStatement stmt = conn.prepareStatement(sql);

		// Execute Query
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		// Process Data
		if (rs.next()) {
			film = new Film();
			int id = rs.getInt("id");
			film.setId(id);
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setReleaseYear(rs.getInt("release_year"));
			film.setLanguageId(rs.getString("language_id"));
			film.setLanguage(rs.getString("name"));
			film.setLength(rs.getInt("length"));
			film.setRating(rs.getString("rating"));
			film.setActorsInFilm(findActorsByFilmId(filmId));
		}
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {
		List<Actor> actorsInFilm = new ArrayList<>();

		// Establish connection to database
		Connection conn = DriverManager.getConnection(URL, user, pass);

		// Establish SQL statement
		String sql = "SELECT * FROM actor JOIN film_actor ON actor.id = film_actor.actor_id JOIN film"
				+ " on film.id = film_actor.film_id WHERE film_actor.film_id = ?";

		// Prepared statement
		PreparedStatement stmt = conn.prepareStatement(sql);

		// Execute
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();

		// Process data
		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			Actor actInFilm = new Actor(firstName, lastName, id);
			actorsInFilm.add(actInFilm);

		}
		stmt.close();
		conn.close();
		return actorsInFilm;

	}

	public List<Film> keywordByFilm(String keyword) throws SQLException {
		List<Film> keywordForFilm = new ArrayList<>();

		// Establish connection to database
		Connection conn = DriverManager.getConnection(URL, user, pass);

		// Establish SQL statement
		String sql = "SELECT * FROM film JOIN language ON film.language_id = language.id WHERE title LIKE ? OR description LIKE ?";
//		String sql = "SELECT * FROM film JOIN language ON film.language = language.id WHERE film.id = ?";

		// Prepared statement
		PreparedStatement stmt = conn.prepareStatement(sql);

		// Execute
		stmt.setString(1, "%" + keyword + "%");
		stmt.setString(2, "%" + keyword + "%");
		ResultSet rs = stmt.executeQuery();

		// Process data
		while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			String rating = rs.getString("rating");
			String language = rs.getString("name");
			int release_year = rs.getInt("release_year");
			Film actInFilm = new Film(id, title, description, rating, language, release_year);
			actInFilm.setActorsInFilm(findActorsByFilmId(id));
			keywordForFilm.add(actInFilm);

		}
		stmt.close();
		conn.close();

		return keywordForFilm;

	}

	public Film getLanguage(String language) throws SQLException {
		Film getLang = new Film();

		// Establish connection to database
		Connection conn = DriverManager.getConnection(URL, user, pass);

		// Establish SQL statement
		String sql = "SELECT * FROM film JOIN language ON film.language = language.id WHERE film.id = ?";

		// Prepared statement
		PreparedStatement stmt = conn.prepareStatement(sql);

		// Execute
		stmt.setString(1, language);
		ResultSet rs = stmt.executeQuery();

		// Process Data
		if (rs.next()) {
			getLang.setLanguageId(rs.getString("language"));

		}
		return getLang;

	}
}