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

    //Поиск серии в каталоге серий по имени и автору
    public Series findSeries(String seriesName, String seriesAuthor) {
        if (this.series==null) return null;
        for (Series thisSeries : this.series) {
            if (thisSeries.getSeriesName().toLowerCase() == seriesName.toLowerCase() && thisSeries.getSeriesAuthor().getName().toLowerCase() == seriesAuthor.toLowerCase()) {
                return thisSeries;
            }
        }
        return null;
    }

    //Создание новой серии, добавление в каталог
    public Series newSeries(String name, Author author, Comic comic) {
        Series series = new Series(name, author);
        series.setComicInSeries(new HashMap<>(),comic);
        if (this.series == null){
            this.series = new ArrayList<>();
            this.series.add(series);
        } else this.series.add(series);
        return series;
    }

    //Проверка, есть ли серия в каталоге серий
    public boolean searchInSeries(Series series, String name) {
        for (int i = 0; i < series.getComicInSeries().size(); i++) {
            if (series.getComicInSeries().get(i).getName().toLowerCase() == name.toLowerCase()) return true;
        }
        return false;
    }

    //Добавление комикса в серию
    public void addComicToSeries(Series series, Comic comic) {
        if (this.searchInSeries(series, comic.getName())) System.out.println("");
        else series.getComicInSeries().put((byte) series.getComicInSeries().size(), comic);

    }

    public void printAllSeries(){
        if (this.series == null) System.out.println("Ошибка! Нет серий.");
        else {
            for (Series thisSeries : this.series) {
                System.out.println(thisSeries);
            }
        }
    }

}
