package ru.openitstudio.sshide.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.openitstudio.sshide.App;
import ru.openitstudio.sshide.AppConstants;
import ru.openitstudio.sshide.common.Settings;
import ru.openitstudio.sshide.components.terminal.snippets.SnippetItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveAndLoad {
    public synchronized static void loadSettings() {
        File file = new File(AppConstants.CONFIG_DIR + File.separator + ".sshide" + File.separator +
                AppConstants.CONFIG_DB_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (file.exists()) {
            try {
                App.settings = objectMapper.readValue(file,
                        new TypeReference<Settings>() {
                        });
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        App.settings = new Settings();
    }

    public synchronized static void saveSettings() {
        File file = new File(AppConstants.CONFIG_DIR,
                AppConstants.CONFIG_DB_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, App.settings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void loadSnippets() {
        File file = new File(App.getConfig("app.dir"),
                AppConstants.SNIPPETS_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (file.exists()) {
            try {
                App.snippetItems = objectMapper.readValue(file,
                        new TypeReference<List<SnippetItem>>() {
                        });
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        App.snippetItems = new ArrayList<>();
    }

    public synchronized static void saveSnippets() {
        File file = new File(App.getConfig("app.dir"),
                AppConstants.SNIPPETS_FILE);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, App.snippetItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
