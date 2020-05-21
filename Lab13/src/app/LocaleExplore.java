package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        DisplayLocales locales = new DisplayLocales();
        Locale roLocale = new Locale("ro", "RO");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter command: Info | SetLocale | DisplayLocales");
        String command = s.nextLine();
        if(command.equals("Info"))
        {
            Info info = new Info();
            info.printInfo();
        }
        else
        if(command.equals("SetLocale"))
        {
            new SetLocale(roLocale);
        } else
        if(command.equals("DisplayLocales"))
        {
            locales.printLocales();
        }
        else
        {
            System.out.println("Invalid command");
        }
    }
}
