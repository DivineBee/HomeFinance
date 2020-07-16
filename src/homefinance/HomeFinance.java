package homefinance;

import homefinance.settings.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class HomeFinance {
    public static void main(String[] args) {
        init();
        System.out.println(Text.getItem("PROGRAM_NAME"));
        System.out.println(Arrays.toString(Text.getMonths()));
    }
    private static void init(){
        Text.init();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\fonts\\Alice-Regular.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
