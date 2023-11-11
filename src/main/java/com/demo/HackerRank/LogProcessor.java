package com.demo.HackerRank;

import java.io.*;
import java.util.Scanner;

public class LogProcessor {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("Enter the filename: ");
        String filename = scan.nextLine();

        processLogFile(filename);
    }

    public static void processLogFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String outputFilename = "bytes_" + filename;
            int numLargeResponses = 0;
            long totalBytes = 0;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains("GET")) {
                        String[] parts = line.split(" ");
                        if (parts.length >= 10) {
                            try {
                                int bytes = Integer.parseInt(parts[parts.length - 1]);
                                if (bytes > 5000) {
                                    numLargeResponses++;
                                    totalBytes += bytes;
                                }
                            } catch (NumberFormatException e) {
                                // Ignore lines that don't have a valid byte count
                            }
                        }
                    }
                }

                // Write the results to the output file
                bw.write(Integer.toString(numLargeResponses));
                bw.newLine();
                bw.write(Long.toString(totalBytes));
            }

            System.out.println("Processing complete. Output file: " + outputFilename);
        }
    }
}