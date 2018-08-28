package serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ImplMarshalingToXml {
    static final String PACKAGE = DataObject.class.getPackage().getName();

    public static void main(String[] args) {

        DataObject dataObject = new DataObject();
        dataObject.setMyData("gogogo");
        File file = new File("store.xml");

        try {
            //JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE);   // for ObjectFactory using
            JAXBContext jaxbContext = JAXBContext.newInstance(DataObject.class); // for jaxb.index using
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            marshaller.marshal(dataObject, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
