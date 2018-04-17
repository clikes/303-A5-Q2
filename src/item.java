
public abstract class item {
	private String name;
	private char token;
	private int x, y;
	public char getToken(){
		return token;
	}
	public item(char token, String name) {
		this.token = token;
		this.name = name;
		x = 0;
		y = 0;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	abstract boolean move(int dx, int dy);
	abstract boolean step();
}
