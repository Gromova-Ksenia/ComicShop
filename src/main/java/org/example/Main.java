package org.example;

import org.example.comicinfo.Comic;
import org.example.shop.Shop;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.setCash(2000);
        ShopInterface shopInterface = new ShopInterface(shop.shopManage);
        shop.assortmentManage.addNewComic(new Comic("Тёмные воды", "Сергей Дубров", "Bubble", 50, "Ужасы",
                2021, 200, 350, false, true, "Чёрное озеро"), 10);
        shop.assortmentManage.addNewComic(new Comic("Тёмные небеса", "Сергей Дубров", "Bubble", 47, "Ужасы",
                2022, 200, 350, false, true, "Чёрное озеро"), 10);
        shop.assortmentManage.addNewComic(new Comic("Переходы", "Елена Савицкая", "Bubble", 33, "Комедия",
                2017, 150, 300, false, false), 17);

        shopInterface.printMainMenu();
    }
}