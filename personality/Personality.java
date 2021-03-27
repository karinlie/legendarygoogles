package personality;

import java.util.Collection;
import describable.Describable;
import item.Item;

public interface Personality extends Describable {

	Collection<Item> getItems();

}
