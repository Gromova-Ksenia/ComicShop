package org.example;

import org.example.comicinfo.author.Author;
import org.example.comicinfo.Comic;
import org.example.comicinfo.series.Series;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ComicTest {
    Author artyomGab = new Author("Артем Габрелянов");
    Series gromSeries = new Series("Майор Гром", artyomGab);
    Comic comic = new Comic("Чумной доктор", artyomGab, "Bubble", 36,
            "Детектив", 2012, 300, 600, false, true, gromSeries);

    @BeforeEach
    public void init() {
        comic.setName("Чумной доктор");
        comic.setAuthor(artyomGab);
        comic.setPublisher("Bubble");
        comic.setNumberOfPages(36);
        comic.setGenre("Детектив");
        comic.setReleaseYear(2012);
        comic.setCostPrice(300);
        comic.setSellingPrice(600);
        comic.setASequel(false);
        comic.setInASeries(true);
        comic.setSeries(gromSeries);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(comic);
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Чумной доктор", comic.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        comic.setName("testName");
        assertEquals("testName", comic.getName());
    }

    @org.junit.jupiter.api.Test
    void getAuthor() {
        Author artyomGab1 = new Author("Артем Габрелянов");
        assertEquals(artyomGab1, comic.getAuthor());
    }

    @org.junit.jupiter.api.Test
    void setAuthor() {
        Author newAuthor = new Author("New Author");
        comic.setAuthor(new Author("New Author"));
        assertEquals(newAuthor, comic.getAuthor());
    }

    @org.junit.jupiter.api.Test
    void getPublisher() {
        assertEquals("Bubble", comic.getPublisher());
    }

    @org.junit.jupiter.api.Test
    void setPublisher() {
        comic.setPublisher("new publisher");
        assertEquals("new publisher", comic.getPublisher());
    }

    @org.junit.jupiter.api.Test
    void getNumberOfPages() {
        assertEquals(36, comic.getNumberOfPages());
    }

    @org.junit.jupiter.api.Test
    void setNumberOfPages() {
        comic.setNumberOfPages(45);
        assertEquals(45, comic.getNumberOfPages());
    }

    @org.junit.jupiter.api.Test
    void getGenre() {
        assertEquals("Детектив", comic.getGenre());
    }

    @org.junit.jupiter.api.Test
    void setGenre() {
        comic.setGenre("test genre");
        assertEquals("test genre", comic.getGenre());
    }

    @org.junit.jupiter.api.Test
    void getReleaseYear() {
        assertEquals(2012, comic.getReleaseYear());
    }

    @org.junit.jupiter.api.Test
    void setReleaseYear() {
        comic.setReleaseYear(1995);
        assertEquals(1995, comic.getReleaseYear());
    }

    @org.junit.jupiter.api.Test
    void getCostPrice() {
        assertEquals(300, comic.getCostPrice());
    }

    @org.junit.jupiter.api.Test
    void setCostPrice() {
        comic.setCostPrice(134);
        assertEquals(134, comic.getCostPrice());
    }

    @org.junit.jupiter.api.Test
    void getSellingPrice() {
        assertEquals(600, comic.getSellingPrice());
    }

    @org.junit.jupiter.api.Test
    void setSellingPrice() {
        comic.setSellingPrice(890);
        assertEquals(890, comic.getSellingPrice());
    }

    @org.junit.jupiter.api.Test
    void getASequel() {
        assertEquals(false, comic.getASequel());
    }

    @org.junit.jupiter.api.Test
    void setASequel() {
        comic.setASequel(true);
        assertEquals(true, comic.getASequel());
    }

    @org.junit.jupiter.api.Test
    void isInASeries() {
        assertEquals(true, comic.isInASeries());
    }

    @org.junit.jupiter.api.Test
    void setInASeries() {
        comic.setInASeries(false);
        assertEquals(false, comic.isInASeries());
        assertEquals(null, comic.getSeries());
    }

}