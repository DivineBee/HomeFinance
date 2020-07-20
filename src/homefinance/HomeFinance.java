package homefinance;

import homefinance.settings.Format;
import homefinance.settings.Settings;
import homefinance.settings.Text;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class HomeFinance {
    public static void main(String[] args) {
        init();
        System.out.println(Format.dateMonth(new Date()));
    }
    private static void init(){
        Settings.init();
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ALICE_REGULAR));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
