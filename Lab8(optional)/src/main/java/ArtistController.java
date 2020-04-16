
import java.sql.*;

public class ArtistController {


    private static Connection conn = Database.getConnection();

    public static void create(String name, String country) throws SQLException {
        try {
            String sql = "INSERT INTO artists (name, country) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public static void findByName(String name){
        try {
            name = name.toUpperCase();
            String sql = "SELECT * FROM artists WHERE UPPER(name) = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2) + " " + rs.getString(3));
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
    }


}
