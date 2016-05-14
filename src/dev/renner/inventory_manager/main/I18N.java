package dev.renner.inventory_manager.main;

/**
 * Created by renne on 14.05.2016.
 */
public enum I18N {

    CLOSE_BUTTON("close.button"),
    CREATE_ITEM_BUTTON("new.item.button"),
    CREATE_LOCATION_BUTTON("new.location.button"),
    CREATE_CATEGORY_BUTTON("new.category.button"),
    ITEM_DIALOG_TITLE("item.dialog.title"),
    ITEM_DIALOG_NAME("item.dialog.name"),
    ITEM_DIALOG_CATEGORY("item.dialog.category"),
    ITEM_DIALOG_MANUFACTURER("item.dialog.manufacturer");


    private String key;

    I18N(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    }
