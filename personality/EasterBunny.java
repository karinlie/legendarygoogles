package personality;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import item.Item;
import item.Egg;
import item.ChocolateEgg;

public class EasterBunny implements Personality {
	private String name = "Easter Bunny";
	private String description = "A cute bunny with a surprisingly large amount of eggs.";
	private ArrayList<Item> items = new ArrayList<>(Arrays.asList(new Egg(), new ChocolateEgg()));

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Collection<Item> getItems() {
		return items;
	}
}
