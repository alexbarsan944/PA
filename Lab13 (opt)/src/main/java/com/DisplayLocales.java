package com;

import java.util.Locale;

import static app.LocaleExplore.loadProp;

public class DisplayLocales  {
    private static final String[] availableLocales = new String[]{
            "en", "ro_RO"
    };
    public DisplayLocales() {
        Locale l = Locale.getDefault();
        System.out.println(loadProp(l,"locale.set"));
        System.out.println(Locale.getDefault().getDisplayCountry()+"\t"+Locale.getDefault().getDisplayLanguage());
        System.out.println(loadProp(l,"locales"));

        for(String locale : availableLocales) {
            System.out.println(locale);
        }
    }
}
