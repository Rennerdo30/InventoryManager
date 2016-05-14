package dev.renner.inventory_manager.util;

/**
 * Created by renne on 14.05.2016.
 */
public enum I18NKeys {

    //Main Window
    MENU_FILE_BUTTON("menu.file.button"),
    MENU_FILE_CLOSE_BUTTON("menu.file.close.button"),
    MENU_FILE_CREATE_ITEM_BUTTON("menu.file.new_item.button"),
    MENU_FILE_CREATE_LOCATION_BUTTON("menu.file.new_location.button"),
    MENU_FILE_CREATE_CATEGORY_BUTTON("menu.file.new_category.button"),

    MENU_EDIT_BUTTON("menu.edit.button"),
    MENU_EDIT_DELETE_BUTTON("menu.edit.delete.button"),

    MENU_SETTINGS_BUTTON("menu.settings.button"),
    MENU_SETTINGS_MYSQL_BUTTON("menu.settings.mysql.button"),

    MENU_HELP_BUTTON("menu.help.button"),
    MENU_HELP_ABOUT_BUTTON("menu.help.about.button"),


    MAIN_TABLE_ROW_ID("table.row.item.id.label"),
    MAIN_TABLE_ROW_NAME("table.ow.item.name.label"),
    MAIN_TABLE_ROW_CATEGORY("table.row.item.category.label"),
    MAIN_TABLE_ROW_MANUFACTURER("table.row.item.manufacturer.label"),
    MAIN_TABLE_ROW_BUY_PRICE("table.row.item.buy_price.label"),
    MAIN_TABLE_ROW_BUY_DATE("table.row.item.buy_date.label"),

    //Item Dialog
    ITEM_DIALOG_TITLE("item.dialog.title.label"),
    ITEM_DIALOG_ID("item.dialog.id.label"),
    ITEM_DIALOG_NAME("item.dialog.name.label"),
    ITEM_DIALOG_CATEGORY("item.dialog.category.label"),
    ITEM_DIALOG_MANUFACTURER("item.dialog.manufacturer.label");


    private String key;

    I18NKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}
