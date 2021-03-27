
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class Personality implements Describable {
	private String name;
	private String description;
	private String dialogue;
	private Set<Item> items = new HashSet<>();

	public Personality(String name) {
		this(name, "");
	}

	public Personality(String name, String description) {
		this(name, description, "");
	}

	public Personality(String name, String description, String dialogue) {
		this.name = name;
		this.description = description;
		this.dialogue = dialogue;
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
