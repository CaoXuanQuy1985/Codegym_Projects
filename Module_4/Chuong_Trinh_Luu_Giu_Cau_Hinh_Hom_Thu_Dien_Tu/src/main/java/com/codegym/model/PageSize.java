package com.codegym.model;

public class PageSize {
    public int id_PageSize;
    public int numberPage;

    public PageSize(){}

    public PageSize(int id_PageSize, int numberPage) {
        this.id_PageSize = id_PageSize;
        this.numberPage = numberPage;
    }

    public int getId_PageSize() {
        return id_PageSize;
    }

    public void setId_PageSize(int id_PageSize) {
        this.id_PageSize = id_PageSize;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }
}
