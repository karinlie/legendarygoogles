package location;

import java.util.Collection;
import item.Item;
import personality.Personality;

public interface Location {
	
	String getName();

	String getDescription();
	
	Collection<Item> getItems();

	Collection<Personality> getPersonalities();
}
