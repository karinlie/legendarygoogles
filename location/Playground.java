package location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import item.*;
import personality.*;

public class Playground implements Location {
	private String name = "Playground";
	private String description = "Filled with kids.";
	private ArrayList<Item> items = new ArrayList<>(Arrays.asList(new Flower()));
	private ArrayList<Personality> personalities = new ArrayList<>(Arrays.asList(new EasterBunny()));

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
