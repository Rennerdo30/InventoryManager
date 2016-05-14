package dev.renner.inventory_manager.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by renne on 14.05.2016.
 */
public class ItemData implements Serializable {

    public ArrayList<Item> items;
    public ArrayList<Category> categories;
    public ArrayList<Location> locations;


    public ItemData(ArrayList<Item> items, ArrayList<Category> categories, ArrayList<Location> locations) {
        this.items = items;
        this.categories = categories;
        this.locations = locations;
    }

    public ObservableList<Item> getItems() {
        return FXCollections.observableArrayList(this.items);
    }

    public ObservableList<Category> getCategories() {
        return FXCollections.observableArrayList(this.categories);
    }

    public ObservableList<Location> getLocations() {
        return FXCollections.observableArrayList(this.locations);
    }
}
