import java.util.ArrayList;
import java.util.List;

public class Artist {
    private long id;
    private String name;
    private String country;
    List<Album> albume = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public List<Album> getAlbume() {
        return albume;
    }

    public void setAlbume(List<Album> albume) {
        this.albume = albume;
    }

    public Artist(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
