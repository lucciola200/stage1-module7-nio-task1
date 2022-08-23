package com.epam.mjc.nio;

import java.io.*;
import java.util.Locale;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String keyVal = bufferedReader.readLine();
            while (keyVal != null) {
                String[] parts = keyVal.split(": ", 2);
                String key = parts[0].toLowerCase(Locale.ROOT);
                if (key.equals("name")) {
                    profile.setName(parts[1]);
                } else if (key.equals("age")) {
                    profile.setAge(Integer.parseInt(parts[1]));
                } else if (key.equals("email")) {
                    profile.setEmail(parts[1]);
                } else if (key.equals("phone")) {
                    profile.setPhone(Long.parseLong(parts[1]));
                }

                keyVal = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("das");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
