package view.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view.Musical_Catalog.Catalog;
import view.Musical_Catalog.Song;

import java.io.File;
import java.io.IOException;

public class CompilationSearchController {

    Catalog catalog = new Catalog();

    @FXML
    private Button compilationSearchSearchButton;

    @FXML
    private TextField compilationSearchTextField;

    @FXML
    private Button compilationSearchBackButton;

    @FXML
    private AnchorPane compilationSearchAnchorPane;

    @FXML
    private VBox compilationSearchVBox;

    @FXML
    private TableView<Song> compilationSearchTableView;

    @FXML
    private TableColumn<Song, String> compilationSearchArtistColumn;

    @FXML
    private TableColumn<Song, String> compilationSearchAlbumColumn;

    @FXML
    private TableColumn<Song, String> compilationSearchNameColumn;

    @FXML
    void onClickSearchButton(MouseEvent event) {
        //Clearing stuff?
        compilationSearchArtistColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        compilationSearchNameColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("name"));
        compilationSearchAlbumColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("album"));
        catalog.fillTestData();
        compilationSearchTableView.setItems(catalog.searchCompilation(compilationSearchTextField.getText().trim()));
    }

    @FXML
    void onClickBackButton(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/MainWindow.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        compilationSearchAnchorPane.getChildren().setAll(pane);
    }
}