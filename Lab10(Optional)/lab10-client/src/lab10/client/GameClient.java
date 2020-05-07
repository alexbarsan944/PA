package lab10.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {
        int symbol;
        String serverAddress = "127.0.0.1"; //adresa IP a serverului
        int PORT = 2222;
        int ok = 0;
        int inGame = 0;

        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (ok == 0) {
                // Send a request to the server
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter command... ");
                String request = scan.nextLine();
                out.println(request);
                if (request.equals("Create game") && inGame == 0) {
                    String response = in.readLine();
                    if (response.equals("Game already exists... Try joining!")) {
                        System.out.println(response);
                    } else {
                        inGame++;
                        System.out.println(response);
                        for (int i = 0; i < 11; i++) {
                            String row = in.readLine();
                            System.out.println(row);
                        }
                    }
                } else if (request.equals("Join game") && inGame == 0) {
                    String response = in.readLine();
                    if (response.equals("No game available... Try creating one!")) {
                        System.out.println(response);
                    } else {
                        inGame++;
                        System.out.println(response);
                        for (int i = 0; i < 11; i++) {
                            String row = in.readLine();
                            System.out.println(row);
                        }
                    }
                } else if (request.equals("Move") && inGame == 1) {
                    String r1 = in.readLine();
                    if (r1.equals("You lost")) {
                        System.out.println(r1);
                        for (int i = 0; i < 11; i++) {
                            String row = in.readLine();
                            System.out.println(row);
                        }
                        ok++;
                    } else {
                        if (r1.equals("Wait for your turn")) {
                            System.out.println(r1);
                        } else {
                            for (int i = 0; i < 11; i++) {
                                String row = in.readLine();
                                System.out.println(row);
                            }
                            int flag = 0;
                            while (flag == 0) {
                                Scanner s = new Scanner(System.in);
                                String x = in.readLine();
                                System.out.println(x);
                                String xx = s.nextLine();
                                out.println(xx);
                                out.flush();
                                String y = in.readLine();
                                System.out.println(y);
                                String yy = s.nextLine();
                                out.println(yy);
                                out.flush();
                                x = in.readLine();
                                if (x.equals("You moved")) {
                                    flag++;
                                    System.out.println(x);
                                } else {
                                    System.out.println(x);
                                }
                            }
                            for (int i = 0; i < 11; i++) {
                                String row = in.readLine();
                                System.out.println(row);
                            }
                            String status = in.readLine();
                            if (status.equals("You won!")) {
                                System.out.println(status);
                                ok++;
                            } else {
                                System.out.println(status);
                            }
                        }
                    }
                } else if (request.equals("exit")) {
                    String response = in.readLine();
                    System.out.println(response);
                    ok++;
                } else {
                    System.out.println("aici");
                    String response = in.readLine();
                    System.out.println(response);
                }
            }
        } catch (Exception e) {
            System.err.println("No server listening... " + e + " " + e.getStackTrace()[0].getLineNumber());
        }

    }

}
