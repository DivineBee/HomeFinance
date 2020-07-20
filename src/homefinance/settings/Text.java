package homefinance.settings;

import java.util.HashMap;

final public class Text {
    private static final HashMap<String, String> data = new HashMap<>();
    public static String getItem(String key){
        if (data.containsKey(key)) return data.get(key);
        System.out.println("Такого ключа в Text не существует!"); //for testing
        return "";
    }

    public static String[] getMonths(){
        String[] months = new String[12];
        months[0] = getItem("JANUARY");
        months[1] = getItem("FEBRUARY");
        months[2] = getItem("MARCH");
        months[3] = getItem("APRIL");
        months[4] = getItem("MAY");
        months[5] = getItem("JUNE");
        months[6] = getItem("JULY");
        months[7] = getItem("AUGUST");
        months[8] = getItem("SEPTEMBER");
        months[9] = getItem("OCTOBER");
        months[10] = getItem("NOVEMBER");
        months[11] = getItem("DECEMBER");
        return months;
    }
    public static void init(){
        data.put("PROGRAM_NAME", "Личные финансы");
        data.put("MENU_FILE", "Файл");
        data.put("MENU_EDIT", "Правка");
        data.put("MENU_VIEW", "Вид");
        data.put("MENU_HELP", "Помощь");

        data.put("JANUARY", "Январь");
        data.put("FEBRUARY", "Февраль");
        data.put("MARCH", "Март");
        data.put("APRIL", "Апрель");
        data.put("MAY", "Май");
        data.put("JUNE", "Июнь");
        data.put("JULY", "Июль");
        data.put("AUGUST", "Август");
        data.put("SEPTEMBER", "Сентябрь");
        data.put("OCTOBER", "Октябрь");
        data.put("NOVEMBER", "Ноябрь");
        data.put("DECEMBER", "Декабрь");

        data.put("TITLE_EMPTY", "Вы не ввели название!");
        data.put("IS_EXISTS", "Такая запись уже существует!");
        data.put("DATE_FORMAT", "Некорректный формат даты!");
        data.put("CODE_EMPTY", "Вы не указали код!");
        data.put("CURRENCY_EMPTY", "Вы не выбрали валюту!");
        data.put("ARTICLE_EMPTY", "Вы не выбрали статью!");
        data.put("ACCOUNT_EMPTY", "Вы не выбрали счёт!");
        data.put("RATE_INCORRECT", "Некорректное значение курса!");
        data.put("AMOUNT_FORMAT", "Некорректный формат суммы!");
        data.put("NO_BASE_CURRENCY", "Необходима базовая валюта! Установите параметр базовой валюты.");

        data.put("YES", "Да");
        data.put("NO", "Нет");
    }
}
