package serialization.binary;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class DataObject extends NonSerializable implements Serializable {
    private static final long serialVersionUID = 6815282131150899171L;

    private int i = 5;
    private String s = "aaa";
    private transient String[] def = {"a", "b", "c"};
    private CustomObject customObject = new CustomObject();

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject(); // impl default serialization
        objectOutputStream.writeObject(getMyData());

    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();  // impl default deserialization
        setMyData((String)objectInputStream.readObject());
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", def=" + Arrays.toString(def) +
                ", customObject=" + customObject +
                '}';
    }
}
