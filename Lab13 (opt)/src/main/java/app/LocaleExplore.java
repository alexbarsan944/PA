package app;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class LocaleExplore {
    public static String loadProp(Locale locale, String prop) {
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        return messages.getString(prop);
    }
    public static String loadCmd(Locale locale, String prop) {
        ResourceBundle messages = ResourceBundle.getBundle("Commands", locale);
        return messages.getString(prop);
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        while(true){
            Locale l = Locale.getDefault();
            System.out.println(loadProp(l,"available")+
                    loadCmd(l,"set-locale.cmd") +", "+
                    loadCmd(l, "info-locale.cmd") +", "+
                    loadCmd(l, "display-locales.cmd") +", "+
                    loadCmd(l, "exit.cmd") );
            System.out.println(loadProp(l,"prompt"));
            String command = s.nextLine();
            if(command.equals(loadCmd(l,"info-locale.cmd"))){
                Class c = null;
                try {
                    c = Class.forName(loadCmd(l,"info-locale.impl"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    assert c != null;
                    Constructor constr = c.getConstructor();
                    constr.newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if(command.equals(loadCmd(l,"display-locales.cmd"))){
                Class c = null;
                try {
                    c = Class.forName(loadCmd(l,"display-locales.impl"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    assert c != null;
                    Constructor constr= c.getConstructor();
                    constr.newInstance();
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if(command.equals(loadCmd(l,"set-locale.cmd"))){
                System.out.println("Locale: ");
                System.out.println("ro");
                System.out.println("en");
                String lang = s.nextLine();
                String locale = null;
                if(lang.equals("ro")){
                    locale="ro-RO";
                    loadProp(l,"info");
                }else if(lang.equals("en"))
                {
                    locale = "en-US";
                    loadProp(l,"info");
                }
                Class c = null;
                try {
                    c = Class.forName(loadCmd(l,"set-locale.impl"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    Constructor constructor = c.getConstructor(String.class);
                    Object instanceOfMyClass = constructor.newInstance(locale);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if(command.equals(loadCmd(l,"exit.cmd"))){
                System.out.println(loadProp(l,"bye"));
                break;
            }else System.out.println(loadProp(l,"invalid"));
        }

    }
}
