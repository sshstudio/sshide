package ru.openitstudio.sshide.components.ui;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.openitstudio.sshide.App;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
//<!--Seee https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html-->
public class AppLookAndFeel {

    public static void apply() {

        String themeFile = System.getProperty("user.home") +
                File.separator +
                ".sshide" +
                File.separator +
                "themes" +
                File.separator +
                App.getGlobalSettings().getTheme();

        try {
            File file = new File(themeFile);
            if (file.exists() && file.isFile()) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("color");

                for (int colorsItem = 0; colorsItem < nodeList.getLength(); colorsItem++) {

                    Node node = nodeList.item(colorsItem);

                    UIManager.put(
                            node.getAttributes().getNamedItem("name").getNodeValue(),
                            Color.decode(node.getAttributes().getNamedItem("value").getNodeValue())
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        UIManager.put("control", Color.WHITE);
        UIManager.put("nimbusSelectionBackground", new Color(3, 155, 229));
        UIManager.put("ScrollBar.width", 7);
    }
}
