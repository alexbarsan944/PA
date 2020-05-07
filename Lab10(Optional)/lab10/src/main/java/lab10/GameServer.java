/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author School
 */
public class GameServer {

    public static final int PORT = 2222;
    public static boolean ruleaza;
    public static Game g;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        ruleaza = true;
        try {
            serverSocket = new ServerSocket(PORT);
            while (ruleaza) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            serverSocket.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
    
}
