package com.codegym.model;

public class Setting {
    private int id_Setting;
    public Language language;
    public PageSize pageSize;
    private Boolean spamFilter;
    private String signature;

    public Setting() {}

    public Setting(int id_Setting, Language language, PageSize pageSize, Boolean spamFilter, String signature) {
        this.id_Setting = id_Setting;
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public int getId_Setting() {
        return id_Setting;
    }

    public void setId_Setting(int id_Setting) {
        this.id_Setting = id_Setting;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(Boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
