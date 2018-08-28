package serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "dataObj")
public class DataObject {
    @XmlElement
    private int i1;

    @XmlTransient   // will be skipped in xml ???
    private Integer i2;

    @XmlElement(required = true, name = "i3")
    private int i3;

    @XmlAttribute
    private int id = 100;

    @XmlElement
    String myData;

    @XmlElement
    @XmlElementWrapper(name = "elems")
    // DON'T use Arrays.asList here,  will produce java.lang.UnsupportedOperationException...
    List<CustomObject> customObjectList = new ArrayList<>();


    public DataObject() {
        this.i1 = 1;
        this.i3 = 3;
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
