package cmd.commands.cd;

import cmd.SimpleCmd;
import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(
        name = "cd",
        description = "command can be used to change current directory",
        mixinStandardHelpOptions = true)
public class CdCommand implements Runnable {


    @CommandLine.Parameters(arity = "0..1", description = "The directory to change to")
    private String directory=SimpleCmd.getCurrentLocation().getAbsolutePath();


    private File newCurrentDirectory;

    @Override
    public void run() {
        newCurrentDirectory = new File(directory);
        SimpleCmd.setCurrentLocation(newCurrentDirectory);
        System.out.println("Current Path :" + newCurrentDirectory.getAbsolutePath());
    }
}
