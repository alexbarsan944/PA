package lab10;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> players;
    public Matrice board;
    public static String SGF;

    public Game() {
        players= new ArrayList<>();
        board=new Matrice();
    }
    
    public void addPlayer(Player p){
        this.players.add(p);
    }

    public static void upload(String SGF, String name) {
        try {
            File myObj = new File(name + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(name +".txt");
            myWriter.write(SGF);
            myWriter.close();


            JSch jsch = new JSch();
            Session session = jsch.getSession("alexandru.barsan", "fenrir.info.uaic.ro");
            session.setPassword("parola");

            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");

            sftpChannel.connect();
            sftpChannel.put(name + ".txt", "/fenrir/studs/alexandru.barsan/html");
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int move(Player p, int x, int y){
        if(this.board.matrix[x][y]==0){
            this.board.matrix[x][y]=p.getSimbol();
            SGF = SGF + p.toString() + " " + x + " " + y + "}" + "\n";
            return 1;
        }
        return 0;
    }
}
