package com.example.frontend.shellcmdrunner;

import java.io.IOException;
import java.util.List;

public interface ICommand {
    // First element of the list cmd is the command and the next are arguments
    String runShellCmd(List<String> cmd) throws IOException;
}
