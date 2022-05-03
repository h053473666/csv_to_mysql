package com.alien.pojo;

import com.alien.utils.CsvRow;

public class Product implements CsvRow {
    private String itemId;
    private String name;
    private String image;
    private int price;
    private String category;
    private int sortByRank;
    private int salesVolume;


    public Product() {
    }

    public Product(String itemId, String name, String image, int price, String category, int sortByRank, int salesVolume) {
        this.itemId = itemId;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category = category;
        this.sortByRank = sortByRank;
        this.salesVolume = salesVolume;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSortByRank() {
        return sortByRank;
    }

    public void setSortByRank(int sortByRank) {
        this.sortByRank = sortByRank;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", sortByRank=" + sortByRank +
                ", salesVolume=" + salesVolume +
                '}';
    }

    @Override
    public void setFromRow(String[] row) {
        this.itemId = row[0];
        this.name = row[1];
        this.image = row[2];
        this.price = Integer.parseInt(row[3]);
        this.category = row[4];
        this.sortByRank = Integer.parseInt(row[5]);
        this.salesVolume = Integer.parseInt(row[6]);
    }
}
