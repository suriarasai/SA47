package edu.iss.cats.javabeans;

public class Approve {
	
	private String decision;
	private String comment;
	public Approve() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Approve [decision=" + decision + ", comment=" + comment + "]";
	}
	

}
