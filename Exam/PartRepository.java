package repositories;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import models.Participant;
import xml.XmlWorker;

@XmlRootElement(name = "personalities")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartRepository {
	private static PartRepository instance = null;
	
	@XmlElement(name = "people")
	private static Set<Participant> participants = new HashSet<Participant>();
	
	private static String pathToXMLFile = "C:\\Users\\edy_d\\eclipse-workspace\\examIT\\src\\main\\webapp\\xmlData\\storage.xml";
	
	private PartRepository() {
	}
	
	public static PartRepository getInstance() {
		if (instance == null) {
			instance = new PartRepository();
		}
		return instance;
	}
	
	public boolean ifExist(Participant participant) {
		return participants.contains(participants);
	}
	
	public void addParticipant(Participant participant) {
		participants.add(participant);
		XmlWorker xml = new XmlWorker();
		try {
			xml.writeToXmlFile(pathToXMLFile, this);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void addVotes(Participant participant) {
		participant.setVotes(participant.getVotes() + 1);
	}

	public static Set<Participant> getParticipants() {
		return participants;
	}

	public static void setParticipants(Set<Participant> participants) {
		PartRepository.participants = participants;
	}
	

}
