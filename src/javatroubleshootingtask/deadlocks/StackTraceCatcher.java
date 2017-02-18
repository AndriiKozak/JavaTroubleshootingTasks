/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatroubleshootingtask.deadlocks;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Andrii_Kozak1
 */
public class StackTraceCatcher implements Runnable {

    private final long delay;
    private final Path path;

    public StackTraceCatcher(long delay, String path) {
        this.delay = delay;
        this.path = Paths.get(path);
    }

    @Override
    public void run() {
        try (BufferedWriter writer = Files.newBufferedWriter(path, CREATE)) {
            Thread.sleep(delay);
            writer.write(stackTrace());
            System.out.println("catched");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {

        }
    }

    private String stackTrace() {
        return Arrays.stream(
                ManagementFactory.getThreadMXBean().dumpAllThreads(true, true))
                .map(ThreadInfo::toString)
                .collect(Collectors.joining(System.lineSeparator(), System.lineSeparator(), System.lineSeparator()));
    }

}
