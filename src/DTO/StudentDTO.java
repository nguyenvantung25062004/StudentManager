package DTO;

import java.util.Date;

public class StudentDTO {
	private int conductScore;
	private String ID,name, classID, citizenID,phoneNumber;
	private int province_id;
	private Date dateOfBirth;
	private boolean gender;
	private float academicScore;
	
	public StudentDTO(String iD, int conductScore, String name, String classID, int province_id, Date dateOfBirth,
			boolean gender, float academicScore, String citizenID, String phoneNumber) {
		super();
		ID = iD;
		this.conductScore = conductScore;
		this.name = name;
		this.classID = classID;
		this.province_id = province_id;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.academicScore = academicScore;
		this.citizenID = citizenID;
		this.phoneNumber = phoneNumber;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getConductScore() {
		return conductScore;
	}

	public void setConductScore(int conductScore) {
		this.conductScore = conductScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String position) {
		this.classID = position;
	}

	public int getProvince_id() {
		return province_id;
	}

	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public float getAcademicScore() {
		return academicScore;
	}

	public void setAcademicScore(float academicScore) {
		this.academicScore = academicScore;
	}
	
	

	public String getCitizenID() {
		return citizenID;
	}

	public void setCitizenID(String citizenID) {
		this.citizenID = citizenID;
	}
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "StudentDTO [conductScore=" + conductScore + ", ID=" + ID + ", name=" + name + ", classID=" + classID
				+ ", citizenID=" + citizenID + ", phoneNumber=" + phoneNumber + ", province_id=" + province_id
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", academicScore=" + academicScore + "]";
	}

	

}
