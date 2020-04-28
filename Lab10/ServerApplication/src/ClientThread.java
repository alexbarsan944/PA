import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            /** READ */
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String request = in.readLine();
            if(request.equals("stop"))
            {
                String temp = "Server stopped";
                out.println(temp);
                out.flush();
                System.out.println("Stopping server...");
                System.exit(1);
            }
            else if(request.equals("exit"))
            {
                String temp = "Closing connection with the server";
                out.println(temp);
                out.flush();
                socket.close();
            }
            else
            {
                String temp = "Server received the request: ";
                out.println(temp  + "'" + request + "'") ;
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}