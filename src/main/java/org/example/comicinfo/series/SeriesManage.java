package org.example.comicinfo.series;

import org.example.comicinfo.Comic;
import org.example.comicinfo.author.Author;

import java.util.ArrayList;
import java.util.HashMap;

public class SeriesManage {
    ArrayList<Series> series;

    public SeriesManage() {
    }

    public SeriesManage(ArrayList<Series> series) {
        this.series = series;
    }

    public Series findSeries(String seriesName, String seriesAuthor) {
        for (Series thisSeries : this.series) {
            if (thisSeries.getSeriesName().toLowerCase() == seriesName.toLowerCase() && thisSeries.getSeriesAuthor().getName().toLowerCase() == seriesAuthor.toLowerCase()) {
                return thisSeries;
            }
        }
        return null;
    }

    public Series newSeries(String name, Author author, Comic comic) {
        Series series = new Series(name, author);
        series.setComicInSeries(new HashMap<>());
        series.getComicInSeries().put((byte) 1, comic);
        return series;
    }

    public boolean searchInSeries(Series series, String name) {
        for (int i = 0; i < series.getComicInSeries().size(); i++) {
            if (series.getComicInSeries().get(i).getName().toLowerCase() == name.toLowerCase()) return true;
        }
        return false;
    }

    public void addComicToSeries(Series series, Comic comic) {
        if (this.searchInSeries(series, comic.getName())) System.out.println("");
        else series.getComicInSeries().put((byte) series.getComicInSeries().size(), comic);

    }

}
