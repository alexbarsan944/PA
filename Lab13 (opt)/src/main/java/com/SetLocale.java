package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale{
    public SetLocale(String language){
        String baseName = "Messages";
        Locale.setDefault(Locale.forLanguageTag(language));
        Locale locale = Locale.getDefault();
        ResourceBundle messages =ResourceBundle.getBundle(baseName, locale);
        System.out.println(messages.getString("locale.set"));
    }
}
