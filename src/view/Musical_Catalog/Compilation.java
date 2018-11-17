package view.Musical_Catalog;

import java.util.List;

public class Compilation {
    private String name;
    private List<Song> songList;

    public Compilation(String name, List<Song> song){
        this.name = name;
        this.songList= song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongList() { return songList; }

    public void addSong(Song song) {
        songList.add(song);
    }

    public void printComp(){
        System.out.println(this.name);
        for (int i = 0; i < songList.size(); i++){
            System.out.println(songList.get(i).toString());
        }
    }

    public boolean equals(String name) {
        return this.name == name;
    }
}
