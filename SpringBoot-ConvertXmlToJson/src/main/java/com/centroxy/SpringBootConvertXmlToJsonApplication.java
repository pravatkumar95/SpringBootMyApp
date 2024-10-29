package com.centroxy;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@SpringBootApplication
public class SpringBootConvertXmlToJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConvertXmlToJsonApplication.class, args);
		
//		  try {
//	            String filePath = "D:\\Prepaid-development\\IN-Responsess.xml";
//	            String json = convertXmlFileToJson(filePath);
//	            System.out.println(json);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } catch (ParserConfigurationException | SAXException e) {
//              throw new RuntimeException(e);
//          }
//    }
//
//	    public static String convertXmlFileToJson(String filePath) throws IOException, ParserConfigurationException, SAXException {
//	        File xmlFile = new File(filePath);
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
//			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//			Document document = documentBuilder.parse(xmlFile);
//			document.getDocumentElement().normalize();
//
//			ObjectMapper xmlMapper = new XmlMapper();
//	        JsonNode node = xmlMapper.readTree(xmlFile);
//	        ObjectMapper jsonMapper = new ObjectMapper();
//	        return jsonMapper.writeValueAsString(node);
//	    }
		
		
		try {
            File xmlFile = new File("/static/employee.xml"); // Path to your XML file
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(xmlFile);
            
            // Print the user object
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
		
	}


