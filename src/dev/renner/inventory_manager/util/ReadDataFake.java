package dev.renner.inventory_manager.util;

import dev.renner.inventory_manager.data.Category;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by renne on 14.05.2016.
 */
public class ReadDataFake implements ReadData{
    @Override
    public ArrayList<Category> getCategories() {

        ArrayList<Category> categories= new ArrayList<>();

        categories.add(new Category("1"));

        categories.add(new Category("2"));

        categories.add(new Category("3"));

        categories.add(new Category("4"));



        return categories;
    }
}
