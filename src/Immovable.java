
public class Immovable extends item{

	public Immovable(char token, String name) {
		super(token, name);
		// TODO Auto-generated constructor stub
	}

	public void step(int x, int y){
		return;
	}

	@Override
	boolean move(int dx, int dy) {
		return false;
	}

	@Override
	boolean step() {
		return false;
	}


}
