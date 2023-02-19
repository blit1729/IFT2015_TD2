import java.util.*;

public class Grid {
    
    public class Cell {
        
        // Attributes Cell class
        private int value;
        private Cell left;
        private Cell right;
        private Cell up;
        private Cell down;


        // Constructor Cell class
        public Cell(int value){
            this.value = value;
        }
        
        // Getters Cell class
        public int getValue(){
            return this.value;
        }
        
        public Cell getLeft(){
            return this.left;
        }
        
        public Cell getRight(){
            return this.right;
        }
        
        public Cell getUp(){
            return this.up;
        }
        
        public Cell getDown(){
            return this.down;
        }
        
        
        // Setters Cell class
        public void setLeft(Cell left){
            this.left = left;
        }
        
        public void setRight(Cell right){
            this.right = right;
        }
        
        public void setUp(Cell up){
            this.up = up;
        }
        
        public void setDown(Cell down){
            this.down = down;
        }
    }
    
    // Attributes Grid class
    private Cell[] grid = new Cell[12];

    // Constructor Grid class
    public Grid(){
        
        // Create a random 12 cases grid of cells with the exact amount of
        // each type of cell that we need (1, 5, 10, 25, X)
        
        int compt1 = 0;  // need 4
        int compt5 = 0;  // need 2
        int compt10 = 0; // need 4
        int compt25 = 0; // need 1
        int comptX = 0;  // need 1
        
        for(int i = 0; i < 12; i++){
            int ran;
            Random r = new Random();
            ran = r.nextInt(5);
            
            if(ran == 0 & compt1 < 4){ 
                this.grid[i] = new Cell(1);
                compt1 += 1;
            }
            
            else if(ran == 1 & compt5 < 2){
                this.grid[i] = new Cell(5);
                compt5 += 1;
            }
            
            else if(ran == 2 & compt10 < 4){
                this.grid[i] = new Cell(10);
                compt10 += 1;

            }
            else if(ran == 3 & compt25 < 1){
                this.grid[i] = new Cell(25);
                compt25 += 1;

            }
            else if(ran == 4 & comptX < 1){
                this.grid[i] = new Cell(-1);
                comptX += 1;

            }
            else{ i--; }
        }
        setNeighbours();
    }
    
    // Set the proper 4 neighbours of each cell of the grid
    public void setNeighbours(){
        
        for(int i = 0; i < 12; i++){
            // Set up
            if(i == 0 || i == 1 || i == 2 || i == 3){
                this.grid[i].setUp(null);
            }
            else{
                this.grid[i].setUp(this.grid[i-4]);
            }
            
            // Set down
            if(i == 8 || i == 9 || i == 10 || i == 11){
                this.grid[i].setDown(null);
            }
            else{
                this.grid[i].setDown(this.grid[i+4]);
            }
            
            // Set left
            if(i == 0 || i == 4 || i == 8){
                this.grid[i].setLeft(null);
            }
            else{
                this.grid[i].setLeft(this.grid[i-1]);
            }
            
            // Set right
            if(i == 3 || i == 7 || i == 11){
                this.grid[i].setRight(null);
            }
            else{
                this.grid[i].setRight(this.grid[i+1]);
            }
        }
        
    }
    
    // Getter Grid class
    public Cell[] getGrid(){
        return this.grid;
    }
    

    // Verify if the given cell can be moved to the empty case of the grid. 
    // If so, the move is done
    public boolean move(Cell box){
        System.out.println("Value of box:" + box.getValue());                       // test for debuging
        Cell cell; // Cell where we'll put the neighbour we are comparing
        int vCell; // Value of cell
        Cell theCell = null; // Cell that corresponds to X, if a neighbour
        Cell[] grid = this.grid;
        List<Cell> list = Arrays.asList(grid); // Copy of grid (to change type)
        
        boolean bool = false;
        
        // left
        cell = box.getLeft();
        if(cell != null){
            vCell = cell.getValue();
            if(vCell == -1){
                bool = true;
                theCell = cell;
            }
        }
        
        // right
        cell = box.getRight();
        if(cell != null){
            vCell = cell.getValue();
            if(vCell == -1){
                bool = true;
                theCell = cell;
            }
        }
        
        // up
        cell = box.getUp();
        if(cell != null){
            vCell = cell.getValue();
            if(vCell == -1){
                bool = true;
                theCell = cell;
            }
        }
        
        // down
        cell = box.getDown();
        if(cell != null){
            vCell = cell.getValue();
            if(vCell == -1){
                bool = true;
                theCell = cell;
            }
        }
        
        // we make changes if bool == true
        if(bool){
            int indexCell = list.indexOf(theCell);
            System.out.println("Index of cell: " + indexCell);
            
            int indexBox = list.indexOf(box);
            System.out.println("Index of box: " + indexBox);
            
            this.grid[indexCell] = box;
            this.grid[indexBox] = theCell;
            setNeighbours();
            return true;
        }
        return false;
    }

    // Return true if first row = last row (winning the game)
    public boolean check_complete(){
        Cell[] grid = this.grid;
        
        if(grid[0].getValue() == grid[8].getValue()){
            if(grid[1].getValue() == grid[9].getValue()){
                if(grid[2].getValue() == grid[10].getValue()){
                    if(grid[3].getValue() == grid[11].getValue()){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public void solve_game(){
        // TODO
    }
}
