package dev.renner.inventory_manager.main.dialogs;

import dev.renner.inventory_manager.data.Category;
import dev.renner.inventory_manager.data.Item;
import dev.renner.inventory_manager.main.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by renne on 14.05.2016.
 */
public class CategoryDialog {


    public static Category showAndWait(dev.renner.inventory_manager.util.I18N i18n) {
        return CategoryDialog.showAndWait(i18n, null);
    }

    public static Category showAndWait(dev.renner.inventory_manager.util.I18N i18n, Item oldCategory) {

        Dialog<Category> categoryDialog = new Dialog<>();
        categoryDialog.setTitle(i18n.getItemDialogTitle());



        VBox vBox = new VBox();
        GridPane grid = new GridPane();

        vBox.getChildren().add(grid);

        categoryDialog.getDialogPane().setContent(vBox);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        categoryDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        categoryDialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);

        categoryDialog.setResultConverter(new Callback<ButtonType, Category>() {
            @Override
            public Category call(ButtonType b) {
                if (b == buttonTypeOk) {
                    return new Category();
                }
                return null;

            }
        });

        if(oldCategory != null)
        {
        }

        Optional<Category> result = categoryDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }


}
