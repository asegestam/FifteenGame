
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class Game extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Cell blank;
 
    public Game()
    {
    	super("15 game");
        makeFrame();
    }
    /*Creates the frame*/
    public void makeFrame()
    {
       Container contentPane = this.getContentPane();
       this.pack();
       this.setSize(400,400);
       this.setResizable(false);
       contentPane.setLayout(new GridLayout(4,4,3,3));
       this.setLocationRelativeTo(null);
       createButtons();
       this.setVisible(true);
    }
    
    public void init() {
    	this.revalidate();
    	this.repaint();
    }
    /*Creates the buttons as cells with the right markings and with listeners*/
    private void createButtons() {
    	Container contentPane = this.getContentPane();
    	GameGenerator generator = new GameGenerator(4);
        int col;
        int row;
        int j = 0;
        for(int i : generator)
        {
        	col = j%4;
            row = j/4;
            j++;
            JButton button;
            if(i!=0) {
            	button = new Cell(Integer.toString(i),col,row);
            }
            else
            {
            	blank = new Cell("",col,row);
                button = blank;
            }
            button.addActionListener(
            (ActionEvent e)->{actionHandler(e);});
            contentPane.add(button);
        }
    }
    /*Handles the clicked action*/
    private void actionHandler(ActionEvent e){
        Cell clickedCell = (Cell)e.getSource();
        if(isNeighbor(clickedCell))
        {
        	swapCell(clickedCell);
        }
        else
        {
           Toolkit.getDefaultToolkit().beep();  
        }
        
    }
    /*Swaps the clicked cell with the blank cell */
    private void swapCell(Cell clicked) {
        blank.setText(clicked.getText());
        clicked.setText("");
        blank = clicked;
    }
    /*Checks if the clicked cell is neighbor with the blank cell*/
    private boolean isNeighbor(Cell clicked)
    {
        int clickedRow = clicked.getRow();
        int clickedCol = clicked.getCol();
        int blankRow = blank.getRow();
        int blankCol = blank.getCol();

        if((clickedRow == blankRow) && ((clickedCol == blankCol-1 || clickedCol == blankCol+1))){
        	return true;
        }

        else if((clickedCol == blankCol) && ((clickedRow == blankRow-1 || clickedRow == blankRow+1))){
        	return true;
        	}
        return false;
    }

}
