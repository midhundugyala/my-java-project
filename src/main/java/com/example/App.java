package com.example;

import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    
    // Sonar will flag this as hardcoded password
    private String password = "admin123"; 

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.add(5, 10));
        app.riskyMethod(null);
    }

    public int add(int a, int b) {
        return a + b;
    }

    // Sonar will flag null pointer, unused variable, empty catch
    public void riskyMethod(String input) {
        String unused = "test"; // unused
        try {
            System.out.println(input.length());
        } catch (Exception e) {
            // empty catch - bad practice
        }
        if (input == "") { // should use .equals()
            logger.info("empty");
        }
    }
}
