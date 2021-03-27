import item.*;
import location.*;
import personality.*;
import describable.*;

class Main {
	public static void main(String[] args) {
		Location playground = new Location("Playground", "Filled with kids!");
		System.out.println(Describable.describe(playground));

		for (Personality personality : playground.getPersonalities()) {
			System.out.println(Describable.describe(personality));

			for (Item item : personality.getItems()) {
				System.out.println(Describable.describe(item));
			}
		}

		for (Item item : playground.getItems()) {
			System.out.println(Describable.describe(item));
		}
	}
}
