package view.Musical_Catalog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Catalog {
    private ObservableList<Compilation> compilations = FXCollections.observableArrayList();
    private ObservableList<Artist> contents = FXCollections.observableArrayList();

    public Catalog() {
    }

    public Catalog(List<Compilation> mCompilation, List<Artist> mArtist) {
        contents = FXCollections.observableArrayList(mArtist);
        compilations = FXCollections.observableArrayList(mCompilation);
    }

    public ObservableList<Compilation> getCompilations() {
        return compilations;
    }

    public ObservableList<Artist> getContents() {
        return contents;
    }

    public void setmArtist(List<Artist> artist) {
        contents = FXCollections.observableArrayList(artist);
    }

    public void addCompilation(Compilation compilation) {
        compilations.add(compilation);
    }

    public void addArtist(Artist artist) {
        contents.add(artist);
    }

    public void addAlbum(Album album) {
        for (Artist a : contents) {
            if (a.equals(album.getArtist())) {
                a.addAlbum(album);
                return;
            }
        }
        Artist temp = new Artist(album.getArtist());
        temp.addAlbum(album);
        contents.add(temp);
    }

    public void addSong(Song song) {
        for (Artist a : contents) {
            if (a.equals(song.getArtist())) {
                for (Album al : a.getContents()) {
                    if (al.equals(song.getAlbum())) {
                        al.addSong(song);
                        return;
                    }
                }
                Album temp = new Album(song.getName(), song.getArtist(), song.getGenre());
                temp.addSong(song);
                a.addAlbum(temp);
            }
        }
        Album temp = new Album(song.getName(), song.getArtist(), song.getGenre());
        addAlbum(temp);
    }

    public ObservableList<Song> searchSong(String name) {
        ObservableList ans = FXCollections.observableArrayList();
        for (Artist a : getContents()) {
            for (Album al : a.getContents()) {
                for (Song s : al.getContents()) {
                    if (s.getName().equals(name)) {
                        ans.add(s);
                    }
                }
            }
        }
        return ans;
    }

    public Artist searchArtist(String name) {
        for (Artist a : getContents()) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public ObservableList<Album> searchAlbumByArtist(String name) {
        ObservableList<Album> ans = FXCollections.observableArrayList();
        for (Artist a : getContents()) {
            if (a.getName().equals(name)) {
                for (Album al : a.getContents()) {
                    ans.add(al);
                }
            }
        }
        return ans;
    }

    public ObservableList<Song> searchAlbumByName(String name) {
        ObservableList<Song> ans = FXCollections.observableArrayList();
        for (Artist a : getContents()) {
            for (Album al : a.getContents()) {
                if (al.getName().equals(name)) for (Song s : al.getContents()) {
                    ans.add(s);
                }
            }
        }
        return ans;
    }

    public ObservableList<Song> searchCompilation(String name) {
        ObservableList ans = FXCollections.observableArrayList();
        for (Compilation c : getCompilations()) {
            if (c.getName().equals(name)) {
                for (Song s : c.getSongList()){
                    ans.add(s);
                }
            }
        }
        return ans;
    }

    public ObservableList<Song> searchGenre(String name) {
        ObservableList ans = FXCollections.observableArrayList();
        for (Artist a : getContents()) {
            for (Album al : a.getContents()) {
                for (Song s : al.getContents()) {
                    if (s.getGenre().getName().equals(name)) {
                        ans.add(s);
                    }
                }
            }
        }
        return ans;
    }

    public void fillTestData() {
        Genre rap = new Genre("Rap");
        Genre jrap = new Genre("Jazz Rap", rap, rap.getName());
        Genre prap = new Genre("Pop Rap", rap, rap.getName());
        Artist blackseedoil = new Artist("Масло чёрного тмина");
        Album badjazz = new Album("Bad Jazz", "Масло чёрного тмина", jrap, jrap.getName());
        badjazz.addSong(new Song("Танцуй", "Масло чёрного тмина", "Bad Jazz", jrap, jrap.getName()));
        blackseedoil.addAlbum(badjazz);

        Artist drake = new Artist("Drake");
        Album scorpion = new Album("Scorpion", "Drake", prap, prap.getName());
        scorpion.addSong(new Song("Survival", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Nonstop", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Elevate", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Emotionless", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("I'm upset", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("8 out of 10", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Mob Ties", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Can't take a joke", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Sandra's rose", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Talk up", "Drake", "Scorpion", prap, prap.getName()));
        scorpion.addSong(new Song("Is there more", "Drake", "Scorpion", prap, prap.getName()));
        drake.addAlbum(scorpion);
        Compilation myNightPlaylist = new Compilation("My Night Playlist", badjazz.getContents());
        compilations.add(myNightPlaylist);
        contents.add(blackseedoil);
        contents.add(drake);
    }
}
