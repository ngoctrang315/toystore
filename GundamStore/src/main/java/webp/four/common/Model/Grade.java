package webp.four.common.Model;

public class Grade {
	private String grade;
	private String gradeName;
	public Grade() {
		super();
	}
	public Grade(String grade, String gradeName) {
		super();
		this.grade = grade;
		this.gradeName = gradeName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
}
