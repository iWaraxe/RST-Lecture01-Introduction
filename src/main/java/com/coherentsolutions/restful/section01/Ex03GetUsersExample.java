// File: Ex03GetUsersExample.java
package com.coherentsolutions.restful.section01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 * Example 03: GET Users Example
 *
 * This class demonstrates how to send a GET request to retrieve all users
 * and deserialize the JSON response into Java objects.
 */
public class Ex03GetUsersExample {

    private static final String BASE_URL = "http://localhost:49000"; // Replace with your port

    /**
     * Main method to execute the GET users example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Build the GET request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BASE_URL + "/users"))
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Output the status code
            System.out.println("Response status code: " + response.statusCode());

            // Check if the request was successful
            if (response.statusCode() == 200) {
                // Deserialize the JSON response into a list of UserDTO objects
                ObjectMapper objectMapper = new ObjectMapper();
                List<Ex02UserDTO> users = objectMapper.readValue(response.body(),
                        new TypeReference<List<Ex02UserDTO>>() {});

                // Output the users
                for (Ex02UserDTO user : users) {
                    System.out.println(user);
                }
            } else {
                System.out.println("Failed to retrieve users. Please check the API.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
