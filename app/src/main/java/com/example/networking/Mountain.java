package com.example.networking;

public class Mountain {
    private String ID;
    private String name;

    public Mountain(String ID, String Name) {
        this.ID = ID;
        this.name = Name;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}