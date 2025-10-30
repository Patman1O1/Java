package com.gradecalc.tests;

import com.gradecalc.Item;
import com.gradecalc.ItemSerializer;
import com.gradecalc.Phys142;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;

public class ItemSerializerTests {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final String DIRECTORY_STRING = "../json/tests";

    private static final Path DIRECTORY = Path.of(DIRECTORY_STRING);

    private static ItemSerializer itemSerializer;

    /* --------------------------------------------------Methods----------------------------------------------------- */
    @BeforeAll
    protected static void createTestDirectory() {
        try {
            Files.createDirectory(DIRECTORY);
        } catch (IOException e) {
            System.out.printf("IOException thrown with message \"%s\"\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("Exception thrown with message \"%s\"\n", e.getMessage());
        }
    }

    @BeforeEach
    protected void createItemSerializer() { ItemSerializerTests.itemSerializer = new ItemSerializer(); }

    @AfterAll
    protected static void cleanUp() {
        try {
            Files.deleteIfExists(DIRECTORY);
        } catch (IOException e) {
            System.out.printf("IOException thrown with message \"%s\"\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("Exception thrown with message \"%s\"\n", e.getMessage());
        }
    }

    /* -----------------------------------------------Method Tests--------------------------------------------------- */
    @Test
    protected void methods__serialize__phys142__lectures() {
        for (Item item : Phys142.lectureItems) {

        }
    }

}
