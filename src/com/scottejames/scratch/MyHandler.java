package com.scottejames.scratch;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
        if(t.getRequestMethod().equalsIgnoreCase("GET")){
            Headers responseHeaders = t.getResponseHeaders();
            String request = t.getRequestURI().toString();

            String payload = request.split("\\?")[1];

            String cmd = payload.split("=")[0];
            String arg = payload.split("=")[1];
            System.out.println("Request: " + request);
            System.out.println("cmd: " + cmd + " arg: " + arg);

            String redirect = Resolver.getInstance().resolve(cmd, arg);

            responseHeaders.set("Location", redirect);
            t.sendResponseHeaders(302,0);
                System.out.println("Redirect to URL :  + google.com");
            }

    }
}
