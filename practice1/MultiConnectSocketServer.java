package lesson2.practice1;

import lesson2.practice1.command.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import lesson2.practice1.CliApplication;
import lesson2.practice1.repository.talker.TalkerRepository;

public class MultiConnectSocketServer {

    ServerSocket serverSocket;
    TalkerRepository talkerRepository;


    public static void main(String[] args) throws IOException {
        new MultiConnectSocketServer().start();
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(9000);
        System.out.println("Server is listening connections on port " + 9000);

        while (true) {
            Socket accept = serverSocket.accept();
            new ConnectionHandler(accept).start();
        }
    }

    private

    static class ConnectionHandler extends Thread {

        private final Socket clientSocket;
        BufferedReader in;
        PrintWriter out;


        public ConnectionHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                System.out.println("-- Client connected");
                CliApplication cliApplication = new CliApplication();
                cliApplication.start();
                // Каналы взаимодействия
                // от клиента
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // к клиенту
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                out.println("Hello! What's your login?");
                int g = 0;



                while ((inputLine = in.readLine()) != null) {
                    if (g==0){
                        g=1;
                        //TODO тут добавлять пользователя

                    }
                    //TODO тут делать проверку на команду
//                    List<Command> commands = cliApplication.commands;


                    for (Command command : cliApplication.commands) {
                        if (command.isApplicable(inputLine)) {
                            command.execute(inputLine);
                        }
                    }

                    System.out.println("<< received message from client: " + inputLine);
                    String response = "echo: " + inputLine;
                    System.out.println(">> sending response " + response);
                    out.println(response);
                }
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}