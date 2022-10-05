package game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) {
		
		Frame frame = new Frame("보드게임");
		frame.setLayout(null);
		frame.setBounds(500, 100, 425, 200);
		
		Font font = new Font("굴림체", Font.BOLD, 20);
		
		Label lb = new Label("게임을 선택하세요");
		lb.setBounds(125, 50, 450, 30);
		lb.setFont(font);
		
		Button btn_bingo = new Button("빙고");
		btn_bingo.setBounds(90, 100, 50, 30);
		
		Button btn_omok = new Button("오목");
		btn_omok.setBounds(190, 100, 50, 30);
		
		Button btn_othello = new Button("오셀로");
		btn_othello.setBounds(290, 100, 50, 30);
		
		btn_bingo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Bingo_Kan();
				frame.dispose();
				
			}
		});
		
		btn_omok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Omok_Main();
				frame.dispose();
				
			}
		});
		
		btn_othello.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Othello_Main();
				frame.dispose();
				
			}
		});
		
		
		frame.add(lb);
		frame.add(btn_bingo);
		frame.add(btn_omok);
		frame.add(btn_othello);
		
		frame.setResizable(false);//사이즈 변경 불가
		frame.setVisible(true);
	
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				frame.dispose();
			}
		});
		

	}
}
