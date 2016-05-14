package dev.renner.inventory_manager.main.dialogs;

import dev.renner.inventory_manager.data.Category;
import dev.renner.inventory_manager.data.Item;
import dev.renner.inventory_manager.data.Location;
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
public class LocationDialog {


    public static Location showAndWait(dev.renner.inventory_manager.util.I18N i18n) {
        return LocationDialog.showAndWait(i18n, null);
    }

    public static Location showAndWait(dev.renner.inventory_manager.util.I18N i18n, Location oldLocation) {

        Dialog<Location> locationDialog = new Dialog<Location>();
        locationDialog.setTitle(i18n.getItemDialogTitle());


        VBox vBox = new VBox();
        GridPane grid = new GridPane();


        vBox.getChildren().add(grid);

        locationDialog.getDialogPane().setContent(vBox);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        locationDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        locationDialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);

        locationDialog.setResultConverter(new Callback<ButtonType, Location>() {
            @Override
            public Location call(ButtonType b) {
                if (b == buttonTypeOk) {
                    return new Location();
                }
                return null;

            }
        });

        if (oldLocation != null) {
        }

        Optional<Location> result = locationDialog.showAndWait();

        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }


}
