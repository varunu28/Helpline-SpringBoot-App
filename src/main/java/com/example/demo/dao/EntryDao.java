package com.example.demo.dao;

import com.example.demo.model.Entry;

import java.io.IOException;

public interface EntryDao {
    int insertPerson(Entry entry) throws IOException;
}
