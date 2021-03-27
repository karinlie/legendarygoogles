import item.*;
import location.*;
import personality.*;
import describable.*;

class Main {
	public static void main(String[] args) {
		Describable playground = new Playground();
		System.out.println(Describable.describe(playground));
	}
}
