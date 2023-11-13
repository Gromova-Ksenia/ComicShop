package org.example.shop;

import org.example.comicinfo.Comic;
import org.example.shop.assortiment.AssortmentPosition;

public class ShopManage {
    public Shop shop;


    public ShopManage() {
    }

    public ShopManage(Shop shop) {
        this.shop = shop;
    }

    //Продажа комикса
    public void sellComic(String comicName, String authorName, int quantity) {
        float earning = this.shop.assortmentManage.comicSell(comicName, authorName, quantity);
        this.shop.setCash(this.shop.getCash() + earning);
    }

    //Покупка нового комикса
    public void buyNewComic(Comic comic, int quantity) {
        this.shop.setCash(this.shop.getCash() - comic.getCostPrice() * quantity);
            AssortmentPosition thisPosition = this.shop.assortmentManage.findComicInAssortment(comic);
            if (thisPosition == null) this.shop.assortmentManage.addNewComic(comic, quantity);
            else this.shop.assortmentManage.fillPosition(thisPosition, quantity);
    }

    //Проверка возможности покупки
    public boolean canBuyNewComic(int price, int quantity){
        if (this.shop.getCash()>=price*quantity) return true;
        else return false;
    }
}
