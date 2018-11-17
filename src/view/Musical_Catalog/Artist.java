package view.Musical_Catalog;


import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private List<Album> contents;

    public Artist(String name) {
        this.name = name;
        contents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getContents() {
        return contents;
    }

    public void addAlbum(Album album) {
        contents.add(album);
    }

    public void printArtist(){
        System.out.println(name + ':');
        for (int i = 0; i < contents.size(); i++){
            contents.get(i).printAlbum();
        }
    }

    public boolean equals(Artist a) {
        return name.equals(a.getName());
    }
}