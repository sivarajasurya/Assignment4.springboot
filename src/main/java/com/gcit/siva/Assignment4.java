package com.gcit.siva;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Assignment4 {
    static ObjectMapper objectMapper = new ObjectMapper();
    static Map<String,String> file = new HashMap<>();

   public Assignment4(String fileName) throws IOException {
        File jsonFile = new File(fileName);
        List<Country> countries = objectMapper.readValue(jsonFile, new TypeReference<>(){});
        countries.forEach(obj1 -> map(obj1.getName(), obj1.getCode()));
    }

//    public static void main(String[] args) throws IOException {
//        Assignment4 obj = new Assignment4();
//        System.out.println(obj.usingCountryCode("In"));
//
//    }
    public void map(String name, String code){
        file.put(name.toUpperCase(),code.toUpperCase());
    }

    public String usingCountryName(String name){
        String a = file.get(name.toUpperCase());
        if (a == null){
            return "Invalid input";
        }else
            return a;

    }

    public String  usingCountryCode(String code){
        String a = getKey(file, code.toUpperCase());
        if (a == null){
           return "Invalid input" ;
        }else
            return a;

    }
    public <K, V> K getKey(Map<K, V> map, V value)
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
