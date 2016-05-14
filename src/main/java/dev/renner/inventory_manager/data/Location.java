package dev.renner.inventory_manager.data;

import java.util.UUID;

/**
 * Created by renne on 14.05.2016.
 */
public class Location {
    private UUID id;
    private String name;

    public Location() {
        this.id = UUID.randomUUID();
        this.name = "";
    }

    public Location(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


}
