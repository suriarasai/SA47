package sample.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HeroDTO implements Serializable {
	private String name;
	private String description;
	private String play;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlay() {
		return play;
	}
	public void setPlay(String play) {
		this.play = play;
	}
	@Override
	public String toString() {
		return "HeroDTO [description=" + description + ", name=" + name
				+ ", play=" + play + "]";
	}
	
}
