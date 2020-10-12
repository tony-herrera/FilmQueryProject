package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private String language;
	private int length;
	private int rentalDuration;
	private int rentalRate;
	private int replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorsInFilm;

	public Film(int id, String title, String description, int releaseYear, String languageId, int length,
			int rentalDuration, int rentalRate, int replacementCost, String rating, String specialFeatures,
			List<Actor> actorsInFilm) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = languageId;
		this.length = length;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actorsInFilm = actorsInFilm;
	}

	public Film() {
	}

	public Film(int id, String title, String description, String rating) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.rating = rating;
	}

	public Film(int id, String title, String description, String rating, String language, int release_year) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.language = language;
		this.releaseYear = release_year;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguageId() {
		return language;
	}

	public void setLanguageId(String languageId) {
		this.language = languageId;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film id: ");
		builder.append(id);
		builder.append("\n Title: ");
		builder.append(title);
		builder.append("\n Description: ");
		builder.append(description);
		builder.append("\n Release Year: ");
		builder.append(releaseYear);
		builder.append("\n Language: ");
		builder.append(language);
		builder.append("\n Total Run Time: ");
		builder.append(length);
		builder.append("\n Rating: ");
		builder.append(rating);
		builder.append("\n Special Features: ");
		builder.append(specialFeatures);
		builder.append("\n Actors and Actresses Who Are In This Film: ");
		for (Actor actor : actorsInFilm) {
			builder.append(actor + "\n");
		}
//		builder.append(".");
		return builder.toString();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Actor> getActorsInFilm() {
		return actorsInFilm;
	}

	public void setActorsInFilm(List<Actor> actorsInFilm) {
		this.actorsInFilm = actorsInFilm;
	}

}
