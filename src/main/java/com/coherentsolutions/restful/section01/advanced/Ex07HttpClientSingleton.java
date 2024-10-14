// File: Ex07HttpClientSingleton.java
package com.coherentsolutions.restful.section01.advanced;

import java.net.http.HttpClient;

/**
 * Example 07: HttpClient Singleton (Advanced)
 *
 * This class demonstrates how to implement a singleton pattern for HttpClient
 * to ensure a single instance is used throughout the application.
 */
public class Ex07HttpClientSingleton {

    private static HttpClient httpClient;

    /**
     * Private constructor to prevent instantiation.
     */
    private Ex07HttpClientSingleton() {
        // Private constructor
    }

    /**
     * Provides a globally accessible HttpClient instance.
     *
     * @return HttpClient instance.
     */
    public static HttpClient getInstance() {
        if (httpClient == null) {
            synchronized (Ex07HttpClientSingleton.class) {
                if (httpClient == null) {
                    httpClient = HttpClient.newHttpClient();
                }
            }
        }
        return httpClient;
    }
}
