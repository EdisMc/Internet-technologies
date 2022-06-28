package models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Participant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String ID;
	private String nameSch;
	private String nameNom;
	private String votes;
	
	public Participant() {
	}

	public Participant(String iD, String nameSch, String nameNom, String votes) {
		super();
		ID = iD;
		this.nameSch = nameSch;
		this.nameNom = nameNom;
		this.votes = votes;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNameSch() {
		return nameSch;
	}

	public void setNameSch(String nameSch) {
		this.nameSch = nameSch;
	}

	public String getNameNom() {
		return nameNom;
	}

	public void setNameNom(String nameNom) {
		this.nameNom = nameNom;
	}


	public String getVotes() {
		return votes;
	}

	public void setVotes(String votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Participant ID=" + ID + ", nameSch=" + nameSch + ", nameNom=" + nameNom + ", votes=" + votes;
	}
	
	

}
