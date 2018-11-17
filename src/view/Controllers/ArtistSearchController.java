package view.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import view.Musical_Catalog.Album;
import view.Musical_Catalog.Catalog;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArtistSearchController implements Initializable {

    private Catalog catalog = new Catalog();

    @FXML
    private TableView<Album> artistSearchTableView;

    @FXML
    private TableColumn<Album, String> artistSearchAlbumColumn;

    @FXML
    private TableColumn<Album, String> artistSearchGenreColumn;

    @FXML
    private Button artistSearchSearchButton;

    @FXML
    private TextField artistSearchTextField;

    @FXML
    private Button artistSearchBackButton;

    @FXML
    private AnchorPane artistSearchAnchorPane;

    @FXML
    private VBox artistSearchVBox;

    public ArtistSearchController() {
    }

    @FXML
    void onClickSearchButton(MouseEvent event) {
        //Clearing stuff?
        artistSearchAlbumColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("name"));
        artistSearchGenreColumn.setCellValueFactory(new PropertyValueFactory<Album, String>("genreName"));
        catalog.fillTestData();
        artistSearchTableView.setItems(catalog.searchAlbumByArtist(artistSearchTextField.getText().trim()));
    }

    @FXML
    void onClickBackButton(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/MainWindow.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        artistSearchAnchorPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}