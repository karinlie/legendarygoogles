package item;

public class Egg implements Item {
	private String name = "Egg";
	private String description = "A smooth, round egg. Good with bacon.";

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
