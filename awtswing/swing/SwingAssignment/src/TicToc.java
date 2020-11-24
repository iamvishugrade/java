import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicToc {
	public static void main (String... args) {
		new TicTocFrame().setVisible(true);
    }
}

class TicTocFrame extends JFrame implements MouseListener{
	final int DEFAULT_WIDTH = 400;
	final int DEFAULT_HEIGHT = 400;
	private boolean isTurnOne;// if false means turn is others
	private int blockX;
	private int blockY;
	final int gapX;
	final int gapY;
	private int filledBlocks[]; // 1 for palyer1, 2 for player2
	
	public TicTocFrame() {
		super("Tic Toc Game");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		gapX = getWidth() / 3;
		gapY = getHeight() / 3;
		filledBlocks = new int[9];
		for (int i = 0; i < 9; i++)
			filledBlocks[i] = -i;
		addMouseListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// cross lines
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillRect(gapX, 1, 5, getHeight());
		g.fillRect(2*gapX, 1, 5, getHeight());
		g.fillRect(1, gapY, getWidth(), 5);
		g.fillRect(1, 2*gapY, getWidth(), 5);
	}
	public void update(Graphics g) {
		int x1 = blockX*gapX + 10;
			int x2 = (blockX+1)*gapX - 10;
			int y1 = blockY*gapY  + 10;
			int y2 = (blockY+1)*gapY - 10;
		if(isTurnOne)
			g.setColor(Color.RED);
		else 
			g.setColor(Color.GREEN);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y1, x1, y2);
	}
	
	private boolean checkWinStatus() {
		if(
		filledBlocks[0] == filledBlocks[1] && filledBlocks[0] == filledBlocks[2] || 
		filledBlocks[3] == filledBlocks[4] && filledBlocks[3] == filledBlocks[5] || 
		filledBlocks[6] == filledBlocks[7] && filledBlocks[6] == filledBlocks[8] || 
		filledBlocks[0] == filledBlocks[3] && filledBlocks[0] == filledBlocks[6] || 
		filledBlocks[1] == filledBlocks[4] && filledBlocks[1] == filledBlocks[7] || 
		filledBlocks[2] == filledBlocks[5] && filledBlocks[2] == filledBlocks[8] || 
		filledBlocks[0] == filledBlocks[4] && filledBlocks[0] == filledBlocks[8] || 
		filledBlocks[2] == filledBlocks[4] && filledBlocks[2] == filledBlocks[7])
			return true;
		return false;
	}
	
	public void mouseClicked(MouseEvent event) {
		blockX = event.getX() / gapX; // = x / (width/3)
		blockY = event.getY() / gapY; // = y / (height/3)
		if(filledBlocks[blockX * 3 + blockY] < 0) {
			isTurnOne = !isTurnOne;
			filledBlocks[blockX * 3 + blockY] = (isTurnOne)? 1 : 2;
			update(getGraphics());
			if(checkWinStatus()) {
				System.out.println ("game won");
				//add(resultPanel, BorderLayout.CENTER);
				JInternalFrame iframe = new JInternalFrame("Congrats!!!", false, false, false, false);
				JLabel resultLabel = new JLabel("<html><Font size=6 color=#00ffff>"+
					"!!Congratulation!!\n Player "+ (isTurnOne?"First":"Second")
					 +" won the game.</Font></html>");
				ImageIcon winImage = new ImageIcon("WinGame.png");
				JLabel imgLabel = new JLabel(winImage);
		
				iframe.setSize(getContentPane().getWidth(), getContentPane().getHeight());
				iframe.add(resultLabel, BorderLayout.NORTH);
				iframe.add(imgLabel, BorderLayout.CENTER);
				add(iframe, BorderLayout.CENTER);
				iframe.setVisible(true);
			}
		}
	}
	public void mouseReleased(MouseEvent event) {
	}
	public void mousePressed(MouseEvent event) {
	}
	public void mouseEntered(MouseEvent event) {
	}
	public void mouseExited(MouseEvent event) {
	}
}