package cmd.commands.time;

import cmd.SimpleCmd;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.io.File;

@CommandLine.Command(
        name = "time",
        description = "outputs the current time",
        mixinStandardHelpOptions = true)
public class TimeCommand implements Runnable {

    @Option(names = {"-f"}, description = "formats the time in a different style")
    private String format;

    @Override
    public void run() {
        System.out.println("15:10");
    }
}
