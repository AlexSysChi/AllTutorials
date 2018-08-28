package serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class MarshallingToJson {

    public static void main(String[] args) {
        DataObject dataObject = new DataObject();
        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataObject);

        File file = new File("store.json");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        DataObject restoredDataObject = gson.fromJson(json, DataObject.class);
        System.out.println(restoredDataObject);
    }
}
