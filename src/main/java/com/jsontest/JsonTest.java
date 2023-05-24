package com.jsontest;

import org.json.*;

public class JsonTest {

    public void printXmlFromJson(String jsonStr){
        JSONObject json = new JSONObject(jsonStr);
        System.out.println(json);
        String xml = XML.toString(json);
        System.out.println(xml);
    }
}
