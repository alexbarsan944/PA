package com;

import java.util.Locale;

import static app.LocaleExplore.loadProp;

public class DisplayLocales  {
    private static final String[] availableLocales = new String[]{
            "en", "ro_RO"
    };
    public Locale print(Locale locale) {
        System.out.println(loadProp(locale, "locales"));
        for (String locales : availableLocales) {
            System.out.println(locales);
        }

        return locale;
    }
}
