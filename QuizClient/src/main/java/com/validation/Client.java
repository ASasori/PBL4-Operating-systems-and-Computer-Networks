/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.validation;

/**
 *
 * @author Nguyen
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.Socket;

public class Client {

    public static final String SERVER_HOST = "localhost";
    public static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_HOST, PORT);
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            while (true) {
                int length = dis.readInt();
                byte[] imgBytes = new byte[length];
                dis.readFully(imgBytes, 0, length);

                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imgBytes));

                SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Screen Share Client");
                    frame.getContentPane().setLayout(new BorderLayout());
                    frame.getContentPane().add(new JLabel(new ImageIcon(image)));
                    frame.pack();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
