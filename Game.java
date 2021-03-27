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
		Location forest = new Location("The first forest", "With a delightful scent of spring.");
		forest.addItem(new Item("Rock", "A plain old rock."));
		forest.addItem(new Item("Twig", "About a meter long."));
		Location village = new Location("Stonepeck Village", "Busy workers fill the streets.");
		village.addItem(new Item("Coin", "Probably not worth anything."));
		village.addItem(new Item("Sand", "Dusty."));
		Location home = new Location("Your house", "Small, but functional.");
		home.addItem(new Item("Wall Clock", "Tick tock."));
		home.addItem(new Item("Broom", "To keep the sand outdoors."));
		Location mountains = new Location("The red mountains", "The elderly speak of dragons, deep within the mountains.");
		mountains.addItem(new Item("Sharp Rock", "Could be used as a weapon."));
		mountains.addItem(new Item("Dragon Scales", "Maybe the tales are true?"));
		Location sea = new Location("The shallow sea", "Only skilled seafarers know how to sail these waters.");
		sea.addItem(new Item("Crab", "Looks crabby."));
		sea.addItem(new Item("Sea Shells", "Quite pretty."));
		
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
		
		System.out.println("\nYou may go to: ");
		for (Location l : location.getAdjacentLocations()) {
			System.out.println("\t"+l.getName());
		}
		
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
				}
			}
		}
		scanner.close();
	}

	public Location getStartLocation() {
		return startLocation;
	}
}
