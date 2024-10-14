package com.coherentsolutions.restful.section01.advanced;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Ex05LoggingExample {

    private static final Logger LOGGER = Logger.getLogger(Ex05LoggingExample.class.getName());

    public static void main(String[] args) {
        try {
            // Create a FileHandler to save logs to a file
            FileHandler fileHandler = new FileHandler("logs/api_test.log", true); // true for appending logs
            fileHandler.setFormatter(new SimpleFormatter()); // Set simple format for readability

            // Add the FileHandler to the logger
            LOGGER.addHandler(fileHandler);

            // Log some messages
            LOGGER.info("This log message will be saved to the file.");

            // Remember to close the handler to release resources
            fileHandler.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
