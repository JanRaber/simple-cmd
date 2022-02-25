package cmd.commands.time;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@CommandLine.Command(
        name = "time",
        description = "outputs the current time",
        mixinStandardHelpOptions = true)
public class TimeCommand implements Runnable {

    @Option(names = {"-f"}, description = "formats the time in a different style")
    private String format;

    @Override
    public void run() {
        Date currentDate = new Date();

        // Creating simple date formatter to 24 hours
        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");

        // getting the time in 24 hours format
        System.out.println(formatter.format(currentDate));
    }
}
