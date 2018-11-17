package view.Musical_Catalog;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private String name;
    private String parentName;
    private Genre parent;
    private List<Genre> child;

    public Genre(String name){
        this.name = name;
    }

    public Genre(String name, Genre parent){
        this.name = name;
        this.parent= parent;
        this.child = new ArrayList<>();
    }

    public Genre(String name, Genre parent, String parentName){
        this.name = name;
        this.parentName = parentName;
        this.parent = parent;
        this.child = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubGenre(Genre subGenre){
        child.add(subGenre);
    }
}
