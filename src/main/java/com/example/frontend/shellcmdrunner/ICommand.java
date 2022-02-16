package com.example.frontend.shellcmdrunner;

import java.io.IOException;
import java.util.List;

public interface ICommand {
    // First element of the list cmd is the command to run and the next are its arguments
    // Returns a String with the output from cmd
    // It should work in both linux and windows environments
    String runShellCmd(List<String> cmd) throws IOException;
}
