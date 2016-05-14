package dev.renner.inventory_manager.util;

import dev.renner.inventory_manager.data.Category;
import dev.renner.inventory_manager.data.Item;
import dev.renner.inventory_manager.data.ItemData;
import dev.renner.inventory_manager.data.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by renne on 14.05.2016.
 */
public class ReadDataFake implements ReadData {

    @Override
    public ItemData readData() {

        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<Location> locations = new ArrayList<>();

        categories.add(new Category("Hardware"));
        categories.add(new Category("Software"));

        locations.add(new Location("Schrank"));
        locations.add(new Location("Dachboden"));


        return new ItemData(items, categories, locations);
    }
}
