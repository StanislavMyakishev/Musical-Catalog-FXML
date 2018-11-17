package view.Musical_Catalog;

public class Song {

    private String name;
    private String artist;
    private String album;
    private Genre genre;
    private String genreName;

    public Song(String name, String artist, String album, Genre genre) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public Song(String name, String artist, String album, Genre genre, String genreName) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genreName = genreName;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public Genre getGenre(){ return genre; }

    public String getGenreName() { return genreName; }

    public void setGenreName(String genreName) { this.genreName = genreName; }

    @Override
    public String toString() {
        return name;
    }
}
