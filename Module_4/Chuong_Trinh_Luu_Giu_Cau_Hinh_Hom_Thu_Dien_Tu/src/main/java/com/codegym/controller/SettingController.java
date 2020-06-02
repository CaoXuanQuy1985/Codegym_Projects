package com.codegym.controller;

import com.codegym.model.Language;
import com.codegym.model.PageSize;
import com.codegym.model.Setting;
import com.codegym.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SettingController {

    @Autowired
    private SettingService settingService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showSetting(Model model) {
        List<Setting> settings = settingService.getAllSettings();
        List<Language> languages = settingService.getAllLanguages();
        List<PageSize> pageSizes = settingService.getAllPageSizes();
        Setting setting = settings.get(0);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("setting", setting);
        return "setting-form";
    }

    @RequestMapping(value="/setting-save-servlet", method=RequestMethod.GET)
    public String showSaveSetting(Model model) {
        List<Setting> settings = settingService.getAllSettings();
        model.addAttribute("settings", settings);
        return "setting-save";
    }

    @RequestMapping(value="/save-setting", method=RequestMethod.POST)
    public String saveSetting(@ModelAttribute Setting setting) {
        int newIdLanguage = setting.getLanguage().getId_Language() - 1;
        String newNameLanguage = settingService.getLanguage(newIdLanguage).getName();
        Language newLanguage = new Language(newIdLanguage, newNameLanguage);

        int newIdPageSize = setting.getPageSize().getId_PageSize() - 1;
        int newNumberPage = settingService.getPageSize(newIdPageSize).getNumberPage();
        PageSize newPageSize = new PageSize(newIdPageSize, newNumberPage);

        setting.setLanguage(newLanguage);
        setting.setPageSize(newPageSize);
        settingService.updateSetting(setting.getId_Setting(),setting);
        return "redirect:/setting-save-servlet";
    }
}
