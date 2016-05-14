package dev.renner.inventory_manager.util;

import java.util.ResourceBundle;

/**
 * Created by renne on 14.05.2016.
 */
public class I18N {


    private ResourceBundle bundle;

    public I18N(ResourceBundle bundle) {
        this.bundle = bundle;
    }
    public String getItemDialogID() {
        return this.bundle.getString(I18NKeys.ITEM_DIALOG_ID.getKey());
    }
    public String getItemDialogName() {
        return this.bundle.getString(I18NKeys.ITEM_DIALOG_NAME.getKey());
    }
    public String getItemDialogCategory() {
        return this.bundle.getString(I18NKeys.ITEM_DIALOG_CATEGORY.getKey());
    }
    public String getItemDialogManufacturer() {
        return this.bundle.getString(I18NKeys.ITEM_DIALOG_MANUFACTURER.getKey());
    }
    public String getItemDialogTitle() {
        return this.bundle.getString(I18NKeys.ITEM_DIALOG_TITLE.getKey());
    }
    public String getMainWindowTableRowID() {
        return this.bundle.getString(I18NKeys.MAIN_TABLE_ROW_ID.getKey());
    }
    public String getMainWindowTableRowName() {
        return this.bundle.getString(I18NKeys.MAIN_TABLE_ROW_NAME.getKey());
    }
    public String getMainWindowTableRowCategory() {
        return this.bundle.getString(I18NKeys.MAIN_TABLE_ROW_CATEGORY.getKey());
    }
    public String getMainWindowTableRowManufacturer() {
        return this.bundle.getString(I18NKeys.MAIN_TABLE_ROW_MANUFACTURER.getKey());
    }
    public String getMainWindowTableRowBuyPrice() {
        return this.bundle.getString(I18NKeys.MAIN_TABLE_ROW_BUY_PRICE.getKey());
    }
    public String getMainWindowTableRowBuyDate() {
        return  this.bundle.getString(I18NKeys.MAIN_TABLE_ROW_BUY_DATE.getKey());
    }
    public String getMainWindowMenuFileCloseBtn() {
        return this.bundle.getString(I18NKeys.MENU_FILE_CLOSE_BUTTON.getKey());
    }
    public String getMainWindowMenuFileNewItemBtn() {
        return this.bundle.getString(I18NKeys.MENU_FILE_CREATE_ITEM_BUTTON.getKey());
    }
    public String getMainWindowMenuFileNewCategoryBtn() {
        return this.bundle.getString(I18NKeys.MENU_FILE_CREATE_CATEGORY_BUTTON.getKey());
    }
    public String getMainWindowMenuFileNewLocationBtn() {
        return this.bundle.getString(I18NKeys.MENU_FILE_CREATE_LOCATION_BUTTON.getKey());
    }



}
