package southparktriviamaze;

public interface MazeInterface {
	
	public int getRows();
	
	public int getCols();
	
	public CellType getNeighborType(Direction direction);

}
