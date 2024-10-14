// File: Ex05LoggingExample.java
package com.coherentsolutions.restful.section01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Example 05: Logging Example
 *
 * This class demonstrates how to incorporate logging into API tests.
 */
public class Ex05LoggingExample {

    private static final String BASE_URL = "http://localhost:49000"; // Replace with your port
    private static final Logger LOGGER = Logger.getLogger(Ex05LoggingExample.class.getName());

    /**
     * Main method to execute the logging example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Set logging level
        LOGGER.setLevel(Level.ALL);

        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Build the GET request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BASE_URL + "/users"))
                .build();

        // Log the request details
        LOGGER.info("Sending GET request to: " + request.uri());

        try {
            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Log the response status code
            LOGGER.info("Received response with status code: " + response.statusCode());

            // Log the response body
            LOGGER.fine("Response body: " + response.body());

            // Check if the request was successful
            if (response.statusCode() == 200) {
                // Deserialize the JSON response into a list of UserDTO objects
                ObjectMapper objectMapper = new ObjectMapper();
                List<Ex02UserDTO> users = objectMapper.readValue(response.body(),
                        new TypeReference<List<Ex02UserDTO>>() {});

                // Output the users
                for (Ex02UserDTO user : users) {
                    LOGGER.info("User: " + user);
                }
            } else {
                LOGGER.warning("Failed to retrieve users. Please check the API.");
            }

        } catch (IOException | InterruptedException e) {
            LOGGER.severe("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
