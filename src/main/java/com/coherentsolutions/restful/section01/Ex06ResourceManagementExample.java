// File: Ex06ResourceManagementExample.java
package com.coherentsolutions.restful.section01;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

/**
 * Example 06: Resource Management Example
 *
 * This class demonstrates effective resource management by reusing HttpClient
 * instances and properly closing responses.
 */
public class Ex06ResourceManagementExample {

    private static final String BASE_URL = "http://localhost:49000"; // Replace with your port
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    /**
     * Main method to execute the resource management example.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Reuse HTTP_CLIENT for multiple requests
        for (int i = 0; i < 5; i++) {
            sendGetRequest();
        }
    }

    /**
     * Sends a GET request to retrieve users and ensures resources are properly managed.
     */
    private static void sendGetRequest() {
        // Build the GET request
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(BASE_URL + "/users"))
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            // Process the response (omitted for brevity)

            // No explicit connection close needed, but ensure large responses are properly handled

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
