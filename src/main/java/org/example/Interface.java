package org.example;

import org.example.comicinfo.Comic;
import org.example.shop.Shop;
import org.example.shop.ShopManage;

import java.util.Scanner;

public class Interface {
    public ShopManage shopManage;

    public void printMainMenu() {
        System.out.println("\nЧто вы хотите? \n1. Поиск комикса \n2. Продажа комикса \n3. Пополнение ассортимента \n4. Списание комикса");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (!(choice >= 1 && choice <= 4)) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.comicSearch();
                    break;
                case 2:
                    String comicName, authorName;
                    int quantityToSell;
                    System.out.println("Введите название комикса: ");
                    comicName = scanner.next();
                    System.out.println("Введите имя автора: ");
                    authorName = scanner.next();
                    System.out.println("Введите количество экземпляров для покупки: ");
                    quantityToSell = scanner.nextInt();
                    this.shopManage.sellComic(comicName, authorName, quantityToSell);
                    break;
                case 3:
                    System.out.println("Введите название комикса: ");
                    int price = scanner.nextInt();
                    System.out.println("Введите название комикса: ");
                    int quantityToBuy = scanner.nextInt();
                    if (this.shopManage.canBuyNewComic(price, quantityToBuy)) this.gotNewComic(price, quantityToBuy);
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    public void comicSearch() {
        System.out.println("\nКакой поиск вы хотите провести? \n1. По названию \n2. По автору \n3. По жанру \n4. В главное меню");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (!(choice >= 1 && choice <= 4)) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите название комикса: ");
                    this.shopManage.shop.assortmentManage.searchByName(scanner.next());
                    break;
                case 2:
                    System.out.println("Введите имя автора: ");
                    this.shopManage.shop.assortmentManage.searchByAuthor(scanner.next());
                    break;
                case 3:
                    System.out.println("Введите жанр: ");
                    this.shopManage.shop.assortmentManage.searchByGenre(scanner.next());
                    break;
                case 4:
                    this.printMainMenu();
                    break;
                default:
                    System.out.print("Неверный номер. Попробуйте снова: ");
                    break;
            }
        }
    }

    public void gotNewComic(float price, int quantityToBuy) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название комикса: ");
        String name = scanner.next();
        System.out.print("Введите имя автора: ");
        String author = scanner.next();
        System.out.println("Введите издателя: ");
        String publisher = scanner.next();
        System.out.println("Введите жанр: ");
        String genre = scanner.next();
        System.out.println("Введите количество страниц: ");
        int numberOfPages = scanner.nextInt();
        System.out.println("Введите год выпуска: ");
        int year = scanner.nextInt();
        System.out.println("Введите стоимость продажи: ");
        float sellingPrice = scanner.nextFloat();
        System.out.println("Является ли сиквелом? (Да/Нет): ");
        String isASequel = scanner.next();
        System.out.println("Является ли частью серии? (Да/Нет): ");
        String inASeries = scanner.next();
        if (inASeries == "Да") {
            System.out.println("Является ли частью серии? (Да/Нет): ");
            String seriesName = scanner.next();
            this.shopManage.shop.assortmentManage.addNewComic(new Comic(name, author, publisher, numberOfPages, genre,
                    year, price, sellingPrice, (isASequel == "Да" ? true : false), true, seriesName), quantityToBuy);
        } else
            this.shopManage.shop.assortmentManage.addNewComic(new Comic(name, author, publisher, numberOfPages, genre,
                    year, price, sellingPrice, (isASequel == "Да" ? true : false), false), quantityToBuy);
    }
}
