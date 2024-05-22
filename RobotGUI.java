import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RobotGUI extends JFrame implements ActionListener
{

    private JPanel header = new JPanel();
    private JPanel grid = new JPanel(); 
    private JPanel buttons = new JPanel(); 
    private JTextField [][]cell= new JTextField [RobotMonitor.MAX][RobotMonitor.MAX]; // the cells
    // these next label provides a border around the cells
    private JLabel move = new JLabel("NO MOVE", JLabel.CENTER);
    private JButton rightBtn = new JButton ("RIGHT");
    private JButton leftBtn = new JButton ("LEFT");
    private JButton upBtn = new JButton ("UP");
    private JButton downBtn = new JButton ("DOWN");
    private JButton exitBtn = new JButton ("EXIT");
    private LineBorder line = new LineBorder(Color.black, 2);
    private RobotMonitor robot = new RobotMonitor();
	
    // the constructor
    public RobotGUI()
    {
      try
      {
      	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setTitle("RobotMonitor");
	  setSize(350, 300);
	  setLocation(300, 100);
	  getContentPane().setBackground(Color.GREEN);
	  grid.setLayout(new GridLayout(RobotMonitor.MAX,RobotMonitor.MAX)); 
	  // creates and adds nine buttons to the grid
	  for (int r = 0; r<RobotMonitor.MAX; r++)
	  {
	        for (int c=0; c<RobotMonitor.MAX; c++)
	        {
	          cell[r][c] = new JTextField(3);
	          grid.add(cell[r][c]);
	        }
	  }
	  setUpGrid();
	  update(" R ", Color.GREEN);
	  // positions the items on the screen
	  rightBtn.addActionListener(this);
	  leftBtn.addActionListener(this);
	  upBtn.addActionListener(this);
	  downBtn.addActionListener(this);
	  exitBtn.addActionListener(this);
	  buttons.add(rightBtn);
	  buttons.add(leftBtn);
	  buttons.add(upBtn);
	  buttons.add(downBtn);
	  buttons.add(exitBtn);
          header.add(move);// ADDED!!!!!
	  add(header, BorderLayout.NORTH);
	  add(grid, BorderLayout.CENTER);
	  add(buttons, BorderLayout.SOUTH);
	  setVisible(true);
      }
      catch (VDMException error)
      {
       		JOptionPane.showMessageDialog(null, error.toString(), "VDM INITIALISATION ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }

    public void actionPerformed(ActionEvent e)
    {
       	try
       	{
       		if (e.getSource() == rightBtn)
	       	{
	       		update("   ", Color.GREEN);
	       		robot.MoveRight();
	       		update(" R ", Color.GREEN);
	       	}
	       	if (e.getSource() == leftBtn)
	       	{
	       		update("   ", Color.GREEN);
	       		robot.MoveLeft();
	       		update(" R ", Color.GREEN);
	       	}
	       	if (e.getSource() == upBtn)
	       	{
	       		update("   ", Color.GREEN);
	       		robot.MoveUp();
	       		update(" R ", Color.GREEN);
	       	}
	       	if (e.getSource() == downBtn)
	       	{
	       		update("   ", Color.GREEN);
	       		robot.MoveDown();
	       		update(" R ", Color.GREEN);
	       	}	
	       	if (e.getSource() == exitBtn)
	       	{
	       		robot.Exit();
	       		setUpGrid();
	       	}
       	}
       	catch (VDMException error)
       	{
       		update(" R ", Color.RED);
       		JOptionPane.showMessageDialog(null, error.toString(), "VDM ERROR", JOptionPane.ERROR_MESSAGE);
       	}
       	catch (Exception error)
       	{
       		JOptionPane.showMessageDialog(null, error.toString(), "GENERAL ERROR", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
       	}
    }

    private void update(String msg, Color c)
    {
	   try
	   {
	   	int row = robot.GetRow();
       		int col = robot.GetCol();
       		cell[row-1][col-1].setText(msg);
       		cell[row-1][col-1].setBackground(c);
                if (robot.GetMove()!= null)
                {
                    move.setText("LAST MOVE: " + robot.GetMove());
                }
                else
                {
                    move.setText("");
                }
                
	   }
	   catch (Exception error)
           {
       		JOptionPane.showMessageDialog(null, error.toString(), "GENERAL ERROR", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
           }
    }
    
    private void setUpGrid()
    {
    	for (int r = 0; r<RobotMonitor.MAX; r++)
	{
	        for (int c=0; c<RobotMonitor.MAX; c++)
	        {
	          cell[r][c].setText("   ");
	          cell[r][c].setEditable(false);
	          cell[r][c].setBorder(line);
	          cell[r][c].setBackground(Color.LIGHT_GRAY);	
	        }
	}
	cell[RobotMonitor.MAX-1][RobotMonitor.MAX-1].setBackground(Color.BLUE);
	update(" R ", Color.GREEN);
    }
}
