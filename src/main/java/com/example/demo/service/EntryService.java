package com.example.demo.service;

import com.example.demo.dao.EntryDao;
import com.example.demo.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class EntryService {

    private final EntryDao entryDao;

    @Autowired
    public EntryService(@Qualifier("entryDao") EntryDao entryDao) {
        this.entryDao = entryDao;
    }

    public int addPerson(Entry entry) throws IOException {
        return entryDao.insertPerson(entry);
    }
}
