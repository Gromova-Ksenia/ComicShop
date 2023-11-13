package org.example.shop.assortiment;

import org.example.comicinfo.Comic;

import java.util.ArrayList;
import java.util.Locale;

public class AssortmentManage {
    ArrayList<AssortmentPosition> assortment;

    public AssortmentManage() {
    }

    public AssortmentManage(ArrayList<AssortmentPosition> assortment) {
        this.assortment = assortment;
    }


    //Проверка наличиякомикса в продаже. Если находит - возвращает позицию.
    public AssortmentPosition findComicInAssortment(String comicName, String authorName) {
        if (this.assortment == null) return null;
        else {
            for (AssortmentPosition thisPosition : this.assortment) {
                if (thisPosition.getComic().getName().toLowerCase() == comicName.toLowerCase() &&
                        thisPosition.getComic().getAuthor().getName().toLowerCase() == authorName.toLowerCase())
                    return thisPosition;
            }
        }
        return null;
    }
    public AssortmentPosition findComicInAssortment(Comic comic) {
        if (this.assortment == null) return null;
        else {
            for (AssortmentPosition thisPosition : this.assortment) {
                if (thisPosition.getComic().getName().toLowerCase() == comic.getName().toLowerCase() &&
                        thisPosition.getComic().getAuthor().getName().toLowerCase() == comic.getAuthor().getName().toLowerCase())
                    return thisPosition;
            }
        }
        return null;
    }

    //Пополняет позцию комиксов при поступлении новой партии.
    public void fillPosition(AssortmentPosition position, int quantity) {
        position.setAvailable(position.getAvailable() + quantity);
    }

    //Добавляет новый комикс в ассортимент
    public void addNewComic(Comic comic, int quantity) {
        if (findComicInAssortment(comic.getName(), comic.getAuthor().getName()) == null)
            assortment.add(new AssortmentPosition(comic, quantity));
        else {
            this.fillPosition(findComicInAssortment(comic.getName(), comic.getAuthor().getName()), quantity);
        }
    }



    //Удаляет комикс из ассортимента
    public void deletePosition(AssortmentPosition position) {
        this.assortment.remove(position);
    }

    //Покупка комикса. Проверка возможности, в случае успеха уменьшение количества в ассортименте
    public float comicSell(String comicName, String authorName, int quantity) {
        AssortmentPosition position = this.findComicInAssortment(comicName, authorName);
        if (position == null) {
            this.unableToBuy();
            return 0;
        } else {
            float earnings;
            if (quantity < position.getAvailable()) {  // Если в наличии достаточно экземпляров
                position.setAvailable(position.getAvailable() - quantity);
                earnings = position.getComic().getSellingPrice() * quantity;
                return earnings;
            } else if (quantity > position.getAvailable()) { //Если недостаточно экземпляров
                this.notEnoughAvailable();
                earnings = position.getComic().getSellingPrice() * position.getAvailable();
                this.deletePosition(position);
                return earnings;
            } else { //Если ровное количество
                earnings = position.getComic().getSellingPrice() * quantity;
                this.deletePosition(position);
                return earnings;
            }
        }
    }

    //Списания товара без получения денег
    public void positionRemove(AssortmentPosition position) {
        this.assortment.remove(position);
    }

    //Вывод оповещения о невозможности покупки
    public void unableToBuy() {
        System.out.println("Покупка невозможна: комикса нет в наличии.");
    }

    //Оповещение о нехватке товара
    public void notEnoughAvailable() {
        System.out.println("В наличии меньше товара. Будет продано доступное количество.");
    }

    //Поиск по названию
    public void searchByName(String comicName) {
        for (AssortmentPosition assortmentPosition : this.assortment) {
            if (assortmentPosition.getComic().getName().toLowerCase() == comicName.toLowerCase())
                System.out.println(assortmentPosition.getComic());
        }
    }

    //Поиск по автору
    public void searchByAuthor(String authorName) {
        for (AssortmentPosition assortmentPosition : this.assortment) {
            if (assortmentPosition.getComic().getAuthor().getName().toLowerCase() == authorName.toLowerCase())
                System.out.println(assortmentPosition.getComic());
        }
    }

    //Поиск по жанру
    public void searchByGenre(String genre) {
        for (AssortmentPosition assortmentPosition : this.assortment) {
            if (assortmentPosition.getComic().getGenre().toLowerCase() == genre.toLowerCase())
                System.out.println(assortmentPosition.getComic());
        }
    }

    public ArrayList<AssortmentPosition> getAssortment() {
        return assortment;
    }

    public void setAssortment(ArrayList<AssortmentPosition> assortment) {
        this.assortment = assortment;
    }

}
