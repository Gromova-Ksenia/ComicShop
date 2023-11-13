package org.example.comicinfo;

import org.example.comicinfo.author.Author;
import org.example.comicinfo.author.AuthorManage;
import org.example.comicinfo.series.Series;
import org.example.comicinfo.series.SeriesManage;

public class Comic {
    private String name;
    private Author author;
    private String publisher;
    private int numberOfPages;
    private String genre;
    private int releaseYear;
    private float costPrice;
    private float sellingPrice;
    private boolean isASequel;
    private boolean inASeries;
    private Series series = null;

    public Comic() {
        this.name = null;
        this.author = null;
        this.publisher = null;
        this.numberOfPages = 0;
        this.genre = null;
        this.releaseYear = 0;
        this.costPrice = 0;
        this.sellingPrice = 0;
        this.isASequel = false;
        this.inASeries = false;
        this.series = null;
    }

    public Comic(String name, Author author, String publisher, int numberOfPages, String genre,
                 int releaseYear, float costPrice, float sellingPrice, boolean isASequel, boolean inASeries) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.isASequel = isASequel;
        this.inASeries = inASeries;
    }

    public Comic(String name, String authorName, String publisher, int numberOfPages, String genre,
                 int releaseYear, float costPrice, float sellingPrice, boolean isASequel, boolean inASeries) {
        this.name = name;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.isASequel = isASequel;
        this.inASeries = inASeries;
        AuthorManage authorManage = new AuthorManage();
        this.author = authorManage.newAuthor(authorName, this);
    }

    public Comic(String name, Author author, String publisher, int numberOfPages, String genre,
                 int releaseYear, float costPrice, float sellingPrice, boolean isASequel, boolean inASeries, String seriesName) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.isASequel = isASequel;
        this.inASeries = inASeries;
        SeriesManage seriesManage = new SeriesManage();
        this.series = seriesManage.newSeries(seriesName,author,this);
    }
    public Comic(String name, String authorName, String publisher, int numberOfPages, String genre,
                 int releaseYear, float costPrice, float sellingPrice, boolean isASequel, boolean inASeries, String seriesName) {
        this.name = name;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.isASequel = isASequel;
        this.inASeries = inASeries;
        AuthorManage authorManage = new AuthorManage();
        this.author = authorManage.newAuthor(authorName, this);
        SeriesManage seriesManage = new SeriesManage();
        this.series = seriesManage.newSeries(seriesName,author,this);
    }

    @Override
    public String toString() {
        return ("\nНазвание: " + this.name + "\nАвтор: " + this.author.getName() + "\nИздательство: " + this.publisher +
                "\nКоличество страниц: " + this.numberOfPages + "\nЖанр: " + this.genre + "\nГод релиза: " + this.releaseYear +
                "\nСебестоимость: " + this.costPrice + "\nСтоимость продажи: " + this.sellingPrice +
                (isASequel ? "\nСиквел." : "\nНе сиквел.") + (inASeries ? ("\nВ серии: " + this.series.getSeriesName()) : "\nНе является частью серии."));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean getASequel() {
        return isASequel;
    }

    public void setASequel(boolean aSequel) {
        isASequel = aSequel;
    }

    public boolean isInASeries() {
        return inASeries;
    }

    public void setInASeries(boolean inASeries) {
        this.inASeries = inASeries;
        if (!inASeries) this.series = null;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
