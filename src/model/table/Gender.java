package model.table;

public class Gender {
	private Integer idgender;
	private String gender;
	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gender(String gender) {
		super();
		this.gender = gender;
	}
	public Integer getIdgender() {
		return idgender;
	}
	public void setIdgender(Integer idgender) {
		this.idgender = idgender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
