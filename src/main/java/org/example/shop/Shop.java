package org.example.shop;

import org.example.comicinfo.author.Author;
import org.example.comicinfo.author.AuthorManage;
import org.example.comicinfo.series.Series;
import org.example.comicinfo.series.SeriesManage;
import org.example.shop.assortiment.AssortmentManage;
import org.example.shop.assortiment.AssortmentPosition;

import java.util.ArrayList;

public class Shop {
    private ArrayList<AssortmentPosition> assortment;
    private ArrayList<Author> authors;
    private ArrayList<Series> series;
    private double cash;
    public ShopManage shopManage = new ShopManage(this);
    public AssortmentManage assortmentManage = new AssortmentManage(this.assortment);
    public AuthorManage authorManage = new AuthorManage(this.authors);
    public SeriesManage seriesManage = new SeriesManage(this.series);

    public Shop() {
    }

    public Shop(ArrayList<AssortmentPosition> assortments, double cash) {
        this.assortment = assortments;
        this.cash = cash;
    }

    public ArrayList<AssortmentPosition> getAssortment() {
        return assortment;
    }

    public void setAssortment(ArrayList<AssortmentPosition> assortment) {
        this.assortment = assortment;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
