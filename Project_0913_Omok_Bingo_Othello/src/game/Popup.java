package game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Popup {
	
	Font font = new Font("����ü", Font.BOLD, 20);
	
	public void Popup_Error() {
			Frame Popup_error = new Frame("Error");
			Popup_error.setLayout(null);
			Popup_error.setBounds(600, 100, 400, 200);
			
			Label message = new Label("3�̻��� ���ڸ� �Է��ϼ���");
			message.setBounds(75, 50, 350, 50);
			message.setFont(font);
			
			Button btn_error = new Button("Ȯ��");
			btn_error.setBounds(175, 100, 50, 30);
			btn_error.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Popup_error.dispose();
				}
			});
		
			Popup_error.setResizable(false);//������ ���� �Ұ�
			Popup_error.setVisible(true);
			
			Popup_error.add(message);
			Popup_error.add(btn_error);
			
			Popup_error.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					
					Popup_error.dispose();
				}
			});
			
		}
	
	public void OmokWin(int n) {
		Frame Win = new Frame("Winner");
		Win.setLayout(null);
		Win.setBounds(600, 100, 300, 200);
		
		switch( n ) { 
			case 1 :
				Label p1 = new Label("Player1(�浹) �¸�");
				p1.setBounds(75, 50, 350, 50);
				p1.setFont(font);
				Win.add(p1);
				break;
			case 2 :
				Label p2 = new Label("Player2(�鵹) �¸�");
				p2.setBounds(75, 50, 350, 50);
				p2.setFont(font);
				Win.add(p2);
				break;
		}
				
		Button btn = new Button("Ȯ��");
		btn.setBounds(125, 100, 50, 30);
		btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Win.dispose();
			}
		});
	
		Win.setResizable(false);//������ ���� �Ұ�
		Win.setVisible(true);
		Win.add(btn);
		
		Win.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					
				Win.dispose();
			}
		});	
	}
	
	public void BingoWin(int n) {
			
			Frame f = new Frame();
			f.setLayout(null);
			
			Label lb = new Label();
			if( n == 1 || n == 2) {
			lb.setText("���� " + n +" ����~!" );
			}else {
				lb.setText("���º� �Դϴ�" );			
			}
			lb.setBounds(90, 50, 200, 40);
			
			f.setBounds(550, 450, 250, 175);
			
			Button btn_exit = new Button("Ȯ��");
	//		Button btn_cancel = new Button("���");
			
			btn_exit.setBounds(100, 100, 50, 30);
	//		btn_cancel.setBounds(180, 80, 70, 50);
			
			ActionListener al = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ss = e.getActionCommand();
					System.out.println(ss);
					
					switch( ss ) {
					case "Ȯ��":
						f.dispose();
//						System.exit(0);					
						break;
					
	//				case "���":
	//					f.dispose();
	//					break;
	//				
					}//switch
					
				}
			};
			
			btn_exit.addActionListener(al);
	//		btn_cancel.addActionListener(al);
				
			f.add(lb);
			f.add(btn_exit);
	//		f.add(btn_cancel);
			
			f.setVisible(true);
			
			f.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					//x��ư�� �����ϸ� ���Ῡ�θ� ���� �˾� �������� �������
					f.dispose();
					
				}
				
			});
			
		}
	
	public void Othello_no_space() {
		Frame Popup_error = new Frame("No space");
		Popup_error.setLayout(null);
		Popup_error.setBounds(600, 100, 400, 200);
		
		Label message = new Label("������ �ִ� �ڸ��� �����ϴ�");
		message.setBounds(75, 50, 350, 50);
		message.setFont(font);
		
		Button btn_error = new Button("Ȯ��");
		btn_error.setBounds(175, 100, 50, 30);
		btn_error.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Popup_error.dispose();
			}
		});
	
		Popup_error.setResizable(false);//������ ���� �Ұ�
		Popup_error.setVisible(true);
		
		Popup_error.add(message);
		Popup_error.add(btn_error);
		
		Popup_error.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Popup_error.dispose();
			}
		});
		
	}
	
	public void Othello_not_able() {
		Frame Popup_error = new Frame("��ġ �Ұ�");
		Popup_error.setLayout(null);
		Popup_error.setBounds(600, 100, 400, 200);
		
		Label message = new Label("���� �� ���� �ڸ��Դϴ�");
		message.setBounds(75, 50, 350, 50);
		message.setFont(font);
		
		Button btn_error = new Button("Ȯ��");
		btn_error.setBounds(175, 100, 50, 30);
		btn_error.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Popup_error.dispose();
			}
		});
	
		Popup_error.setResizable(false);//������ ���� �Ұ�
		Popup_error.setVisible(true);
		
		Popup_error.add(message);
		Popup_error.add(btn_error);
		
		Popup_error.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				Popup_error.dispose();
			}
		});
	}
	
	public void Othello_Winner(int[] arr) {
		Frame Win = new Frame("Winner");
		Win.setLayout(null);
		Win.setBounds(600, 100, 300, 300);
		
		Label p1 = new Label("Player1 : " + arr[0]);
		p1.setBounds(50, 50, 350, 50);
		p1.setFont(font);
		Label p2 = new Label("Player2 : " + arr[1]);
		p2.setBounds(50, 100, 350, 50);
		p2.setFont(font);
		
		Win.add(p1);
		Win.add(p2);
		switch( arr[2] ) { 
			case 0 :
				Label win0 = new Label("���º�");
				win0.setBounds(50, 150, 350, 50);
				win0.setFont(font);
				Win.add(win0);
				break;
			case 1 :
				Label win1 = new Label("Player1(�浹) �¸�");
				win1.setBounds(50, 150, 350, 50);
				win1.setFont(font);
				Win.add(win1);
				break;
			case 2 :
				Label win2 = new Label("Player2(�鵹) �¸�");
				win2.setBounds(50, 150, 350, 50);
				win2.setFont(font);
				Win.add(win2);
				break;
			case 3 :
				Label win3 = new Label("����");
				win3.setBounds(50, 150, 350, 50);
				win3.setFont(font);
				Win.add(win3);
				break;
		}
				
		Button btn = new Button("Ȯ��");
		btn.setBounds(125, 225, 50, 30);
		btn.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Win.dispose();
			}
		});
	
		Win.setResizable(false);//������ ���� �Ұ�
		Win.setVisible(true);
		Win.add(btn);
		
		Win.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					
				Win.dispose();
			}
		});
	}
}


