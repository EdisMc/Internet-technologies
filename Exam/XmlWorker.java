package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import repositories.PartRepository;

public class XmlWorker {
	
	public void writeToXmlFile(String pathToXml,PartRepository instance) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(PartRepository.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(instance, new File(pathToXml));
	}

}
