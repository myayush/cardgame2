package com.psl.gems.client;

import java.io.FileWriter;
import java.io.IOException;
import com.psl.gems.play.Pack;

public class TestClient {
    public static void main(String[] args) {
        // Create a full pack
        Pack pack = new Pack();

        // Shuffle the pack
        pack.shuffle();

        // Print the full pack as JSON file
        String fileName = "pack-of-cards.json";
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(pack.toJson());
            System.out.println("Pack written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing pack to file: " + e.getMessage());
        }
    }
}
