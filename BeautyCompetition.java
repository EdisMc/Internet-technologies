package models;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="competition")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeautyCompetition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String name;
	public String lastName;
	public String age;
	public String city;
	
	BeautyCompetition() {
	}

	public BeautyCompetition(String name, String lastName, String age, String city) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, city, lastName, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeautyCompetition other = (BeautyCompetition) obj;
		return Objects.equals(city, other.city);
	}
	
	@Override
	public String toString() {
		return "Име: " + name + ", " + "Фамилия: " + lastName + "" + "!";
	}

}
