package app;

import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
        Artist artist;
        ArtistRepository rep = new ArtistRepository();
        AlbumRepository rep2 = new AlbumRepository();
        artist=rep.findById(1);
        System.out.println(artist.getName());
        List<Album> lista;
        lista= rep2.findByArtist(2);
        for(Album a : lista){
            System.out.println(a.getName());
        }
		
    }
}
