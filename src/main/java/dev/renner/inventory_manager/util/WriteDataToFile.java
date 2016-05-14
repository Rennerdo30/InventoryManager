package dev.renner.inventory_manager.util;

import dev.renner.inventory_manager.data.ItemData;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.spec.ECField;

/**
 * Created by renne on 14.05.2016.
 */
public class WriteDataToFile implements WriteData {
    @Override
    public void writeData(ItemData data) {
        try {
            FileOutputStream fout = new FileOutputStream("data.save");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(data);
        } catch (Exception e) {
            System.out.println("Could not save data to file!");
            e.printStackTrace();
        }


    }
}
