package com.example.demo.dao;

import com.example.demo.model.Entry;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Repository("entryDao")
public class EntryDataAccessService implements EntryDao  {

    @Override
    public int insertPerson(Entry entry) {
        System.out.println(entry.toString());

        // Save entry to JSON file
        String fileName = saveAsJSONFile(entry);

        // Push the JSON file to S3 bucket
        saveToS3Bucket(fileName);

        return 0;
    }

    private void saveToS3Bucket(String fileName) {

    }

    private String saveAsJSONFile(Entry entry) {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = "entry-" + UUID.randomUUID() + ".json";
        File file = new File(fileName);
        try {
            mapper.writeValue(file, entry);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}