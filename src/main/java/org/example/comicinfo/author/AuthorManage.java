package org.example.comicinfo.author_manage;

import org.example.comicinfo.Author;
import org.example.comicinfo.Comic;

import java.util.ArrayList;

public abstract class AuthorManage {
    public Author findAuthor(String authorName, ArrayList<Author> authors) {
        for (Author author : authors) {
            if (authorName == author.getName()) return author;
        }
        return null;
    }

    public Author newAuthor(String name, Comic comic) {
        Author author = new Author(name);
        author.setComicPublished(new ArrayList<>()) ;
        author.getComicPublished().add(comic);
        return author;
    }
}
