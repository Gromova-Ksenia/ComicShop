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

    //Поиск автора в каталоге авторов
    public Author findAuthor(String authorName) {
        for (Author author : this.authors) {
            if (authorName == author.getName()) return author;
        }
        return null;
    }

    //Добавление нового автора в каталог
    public void addAuthorToList(Author author){
        this.authors.add(author);
    }

    //Создание нового автора, добавление в каталог
    public Author newAuthor(String name, Comic comic) {
        Author author = new Author(name);
        author.setComicPublished(new ArrayList<>()) ;
        author.getComicPublished().add(comic);
        return author;
    }

    //Добавление новой работы автору
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
