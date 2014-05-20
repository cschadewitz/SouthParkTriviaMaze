package southparktriviamaze;

public interface MazeInterface {
	
	public int getRows();
	
	public int getCols();
	
	public CellType getNeighborType(Location location, Direction direction);

}
