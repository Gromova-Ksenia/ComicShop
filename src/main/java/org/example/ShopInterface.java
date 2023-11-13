package org.example;

import org.example.comicinfo.Comic;
import org.example.shop.ShopManage;

import java.util.Scanner;

public class ShopInterface {
    public ShopManage shopManage;

    public ShopInterface() {
    }

    public ShopInterface(ShopManage shopManage) {
        this.shopManage = shopManage;
    }

    //Вывод основного меню
    public void printMainMenu() {
        System.out.print("\nЧто вы хотите? \n1. Вывести ассортимент комиксов\n2. Вывести все серии комиксов" +
                " \n3. Поиск комикса \n4. Продажа комикса \n5. Пополнение ассортимента \n6. Списание комикса\n7. Завершение работы\nВыберите: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 7) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.shopManage.shop.assortmentManage.showAssortment();
                    this.printMainMenu();
                    break;
                case 2:
                    this.shopManage.shop.seriesManage.printAllSeries();
                    break;
                case 3:
                    this.comicSearch();
                    this.printMainMenu();
                    break;
                case 4:
                    String comicName, authorName;
                    int quantityToSell;
                    System.out.print("Введите название комикса: ");
                    comicName = scanner.next();
                    System.out.print("Введите имя автора: ");
                    authorName = scanner.next();
                    System.out.print("Введите количество экземпляров для покупки: ");
                    quantityToSell = scanner.nextInt();
                    this.shopManage.sellComic(comicName, authorName, quantityToSell);
                    this.printMainMenu();
                    break;
                case 5:
                    System.out.print("Введите стоимость комикса: ");
                    int price = scanner.nextInt();
                    System.out.print("Введите количество экземпляров для покупки: ");
                    int quantityToBuy = scanner.nextInt();
                    if (this.shopManage.canBuyNewComic(price, quantityToBuy)) this.gotNewComic(price, quantityToBuy);
                    else System.out.println("Покупка невозможна: недостаточно средств.");
                    this.printMainMenu();
                    break;
                case 6:
                    System.out.print("Введите название комикса: ");
                    comicName = scanner.next();
                    System.out.print("Введите имя автора: ");
                    authorName = scanner.next();
                    this.shopManage.shop.assortmentManage.positionRemove(this.shopManage.shop.assortmentManage.findComicInAssortment(comicName, authorName));
                    this.printMainMenu();
                    break;
                case 7:
                    break;
                default:
                    System.out.print("Ошибка: неверный номер. Попробуйте снова: ");
                    break;
            }
        }
    }

    //Вывод меню поиска
    public void comicSearch() {
        System.out.print("\nКакой поиск вы хотите провести? \n1. По названию \n2. По автору \n3. По жанру \n4. В главное меню\nВведите ваш выбор: ");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (!(choice >= 1 && choice <= 4)) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите название комикса: ");
                    this.shopManage.shop.assortmentManage.searchByName(scanner.next());
                    break;
                case 2:
                    System.out.print("Введите имя автора: ");
                    scanner.nextLine();
                    scanner.reset();
                    String authorName = scanner.nextLine();
                    this.shopManage.shop.assortmentManage.searchByAuthor(authorName);
                    break;
                case 3:
                    System.out.print("Введите жанр: ");
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

    //Добавление нового комикса
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
