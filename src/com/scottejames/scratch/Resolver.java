package com.scottejames.scratch;

public class Resolver {

    private static Resolver _instance;
    private void Resolver(){

    }
    public synchronized static Resolver getInstance(){

        if (_instance == null){
            _instance = new Resolver();
        }
        return _instance;
    }


    public String resolve(String cmd, String arg) {

        String [] splitArgs = arg.split("%20");

        String command = splitArgs[0];
        if (command.equals("tw")){
            return "http://www.twitter.com";
        } else if (command.equals("fb")){
            return "http://www.facebook.com";
        }
        return "http://www.google.com/search?q="+command;
    }


}
