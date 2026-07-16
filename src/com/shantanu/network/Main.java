package com.shantanu.network;

import com.shantanu.network.http.HttpParser;
import com.shantanu.network.http.Request;
import com.shantanu.network.http.Router;

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
            HttpParser parser = new HttpParser();
            Request request = parser.parse(line);

            Router router = new Router();
            String body = router.route(request);

            OutputStream output = client.getOutputStream();

            String response =
                    "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html\r\n" +
                            "\r\n" +
                            body;
            output.write(response.getBytes());

            output.flush();

            client.close();
        }
    }
}