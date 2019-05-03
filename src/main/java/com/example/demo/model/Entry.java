package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Entry {

    private String location;
    private String area;
    private String content;
    private String source;
    private Date timestamp;
    private String isrescued;

    public Entry(@JsonProperty("location") String location,
                  @JsonProperty("area") String area,
                 @JsonProperty("content") String content,
                 @JsonProperty("source") String source,
                 @JsonProperty("isrescued") String isrescued) {
        this.location = location;
        this.area = area;
        this.content = content;
        this.source = source;
        this.isrescued = isrescued;
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

    public String getIsrescued() {
        return isrescued;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "location='" + location + '\'' +
                ", area='" + area + '\'' +
                ", content='" + content + '\'' +
                ", source='" + source + '\'' +
                ", timestamp=" + timestamp +
                ", isrescued='" + isrescued + '\'' +
                '}';
    }
}
