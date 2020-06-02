package com.codegym.service;

import com.codegym.model.Language;
import com.codegym.model.PageSize;
import com.codegym.model.Setting;

import java.util.List;

public interface SettingService {
    List<Language> getAllLanguages();
    Language getLanguage(int id);
    List<PageSize> getAllPageSizes();
    PageSize getPageSize(int id);
    List<Setting> getAllSettings();
    Setting getSetting(int id);
    void updateSetting(int id, Setting setting);
}
