package com.shantanu.network.http;

public class HttpParser {

    public Request parse(String line) {

        String[] parts = line.split(" ");

        return new Request(
                parts[0],
                parts[1],
                parts[2]
        );
    }
}