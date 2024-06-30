package model.table;

public class Grade {
	private Integer idgrade;
	private String grade;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String grade) {
		super();
		this.grade = grade;
	}
	public Integer getIdgrade() {
		return idgrade;
	}
	public void setIdgrade(Integer idgrade) {
		this.idgrade = idgrade;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
