package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/api")
public class PublicIpController {

    @GetMapping("/public-ip")
    public String getPublicIp() {
        try {
            // URL of a public IP service
            String ipServiceUrl = "https://api.ipify.org?format=text";
            URL url = new URL(ipServiceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String ipAddress = in.readLine();
            in.close();

            return "Public IP Address: " + ipAddress;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching public IP address.";
        }
    }
}
