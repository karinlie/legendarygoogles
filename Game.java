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
		Location village = new Location("Stonepeck Village", "Busy workers fill the streets.");
		Location home = new Location("Your house", "Small, but functional.");
		Location mountains = new Location("The red mountains", "The elderly speak of dragons, deep within the mountains.");
		Location sea = new Location("The shallow sea", "Only skilled seafarers know how to sail these waters.");

		home.connectLocation(village);
		village.connectLocation(forest);
		forest.connectLocation(mountains);
		forest.connectLocation(sea);

		startLocation = home;
	}

	private void play(Location location) {
		System.out.println("\n\nYour current location:\n" + Describable.describe(location));
		System.out.println("\nYou may go to: ");
		for (Location l : location.getAdjacentLocations()) {
			System.out.println(l.getName());
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String input = scanner.nextLine();
			if (input.contains("endgame")) {
				break;
			}
			List<Location> nextLocations = location.getAdjacentLocations().stream().filter(l -> l.getName().toLowerCase().contains(input)).collect(Collectors.toList());
			if (0 < nextLocations.size()) {
				play(nextLocations.get(0));
				break;
			}
		}
		scanner.close();
	}

	public Location getStartLocation() {
		return startLocation;
	}
}
