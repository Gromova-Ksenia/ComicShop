package org.example.shop.assortiment;

import org.example.comicinfo.Comic;

public class Assortment {
    private Comic comic;
    private int available;

    public Assortment() {
    }

    public Assortment(Comic comic, int available) {
        this.comic = comic;
        this.available = available;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
