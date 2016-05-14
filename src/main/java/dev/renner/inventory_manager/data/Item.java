package dev.renner.inventory_manager.data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by renne on 14.05.2016.
 */
public class Item implements Serializable {
    private UUID id;
    private String name;
    private Category category;
    private String manufacturer;
    private Date buyDate;
    private double buyPrice;


    public Item()
    {
        this.id = UUID.randomUUID();
        this.name = "";
        this.category = new Category();
        this.manufacturer = "";
        this.buyDate = new Date();
        this.buyPrice = 0;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }


}
