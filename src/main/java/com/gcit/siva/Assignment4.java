package com.gcit.siva;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Assignment4 {
    static Scanner get = new Scanner(System.in);
    static ObjectMapper objectMapper = new ObjectMapper();
    static Map<String,String> file = new HashMap<>();
    public static void main(String[] args) throws IOException {
        File jsonFile = new File(".\\jason\\countries.json");
        List<Country> countries = objectMapper.readValue(jsonFile, new TypeReference<>(){});
        countries.forEach(obj1 -> map(obj1.getName(), obj1.getCode()));

    }


    public static void map(String name, String code){
        file.put(name.toUpperCase(),code.toUpperCase());
    }

    public static String usingCountryName(String name){
        String a = file.get(name.toUpperCase());
        if (a == null){
            return "Invalid input";
        }else
            return a;

    }

    public static String  usingCountryCode(String code){
        String a = getKey(file, code.toUpperCase());
        if (a == null){
           return "Invalid input" ;
        }else
            return a;

    }
    public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
