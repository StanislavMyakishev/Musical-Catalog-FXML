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

public class TrackSearchController {

    Catalog catalog = new Catalog();

    @FXML
    private Button trackSearchBackButton;

    @FXML
    private Button trackSearchSearchButton;

    @FXML
    private TableView<Song> trackSearchTableView;

    @FXML
    private TableColumn<Song, String> trackSearchArtistColumn;

    @FXML
    private TableColumn<Song, String> trackSearchGenreColumn;

    @FXML
    private TableColumn<Song, String> trackSearchNameColumn;

    @FXML
    private ListView<String> trackSearchListVIew;

    @FXML
    private AnchorPane trackSearchAnchorPane;

    @FXML
    private VBox trackSearchVBox;

    @FXML
    private TextField trackSearchTextField;

    @FXML
    void onClickSearchButton(MouseEvent event) {
        //Clearing stuff?
        trackSearchArtistColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        trackSearchNameColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("name"));
        trackSearchGenreColumn.setCellValueFactory(new PropertyValueFactory<Song, String>("genreName"));
        catalog.fillTestData();
        trackSearchTableView.setItems(catalog.searchSong(trackSearchTextField.getText().trim()));
    }

    @FXML
    void onClickBackButton(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/MainWindow.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        trackSearchAnchorPane.getChildren().setAll(pane);
    }
}