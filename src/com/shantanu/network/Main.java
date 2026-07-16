package com.shantanu.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server Started on Port 8080");

        while (true) {

            System.out.println("Waiting for Client...");

            Socket client = server.accept();

            System.out.println("Client Connected!");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(client.getInputStream())
                    );

            String line = reader.readLine();

            System.out.println("Received: " + line);

            OutputStream output = client.getOutputStream();

            String response =
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html\r\n" +
                            "\r\n" +
                            "<h1>Hello Shantanu!</h1>";

            output.write(response.getBytes());

            output.flush();

            client.close();
        }
    }
}