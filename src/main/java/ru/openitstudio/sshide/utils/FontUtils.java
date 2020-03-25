package ru.openitstudio.sshide.utils;

import ru.openitstudio.sshide.App;

import java.awt.*;
import java.io.InputStream;

public class FontUtils {
    public static Font fontMono;
    private static Font fontAwesomeFont;

    public static Font getFontAwesomeFont() {
        return fontAwesomeFont;
    }

    public static Font getFontMono() {
        return fontMono;
    }

    public static void loadFonts() {
        try (InputStream is = App.class.getResourceAsStream("/fontawesome-webfont.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontAwesomeFont = font.deriveFont(Font.PLAIN, 14f);
            System.out.println("Font loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream is = App.class.getResourceAsStream("/JetBrainsMonoRegular.ttf")) {
            System.out.println(is);
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontMono = font.deriveFont(Font.PLAIN, 14f);
            System.out.println("Font loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
