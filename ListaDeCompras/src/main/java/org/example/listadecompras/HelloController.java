package org.example.listadecompras;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {

    private final ObservableList<String> itens = FXCollections.observableArrayList();

    @FXML
    private TableColumn<String, String> tableListaItens;

    @FXML
    private TableView<String> tabelaItens;

    @FXML
    private TextField itemInput;

    @FXML
    protected void initialize() {

        // Indica como extrair o texto da String para a coluna
        tableListaItens.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue()));

        // Liga a lista à tabela
        tabelaItens.setItems(itens);
    }

    @FXML
    protected void adicionarCompra() {
        String novoItem = itemInput.getText();

        if (novoItem.isEmpty()) return;

        itens.add(novoItem);
        itemInput.clear();
    }
}
