package serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomObject {
    @XmlElement
    private int i;

    public CustomObject() {
    }

    public CustomObject(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "i=" + i +
                '}';
    }
}
