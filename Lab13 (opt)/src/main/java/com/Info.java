package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Info {
    public Info() {
        Locale locale = Locale.getDefault();
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        String[] weekDays = new DateFormatSymbols(locale).getWeekdays();
        String[] months = new DateFormatSymbols(locale).getMonths();
        Currency currency= Currency.getInstance(locale);
        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: "  + locale.getDisplayLanguage());
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName() + ")");
        System.out.println("Week days: "  + Arrays.toString(weekDays));
        System.out.println("Months: "  + Arrays.toString(months));
        System.out.println("Today: " + today.format(formatter));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/FullCountryInfo/JSON/debug?sCountryISOCode=" + locale.getCountry());
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            Scanner scanner = new Scanner(httpResponse.getEntity().getContent());
            StringBuilder responseBuilder = new StringBuilder();

            while (scanner.hasNext()) {
                responseBuilder.append(scanner.nextLine());
            }
            ObjectMapper mapper = new ObjectMapper();
            Map map = mapper.readValue(responseBuilder.toString(), Map.class);

            System.out.println("Phone Code: +" + map.get("sPhoneCode"));
            System.out.println("Continent: " + map.get("sContinentCode"));
            System.out.println("Country Flag: " + map.get("sCountryFlag"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
