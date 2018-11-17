package view.Musical_Catalog;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private String genreName;
    private Genre genre;
    private List<Song> contents;

    public Album(String name, String artist, Genre genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        contents = new ArrayList<>();
    }

    public Album(String name, String artist, Genre genre, String genreName){
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.genreName = genreName;
        contents = new ArrayList<>();
    }

    public void addSong(Song song){
        contents.add(song);
    }

    public String getName() {
        return name;
    }

    public String getGenreName() { return genreName; }

    public void setGenreName(String genreName) { this.genreName = genreName; }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public List<Song> getContents() {
        return contents;
    }

    public void printAlbum(){
        System.out.println(name + ':');
        for (int i = 0; i < contents.size(); i++){
            System.out.println(contents.get(i).toString());
        }
    }
}
