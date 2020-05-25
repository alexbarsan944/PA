package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LocaleExplore {
    public static String loadProp(Locale locale, String prop) {
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        return messages.getString(prop);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale locale = Locale.getDefault();
        int countLanguages=0;
        boolean running = true;
        while (running) {
            new DisplayLocales().print(locale);
            System.out.println(loadProp(locale, "prompt"));
            String line = scanner.nextLine();
            while(line.equals("ro_RO"))
            {
                countLanguages++;
                locale = new Locale("ro", "RO");
                while(true)
                {
                    System.out.println(loadProp(locale, "prompt"));
                    line = scanner.nextLine();
                    if (line.equals("info")) {
                        new Info().printInfo(locale);
                        new Info().printOtherInfo(locale);

                    } else if (line.equals("set")) {
                        new DisplayLocales().print(locale);
                        line = scanner.nextLine();
                        if(line.equals("en")) {
                            locale = new Locale("en");
                            new SetLocale(locale);
                            break;
                        }
                    }
                    else
                    {
                        System.out.println(loadProp(locale, "invalid"));
                    }
                }
            }
            while(line.equals("en"))
            {
                countLanguages++;
                locale = new Locale("en", "US");
                while(true)
                {
                    System.out.println(loadProp(locale, "prompt"));
                    line = scanner.nextLine();
                    if (line.equals("info")) {
                        new Info().printInfo(locale);
                        new Info().printOtherInfo(locale);
                    } else if (line.equals("set")) {
                        new DisplayLocales().print(locale);
                        line = scanner.nextLine();
                        if(line.equals("ro_RO")) {
                            locale = new Locale("ro", "RO");
                            new SetLocale(locale);
                            break;
                        }
                    }
                    else
                    {
                        System.out.println(loadProp(locale, "invalid"));
                    }
                }
            }
            if(countLanguages == 0)
            {
                System.out.println(loadProp(locale, "invalid"));
            }
        }
    }

}
