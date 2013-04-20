import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Solver {

	int[][] hexGrid = new int[20][20];
	int[] sporePieces = new int[6];
	int Height;
	int Width;
	static Queue possibleQueue;
	static Queue allMovesQueue;

	
	static JFrame ThisFrame = new JFrame();
	static JButton CalcButton = new JButton("Find Solution");
	static JLabel columnLabel = new JLabel("Number of hexagon in longest column");
	static JLabel rowLabel = new JLabel("Number of hexagon in longest row");
	static JLabel gridLabel = new JLabel("Insert Grid");
	static JLabel sporeLabel = new JLabel("Insert Spores");

	static JTextField columnBox = new JTextField();
	static JTextField rowBox = new JTextField();
	static JTextField gridBox = new JTextField();
	static JTextField sporeBox = new JTextField();
	
	
	// SporePieces
	// 1 = single row
	// 2 = NW + SE
	// 3 = NE + SW
	// 4 = row + NW + SE
	// 5 = row + NE + SW
	// 6 = NE + NW + SE + SW
	// 7 = ALL

	public static void main(String[] args) {


		columnBox.setMinimumSize(columnBox.getPreferredSize());
		rowBox.setMinimumSize(rowBox.getPreferredSize());
		gridBox.setMinimumSize(gridBox.getPreferredSize());
		sporeBox.setMinimumSize(sporeBox.getPreferredSize());

		ThisFrame.setSize(450, 300);
		ThisFrame.setLayout(new GridBagLayout());

		GridBagConstraints Constraints = new GridBagConstraints();
		Constraints.gridx = 0;
		Constraints.gridy = 0;
		Constraints.gridheight = 1;
		Constraints.gridwidth = 1;
		Constraints.weightx = 50.0;
		Constraints.weighty = 50.0;
		Constraints.insets = new Insets(5, 5, 5, 5);
		Constraints.fill = GridBagConstraints.HORIZONTAL;

		ThisFrame.add(columnLabel, Constraints);

		Constraints.gridx = 1;
		Constraints.gridy = 0;

		ThisFrame.add(columnBox, Constraints);

		Constraints.gridx = 0;
		Constraints.gridy = 1;
		ThisFrame.add(rowLabel, Constraints);

		Constraints.gridx = 1;
		Constraints.gridy = 1;
		ThisFrame.add(rowBox, Constraints);

		Constraints.gridx = 0;
		Constraints.gridy = 2;
		ThisFrame.add(gridLabel, Constraints);

		Constraints.gridx = 1;
		Constraints.gridy = 2;
		ThisFrame.add(gridBox, Constraints);

		Constraints.gridx = 0;
		Constraints.gridy = 3;
		ThisFrame.add(sporeLabel, Constraints);

		Constraints.gridx = 1;
		Constraints.gridy = 3;
		ThisFrame.add(sporeBox, Constraints);

		Constraints.gridx = 0;
		Constraints.gridy = 4;

		ButtonHandler handler = new ButtonHandler();
		CalcButton.addActionListener(handler);
		ThisFrame.add(CalcButton, Constraints);

		// ThisFrame.pack();
		ThisFrame.setVisible(true);

	}

	// SporePieces
	// 1 = single row
	// 2 = NW + SE
	// 3 = NE + SW
	// 4 = row + NW + SE
	// 5 = row + NE + SW
	// 6 = NE + NW + SE + SW
	// 7 = ALL
	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
                Height = Integer.parseInt(columnBox.getText());
                Width = Integer.parseInt(rowBox.getText());
                String sporebox = sporeBox.getText(); 
                String gridbox = gridBox.getText();
                int counter=0;


                //just keeps a matrix of the spore pieces
                for (int i = 0; i < sporeBox.getText().length(); i++)
                {
                    sporePieces[i] = sporebox.charAt(i);
                }


                //fills up the grid as well as the queue for all possible moves
                for (int i = 0; i < Height; i++)
                {
                    for (int j = 0; j < Width; j++)
                    {
                        hexGrid[i][j] = gridbox.charAt(counter);

                        if (gridbox.charAt(counter) == 1)
                            allMovesQueue.add(new coordinate(i, j));

                        counter += 2;
                    }
                }

                possibleQueue = BeSmart();


            }

		private Queue BeSmart()
            {
                Queue temp;
                Queue temp2;
                
                temp2 = allMovesQueue;
                
                int x, y;

                for (int i = 0; i < temp2.size(); i++)
                {
                    x = ((coordinate)(temp2.remove())).getWidth();
                    y = ((coordinate)(temp2.remove())).getHeight();

                    if(gridBox[x+

                }


                return temp;
            }
	}

	
    public class coordinate
    {
        private int height, width;

        public coordinate(int x, int y)
        {
            x = width;
            y = height; 
        }

        public int getHeight(){
            return height;
        }

        public int getWidth(){
            return width;
        }
    }
}
