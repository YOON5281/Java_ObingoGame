package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Omok_Main {
	int i = 0;
	int j = 0;
	int userCount = 0;
	Color color=new Color(0,0,0,0);
	
	ImageIcon img1 = new ImageIcon("grid2.png");
	ImageIcon img2 = new ImageIcon("omok_black2.png");
	ImageIcon img3 = new ImageIcon("omok_white2.png");
	
	
	
	public Omok_Main() {
		
		Frame f = new Frame("Omok");
		f.setLayout(null);
		f.setBounds(500, 100, 1000, 900);
		
		Font font = new Font("굴림체", Font.BOLD, 20);
		
		JButton[][] btn = new JButton[19][19];
		
		Label turn = new Label("Player1의 차례");
		turn.setBounds(825, 100, 300, 50);
		turn.setFont(font);
		
		Button reset = new Button("리셋");
		reset.setBounds(860, 150, 70, 40);
		
		f.add(turn);
		f.add(reset);
		
		Omok_Player p1 = new Omok_Player(Omok_Color.White);
		Omok_Player p2 = new Omok_Player(Omok_Color.Black);
		Omok_Board board = new Omok_Board(19);
	
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				board.Omok_resetBoard();
				for(i = 0 ; i < 19; i++) {
					for(j = 0; j < 19; j ++) {
						btn[i][j].setIcon(img1);
					}
				}
				p1.setTurn(true);
				p2.setTurn(false);
				turn.setText("Player1의 차례");
				
			}
		});
		
		for(i=0; i < 19; i++) {
			for(j=0 ; j < 19; j++) {
				btn[i][j] = new JButton(String.valueOf(i * 19 +j), img1);
				btn[i][j].setForeground(color);
				btn[i][j].setVisible(true);
				f.add(btn[i][j]);
				btn[i][j].setBounds(50+ 40 * j , 50 + 40 * i, 40, 40);
				btn[i][j].setBorder(null);
				btn[i][j].setBackground(null);
				btn[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				

				
				btn[i][j].addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
	
						int x = Integer.parseInt(e.getActionCommand()) / 19;
						int y = Integer.parseInt(e.getActionCommand()) % 19;
						
						
							//콘솔에 오목판 출력
							
						
						if(p1.getTurn()) {	
							
								//빈 칸에 돌을 맞게 뒀다면 턴 바꾸기
							if(p1.place(board, x, y)) {
								p1.setTurn(false);
								p2.setTurn(true);
								btn[x][y].setForeground(color);
								btn[x][y].setIcon(img2);
								turn.setText("Player2의 차례");
								System.out.println(board);
						
							}
							
								
								//돌이 5개 연속인지 확인
								
		
								int condition1 =  new Omok_gamePlay().check_Omock(board.getBoard());
								
								//돌이 5개 이상 연속으로 있다면 p1 승리
								if(condition1 >= 5) {
									System.out.println(board);
									System.out.println("p1 승리");
									new Popup().OmokWin(1);
									
								}
							} else {				
								if(p2.place(board, x, y)) {
									p2.setTurn(false);
									p1.setTurn(true);
									btn[x][y].setForeground(color);
									btn[x][y].setIcon(img3);
									turn.setText("Player1의 차례");
									System.out.println(board);
								}
								int condition2 = new Omok_gamePlay().check_Omock(board.getBoard()); 
								if(condition2 >= 5) {
									System.out.println(board);
									System.out.println("p2 승리");
									new Popup().OmokWin(2);
								}
					
						}
				}
		});
		
		
				System.out.println();
		
				f.setResizable(false);//사이즈 변경 불가
				f.setVisible(true);
		
		
				f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						f.dispose();
					}
				});		
			}
		}
	}
}
	
