package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Othello_Main {
	int i = 0;
	int j = 0;
	int userCount = 0;
	Color color=new Color(0,0,0,0);
	int[] dol = new int[2];
	int[] placecheck = new int[2];
	int[] origin = new int[2];
	
	ImageIcon img1 = new ImageIcon("omok_black2.png");
	ImageIcon img2 = new ImageIcon("omok_white2.png");
	
	public Othello_Main() {
		Frame f = new Frame("Othello");
		f.setLayout(null);
		f.setBounds(500, 100, 600, 450);
		
		Font font = new Font("굴림체", Font.BOLD, 20);
		Label turn = new Label("Player1의 차례");
		turn.setBounds(400, 100, 300, 50);
		turn.setFont(font);
		
		Button reset = new Button("리셋");
		reset.setBounds(425, 150, 70, 40);
		
		f.add(turn);
		f.add(reset);
		
		JButton[][] btn = new JButton[8][8];
		
		Omok_Player p1 = new Omok_Player(Omok_Color.Black);
		Omok_Player p2 = new Omok_Player(Omok_Color.White);
		Omok_Board board = new Omok_Board(8);
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				board.Omok_resetBoard();
				for(i = 0 ; i < 8; i++) {
					for(j = 0; j < 8; j ++) {
						btn[i][j].setIcon(null);
					}
				}
				//초기돌 4개
				p1.place(board, 3, 4);
				btn[3][4].setForeground(color);
				btn[3][4].setIcon(img1);
				p1.place(board, 4, 3);
				btn[4][3].setForeground(color);
				btn[4][3].setIcon(img1);
				p2.place(board, 3, 3);
				btn[3][3].setForeground(color);
				btn[3][3].setIcon(img2);
				p2.place(board, 4, 4);
				btn[4][4].setForeground(color);
				btn[4][4].setIcon(img2);
				
				p1.setTurn(true);
				p2.setTurn(false);
				turn.setText("Player1의 차례");
			}
			
		});
		
		for(i=0; i < 8; i++) {
			for(j=0 ; j < 8; j++) {
				btn[i][j] = new JButton(String.valueOf(i * 8 +j));
				btn[i][j].setForeground(color);
				btn[i][j].setVisible(true);
				f.add(btn[i][j]);
				btn[i][j].setBounds(50+ 40 * j , 50 + 40 * i, 40, 40);
				btn[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
				

				
				
				btn[i][j].addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
	
						int x = Integer.parseInt(e.getActionCommand()) / 8;
						int y = Integer.parseInt(e.getActionCommand()) % 8;
						
						
							//콘솔에 게임판 출력
						
						
						if(p1.getTurn()) {	
							Othello_check check = new Othello_check();
							
							//게임 종료 확인
							if(!check.checkall(board.getBoard(), Omok_Color.Black) && !check.checkall(board.getBoard(), Omok_Color.White)) {
								new Popup().Othello_Winner(check.Win(board.getBoard()));
							}
							//놓을수 있는 자리가 있는지 확인 없으면 턴 바꾸기
							else if(!check.checkall(board.getBoard(), Omok_Color.Black)) {
								p1.setTurn(false);
								p2.setTurn(true);
								new Popup().Othello_no_space();
								turn.setText("Player2의 차례");
								
							}
							
							
							//빈 칸에 돌을 맞게 뒀다면 턴 바꾸기, 뒤집을수 있는 돌이 없다면 놓을수 없는 자리
							else if(check.check(board.getBoard(), Omok_Color.Black, x, y) && p1.place(board, x, y) ) {
								p1.setTurn(false);
								p2.setTurn(true);
								btn[x][y].setForeground(color);
								btn[x][y].setIcon(img1);
								turn.setText("Player2의 차례");
								
								
								
								
								//놓은 흑돌 사이에 백돌이 있으면 흑돌로 바꾸기
								outer1: for(int i = 0; i < 8; i++) {
									dol = check.range(board.getBoard(), Omok_Color.Black, x, y, i);
									int row = x;
									int col = y;
									
									switch( i ) {
	
									case 0 ://우측
										
										while(col < dol[1]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											++col;
										}
										continue outer1;
									case 1://우측하단
										while(row < dol[0] && col < dol[1]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											++row;
											++col;
										}
										continue outer1;
									case 2://하단
										while(row < dol[0]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											++row;
										}
										continue outer1;
									case 3://좌측하단
										while(row < dol[0] && col > dol[1]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											++row;
											--col;
										}
										continue outer1;
									case 4://좌측
										while(col > dol[1]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											--col;
										}
										continue outer1;
									case 5://좌측상단
										while(row > dol[0] && col > dol[1]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											--row;
											--col;
										}
										continue outer1;
									case 6://상단
										while(row > dol[0]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											--row;
										}
										continue outer1;
									case 7://우측상단
										while(row > dol[0] && col < dol[1]) {
											p1.set(board, row, col);
											btn[row][col].setForeground(color);
											btn[row][col].setIcon(img1);
											--row;
											++col;
										}
										continue outer1;
									}	
								}
							}else {
								new Popup().Othello_not_able();
							}
							
						} else {				
							Othello_check check = new Othello_check();
							
							//게임 종료 확인
							if(!check.checkall(board.getBoard(), Omok_Color.Black) && !check.checkall(board.getBoard(), Omok_Color.White)) {
								new Popup().Othello_Winner(check.Win(board.getBoard()));
							}
							//놓을수 있는 자리가 있는지 확인 없으면 턴 바꾸기
							else if(!check.checkall(board.getBoard(), Omok_Color.White)) {
								p2.setTurn(false);
								p1.setTurn(true);
								new Popup().Othello_no_space();
								System.out.println("놓을수 있는자리가 없습니다(p2)");
								turn.setText("Player1의 차례");
								
								
							}
							
							
							else if(check.check(board.getBoard(), Omok_Color.White, x, y) && p2.place(board, x, y) ) {
								p2.setTurn(false);
								p1.setTurn(true);
								btn[x][y].setForeground(color);
								btn[x][y].setIcon(img2);
								turn.setText("Player1의 차례");
								System.out.println(board);
								
								//놓은 백돌 사이에 흑돌이 있으면 흑돌로 바꾸기
							outer2 : for(int i = 0; i < 8; i++) {
								
								dol = check.range(board.getBoard(), Omok_Color.White, x, y, i);

								int row = x;
								int col = y;
								
								switch( i ) {

								case 0 ://우측
									
									while(col < dol[1]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										++col;
									}
									continue outer2;
								case 1://우측하단
									while(row < dol[0] && col < dol[1]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										++row;
										++col;
									}
									continue outer2;
								case 2://하단
									while(row < dol[0]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										++row;
									}
									continue outer2;
								case 3://좌측하단
									while(row < dol[0] && col > dol[1]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										++row;
										--col;
									}
									continue outer2;
								case 4://좌측
									while(col > dol[1]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										--col;
									}
									continue outer2;
								case 5://좌측상단
									while(row > dol[0] && col > dol[1]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										--row;
										--col;
									}
									continue outer2;
								case 6://상단
									while(row > dol[0]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										--row;
									}
									continue outer2;
								case 7://우측상단
									while(row > dol[0] && col < dol[1]) {
										p2.set(board, row, col);
										btn[row][col].setForeground(color);
										btn[row][col].setIcon(img2);
										--row;
										++col;
									}
									continue outer2;
								}	
							}
						}else {
							new Popup().Othello_not_able();
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
		//초기돌 4개
		p1.place(board, 3, 4);
		btn[3][4].setForeground(color);
		btn[3][4].setIcon(img1);
		p1.place(board, 4, 3);
		btn[4][3].setForeground(color);
		btn[4][3].setIcon(img1);
		p2.place(board, 3, 3);
		btn[3][3].setForeground(color);
		btn[3][3].setIcon(img2);
		p2.place(board, 4, 4);
		btn[4][4].setForeground(color);
		btn[4][4].setIcon(img2);
		
		p1.setTurn(true);
		p2.setTurn(false);
		turn.setText("Player1의 차례");
		}
}