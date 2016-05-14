package dev.renner.inventory_manager.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by renne on 14.05.2016.
 */
public class ItemData implements Serializable{

    public ObservableList<Item> items;
    public ObservableList<Category> categories;
    public ObservableList<Location> locations;


    public ItemData(ArrayList<Item> items, ArrayList<Category> categories, ArrayList<Location> locations) {
        this.items = FXCollections.observableArrayList(items);
        this.categories = FXCollections.observableArrayList(categories);
        this.locations = FXCollections.observableArrayList(locations);
    }
}
