package view.Controllers;

import javafx.scene.Parent;
import view.Musical_Catalog.Catalog;
import view.Musical_Catalog.Song;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;

public class AlbumSearchController {

    private Catalog catalog = new Catalog();

    @FXML
    private Button albumSearchBackButton;

    @FXML
    private Button albumSearchSearchButton;

    @FXML
    private TableColumn<Song, String> albumSearchTrackColumn;

    @FXML
    private TableView<Song> albumSearchTableView;

    @FXML
    private TableColumn<Song, String> albumSearchArtistColumn;

    @FXML
    private TableColumn<Song, String> albumSearchGenreColumn;

    @FXML
    private AnchorPane albumSearchAnchorPane;

    @FXML
    private VBox albumSearchVBox;

    @FXML
    private TextField albumSearchTextField;

    @FXML
    void onClickSearchButton(MouseEvent event) {
        //Clearing stuff?
        albumSearchArtistColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        albumSearchTrackColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("name"));
        albumSearchGenreColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genreName"));
        catalog.fillTestData();
        albumSearchTableView.setItems(catalog.searchAlbumByName(albumSearchTextField.getText().trim()));
    }

    @FXML
    void onClickBackButton(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/MainWindow.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        albumSearchAnchorPane.getChildren().setAll(pane);
    }
}