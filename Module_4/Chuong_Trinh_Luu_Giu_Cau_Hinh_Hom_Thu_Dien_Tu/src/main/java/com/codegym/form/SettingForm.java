package com.codegym.form;

import com.codegym.model.Language;
import com.codegym.model.PageSize;

public class SettingForm {
    private int id_SettingForm;
    private Language languages;
    private PageSize pageSizes;
    private Boolean spamFilter;
    private String signature;

    public SettingForm() {}

    public SettingForm(int id_SettingForm, Language languages, PageSize pageSizes, Boolean spamFilter, String signature) {
        this.id_SettingForm = id_SettingForm;
        this.languages = languages;
        this.pageSizes = pageSizes;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public int getId_SettingForm() {
        return id_SettingForm;
    }

    public void setId_SettingForm(int id_SettingForm) {
        this.id_SettingForm = id_SettingForm;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }

    public PageSize getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(PageSize pageSizes) {
        this.pageSizes = pageSizes;
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
