package com.example.demo.dao;

import com.example.demo.model.Entry;
import org.springframework.stereotype.Repository;


@Repository("entryDao")
public class EntryDataAccessService implements EntryDao  {

    @Override
    public int insertPerson(Entry entry) {
        // Add logic to convert to JSON object
        // Add logic to push to S3 bucket
        System.out.println(entry.toString());
        return 0;
    }
}
