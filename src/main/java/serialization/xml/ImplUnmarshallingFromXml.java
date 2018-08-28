package serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ImplUnmarshallingFromXml {
    public static void main(String[] args) {
        File file = new File("store.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataObject.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            DataObject dataObject = (DataObject)unmarshaller.unmarshal(file);
            System.out.println(dataObject);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
