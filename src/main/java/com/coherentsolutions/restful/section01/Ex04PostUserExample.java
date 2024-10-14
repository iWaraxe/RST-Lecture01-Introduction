// File: Ex04PostUserExample.java
package com.coherentsolutions.restful.section01;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Example 04: POST User Example
 *
 * This class demonstrates how to send a POST request to create a new user
 * by serializing a Java object into JSON.
 */
public class Ex04PostUserExample {

    private static final String BASE_URL = "http://localhost:49000"; // Replace with your port

    /**
     * Main method to execute the POST user example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Create a new user object
        Ex02UserDTO newUser = new Ex02UserDTO();
        newUser.setName("John Doe");
        newUser.setAge(30);
        newUser.setGender("Male");
        newUser.setZipCode("12345");

        try {
            // Serialize the user object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(newUser);

            // Build the POST request
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .uri(URI.create(BASE_URL + "/users"))
                    .header("Content-Type", "application/json")
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Output the status code
            System.out.println("Response status code: " + response.statusCode());

            // Check if the user was created successfully
            if (response.statusCode() == 201) {
                // Deserialize the response body to get the created user
                Ex02UserDTO createdUser = objectMapper.readValue(response.body(), Ex02UserDTO.class);

                // Output the created user
                System.out.println("User created successfully: " + createdUser);
            } else {
                System.out.println("Failed to create user. Please check the API.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
