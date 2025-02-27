package lesson2.io.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Открыт сокет на порту 9000, ждём подключения");
        Socket clientSocket = serverSocket.accept(); // открывает сокет и блокируется пока не будет подключения
        System.out.println("Подключен клиент");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            out.println("Получена строка: " + inputLine);
        }
    }
}
