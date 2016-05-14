package dev.renner.inventory_manager.main;

import dev.renner.inventory_manager.data.Item;
import dev.renner.inventory_manager.main.dialogs.ItemDialog;
import dev.renner.inventory_manager.util.ReadData;
import dev.renner.inventory_manager.util.ReadDataFake;
import dev.renner.inventory_manager.util.WriteData;
import dev.renner.inventory_manager.util.WriteDataFake;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

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

    private ObservableList<Item> tableData;
    private dev.renner.inventory_manager.util.I18N i18n;

    @Override
    public void initialize(URL location, ResourceBundle bundle) {
        this.i18n = new dev.renner.inventory_manager.util.I18N(bundle);
        this.tableData = FXCollections.observableArrayList();
        this.table.setItems(tableData);
        this.closeBtn.setText(bundle.getString(I18N.CLOSE_BUTTON.getKey()));
        this.newItemBtn.setText(bundle.getString(I18N.CREATE_ITEM_BUTTON.getKey()));
        this.newCategoryBtn.setText(bundle.getString(I18N.CREATE_CATEGORY_BUTTON.getKey()));
        this.newLocationBtn.setText(bundle.getString(I18N.CREATE_LOCATION_BUTTON.getKey()));

        tableColumnID.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new SimpleStringProperty(param.getValue().getId().toString());
            }
        });

        tableColumnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new SimpleStringProperty(param.getValue().getName());
            }
        });
        tableColumnManufacturer.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new SimpleStringProperty(param.getValue().getManufacturer());
            }
        });
        tableColumnBuyPrice.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new SimpleStringProperty("" + param.getValue().getBuyPrice());
            }
        });
        tableColumnBuyDate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> param) {
                return new SimpleStringProperty(param.getValue().getBuyDate().toString());
            }
        });

        table.setRowFactory( tv -> {
            TableRow<Item> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Item oldItem = row.getItem();
                    Item newItem = ItemDialog.showAndWait(this.i18n, oldItem);

                    if(!oldItem.equals(newItem))
                    {
                        this.removeItemFromTable(oldItem);
                        this.addItemToTable(newItem);
                    }

                }
            });
            return row ;
        });

    }

    @FXML
    public void newItemAction() {
        Item item = ItemDialog.showAndWait(this.i18n);
        if (item != null)
            this.tableData.add(item);
    }

    @FXML
    public void closeAction() {
        Controller.stage.close();
    }


    private void addItemToTable(Item item)
    {
        if(item != null)
            this.tableData.add(item);
    }

    private void removeItemFromTable(Item item)
    {
        if(item != null) {
            this.tableData.remove(item);
            this.table.getSelectionModel().select(item);
        }
    }

}
