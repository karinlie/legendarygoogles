
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Location implements Describable {
	private String name;
	private String description;
	private Set<Item> items = new TreeSet<>();
	private Set<Personality> personalities = new TreeSet<>();
	private Set<Location> adjacentLocations = new TreeSet<>();

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
	
	public void addAdjacentLocation(Location location) {
		if (location == null) {
			return;
		}
		adjacentLocations.add(location);
		location.addAdjacentLocation(this);
	}

	public void removeAdjacentLocation(Location location) {
		if (location == null) {
			return;
		}
		adjacentLocations.remove(location);
		location.removeAdjacentLocation(this);
	}
}
