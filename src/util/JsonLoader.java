package util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonLoader {
    private  static JsonLoader jsonLoader=new JsonLoader();
    private JsonConfig jsonConfig;

    public static JsonLoader getInstance(){
        return jsonLoader;
    }

    public JsonConfig getJsonConfig() {
        return jsonConfig;
    }

    public void setJsonConfig(JsonConfig jsonConfig) {
        this.jsonConfig = jsonConfig;
    }

    private JsonLoader(){
        ObjectMapper objectMapper=new ObjectMapper();
        String address="src/assets/jsonFile/dataBoard.json";
        File file = new File(address);
        try {
            jsonConfig=objectMapper.readValue(file,JsonConfig.class);
        } catch (IOException e) {
            System.out.println(" i can not read json file sorry:))");
            e.printStackTrace();
        }

    }
}
