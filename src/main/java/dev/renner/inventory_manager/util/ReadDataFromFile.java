package dev.renner.inventory_manager.util;

import dev.renner.inventory_manager.data.ItemData;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by renne on 14.05.2016.
 */
public class ReadDataFromFile implements ReadData {
    @Override
    public ItemData readData() {
        try {
            FileInputStream fis = new FileInputStream("data.save");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (ItemData) ois.readObject();
        } catch (Exception e) {
            System.out.println("Could not load data from file!");
            e.printStackTrace();
        }
        return new ItemData(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }
}
