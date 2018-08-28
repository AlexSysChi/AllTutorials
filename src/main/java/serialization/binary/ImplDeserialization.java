package serialization.binary;

import java.io.*;

public class ImplDeserialization {
    public static void main(String[] args) {
        File file = new File("store.bin");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            DataObject restoreObject = (DataObject) objectInputStream.readObject();
            System.out.println(restoreObject);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
