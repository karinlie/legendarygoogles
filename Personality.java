import java.util.ArrayList;
import java.util.Collection;

public class Personality implements Describable {
	private String name;
	private String description;
	private String dialogue;
	private ArrayList<Item> items = new ArrayList<>();

	public Personality(String name) {
		this(name, "");
	}
	
	public Personality(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public String getDialogue() {
		return dialogue;
	}
}
