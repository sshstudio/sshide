package ru.openitstudio.sshide.components.sysinfo.platforms.linux;

import ru.openitstudio.sshide.common.ssh.SshClient;
import ru.openitstudio.sshide.components.sysinfo.ServicePanel;
import ru.openitstudio.sshide.components.sysinfo.SocketPanel;
import ru.openitstudio.sshide.components.sysinfo.platforms.SystemInfo;
import ru.openitstudio.sshide.utils.ScriptLoader;
import ru.openitstudio.sshide.utils.SshCommandUtils;
import ru.openitstudio.sshide.utils.SudoUtils;

import java.util.concurrent.atomic.AtomicBoolean;

public class LinuxSysInfo {
    public static SystemInfo retrieveSystemInfo(SshClient client, AtomicBoolean stopFlag) throws Exception {
        SystemInfo systemInfo = new SystemInfo();
        StringBuilder output = new StringBuilder();
        if (SshCommandUtils.exec(client, ScriptLoader.loadShellScript("/linux-system-info.sh"), stopFlag, output)) {
            systemInfo.setSystemOverview(output.toString());
        }
        output = new StringBuilder();
        if (SshCommandUtils.exec(client, ServicePanel.SYSTEMD_COMMAND, stopFlag, output)) {
            systemInfo.setServices(ServicePanel.parseServiceEntries(output));
        }
        output = new StringBuilder();
        if (SshCommandUtils.exec(client, SocketPanel.LSOF_COMMAND, stopFlag, output)) {
            systemInfo.setSockets(SocketPanel.parseSocketList(output.toString()));
        }
        return systemInfo;
    }

    public static boolean runCommandWithSudo(SshClient client, AtomicBoolean stopFlag, String command) throws Exception {
        //StringBuilder output = new StringBuilder();
        return SudoUtils.runSudo(command, client) == 0;
    }

    public static boolean runCommand(SshClient client, AtomicBoolean stopFlag, String command) throws Exception {
        StringBuilder output = new StringBuilder();
        return SshCommandUtils.exec(client, command, new AtomicBoolean(false), output);
    }
}
