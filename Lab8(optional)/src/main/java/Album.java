public class Album {
    private long id;
    private String name;
    long artist_id;
    long release_year;
    Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }



    public Album(long id, String name, long artist_id, long release_year) {
        this.id = id;
        this.name = name;
        this.artist_id = artist_id;
        this.release_year = release_year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }

    public long getRelease_year() {
        return release_year;
    }

    public void setRelease_year(long release_year) {
        this.release_year = release_year;
    }
}
