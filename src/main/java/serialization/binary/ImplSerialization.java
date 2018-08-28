package serialization.binary;

import java.io.*;

public class ImplSerialization {
    public static void main(String[] args) {

        DataObject dataObject = new DataObject();
        dataObject.setMyData("hahaha");

        File file = new File("store.bin");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(dataObject);
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
