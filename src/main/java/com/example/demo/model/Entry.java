package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Entry {

    private String location;
    private String area;
    private String content;

    public Entry(@JsonProperty("location") String location,
                  @JsonProperty("area") String area,
                 @JsonProperty("content") String content) {
        this.location = location;
        this.area = area;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "location='" + location + '\'' +
                ", area='" + area + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
