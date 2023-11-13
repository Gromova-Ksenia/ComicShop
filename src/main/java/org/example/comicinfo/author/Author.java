package org.example.comicinfo.author;

import org.example.comicinfo.Comic;

import java.util.ArrayList;

public class Author {
    private String name;
    private ArrayList<Comic> comicPublished;

    public Author() {
        this.name = "";
        this.comicPublished = null;
    }

    public Author(String name) {
        this.name = name;
        this.comicPublished = null;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object.getClass() != this.getClass()) return false;
        return ((((Author) object).name == this.name) && (((Author) object).comicPublished == this.comicPublished));
    }

    @Override
    public String toString() {
        String authorPrint = "\nАвтор: " + this.name + "\nСписок работ:\n";
        for (int i=0; i<this.comicPublished.size();i++){
            authorPrint+= this.comicPublished.get(i).getName() + "\n";
        }
        return (authorPrint);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Comic> getComicPublished() {
        return comicPublished;
    }

    public void setComicPublished(ArrayList<Comic> comicPublished) {
        this.comicPublished = comicPublished;
    }

    public void addNewPublishedComic(Comic comic) {
        this.comicPublished.add(comic);
    }

}
