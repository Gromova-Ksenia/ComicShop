package org.example.comicinfo.series;

import org.example.comicinfo.Comic;
import org.example.comicinfo.author.Author;

import java.util.HashMap;

public class Series {
    private String seriesName;
    private Author seriesAuthor;
    private HashMap<Byte, Comic> comicInSeries;

    public Series() {
        this.seriesName = null;
        this.seriesAuthor = null;
        this.comicInSeries = null;
    }

    public Series(String seriesName, Author seriesAuthor) {
        this.seriesName = seriesName;
        this.seriesAuthor = seriesAuthor;
        this.comicInSeries = null;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;
        return ((((Series) object).seriesName == this.seriesName) && (((Series) object).seriesAuthor.getName().toLowerCase() == this.seriesAuthor.getName()) &&
                (((Series) object).comicInSeries == this.comicInSeries));
    };

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setComicInSeries(HashMap<Byte, Comic> comicInSeries, Comic comic) {
        this.comicInSeries = comicInSeries;
        this.comicInSeries.put((byte)(comicInSeries.size()+1), comic);
    }
    public HashMap<Byte, Comic> getComicInSeries() {
        return comicInSeries;
    }

    public Author getSeriesAuthor() {
        return seriesAuthor;
    }

    public void setSeriesAuthor(Author seriesAuthor) {
        this.seriesAuthor = seriesAuthor;
    }

    @Override
    public String toString() {
        String seriesPrint = "\nНазвание серии: " + this.seriesName + "\nСписок работ:\n";
        for (int i=0; i<this.comicInSeries.size();i++){
            seriesPrint+= this.comicInSeries.get(i).getName() + "\n";
        }
        return (seriesPrint);
    }
}
