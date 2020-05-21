package com;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public void printInfo() {
        Locale roLocale = new Locale("ro", "RO");
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(roLocale);
        String[] weekDays = new DateFormatSymbols(roLocale).getWeekdays();
        String[] months = new DateFormatSymbols(roLocale).getMonths();
        Currency currency= Currency.getInstance(roLocale);
        System.out.println("Country: " + roLocale.getDisplayCountry());
        System.out.println("Language: "  + roLocale.getDisplayLanguage());
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName() + ")");
        System.out.println("Week days: "  + Arrays.toString(weekDays));
        System.out.println("Months: "  + Arrays.toString(months));
        System.out.println("Today: " + today.format(formatter));


    }
}
