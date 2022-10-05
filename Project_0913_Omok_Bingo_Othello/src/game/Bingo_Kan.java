package game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bingo_Kan {
	public Bingo_Kan() {
		
		Frame frame = new Frame("Bingo Game");
		frame.setLayout(null);
		frame.setBounds(500, 100, 600, 200);
		
		Font font = new Font("굴림체", Font.BOLD, 20);
		
		Label lb = new Label("게임판의 크기를 설정해주세요( n * n )");
		lb.setBounds(125, 50, 425, 30);
		lb.setFont(font);
		

		
		TextField tf = new TextField(10);
		tf.setBounds(200, 100, 50, 30);
		
		Button btn = new Button("확인");
		btn.setBounds(300, 100, 50, 30);
		btn.setEnabled(false);//버튼클릭 비활성화
		
		btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				while(true) { 
					
					try{
						int n = Integer.parseInt(tf.getText());
						
						
						if( n < 3) {
							new Popup().Popup_Error();
							tf.setText("");
							break;
							
						}else {
							new Bingo_Main(n);
							frame.dispose();
							break;
						}
					}catch (NumberFormatException e1) {
						new Popup().Popup_Error();
						tf.setText("");
						break;
					} 
				
				}
			}
		});		
		
		
		tf.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				if( tf.getText().trim().equals("") ) {
					//tf가 비어있다면 입력버튼 비활성화
					btn.setEnabled(false);
				}else {
					btn.setEnabled(true);
				}
				
			}
		});
		
		frame.add(tf);
		frame.add(btn);
		frame.add(lb);
		
		frame.setResizable(false);//사이즈 변경 불가
		frame.setVisible(true);
		
	
		
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				frame.dispose();
			}
		});
		
	}//main
}
