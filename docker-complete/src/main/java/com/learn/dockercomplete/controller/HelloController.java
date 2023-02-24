package com.learn.dockercomplete.controller;


import com.learn.dockercomplete.pojo.FileCreatePojo;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHelloMessage() {


        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> Learning docker </h1>\n" +
                "</body>\n" +
                "</html>";

    }

    @PostMapping("/saveFile")
    public String saveFile(@RequestBody FileCreatePojo fileCreatePojo) {
        try {

            Path path = Paths.get("/home/file");
            if (!Files.exists(path)) {
                //java.nio.file.Files;
                Files.createDirectories(path);
                System.out.println("Directory is created!");
            }

        } catch (IOException e) {

            System.err.println("Failed to create directory!" + e.getMessage());

        }
        try {
            FileWriter myWriter = new FileWriter("/home/file/" + fileCreatePojo.getFileName() + ".txt");
            myWriter.write(fileCreatePojo.getContent());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return "Successfully created file ";
    }

    @GetMapping("/readFile")
    public String readFile(@RequestParam("filename") String filename) throws IOException {
        // Passing the path to the file as a parameter
        FileReader fr = new FileReader("/home/file/" +filename+".txt");
        String result = "";

        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1){
            // Print all the content of a file
            System.out.print((char)i);
            result += (char)i;
        }

        return result;


    }

}
