package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController  // Add this annotation to enable web endpoints
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @PostConstruct
    public void init() {
        log.info("Java app started");
    }

    // Root endpoint - Hello World landing page
    @GetMapping("/")
    public String home() {
        return "<!DOCTYPE html>" +
               "<html>" +
               "<head>" +
               "<title>Hello World - Spring Boot App</title>" +
               "<style>" +
               "body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; background-color: #f0f8ff; }" +
               ".container { max-width: 600px; margin: 0 auto; padding: 20px; }" +
               ".success { color: #28a745; font-size: 48px; margin-bottom: 20px; }" +
               ".info { color: #17a2b8; font-size: 18px; margin: 10px 0; }" +
               ".status { background-color: #d4edda; padding: 15px; border-radius: 5px; margin: 20px 0; }" +
               "</style>" +
               "</head>" +
               "<body>" +
               "<div class='container'>" +
               "<h1 class='success'>🎉 Hello World!</h1>" +
               "<h2>Welcome to My Spring Boot Application</h2>" +
               "<div class='status'>" +
               "<p class='info'><strong>Status:</strong> " + getStatus() + "</p>" +
               "<p class='info'><strong>Time:</strong> " + LocalDateTime.now() + "</p>" +
               "<p class='info'><strong>Message:</strong> Your Docker containerized Spring Boot app is running successfully!</p>" +
               "</div>" +
               "<p>🚀 <strong>Congratulations!</strong> Your CI/CD pipeline is working perfectly.</p>" +
               "<p>📦 This app was built with Gradle, containerized with Docker, and deployed via CircleCI.</p>" +
               "</div>" +
               "</body>" +
               "</html>";
    }

    // Simple text endpoint
    @GetMapping("/hello")
    public String hello() {
        return "Hello World from Spring Boot!";
    }

    // JSON API endpoint
    @GetMapping("/api/status")
    public String statusApi() {
        return "{\n" +
               "  \"status\": \"" + getStatus() + "\",\n" +
               "  \"message\": \"Spring Boot application is running\",\n" +
               "  \"timestamp\": \"" + LocalDateTime.now() + "\",\n" +
               "  \"version\": \"1.0-SNAPSHOT\"\n" +
               "}";
    }

    // Health check endpoint
    @GetMapping("/health")
    public String health() {
        return "{\n" +
               "  \"status\": \"UP\",\n" +
               "  \"application\": \"" + getStatus() + "\",\n" +
               "  \"timestamp\": \"" + LocalDateTime.now() + "\"\n" +
               "}";
    }

    public String getStatus() {
        return "OK";
    }
}