
public class Item implements Describable {
	private String name;
	private String description;

	public Item(String name, String descripton) {
		this.name = name;
		this.description = descripton;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
