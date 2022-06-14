package repositories;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import models.User;
import xml.XMLWorker;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCollection {
	@XmlElement(name="collection")
	private static ArrayList<User>collection;
	private static UserCollection instance;
	private String fileName="";
	
	public void addUser(User user) {
		collection.add(user);
		update();
	}
	public boolean checkUser(User user) {
		return collection.contains(user);
	}
	public static UserCollection getInstance() {
		if(instance==null) {
			collection=new ArrayList<User>();
			instance=new UserCollection();
		}
		return instance;
	}
	public void update() {
		XMLWorker worker=new XMLWorker();
		try {
			worker.writeToXmlFile(fileName, this);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<User> getList() {
		return collection;
	}
 
}