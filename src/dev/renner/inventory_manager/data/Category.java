package dev.renner.inventory_manager.data;

import java.util.UUID;

/**
 * Created by renne on 14.05.2016.
 */
public class Category {
    private UUID id;
    private String name;

    public Category()
    {
    }

    public Category(String name)
    {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return  this.name;
    }

}
