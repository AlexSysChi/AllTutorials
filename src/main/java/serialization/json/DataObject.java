package serialization.json;

import serialization.xml.CustomObject;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


public class DataObject {

    private int i1 = 1;

    private int i2 = 2;

    private int i3 = 3;

    private int id = 100;

    String myData;

    List<CustomObject> customObjectList = new ArrayList<>();

    public DataObject() {
        this.customObjectList.add(new CustomObject(10));
        this.customObjectList.add(new CustomObject(20));
        this.customObjectList.add(new CustomObject(30));
    }

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                ", i3=" + i3 +
                ", id=" + id +
                ", myData='" + myData + '\'' +
                ", customObjectList=" + customObjectList +
                '}';
    }
}
