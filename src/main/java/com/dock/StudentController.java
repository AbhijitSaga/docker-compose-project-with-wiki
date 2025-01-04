package com.dock;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/welocom/{name}")
    public  String getUserInformation(@PathVariable String name){
        return "Hii  " +name;
    }


    @PostMapping("/textmsg")
    public  String saveName(@RequestParam String name) throws FileNotFoundException {
        final String FILE_PATH = "client_data.txt";
        //write file
        try (FileWriter writer = new FileWriter(FILE_PATH, true) ) {
            writer.write(name + System.lineSeparator());
        } catch ( IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }

        //read file
        File file = new File(FILE_PATH);
        String allSaveData="";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while (( line = reader.readLine()) != null) {
                allSaveData+=line +",  ";
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allSaveData;
    }

    @PostMapping("/student")
    ResponseEntity<?> saveStudent(@RequestBody Student  student) {
        return ResponseEntity.ok(studentRepository.saveAndFlush(student));
    }
    @GetMapping("/student")
    ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

}
