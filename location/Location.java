package location;

import java.util.Collection;

import describable.Describable;
import item.Item;
import personality.Personality;

public interface Location extends Describable {

	Collection<Item> getItems();

	Collection<Personality> getPersonalities();
	
}
