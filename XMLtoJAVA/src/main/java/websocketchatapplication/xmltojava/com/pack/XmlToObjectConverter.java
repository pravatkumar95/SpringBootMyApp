package websocketchatapplication.xmltojava.com.pack;

import jakarta.xml.bind.*;
import java.io.File;

public class XmlToObjectConverter {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("/static/data.xml"); // Path to your XML file
            JAXBContext jaxbContext = JAXBContext.newInstance(MethodResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MethodResponse methodResponse = (MethodResponse) jaxbUnmarshaller.unmarshal(xmlFile);

            // Print the Java object
            Params params = methodResponse.getParams();
            Param param = params.getParam();
            Value value = param.getValue();
            Struct struct = value.getStruct();
            Member[] members = struct.getMember();
            for (Member member : members) {
                System.out.println("Name: " + member.getName());
                // Assuming there's always a value
                System.out.println("Value: " + member.getValue());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

