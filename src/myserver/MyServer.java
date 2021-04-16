/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Commando
 */
public class MyServer {

    /**
     * @param args the command line arguments
     */
private static boolean flag;
    public static void main(String[] args) throws IOException {
        flag = true;
        int choice;
        String Result;
        Scanner scanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(3333);
        while (flag){
            try {
                Socket socket = serverSocket.accept();
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                if (socket.isConnected()){

                    System.out.println("Enter your choice");

                    choice = scanner.nextInt();
                    outputStream.writeInt(choice);
                    Result = inputStream.readUTF();
                    System.out.println(Result);

                }

            } catch (IOException e) {
            }
        }
    }
}

