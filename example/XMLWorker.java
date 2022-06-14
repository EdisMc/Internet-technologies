package xml;

import java.io.File;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;
import repositories.UserCollection;


public class XMLWorker {
	
	public void writeToXmlFile(String xmlFile,UserCollection collection) throws JAXBException {
		JAXBContext context=JAXBContext.newInstance(UserCollection.class);
		Marshaller m=context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(collection, new File(xmlFile));
	}
 
}
