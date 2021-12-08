package com.schwich;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        int imageWidth = 256;
        int imageHeight = 256;

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("image.ppm"));
        writer.write("P3");
        writer.newLine();
        writer.write(imageWidth + " " + imageHeight);
        writer.newLine();
        writer.write(String.valueOf(255));
        writer.newLine();

        for (int j = imageHeight - 1; j >= 0; --j) {
            System.out.println("Scanlines remaining: " + j);
            for (int i = 0; i < imageWidth; ++i) {
                double r = (double) i / (imageWidth - 1);
                double g = (double) j / (imageHeight - 1);
                double b = 0.25;

                Vector3 pixelColor = new Vector3(r, g, b);

                writer.write(pixelColor.toStringAsColor());
                writer.newLine();
            }
        }

        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime) / 1000000;
        System.out.println("Render took: " + durationInMillis + "ms");
    }
}
