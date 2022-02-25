package cmd.commands.time;

import cmd.commands.AbstractTest;
import cmd.commands.BaseCommand;
import cmd.commands.cd.CdCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCommandTest extends AbstractTest {

    private static final CommandLine commandLine = new CommandLine(new BaseCommand());

    @Test
    void getCurrentDateInDefaultFormat() throws IOException {
        // given
        String[] args = {"time"};
        // when
        commandLine.execute(args);
        String expected = LocalTime.now().toString();
        String actual = getOutStreamCaptor().toString();
        actual = cleanOutput(actual);
        assertEquals(actual, expected, "Expected : " + expected + " But was: " + actual);
    }

}
