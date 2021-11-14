package com.scottejames.scratch;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class MyServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = null;

        server = HttpServer.create(new InetSocketAddress(9000), 0);

        server.createContext("/search", new MyHandler());
        server.setExecutor(null);
        server.start();
    }
}
