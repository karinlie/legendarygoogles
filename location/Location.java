package location;

import java.util.Collection;
import item.Item;

public interface Location {
	
	String getName();

	String getDescription();
	
	Collection<Item> getItems();
}
