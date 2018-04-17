import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class World
{
	private item[][] map;
	public final int row, column;
	JFrame frame;
	JLabel[][] labels;
	ArrayList<item> itemsList; 	
	public World(int row, int column) {
		this.row = row;
		this.column = column;
		map = new item[row][column];
		itemsList = new ArrayList<>();
		for (item[] items : map) {
			for (item item : items) {
				item = null;
			}
		}
		frame = new JFrame("World Display");
		frame.setSize(50 * row, 50 * column);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(column,row, 5, 5));
		frame.setVisible(true);
		labels = new JLabel[row][column];
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < column; y++) {
				JLabel a = new JLabel("*");
				a.setHorizontalAlignment(JLabel.CENTER);
				frame.add(a);
				labels[x][y] = a;
			}
		}
	}
		
	
	public void add(item item,int x,int y){
		if (map[x][y] == null) {
			map[x][y]= item;
			itemsList.add(item);
			item.setX(x);
			item.setY(y);
		}
		 
	}
	
	public void step(){
		for (item[] items : map) {
			for (item item : items) {
				if (item != null) item.step();
				display();
			}
		}
	}
	
	
	public item GetNextPositionItem(int x,int y){
		return map[x][y];
	}
	
//	public boolean StepItem(item item){
//		if (item == null) return true;
//		
//		if (item.getName().equals("Immovable")) {
//			return false;
//		}
//		if (item.getName().equals("Moveable")) {
//			return false;
//		}
//		if (item.getName().equals("Autonomous")) {
//			int direction = (int)(Math.random()*3+0.5);
//			int x = item.getX()+dx[direction];
//			int y = item.getY()+dy[direction];
//			if (ItemMove(map[x][y])) {
//				item.setX(x);
//				item.setY(y);
//				return true;
//			}
//		}
//		return false;
//	}
	
//	public boolean ItemMove(item item){
//		if (item == null) return true;
//		
//		if (item.getName().equals("Immovable")) {
//			return false;
//		}
//		if (item.getName().equals("Moveable")) { 
//			return false;
//		}
//		if (item.getName().equals("Autonomous")) {
//			int direction = (int)(Math.random()*3+0.5);
//			int x = item.getX()+dx[direction];
//			int y = item.getY()+dy[direction];
//			if (ItemMove(map[x][y])) {
//				item.setX(x);
//				item.setY(y);
//				return true;
//			}
//		}
//		return false;
//	}
	
	public void display()
	{
		//System.out.println(1);
		char tokens[][] = new char[row][column];
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < column; y++) {
				tokens[x][y] = ' ';
			}
		}
		for (item i : itemsList) {
			tokens[i.getX()][i.getY()] = i.getToken();
		}
		
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < column; y++) {
				labels[x][y].setText(""+tokens[x][y]);
				//System.out.print(tokens[x][y]);
			}
			//System.out.println(System.currentTimeMillis());
		}
	}
	
}