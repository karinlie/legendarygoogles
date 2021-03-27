package describable;

public interface Describable {

	public static String describe(Describable describable) {
		return describable.getName() + ": " + describable.getDescription();
	}

	public String getName();

	public String getDescription();

}
