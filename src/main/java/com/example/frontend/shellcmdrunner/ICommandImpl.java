package com.example.frontend.shellcmdrunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ICommandImpl implements ICommand {

    @Override
    public String runShellCmd(List<String> cmd) throws IOException {
        // TODO: Use linked list for performance like the following:
        // https://www.geeksforgeeks.org/adding-an-element-to-the-front-of-linkedlist-in-java/
        List<String> cmds = new ArrayList<>();
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            cmds.add("cmd.exe");
            cmds.add("/c");
        } else {
            cmds.add("sh"); // posix compliant shell
            cmds.add("-c"); // run cmd
        }
        cmds.addAll(cmd); // Add the chosen cmd and arguments
        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        String text = new BufferedReader(
                new InputStreamReader(pb.start().getInputStream(), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }
}
