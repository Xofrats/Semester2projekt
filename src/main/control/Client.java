package main.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Client {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Where to?");
            String input = keyboard.next();
            outToServer.writeObject(input);

            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            String o = (String)inFromServer.readObject();

            input = keyboard.next();
            outToServer.writeObject(input);

            System.out.println(o);

        } catch (Exception e) {

        }
    }
}