package io.spring.movieportal.model.movie;

public class Movie {
    private int id;
    private String name;
    private String genre;
    private int year;
    private float price;
    private int generalRank;

    public Movie() {

    }

    public Movie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Movie(int id, String name, String genre, int year) {
        this(id, name);
        this.genre = genre;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGeneralRank() {
        return generalRank;
    }

    public void setGeneralRank(int generalRank) {
        this.generalRank = generalRank;
    }
}
