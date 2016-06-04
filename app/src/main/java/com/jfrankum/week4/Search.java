package com.jfrankum.week4;

/**
 * Created by julian on 6/3/16.
 */
public class Search {

    private long id;
    private String name;
    private String location;
    private String status;

    public Search(long id, String name, String location, String status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
    }

    public Search(String type, String param) {
        switch (type) {
            case "name":
                name = param;
                location = "";
                status = "";
                break;
            case "location":
                name = "";
                location = param;
                status = "";
                break;
            case "status":
                name = "";
                location = "";
                status = param;
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }
}
