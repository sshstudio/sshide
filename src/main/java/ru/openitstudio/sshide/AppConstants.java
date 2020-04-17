package ru.openitstudio.sshide;

import java.util.Locale;

public interface AppConstants {
    public static final String CONFIG_DIR = System.getProperty("user.home");
    public static final String SESSION_DB_FILE = "session-store.json";
    public static final String CONFIG_DB_FILE = "settings.json";
    public static final String SNIPPETS_FILE = "snippets.json";
    public static final int LARGE = 24, NORMAL = 16, SMALL = 12;
    public static final long DOWNLOAD_FINISHED = 10203049, FILE_COPY = 20103489,
            FILE_ADDED = 897678;

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String _OS_NAME = OS_NAME.toLowerCase(Locale.ENGLISH);
    public static final boolean isWindows = _OS_NAME.startsWith("windows");
    public static final boolean isMac = _OS_NAME.startsWith("mac");
    public static final boolean isLinux = _OS_NAME.startsWith("linux");
    public static final boolean isFreeBSD = _OS_NAME.startsWith("freebsd");
    public static final boolean isSolaris = _OS_NAME.startsWith("sunos");
    public static final boolean isUnix = !isWindows;
}
