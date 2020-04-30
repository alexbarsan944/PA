package app;

import com.github.javafaker.Artist;
import com.github.javafaker.Faker;
import entity.Albums;
import entity.Artists;
import java.util.List;
import java.util.Random;

import entity.ChartsEntity;
import repo.AlbumRepository;
import repo.ArtistRepository;
import repo.ChartsRepository;


public class AlbumManager {
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        AlbumRepository albRep = new AlbumRepository();
        ArtistRepository artRep = new ArtistRepository();
        ChartsRepository chartRepo = new ChartsRepository();

        Faker faker = new Faker();

        for(int i = 0; i<100 ; i++) /** Generez albume, artisti si chart-uri cu faker */
        {
            Albums a = new Albums();
            Artists artist = new Artists();

            artist.setCountry(faker.country().name());
            artist.setName(faker.name().name());

            a.setArtistId(i);
            a.setName(faker.name().name());
            int year = (getRandomNumberInRange(1900, 2020));
            a.setReleaseYear(year);
            a.setGenre(faker.music().genre());

            artRep.create(artist);
            albRep.create(a);

            ChartsEntity chart = new ChartsEntity();
            chart.setAlbumId(i);
            chart.setRank(getRandomNumberInRange(0,10));
            chartRepo.create(chart);
        }



    }
    
}
