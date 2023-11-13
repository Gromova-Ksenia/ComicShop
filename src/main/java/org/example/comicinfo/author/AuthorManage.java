package org.example.comicinfo.author;

import org.example.comicinfo.Comic;

import java.util.ArrayList;

public class AuthorManage {
    ArrayList<Author> authors;

    public AuthorManage() {
    }

    public AuthorManage(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public Author findAuthor(String authorName) {
        for (Author author : this.authors) {
            if (authorName == author.getName()) return author;
        }
        return null;
    }

    public void addAuthorToList(Author author){
        this.authors.add(author);
    }
    public Author newAuthor(String name, Comic comic) {
        Author author = new Author(name);
        author.setComicPublished(new ArrayList<>()) ;
        author.getComicPublished().add(comic);
        return author;
    }

    public void newWork(Author author, Comic comic){
        author.addNewPublishedComic(comic);
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }


}
