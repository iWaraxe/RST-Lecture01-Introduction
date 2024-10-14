// File: Ex01HttpClientInitialization.java
package com.coherentsolutions.restful.section01;

import java.net.http.HttpClient;

/**
 * Example 01: HttpClient Initialization
 *
 * This class demonstrates how to create an instance of HttpClient
 * which will be used to send HTTP requests in our API tests.
 */
public class Ex01HttpClientInitialization {

    /**
     * Main method to demonstrate HttpClient creation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Output to confirm creation
        System.out.println("HttpClient has been created: " + httpClient);
    }
}
