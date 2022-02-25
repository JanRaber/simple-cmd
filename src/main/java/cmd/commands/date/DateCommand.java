package cmd.commands.date;

import cmd.SimpleCmd;
import picocli.CommandLine.Command;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

import static picocli.CommandLine.Option;

@Command(
        name = "date",
        description = "command can be used to print the date",
        mixinStandardHelpOptions = true)
public class DateCommand implements Runnable {

    public DateCommand() {
    }

    @Override
    public void run() {
        Date actualDate=new Date();
        String pattern = "yyyy-MM-dd";
        System.out.println(new SimpleDateFormat(pattern).format(actualDate));
    }

    
}
