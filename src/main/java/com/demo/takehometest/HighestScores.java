package com.demo.takehometest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HighestScores {

    public static void main(String[] args) throws IOException {
        if(args.length != 2){
            System.err.println("Usage: java HighestScores <input_file> <N records>");
            System.exit(1);
        }
        String filePath = args[0];
        int numRecords = Integer.parseInt(args[1]);

        List<Records> topRecords = readAndOutputTopRecords(filePath, numRecords);
        for(Records record: topRecords){
            System.out.println(record.toJson());
        }

    }

    private static List<Records> readAndOutputTopRecords(String filePath, int numRecords) throws IOException {
        //read the file and output the top N records
        List<Records> records= new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(" : ", 2);
                    if (parts.length != 2) {
                        System.err.println("Invalid record: " + line);
                        continue;
                    }
                    int score = Integer.parseInt(parts[0]);
                    JSONObject recordJson = new JSONObject(parts[1]);

                    if (!recordJson.has("id")) {
                        System.err.println("Record without 'id' field: " + line);
                        continue;
                    }
                    String id = recordJson.getString("id");
                    records.add(new Records(score, id));
                } catch (JSONException | NumberFormatException e) {
                    System.err.println("Error parsing record: " + line);
                }
            }
        }
        //sort score descending order:
        records.sort((r1, r2) -> Integer.compare(r2.getScore(), r1.getScore()));
        return records.subList(0, Math.min(numRecords, records.size()));
    }
}
