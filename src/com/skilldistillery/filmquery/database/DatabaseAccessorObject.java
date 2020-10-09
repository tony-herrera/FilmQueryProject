package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	public DatabaseAccessorObject() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		String sql = "SELECT * FROM film WHERE id = ?";
		String user = "student";
		String pass = "student";

		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		stmt.setInt(1, filmId);
		stmt.setInt(2, filmId);

		while (rs.next()) {
			System.out.println(rs.getString("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
		}
		stmt.close();
		conn.close();
		return null;
	}

	@Override
	public Actor findActorById(int actorId) {
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		return null;
	}

}
