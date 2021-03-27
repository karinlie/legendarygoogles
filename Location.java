
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Location implements Describable {
	private String name;
	private String description;
	private Set<Item> items = new HashSet<>();
	private Set<Personality> personalities = new HashSet<>();
	private Set<Location> adjacentLocations = new HashSet<>();

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
	
	public Collection<Location> getAdjacentLocations() {
		return (Collection<Location>) adjacentLocations;
	}

	public void connectLocation(Location location) {
		if (location == null || location == this || adjacentLocations.contains(location)) {
			return;
		}
		adjacentLocations.add(location);
		location.connectLocation(this);
	}

	public void diconnectLocation(Location location) {
		if (location == null || location == this || !adjacentLocations.contains(location)) {
			return;
		}
		adjacentLocations.remove(location);
		location.diconnectLocation(this);
	}
}
