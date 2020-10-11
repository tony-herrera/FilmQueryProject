package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		FilmQueryApp app = new FilmQueryApp();

//		app.test();

		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);

		Actor actors = db.findActorById(1);
		System.out.println(actors);

		List<Actor> actorsInFilm = db.findActorsByFilmId(2);
		System.out.println(actorsInFilm);

	}

	private void launch() throws SQLException {
		Scanner sc = new Scanner(System.in);

		startUserInterface(sc);

		sc.close();
	}

	private void startUserInterface(Scanner sc) throws SQLException {
		System.out.println("Welcome");
		System.out.println();

		boolean makeAnotherSelection = true;
		while (makeAnotherSelection) {
			System.out.println("Would you like to look up a film by its ID, press 1 ");
			System.out.println("<><><><><><><>");
			System.out.println("Would you like to look up a film by its keyword, press 2 ");
			System.out.println("<><><><><><><>");
			System.out.println("Would you like to exit the application, press 3? ");
			System.out.println();
			String userInput = sc.next();
			sc.nextLine();
			switch (userInput) {

			case "1":
				try {
					System.out.println("Please enter film id : ");
				} catch (Exception e) {
					e.printStackTrace();
				}
				int filmId = sc.nextInt();
				if (db.findFilmById(filmId) == null) {
					System.out.println("This film could not be found");
				} else {
					System.out.println(db.findFilmById(filmId));

				}

				break;

			case "2":
				System.out.println("Please enter keyword");
				String keyword = sc.nextLine();
				if (db.keywordByFilm(keyword).size() == 0) {
					System.out.println("This film could not be found");
				} else {
					System.out.println(db.keywordByFilm(keyword));
				}
				break;

			case "3":
				System.out.println("Good-Bye!");
				makeAnotherSelection = false;
				break;
			default:

			}
		}
		sc.close();
	}
}
