
public class Autonomous extends item{
	World world;
	private int[] dx = {0,1,-1,0};
	private int[] dy = {1,0,0,-1};
	
	public Autonomous(char token, String name, World world) {
		super(token, name);
		this.world = world;
	}

	

	
	@Override
	boolean move(int dx, int dy) {
		return step();
	}

	@Override
	boolean step() {
		int direction = (int)(Math.random()*3+0.5);
		int x = getX()+dx[direction];
		int y = getY()+dy[direction];
		if (x>=world.row||x<0||y>=world.column||y<0) {
			return false;
		}
		item item = world.GetNextPositionItem(x, y);
		
		if (item == null) {
			setX(x);
			setY(y);
			return true;
		}
		if (item.move(dx[direction], dy[direction])) {
			setX(x);
			setY(y);
			return true;
		}
		return false;
	}




}
