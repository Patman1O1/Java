package org.jflap;

import java.io.File;
import java.io.IOException;

/*
* Frequently Used Characters
* ε
* Σ
* */

public class Main {
    public static final File JFLAP_FILE = new File("C:\\Users\\patri\\OneDrive\\Coding\\Java\\Programs\\Jflap\\",
                                             "JFLAP7.1.jar");

    public static void runJflap() {
        try {
            // Start JFLAP
            Process jflapProcess = new ProcessBuilder("java", "-jar", JFLAP_FILE.getAbsolutePath()).inheritIO().start();

            // 🔹 If your program ends, destroy JFLAP
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (jflapProcess.isAlive()) {
                    jflapProcess.destroy();
                }
            }));

            // 🔹 If JFLAP ends, exit your program
            int exitCode = jflapProcess.waitFor();
            System.out.println("JFLAP exited with code: " + exitCode);
            System.exit(exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { runJflap(); }

}