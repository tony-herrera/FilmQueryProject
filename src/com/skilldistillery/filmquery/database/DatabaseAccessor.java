package com.skilldistillery.filmquery.database;

import com.skilldistillery.filmquery.entities.Film;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;

public interface DatabaseAccessor {
	public Film findFilmById(int filmId) throws SQLException;

	public Actor findActorById(int actorId) throws SQLException;

	public List<Actor> findActorsByFilmId(int filmId) throws SQLException;

	public List<Film> keywordByFilm(String keyword) throws SQLException;
}
