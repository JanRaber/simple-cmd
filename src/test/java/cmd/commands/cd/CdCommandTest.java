package cmd.commands.cd;

import cmd.SimpleCmd;
import cmd.commands.AbstractTest;
import cmd.commands.dir.DirCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CdCommandTest extends AbstractTest {
    @Test
    public void testDirWithF(@TempDir Path tempDir) throws IOException {
        // given
        String location = "C:\\";
        String[] args = {location};
        CdCommand cdCommand = CommandLine.populateCommand(new CdCommand(), args);
        // when
        cdCommand.run();
        // then

        assertEquals(SimpleCmd.getCurrentLocation().getAbsolutePath(), location);
    }

    @Test
    public void testDirWithoutArguments(@TempDir Path tempDir) throws IOException {
        // given
        //prepareTestFolder(tempDir);
        String[] args = {};
        String location = SimpleCmd.getCurrentLocation().getAbsolutePath();
        CdCommand cdCommand = CommandLine.populateCommand(new CdCommand(), args);
        // when
        cdCommand.run();
        // then
        assertEquals(location, SimpleCmd.getCurrentLocation().getAbsolutePath());
    }

    private void prepareTestFolder(@TempDir Path tempDir) throws IOException {
        // for other possible usages of @TempDir see https://www.baeldung.com/junit-5-temporary-directory
        Path myFile = tempDir.resolve("myFile.txt");
        Files.write(myFile, Collections.singletonList(""));

        Path folder1 = tempDir.resolve("folder1");
        Path directory = Files.createDirectory(folder1, noAttributes);

        Path myFile2 = directory.resolve("myFile2.txt");
        Files.write(myFile2, Collections.singletonList(""));
    }

}