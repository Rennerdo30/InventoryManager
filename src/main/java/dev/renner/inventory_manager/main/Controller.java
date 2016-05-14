package dev.renner.inventory_manager.main;

import dev.renner.inventory_manager.data.ItemData;
import dev.renner.inventory_manager.data.Item;
import dev.renner.inventory_manager.main.dialogs.ItemDialog;
import dev.renner.inventory_manager.main.dialogs.QRDialog;
import dev.renner.inventory_manager.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static ReadData readData = new ReadDataFake();
    public static WriteData writeData = new WriteDataFake();
    public static Stage stage;

    @FXML
    MenuItem closeBtn;
    @FXML
    MenuItem newItemBtn;
    @FXML
    MenuItem newCategoryBtn;
    @FXML
    MenuItem newLocationBtn;

    //Table
    @FXML
    TableView table;
    @FXML
    TableColumn<Item, String> tableColumnID;
    @FXML
    TableColumn<Item, String> tableColumnName;
    @FXML
    TableColumn<Item, String> tableColumnCategory;
    @FXML
    TableColumn<Item, String> tableColumnManufacturer;
    @FXML
    TableColumn<Item, String> tableColumnBuyPrice;
    @FXML
    TableColumn<Item, String> tableColumnBuyDate;

    private dev.renner.inventory_manager.util.I18N i18n;
    private ItemData itemData = readData.readData();

    @Override
    public void initialize(URL location, ResourceBundle bundle) {
        this.i18n = new dev.renner.inventory_manager.util.I18N(bundle);
        this.table.setItems(itemData.items);

        this.closeBtn.setText(this.i18n.getMainWindowMenuFileCloseBtn());
        this.newItemBtn.setText(this.i18n.getMainWindowMenuFileNewItemBtn());
        this.newCategoryBtn.setText(this.i18n.getMainWindowMenuFileNewCategoryBtn());
        this.newLocationBtn.setText(this.i18n.getMainWindowMenuFileNewLocationBtn());


        this.tableColumnID.setText(this.i18n.getMainWindowTableRowID());
        this.tableColumnName.setText(this.i18n.getMainWindowTableRowName());
        this.tableColumnCategory.setText(this.i18n.getMainWindowTableRowCategory());
        this.tableColumnManufacturer.setText(this.i18n.getMainWindowTableRowManufacturer());
        this.tableColumnBuyPrice.setText(this.i18n.getMainWindowTableRowBuyPrice());
        this.tableColumnBuyDate.setText(this.i18n.getMainWindowTableRowBuyDate());

        tableColumnID.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getId().toString());
        });
        tableColumnName.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getName());
        });
        tableColumnCategory.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getCategory().getName());
        });
        tableColumnManufacturer.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getManufacturer());
        });
        tableColumnBuyPrice.setCellValueFactory((param) -> {
            return new SimpleStringProperty("" + param.getValue().getBuyPrice());
        });
        tableColumnBuyDate.setCellValueFactory((param) -> {
            return new SimpleStringProperty(param.getValue().getBuyDate().toString());
        });


        final ContextMenu tableRowContextMenu = new ContextMenu();
        final MenuItem generateQrCodeBtn = new MenuItem("Generate QR-Code");
        generateQrCodeBtn.setOnAction((e) -> {
            QRDialog.showAndWait(this.i18n, (Item) this.table.getSelectionModel().getSelectedItem());
        });

        tableRowContextMenu.getItems().add(generateQrCodeBtn);

        table.setRowFactory(tv -> {
            TableRow<Item> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Item oldItem = row.getItem();
                    Item newItem = ItemDialog.showAndWait(this.i18n, oldItem, this.itemData);

                    if (!oldItem.equals(newItem) && newItem != null) {
                        this.removeItemFromTable(oldItem);
                        this.addItemToTable(newItem);
                    }

                }
            });
            row.setContextMenu(tableRowContextMenu);
            return row;
        });

    }

    @FXML
    public void newItemAction() {
        Item item = ItemDialog.showAndWait(this.i18n, this.itemData);
        if (item != null)
            this.itemData.items.add(item);
    }

    @FXML
    public void closeAction() {
        Controller.stage.close();
    }


    private void addItemToTable(Item item) {
        if (item != null) {
            this.itemData.items.add(item);
            this.table.getSelectionModel().select(item);
        }
    }

    private void removeItemFromTable(Item item) {
        if (item != null) {
            this.itemData.items.remove(item);
        }
    }

}
