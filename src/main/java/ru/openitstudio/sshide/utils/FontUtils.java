package ru.openitstudio.sshide.utils;

import ru.openitstudio.sshide.App;

import java.awt.*;
import java.io.InputStream;

public class FontUtils {
    public static Font fontForUi;
    public static Font fontForConsole;
    private static Font fontAwesomeFont;

    public static Font getFontAwesomeFont() {
        return fontAwesomeFont;
    }

    public static Font getFontForUi() {
        return fontForUi;
    }

    public static Font getFontForConsole() {
        return fontForConsole;
    }

    public static void loadFonts() {
        try (InputStream is = App.class.getResourceAsStream("/fontawesome-webfont.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontAwesomeFont = font.deriveFont(Font.PLAIN, 14f);
            System.out.println("Font loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String monoFontFileName = "/JetBrainsMonoRegular.ttf";

        if (System.getProperty("os.name").equals("Mac OS X")) {
            monoFontFileName = "/SFmono.ttf";
        }

        try (InputStream is = App.class.getResourceAsStream(monoFontFileName)) {
            System.out.println(is);
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontForUi = font.deriveFont(Font.PLAIN, 14f);
            System.out.println("Font loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (InputStream is = App.class.getResourceAsStream("/Andale.ttf")) {
            System.out.println(is);
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            fontForConsole = font.deriveFont(Font.PLAIN, 14f);
            System.out.println("Font loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
