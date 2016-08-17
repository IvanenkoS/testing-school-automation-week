package lv.ctco.ts.smoke.restexample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by nikolajsokunevs on 17/08/16.
 */
public class JsonUtils {

    private static JsonReader jsonReader;
    private static Type listOfTestObject = new TypeToken<List<Cat>>() {
    }.getType();

    public static void main(String[] args) throws Exception {

        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader("src/main/resources/cats.json"));
        Type listOfTestObject = new TypeToken<List<Cat>>() {
        }.getType();

        System.out.println("111" + jsonReader.toString());
        List<Cat> cats = gson.fromJson(jsonReader,
                listOfTestObject);


        try (Writer writer = new FileWriter("src/main/resources/cats_new.json")) {

            gson.toJson(cats, writer);
        }


    }

    public static List<Cat> getCats() {
        Gson gson = new Gson();
        try {
            jsonReader = new JsonReader(new FileReader("src/main/resources/cats.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gson.fromJson(jsonReader, listOfTestObject);
    }

    public static void saveToFile(List<Cat> cats) {
        Gson gson = new Gson();
        try {
            try (Writer writer = new FileWriter("src/main/resources/cats.json")) {

                gson.toJson(cats, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
