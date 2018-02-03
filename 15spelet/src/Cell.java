import javax.swing.*;

public class Cell extends JButton
{
	private static final long serialVersionUID = 1L;
	//The row for the cell
    private int row;
    //The column for the cell
    private int col;

    public Cell(String s,int ccol,int crow)
    {
       super(s);
       row= crow;
       col = ccol;
    }

    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
}
