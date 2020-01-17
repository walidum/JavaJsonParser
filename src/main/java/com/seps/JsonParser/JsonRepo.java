/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seps.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public String getJson() throws IOException {
        if (json == null || json.isEmpty()) {
            loadJSONFromFile();
        }
        return json;
    }

    public String loadJSONFromFile() throws FileNotFoundException, IOException {
        URL url = JsonRepo.class.getClassLoader().getResource("json.json");
        InputStream is = new FileInputStream(url.getPath());
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");
        return json;
    }
}
