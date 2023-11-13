package org.example.shop.assortiment;

import org.example.comicinfo.Comic;

public class AssortmentPosition {
    private Comic comic;
    private int available;

    public AssortmentPosition() {
    }

    public AssortmentPosition(Comic comic, int available) {
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

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;
        return ((((AssortmentPosition) object).getComic().getName() == this.comic.getName()) &&
                (((AssortmentPosition) object).getComic().getAuthor() == this.comic.getAuthor()));
    }
    public String toString() {
       return ("Название: " + this.comic.getName() + "\nАвтор: " + this.comic.getAuthor().getName() + "\nВ наличии: " + this.available);
    }
}
