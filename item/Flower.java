package item;

public class Flower implements Item {
	private String name = "Flower";
	private String description = "A lovely red flower.";

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
