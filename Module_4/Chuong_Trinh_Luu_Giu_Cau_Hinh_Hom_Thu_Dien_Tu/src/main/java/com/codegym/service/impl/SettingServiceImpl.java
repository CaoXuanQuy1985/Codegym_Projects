package com.codegym.service.impl;

import com.codegym.model.Language;
import com.codegym.model.PageSize;
import com.codegym.model.Setting;
import com.codegym.service.SettingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {
    private static List<Setting> settings;
    private static List<Language> languages;
    private static List<PageSize> pageSizes;

    static  {
        settings = new ArrayList<Setting>();
        languages = new ArrayList<Language>();
        pageSizes = new ArrayList<PageSize>();

        Language english = new Language(1, "English");
        Language vietnamese = new Language(2, "Vietnamese");
        Language japanese = new Language(3, "Japanese");
        Language chinese = new Language(4, "Chinese");

        languages.addAll(Arrays.asList(english, vietnamese, japanese, chinese));

        PageSize size5 = new PageSize(1, 5);
        PageSize size10 = new PageSize(2, 10);
        PageSize size15 = new PageSize(3, 15);
        PageSize size25 = new PageSize(4, 25);
        PageSize size50 = new PageSize(5, 50);
        PageSize size100 = new PageSize(6, 100);

        pageSizes.addAll(Arrays.asList(size5, size10, size15, size25, size50, size100));

        Setting setting1 = new Setting(1, english, size5, false, "Cao Xuan Quy");
        settings.add(setting1);
    }

    public List<Language> getAllLanguages() {
        return languages;
    }

    public List<PageSize> getAllPageSizes() {
        return pageSizes;
    }

    public Language getLanguage(int id) {
        return languages.get(id);
    }

    public PageSize getPageSize(int id) {
        return pageSizes.get(id);
    }

    public List<Setting> getAllSettings() {
        return settings;
    }

    public Setting getSetting(int id) {
        return settings.get(id);
    }

    public void updateSetting(int id, Setting setting) {
        settings.set(id - 1, setting);
    }
}
