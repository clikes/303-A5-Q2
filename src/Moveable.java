
public class Moveable extends item{
	World world;
	

	public Moveable(char token, String name, World world) {
		super(token, name);
		this.world = world;
	}


	
	boolean step(){
		return false;
	}




	@Override
	boolean move(int dx, int dy) {
		int movex = getX()+dx;
		int movey = getY()+dy;
		System.out.println(dx+" "+dy);
		if (movex>=world.row||movex<0||movey>=world.column||movey<0) {
			return false;
		}
		
		item item = world.GetNextPositionItem(movex, movey);
		
		
		System.out.println(getX());
		if (item == null) {
			setX(movex);
			setY(movey);
			return true;
		}
		
		if (item.move(dx, dy)) {
			setX(movex);
			setY(movey);
			return true;
		}
		return false;
	}
}
