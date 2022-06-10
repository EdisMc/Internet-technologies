package repositories;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import models.BeautyCompetition;
import xml.XmlWorker;

@XmlRootElement(name="competition")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
	private static String pathToXml = "C:\\Users\\edy_d\\eclipse-workspace\\it2\\src\\main\\webapp\\xml\\beautyStorage.xml";
	private static Repository instance = null;
	
	@XmlElement(name="competition")
	private static Set<BeautyCompetition> competitions = new HashSet<BeautyCompetition>();
	
	private Repository() {
	}
	
	public static Repository getInstance()  {
		if (instance==null) {
			instance= new Repository();
		}
		return instance;
	}
	
	public boolean ifExist(BeautyCompetition competition) {
		return competitions.contains(competition);
	}
	
	public void addParticipant(BeautyCompetition competition) {
		competitions.add(competition);
		updateXMLFile(); 
	}
	

	public static Set<BeautyCompetition> getParticipants() {
		return competitions;
	}


	public static void setSParticipants(Set<BeautyCompetition> competitions) {
		Repository.competitions = competitions;
	}


	public void updateXMLFile() {
		XmlWorker worker = new XmlWorker();
		try {
			worker.writeToXmlFile(pathToXml, this);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
