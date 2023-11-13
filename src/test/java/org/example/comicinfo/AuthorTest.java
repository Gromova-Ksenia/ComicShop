package org.example.comicinfo;

import org.example.comicinfo.author.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AuthorTest {
    Author author = new Author("Артем Габрелянов");
    Comic comic = new Comic("Чумной доктор", author, "Bubble", 36,
            "Детектив", 2012, 300, 600, false, false);

    @BeforeEach
    public void init() {
        author.setName("");
        author.setComicPublished(new ArrayList<Comic>());
        author.addNewPublishedComic(comic);
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getComicPublished() {
    }

    @Test
    void setComicPublished() {
    }

    @Test
    void addNewPublishedComic() {
    }
}