package personality;

import java.util.ArrayList;
import java.util.Collection;
import describable.Describable;
import item.Item;

public class Personality implements Describable {
	private String name;
	private String description;
	private String dialogue;
	private ArrayList<Item> items = new ArrayList<>();

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
