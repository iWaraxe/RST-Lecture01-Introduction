// File: Ex08CustomHttpClientConfiguration.java
package com.coherentsolutions.restful.section01.advanced;

import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Example 08: Custom HttpClient Configuration (Advanced)
 *
 * This class demonstrates how to customize the HttpClient configuration,
 * such as setting timeouts and proxy settings.
 */
public class Ex08CustomHttpClientConfiguration {

    /**
     * Creates a customized HttpClient instance.
     *
     * @return Customized HttpClient.
     */
    public static HttpClient createCustomHttpClient() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_2)
                .proxy(ProxySelector.getDefault())
                .build();
    }

    /**
     * Main method to demonstrate custom HttpClient usage.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        HttpClient customHttpClient = createCustomHttpClient();

        // Use customHttpClient for requests
        System.out.println("Custom HttpClient created: " + customHttpClient);
    }
}
