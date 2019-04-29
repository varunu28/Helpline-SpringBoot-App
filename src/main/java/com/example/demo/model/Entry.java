package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Entry {

    private String location;
    private String area;
    private String content;
    private String source;
    private Date timestamp;

    public Entry(@JsonProperty("location") String location,
                  @JsonProperty("area") String area,
                 @JsonProperty("content") String content,
                 @JsonProperty("source") String source) {
        this.location = location;
        this.area = area;
        this.content = content;
        this.source = source;
        this.timestamp = new Date();
    }

    public String getLocation() {
        return location;
    }

    public String getArea() {
        return area;
    }

    public String getContent() {
        return content;
    }

    public String getSource() {
        return source;
    }

    public String getTimestamp() {
        return timestamp.toString();
    }

    @Override
    public String toString() {
        return "Entry{" +
                "location='" + location + '\'' +
                ", area='" + area + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp.toString() +
                '}';
    }
}
