package dev.renner.inventory_manager.util;

import java.util.ResourceBundle;

/**
 * Created by renne on 14.05.2016.
 */
public class I18N {


    private ResourceBundle bundle;

    public I18N(ResourceBundle bundle)
    {
        this.bundle = bundle;
    }


    public String getItemDialogName()
    {
        return this.bundle.getString(dev.renner.inventory_manager.main.I18N.ITEM_DIALOG_NAME.getKey());
    }

    public String getItemDialogCategory()
    {
        return this.bundle.getString(dev.renner.inventory_manager.main.I18N.ITEM_DIALOG_CATEGORY.getKey());
    }

    public String getItemDialogManufacturer()
    {
        return this.bundle.getString(dev.renner.inventory_manager.main.I18N.ITEM_DIALOG_MANUFACTURER.getKey());
    }

    public String getItemDialogTitle()
    {
        return this.bundle.getString(dev.renner.inventory_manager.main.I18N.ITEM_DIALOG_TITLE.getKey());
    }


}
