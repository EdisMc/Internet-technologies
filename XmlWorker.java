package xml;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import repositories.Repository;

public class XmlWorker {

	public XmlWorker() {
	}
	
	public void writeToXmlFile(String pathToXml,Repository instance) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(instance, new File(pathToXml));
	}

}
