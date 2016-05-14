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
        this.id = UUID.randomUUID();
        this.name = "";
    }

    public Category(String name)
    {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId()
    {
        return this.id;
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

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Category))
            return false;

        Category tmpCat = (Category) obj;

        return this.getName().equals(tmpCat) && this.getId().equals(tmpCat.getId());

    }
}
