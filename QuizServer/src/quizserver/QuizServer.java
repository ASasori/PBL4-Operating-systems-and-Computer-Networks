/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizserver;

/**
 *
 * @author Nguyen
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class QuizServer {
    private static final int PORT = 12345;  // Server port
    private ServerSocket serverSocket;

    public QuizServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Quiz Server is running on port " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Handle the client in a separate thread
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        QuizServer quizServer = new QuizServer();
        quizServer.start();
    }
}

