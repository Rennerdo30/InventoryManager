package dev.renner.inventory_manager.main.dialogs;

import dev.renner.inventory_manager.data.Category;
import dev.renner.inventory_manager.data.ItemData;
import dev.renner.inventory_manager.data.Item;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by renne on 14.05.2016.
 */
public class ItemDialog {


    public static Item showAndWait(dev.renner.inventory_manager.util.I18N i18n, ItemData itemData) {
        return ItemDialog.showAndWait(i18n, null, itemData);
    }

    public static Item showAndWait(dev.renner.inventory_manager.util.I18N i18n, Item oldItem, ItemData itemData) {

        Dialog<Item> itemDialog = new Dialog<>();
        itemDialog.setTitle(i18n.getItemDialogTitle());


        VBox vBox = new VBox();
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(10);

        Label idLabel = new Label(i18n.getItemDialogID());
        TextField idText = new TextField();
        idText.setEditable(false);

        Label nameLabel = new Label(i18n.getItemDialogName());
        TextField nameText = new TextField();

        Label categoryLabel = new Label(i18n.getItemDialogCategory());
        ComboBox<Category> categoryComboBox = new ComboBox<>();
        categoryComboBox.setMaxWidth(Double.MAX_VALUE);
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
        categoryComboBox.setItems(itemData.getCategories());
        if (itemData.categories.size() > 0)
            categoryComboBox.getSelectionModel().select(0);

        Label manufacturerLabel = new Label(i18n.getItemDialogManufacturer());
        TextField manufacturerText = new TextField();

        Label buyPriceLabel = new Label(i18n.getItemDialogManufacturer());
        TextField buyPriceText = new TextField();
        buyPriceText.setText("0.0");

        Label buyDateLabel = new Label(i18n.getItemDialogManufacturer());
        DatePicker buyDateDate = new DatePicker();
        buyDateDate.setValue(LocalDate.now());

        grid.add(idLabel, 0, 0);
        grid.add(idText, 1, 0);

        grid.add(nameLabel, 0, 1);
        grid.add(nameText, 1, 1);

        grid.add(categoryLabel, 0, 2);
        grid.add(categoryComboBox, 1, 2);

        grid.add(manufacturerLabel, 0, 3);
        grid.add(manufacturerText, 1, 3);

        grid.add(buyPriceLabel, 0, 4);
        grid.add(buyPriceText, 1, 4);

        grid.add(buyDateLabel, 0, 5);
        grid.add(buyDateDate, 1, 5);

        vBox.getChildren().add(grid);

        itemDialog.getDialogPane().setContent(vBox);
        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        itemDialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        itemDialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);

        itemDialog.setResultConverter((b) -> {
            if (b == buttonTypeOk) {
                Item item = new Item();
                item.setId(UUID.fromString(idText.getText()));
                item.setName(nameText.getText());
                item.setCategory(categoryComboBox.getSelectionModel().getSelectedItem());
                item.setManufacturer(manufacturerText.getText());
                item.setBuyPrice(Double.parseDouble(buyPriceText.getText().replace(",", ".")));

                LocalDate localDate = buyDateDate.getValue();
                Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                Date date = Date.from(instant);
                item.setBuyDate(date);
                return item;
            }
            return null;
        });

        idText.setText(UUID.randomUUID().toString());

        if (oldItem != null) {
            idText.setText(oldItem.getId().toString());
            nameText.setText(oldItem.getName());
            categoryComboBox.getSelectionModel().select(oldItem.getCategory());
            manufacturerText.setText(oldItem.getManufacturer());
            buyPriceText.setText(oldItem.getBuyPrice() + "");
            buyDateDate.setValue(oldItem.getBuyDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }

        Optional<Item> result = itemDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }


}
