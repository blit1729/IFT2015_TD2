public class App
{
	public static void main(String[] args) throws Exception {
		Grid grid = new Grid();
		printGrid(grid);
		
		System.out.println(grid.move(grid.getGrid()[2]) + "\n\n");
		printGrid(grid);
		System.out.println(grid.check_complete());
		
		System.out.println(grid.move(grid.getGrid()[8]) + "\n\n");
		printGrid(grid);
		System.out.println(grid.check_complete());	
	}
	
	// print the grid
	public static void printGrid(Grid grid){
		    int i0 = grid.getGrid()[0].getValue();
		    int i1 = grid.getGrid()[1].getValue();
		    int i2 = grid.getGrid()[2].getValue();
		    int i3 = grid.getGrid()[3].getValue();
		    int i4 = grid.getGrid()[4].getValue();
		    int i5 = grid.getGrid()[5].getValue();
		    int i6 = grid.getGrid()[6].getValue();
		    int i7 = grid.getGrid()[7].getValue();
		    int i8 = grid.getGrid()[8].getValue();
		    int i9 = grid.getGrid()[9].getValue();
		    int i10 = grid.getGrid()[10].getValue();
		    int i11 = grid.getGrid()[11].getValue();
		
		System.out.printf(" | %s | %s | %s | %s |\n", i0, i1, i2, i3);
		
		System.out.printf(" | %s | %s | %s | %s |\n", i4, i5, i6, i7);
		
		System.out.printf(" | %s | %s | %s | %s |\n\n\n", i8, i9, i10, i11);
	}
}
