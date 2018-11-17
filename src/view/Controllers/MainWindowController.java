package view.Controllers;

import view.Musical_Catalog.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{

    private Main main;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Button mainGenreButton;

    @FXML
    private Button mainAlbumButton;

    @FXML
    private VBox mainAnchorPaneVBox;

    @FXML
    private Button mainArtistButton;

    @FXML
    private Label mainLabel;

    @FXML
    private Button mainTrackButton;

    @FXML
    private Button mainCompilationButton;

    @FXML
    void onClickArtist(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/ArtistSearch.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        mainAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onClickAlbum(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/AlbumSearch.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        mainAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onClickTrack(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/TrackSearch.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        mainAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onClickGenre(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/GenreSearch.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        mainAnchorPane.getChildren().setAll(pane);
    }

    @FXML
    void onClickCompilation(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(new File("/Users/stanislav/IdeaProjects/Lab2.3/src/view/FXML/CompilationSearch.fxml").toURI().toURL());
        AnchorPane pane = loader.load();
        mainAnchorPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
