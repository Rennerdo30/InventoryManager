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
import java.util.function.BooleanSupplier;

/**
 * Created by renne on 14.05.2016.
 */
public class QRDialog {



    public static Boolean showAndWait(dev.renner.inventory_manager.util.I18N i18n) {

        Dialog<Boolean> itemDialog = new Dialog<>();
        itemDialog.setTitle(i18n.getItemDialogTitle());



        VBox vBox = new VBox();
        GridPane grid = new GridPane();


        vBox.getChildren().add(grid);

        itemDialog.getDialogPane().setContent(vBox);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        itemDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        itemDialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);


        Optional<Boolean> result = itemDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }


}
