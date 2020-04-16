import com.github.javafaker.Faker;

import java.sql.*;
import java.util.Random;

public class Main {
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        Faker faker = new Faker();


        try{
            Database baza = Database.getInstance();
            conn = baza.getConnection();
            System.out.println("Connected");

            st = conn.createStatement();

            String sql = "CREATE DATABASE  MusicAlbums";

            /**
             Se creeaza  baza de date MusicAlbums
             st.executeUpdate(sql);
             */

            String create_user = "grant all privileges on mydb.* to 'dba'@'localhost' identified by 'sql';";
            st.executeUpdate(create_user); /**  Cream userul dba cu parola sql **/


            System.out.println("User created successfully");


            String artists = "create table artists(" +
                    "    id integer not null auto_increment," +
                    "    name varchar(100) not null," +
                    "    country varchar(100)," +
                    "    primary key (id)" +
                    ");";

            String albums = "create table albums(" +
                    "id integer not null auto_increment," +
                    "name varchar(100) not null," +
                    "artist_id integer not null references artists on delete restrict," +
                    "release_year integer," +
                    "primary key (id)" +
                    ");";

            st.executeUpdate("DROP TABLE artists;");
            st.executeUpdate(artists);
            System.out.println("Artists table created successfully");
            st.executeUpdate("DROP TABLE albums;");
            st.executeUpdate(albums);
            System.out.println("Albums table created successfully");



            String addRankAlbums = "ALTER TABLE albums\n" +
                    "ADD rank INT;";
            String addRankArtists = "ALTER TABLE artists\n" +
                    "ADD rank INT;";
            st.executeUpdate(addRankAlbums);
            st.executeUpdate(addRankArtists);

            String chart = "create table chart(" +
                    "id integer not null auto_increment," +
                    "titlu_chart varchar(100) not null," +
                    "primary key (id)" +
                    ");";
            String register_chart = "create table register_chart(" +
                    "id integer not null auto_increment," +
                    "id_album integer not null," +
                    "id_chart integer not null," +
                    "rank integer not null," +
                    "primary key (id)" +
                    ");";
            st.executeUpdate("DROP TABLE chart;");
            st.executeUpdate(chart);
            System.out.println("Table chart created");

            st.executeUpdate("DROP TABLE register_chart;");
            st.executeUpdate(register_chart);
            System.out.println("Table register_chart created");

            //populare tabele cu faker
            for(int i = 0; i<100; i++)
            {
                String nume_artist =  faker.name().firstName();
                String nume_tara = String.valueOf(faker.country().name());

                ArtistController.create(nume_artist, nume_tara);

                String album_title = faker.music().genre() + " " + faker.animal().name();
                int year = (getRandomNumberInRange(1900, 2020));
                AlbumController.create(album_title, i, year);

                String titlu_chart = "Top 100 " + faker.country().name();
                try {
                    String Sql = "INSERT INTO chart (titlu_chart) VALUES (?)";
                    PreparedStatement pstmt = conn.prepareStatement(Sql);
                    pstmt.setString(1, titlu_chart);
                    pstmt.execute();
                }catch(SQLException e){
                    e.printStackTrace();
                }

                int rank = getRandomNumberInRange(0,10);
                try {
                    String Sql = "INSERT INTO register_chart (id_album, id_chart, rank) VALUES (?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(Sql);
                    pstmt.setInt(1,i);
                    pstmt.setInt(2,i);
                    pstmt.setInt(3, rank);
                    pstmt.execute();
                }catch(SQLException e){
                    e.printStackTrace();
                }

            }
            // afisarea albumelor, dupa rank, desc
            System.out.println("\n");
            String afisare = "select art.name, alb.name, reg.rank from albums alb" +
                    "    join artists art on art.id = alb.id" +
                    "    join register_chart reg on alb.id = reg.id order by rank desc;";
            ResultSet rs = st.executeQuery(afisare);
            while (rs.next()) {
                String Name = rs.getString("alb.name");
                String rank = rs.getString("rank");
                System.out.println(Name + " " + rank);
            }




        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}