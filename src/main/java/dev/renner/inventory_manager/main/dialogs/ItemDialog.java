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
public class ItemDialog {


    public static Item showAndWait(dev.renner.inventory_manager.util.I18N i18n) {
        return ItemDialog.showAndWait(i18n, null);
    }

    public static Item showAndWait(dev.renner.inventory_manager.util.I18N i18n, Item oldItem) {

        ArrayList<Category> categories = Controller.readData.getCategories();

        Dialog<Item> itemDialog = new Dialog<>();
        itemDialog.setTitle(i18n.getItemDialogTitle());



        VBox vBox = new VBox();
        GridPane grid = new GridPane();
        Label nameLabel = new Label(i18n.getItemDialogName());
        TextField nameText = new TextField();

        Label categoryLabel = new Label(i18n.getItemDialogCategory());
        Button newCategoryButton = new Button();
        ComboBox<Category> categoryComboBox = new ComboBox<>();
        categoryComboBox.setCellFactory(new Callback<ListView<Category>, ListCell<Category>>() {
            @Override
            public ListCell<Category> call(ListView<Category> param) {
                return new ListCell<Category>() {
                    @Override
                    protected void updateItem(Category item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.getName());
                        }
                    }
                };
            }
        });
        ObservableList<Category> categoryComboBoxData = FXCollections.observableArrayList(categories);
        categoryComboBox.setItems(categoryComboBoxData);
        if (categoryComboBoxData.size() > 0)
            categoryComboBox.getSelectionModel().select(0);

        Label manufacturerLabel = new Label(i18n.getItemDialogManufacturer());
        TextField manufacturerText = new TextField();

        grid.add(nameLabel, 0, 0);
        grid.add(nameText, 1, 0);

        grid.add(categoryLabel, 0, 1);
        grid.add(categoryComboBox, 1, 1);
        grid.add(newCategoryButton, 2, 1);

        grid.add(manufacturerLabel, 0, 2);
        grid.add(manufacturerText, 1, 2);

        vBox.getChildren().add(grid);

        itemDialog.getDialogPane().setContent(vBox);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        itemDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        itemDialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);

        itemDialog.setResultConverter(new Callback<ButtonType, Item>() {
            @Override
            public Item call(ButtonType b) {
                if (b == buttonTypeOk) {
                    Item item = new Item();
                    item.setId(oldItem == null ? UUID.randomUUID() : oldItem.getId());
                    item.setName(nameText.getText());
                    item.setCategory(categoryComboBox.getSelectionModel().getSelectedItem());
                    item.setManufacturer(manufacturerText.getText());
                    return item;
                }
                return null;

            }
        });

        if(oldItem != null)
        {
            nameText.setText(oldItem.getName());
            categoryComboBox.getSelectionModel().select(oldItem.getCategory());
            manufacturerText.setText(oldItem.getManufacturer());
        }

        Optional<Item> result = itemDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }


}
