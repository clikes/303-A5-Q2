
public class Simulator {
	
	
	
	private static World buildWorld(int row, int column) {
		World world = new World(row, column);
		row--;
		column--;
		for (int i = 0; i < 5; i++) {
			world.add(new Immovable('@', "Immovable"), (int)(Math.random()*row), (int)(Math.random()*column));
		}
		for (int i = 0; i < 3; i++) {
			world.add(new Moveable('+', "Moveable",world), (int)(Math.random()*row), (int)(Math.random()*column));
		}
		for (int i = 0; i < 2; i++) {
			world.add(new Autonomous('0', "Autonomous",world), (int)(Math.random()*row), (int)(Math.random()*column));
		}
		return world;
	}
	public static void main(String[] args) {
		World world = buildWorld(10,10);
		for (int i = 0; i < 100; i++) {
			world.step();
		}
	}
}
