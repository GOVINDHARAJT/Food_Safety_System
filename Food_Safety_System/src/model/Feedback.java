package model;

public class Feedback {
	private Long user_mobileno;
	private String username;
	private String food_name;
	private String comment;
	
	public Feedback(Long user_mobileno, String username, String food_name, String comment) {
		this.user_mobileno = user_mobileno;
		this.username = username;
		this.food_name = food_name;
		this.comment = comment;
	}
		
	public Long getUser_mobileno() {
		return user_mobileno;
	}

	public void setUser_mobileno(Long user_mobileno) {
		this.user_mobileno = user_mobileno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
