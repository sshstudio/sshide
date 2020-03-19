package ru.openitstudio.sshide.components.taskmgr.plaformsupport;

import ru.openitstudio.sshide.common.ssh.SshClient;
import ru.openitstudio.sshide.components.taskmgr.ProcessTableEntry;

import java.util.List;

public interface PlatformSupport {
    public void updateMetrics(SshClient client) throws Exception;

    public void updateProcessList(SshClient client) throws Exception;

    public double getCpuUsage();

    public double getMemoryUsage();

    public double getSwapUsage();

    public long getTotalMemory();

    public long getUsedMemory();

    public long getTotalSwap();

    public long getUsedSwap();

    public List<ProcessTableEntry> getProcessList();
}
