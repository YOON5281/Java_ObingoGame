package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Bingo_Main {
	int i = 0;
	int j = 0;
	int userCount = 0;
	int resultValue;
	Color color=new Color(0,0,0,0);
	
	ImageIcon img1 = new ImageIcon("circle2.png");
	ImageIcon img2 = new ImageIcon("X_icon2.png");
	
	
	public Bingo_Main(int n) {
		Frame f = new Frame("Bingo Game");
		f.setLayout(null);//자동배치 끄기
		f.setBounds(550, 250, 100 + n * 50, 200 + n * 50);
		int arr[][] = new int [n][n];
		
		Button btn_reset = new Button("Reset");
		Button btn_exit = new Button("Exit");
		
		JButton[][] btn = new JButton[n][n];
		
		
		btn_reset.setBounds(50, 100 + n * 50, 70, 50);
		btn_exit.setBounds(n * 50 - 20, 100 + n * 50, 70, 50);
		
		Bingo_Algorithm ba = new Bingo_Algorithm();
		
		ba.initialize(arr, n);
		
		for(i=0; i < n; i++) {
			for(j=0 ; j < n ; j++) {
				btn[i][j] = new JButton(String.valueOf(i * n +j));
				btn[i][j].setForeground(color);
				btn[i][j].setVisible(true);
				f.add(btn[i][j]);
				btn[i][j].setBounds(50+ 50 * j , 50 + 50 * i, 50, 50);
				btn[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						userCount++;
						System.out.println(userCount);
						// TODO Auto-generated method stub
						int n1 = Integer.parseInt(e.getActionCommand()) / n;
						int n2 = Integer.parseInt(e.getActionCommand()) % n;
						
						
						userCount = ba.userCount_check(n1, n2, userCount, arr);
						ba.Bingo_Algorithm(n1, n2, n,userCount,arr);
						
						resultValue = ba.Bingo_Algorithm(n1, n2, n,userCount,arr)[n1][n2];					
//						System.out.println("값 check : " + resultValue);
						
//						System.out.println("버튼 체크 : " + btn[n1][n2].getText());
							if(resultValue == 1) {
								btn[n1][n2].setForeground(Color.BLACK);
								btn[n1][n2].setIcon(img1);
							}else if(resultValue == 2) {
								btn[n1][n2].setForeground(Color.BLACK);
								btn[n1][n2].setIcon(img2);							
							}
												
						ba.Bingo_Check(n1, n2, n,userCount,arr);
						
						if(ba.Bingo_Check(n1, n2, n,userCount,arr)[0]>=1) {
							System.out.println("유저1 빙고~!");
							new Popup().BingoWin(1);
						}
						else if(ba.Bingo_Check(n1, n2, n,userCount,arr)[1]>=1) {
							System.out.println("유저2 빙고~!");							
							new Popup().BingoWin(2);
						}else if( userCount >= n*n) {
							new Popup().BingoWin(3);
						}
						
						
						
//						System.out.println(e.getActionCommand());
						
					}
				});
				
			}
		}
		
		
		f.setVisible(true);
		
		f.add(btn_reset);
		f.add(btn_exit);
		
		
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ss = e.getActionCommand();
				
				
				switch( ss ) {
				case "Reset":
					ba.initialize(arr, n);
					for(int i = 0 ; i < n ; i++  ) {
						for(int j = 0 ; j < n ; j++) {
							btn[i][j].setIcon(null);
							btn[i][j].setForeground(color);
						}
					}
					userCount = 0;
					break;
					
				case "Exit":
					System.exit(0);
					break;
				
				
				}//switch
			}
		};
		
		
		btn_reset.addActionListener(al);
		btn_exit.addActionListener(al);
		
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				f.dispose();
			}
		});
		
	}
}