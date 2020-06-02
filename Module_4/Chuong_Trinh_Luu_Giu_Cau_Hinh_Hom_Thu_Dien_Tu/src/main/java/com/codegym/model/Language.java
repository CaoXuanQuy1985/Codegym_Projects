package com.codegym.model;

import java.io.Serializable;

public class Language implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    public int id_Language;
    public String name;

    public Language() {}

    public Language(int id_Language, String name) {
        this.id_Language = id_Language;
        this.name = name;
    }

    public int getId_Language() {
        return id_Language;
    }

    public void setId_Language(int id_Language) {
        this.id_Language = id_Language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
