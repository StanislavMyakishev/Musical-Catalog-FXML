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

public class GenreSearchController {

    Catalog catalog = new Catalog();

    @FXML
    private Button genreSearchSearchButton;

    @FXML
    private ListView<String> genreSearchListView;

    @FXML
    private TextField genreSearchTextField;

    @FXML
    private Button genreSearchBackButton;

    @FXML
    private AnchorPane genreSearchAnchorPane;

    @FXML
    private VBox genreSearchVBox;

    @FXML
    private TableColumn<Song, String> genreSearchAlbumColumn;

    @FXML
    private TableColumn<Song, String> genreSearchNameColumn;

    @FXML
    private TableView<Song> genreSearchTableView;

    @FXML
    private TableColumn<Song, String> genreSearchArtistColumn;

    @FXML
    void onClickSearchButton(MouseEvent event) {
        //Clearing stuff?
        genreSearchArtistColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        genreSearchNameColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("name"));
        genreSearchAlbumColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("album"));
        catalog.fillTestData();
        genreSearchTableView.setItems(catalog.searchGenre(genreSearchTextField.getText().trim()));
    }

    @FXML
    void onClickBackButton(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/MainWindow.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        genreSearchAnchorPane.getChildren().setAll(pane);
    }

}