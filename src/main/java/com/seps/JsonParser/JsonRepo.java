/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seps.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.springframework.stereotype.Component;

/**
 *
 * @author b.walid
 */
@Component
public class JsonRepo {

    private String json;

    public String getJson() {
        if (json == null || json.isEmpty()) {
            loadJSONFromFile();
        }
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String loadJSONFromFile() {

        try {
            URL is = JsonRepo.class.getClassLoader().getResource("json.json");
            InputStream in = new FileInputStream(is.getPath());
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
