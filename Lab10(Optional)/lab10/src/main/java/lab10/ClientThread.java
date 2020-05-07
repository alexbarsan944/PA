package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket = null;
    private Player p;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        int ok = 0;
        int inGame = 0;
        try {
            while (ok == 0) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                int[] simbol = {1, 2};
                String request = in.readLine();
                if (request.equals("stop")) {
                    GameServer.ruleaza = false;
                    out.println("Server stopped");
                    out.flush();
                    System.out.println("Stopping server...");
                    exit(1);
                } else if (request.equals("exit")) {
                    out.println("Closing connection with the server... you lost");
                    System.out.println("Client exited");
                    out.flush();
                    ok++;
                    socket.close();
                    break;
                } else if (request.equals("Create game")) {
                    if (GameServer.g != null) {
                        out.println("Game already exists... Try joining!");
                        out.flush();
                    } else {
                        inGame++;
                        GameServer.g = new Game();
                        p = new Player(simbol[0]);
                        GameServer.g.addPlayer(p);
                        p.setTurn(true);
                        out.println("Game created: you are player " + p.getSimbol());
                        out.flush();
                        String tabla = GameServer.g.board.printMatrix();
                        out.println(tabla);
                        out.flush();
                    }
                } else if (request.equals("Join game") && inGame == 0) {
                    if (GameServer.g == null) {
                        out.println("No game available... Try creating one!");
                        out.flush();
                    } else {
                        inGame++;
                        p = new Player(simbol[1]);
                        GameServer.g.addPlayer(p);
                        out.println("Welcome! You are player " + p.getSimbol());
                        out.flush();
                        String tabla = GameServer.g.board.printMatrix();
                        out.println(tabla);
                        out.flush();
                    }
                } else if (request.equals("Move") && inGame == 1) {
                    if (GameServer.g.board.checkForIdenticalFour(GameServer.g.board.matrix)) {
                        System.out.println("true");
                        out.println("You lost");
                        out.flush();
                        String tabla = GameServer.g.board.printMatrix();
                        out.println(tabla);
                        out.flush();
                        socket.close();
                    } else {
                        if (!p.isTurn()) {
                            out.println("Wait for your turn");
                            out.flush();
                        } else {
                            out.println("It's your turn");
                            out.flush();
                            String tabla = GameServer.g.board.printMatrix();
                            out.println(tabla);
                            out.flush();
                            int flag = 0;
                            while (flag == 0) {
                                out.println("Line:");
                                out.flush();
                                String linie = in.readLine();
                                int x = parseInt(linie);
                                out.println("Column:");
                                out.flush();
                                String coloana = in.readLine();
                                int y = parseInt(coloana);
                                if (x < 0 || x > 9 || y < 0 || y > 9) {
                                    out.println("Invalid line or column");
                                    out.flush();
                                } else if (GameServer.g.move(p, x, y) == 0) {
                                    out.println("You can't move there");
                                    out.flush();
                                } else {
                                    out.println("You moved");
                                    out.flush();
                                    flag++;
                                    for (Player pl : GameServer.g.players) {
                                        pl.setTurn(!pl.isTurn());
                                    }
                                }
                            }
                            tabla = GameServer.g.board.printMatrix();
                            out.println(tabla);
                            out.flush();
                            if (GameServer.g.board.checkForIdenticalFour(GameServer.g.board.matrix)) {
                                out.println("You won!");
                                out.flush();
                                ok++;
                                Game.upload(Game.SGF, "Result1");
                                socket.close();
                            } else {
                                out.println("Wait for yout turn");
                                out.flush();
                            }
                        }
                    }
                } else {
                    out.println("Invalid command");
                    out.flush();
                }
            }
        } catch (Exception e) {
            System.out.println(e + " " + e.getStackTrace()[0].getLineNumber());
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println(ex.getStackTrace()[0].getLineNumber());
            }
        }

    }
}
