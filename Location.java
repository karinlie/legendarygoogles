
import java.util.ArrayList;
import java.util.Collection;

public class Location implements Describable {
	private String name;
	private String description;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Personality> personalities = new ArrayList<>();

	public Location(String name) {
		this(name, "");
	}

	public Location(String name, String description) {
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

	public Collection<Personality> getPersonalities() {
		return personalities;
	}
	
}
