
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AlbumController {

    private static Connection conn = Database.getConnection();

    public static void create(String name, int artistId, int releaseYear) throws SQLException {
        try {
            String sql = "INSERT INTO albums (name, artist_id, release_year) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, artistId);
            pstmt.setInt(3, releaseYear);
            pstmt.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void findByArtist(int artistId) {
        try {
            String sql = "SELECT * FROM albums WHERE artist_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, artistId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2)  + " " + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
