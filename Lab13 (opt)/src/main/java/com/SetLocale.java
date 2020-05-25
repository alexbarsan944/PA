package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale   {
    public SetLocale(Locale l)
    {
        String baseName = "Messages";
        ResourceBundle messages =
                ResourceBundle.getBundle(baseName, l);
        System.out.println(messages.getString("locale.set"));
    }
    public SetLocale(String limba) {
        Locale.setDefault(Locale.forLanguageTag(limba));
        String baseName = "Messages";
        ResourceBundle messages =
                ResourceBundle.getBundle(baseName, Locale.getDefault());
        System.out.println(messages.getString("locale.set"));
    }
}
