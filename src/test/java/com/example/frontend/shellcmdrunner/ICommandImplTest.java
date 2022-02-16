package com.example.frontend.shellcmdrunner;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ICommandImplTest {

    @Test
    void iCommandImplTest() throws IOException {
        List<String> cmd = new ArrayList<>();
        ICommand iCmd = new ICommandImpl();
        // Create command depending on OS - TODO: check exit status
        if(System.getProperty("os.name").toLowerCase().contains("win")) {
            cmd.add("dir");
            cmd.add("/a");
        } else { // Assert linux environment if not windows
            cmd.add("ls"); // cmd to run
            cmd.add("-l"); // arg
        }
        System.out.println(iCmd.runShellCmd(cmd));
    }
}