package eu.ansquare.mctextrandomizer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MyJsonParser {
    public static void parseJson(String filepath){
        Random random = new Random();
        Map<String,String> inputMap = new HashMap<String, String>();

        ObjectMapper objectMapper = new ObjectMapper();



        Map<String, String> resultMap = new HashMap<>();
        LinkedList<String> valueList = new LinkedList<>();
        LinkedList<String> keyList = new LinkedList<>();
        try {

            inputMap = objectMapper.readValue(Files.readAllBytes(Paths.get(filepath)), HashMap.class);

            for (String  key: inputMap.keySet()) {
                keyList.add(key);
                valueList.add(inputMap.get(key));
            }
            for (String key: keyList) {
                int valueint = random.nextInt(valueList.size());
                resultMap.put(key, valueList.get(valueint));
                valueList.remove(valueint);

            }

            String outputFromMap = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultMap);
            System.out.println("result:" + outputFromMap);
            Files.writeString(Paths.get(filepath), outputFromMap);
            System.out.println("File written successfully");

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
