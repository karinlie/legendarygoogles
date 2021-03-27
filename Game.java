import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Game {
	private Location startLocation;

	public static void main(String[] args) {
		Game game = new Game();
		game.initializeWorld();
		game.play(game.getStartLocation());
	}

	private void initializeWorld() {
		Location home = new Location("Your house", "Small, but functional.");
		home.addItem(new Item("Wall Clock", "Tick tock."));
		home.addItem(new Item("Broom", "To keep the sand outdoors."));
		home.addPersonality(new Personality("Poppy", "Your dog.", "Voof!"));
		
		Location village = new Location("Stonepeck Village", "Busy workers fill the streets.");
		village.addItem(new Item("Coin", "Probably not worth anything."));
		village.addItem(new Item("Sand", "Dusty."));
		village.addPersonality(new Personality("Hubert", "The village merchant.", "Are you in the need of a dragontooth, sir?"));
		
		Location forest = new Location("The first forest", "With a delightful scent of spring.");
		forest.addItem(new Item("Rock", "A plain old rock."));
		forest.addItem(new Item("Twig", "About a meter long."));
		forest.addPersonality(new Personality("A bird", "A medium sized bird with quite small wings."));
		
		Location mountains = new Location("The red mountains", "The elderly speak of dragons, deep within the mountains.");
		mountains.addItem(new Item("Sharp Rock", "Could be used as a weapon."));
		mountains.addItem(new Item("Dragon Scales", "Maybe the tales are true?"));
		mountains.addPersonality(new Personality("A dark silhouette", "No light escapes this creature.", "sshhh..."));
		
		Location sea = new Location("The shallow sea", "Only skilled seafarers know how to sail these waters.");
		sea.addItem(new Item("Crab", "Looks crabby."));
		sea.addItem(new Item("Sea Shells", "Quite pretty."));
		sea.addPersonality(new Personality("A fisherman", "This man is probably never indoors.", "Hey! Would you like a fish?"));

		home.connectLocation(village);
		village.connectLocation(forest);
		forest.connectLocation(mountains);
		forest.connectLocation(sea);

		startLocation = home;
	}

	private void play(Location location) {
		System.out.println("\n\nYour current location:\n\t" + Describable.describe(location));

		System.out.println("\nPersonalities at this location: ");
		for (Personality p : location.getPersonalities()) {
			System.out.println("\t"+p.getName());
		}
		
		System.out.println("\nItems at this location: ");
		for (Item i : location.getItems()) {
			System.out.println("\t"+i.getName());
		}
		
		System.out.println("\nAdjacent locations: ");
		for (Location l : location.getAdjacentLocations()) {
			System.out.println("\t"+l.getName());
		}
		
		System.out.println("\n/end, /restart,\ninspect, talk or go\n");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.nextLine();

			if (input.contains("/end")) {
				break;
			}
			if (input.contains("/restart")) {
				play(startLocation);
				break;
			}

			if (input.startsWith("go")) {
				String word = input.substring(2).trim();
				List<Location> nextLocations = location.getAdjacentLocations().stream().filter(l -> l.getName().toLowerCase().contains(word)).collect(Collectors.toList());
				if (0 < nextLocations.size()) {
					play(nextLocations.get(0));
					break;
				}
			}
			else if (input.startsWith("inspect")) {
				String word = input.substring(7).trim();
				List<Item> items = location.getItems().stream().filter(l -> l.getName().toLowerCase().contains(word)).collect(Collectors.toList());
				if (0 < items.size()) {
					System.out.println(Describable.describe(items.get(0)));
				}
			}
			else if (input.startsWith("talk")) {
				String word = input.substring(4).trim();
				List<Personality> personalities = location.getPersonalities().stream().filter(l -> l.getName().toLowerCase().contains(word)).collect(Collectors.toList());
				if (0 < personalities.size()) {
					System.out.println(Describable.describe(personalities.get(0)));
					System.out.println(personalities.get(0).getDialogue());
				}
			}
		}
		scanner.close();
	}

	public Location getStartLocation() {
		return startLocation;
	}
}
