package choose_seat_charge;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import seat_btn.SeatButton0;
import seat_btn.SeatButton1;
import seat_btn.SeatButton2;
import seat_btn.SeatButton3;
import seat_btn.SeatButton4;
import seat_btn.SeatButton5;
import seat_btn.SeatButton6;
import seat_btn.SeatButton7;
import variable.Variable;

public class ChooseSeatMain extends Variable{
	public String[][] seat_name = new String[8][32];//�����¼� ����
	public static void main(String[] args) {
		ChooseSeatMain cs = new ChooseSeatMain();
		Variable va = new Variable();//���� Ŭ���� ����
		SeatButton0 sb0 = new SeatButton0();//1ȣĭ �¼���ư ������ ����
		SeatButton1 sb1 = new SeatButton1();//2ȣĭ �¼���ư ������ ����
		SeatButton2 sb2 = new SeatButton2();//3ȣĭ �¼���ư ������ ����
		SeatButton3 sb3 = new SeatButton3();//4ȣĭ �¼���ư ������ ����
		SeatButton4 sb4 = new SeatButton4();//5ȣĭ �¼���ư ������ ����
		SeatButton5 sb5 = new SeatButton5();//6ȣĭ �¼���ư ������ ����
		SeatButton6 sb6 = new SeatButton6();//7ȣĭ �¼���ư ������ ����
		SeatButton7 sb7 = new SeatButton7();//8ȣĭ �¼���ư ������ ����
		//--------------------------------------------------
		//������ ����
		Frame f = new Frame("�¼� ����");
		f.setSize(650, 880);
		f.setLocation(700, 100);
		f.setLayout(null);
		//--------------------------------------------------
		//���� �Է�
		Font font = new Font("", Font.BOLD, 30);
		Label passage = new Label("���");
		passage.setBounds(200, 410, 75, 75);
		passage.setFont(font);
		Label front = new Label("��");
		front.setBounds(220, 25, 75, 75);
		front.setFont(font);
		Label back = new Label("��");
		back.setBounds(220, 780, 75, 75);
		back.setFont(font);
		f.add(passage);
		f.add(front);
		f.add(back);
		//--------------------------------------------------
		//ĭ ��ȣ
		String [] btn_room_number = {"1ȣ��", "2ȣ��", "3ȣ��", "4ȣ��", "5ȣ��", "6ȣ��", "7ȣ��", "8ȣ��"};//ĭ ��ȣ ����
		Button[] btn_room = new Button[8];
		//--------------------------------------------------
		//ĭ ��ȣ ����
		for( int i = 0; i < btn_room.length; i++ ) {
			btn_room[i] = new Button(btn_room_number[i]);
			btn_room[i].setBackground(Color.GREEN);
		}//for
		int y = 100; 
		for( int i = 0; i < btn_room.length; i++ ) {
			btn_room[i].setBounds(480, y, 125, 75);
			y += 85;
		}//for
		for( int i = 0; i < btn_room.length; i++ ) {
			f.add(btn_room[i]);
		}//for
		//--------------------------------------------------
		//ĭ ��ȣ �¼� ������ ����
		for( int i = 0; i < btn_room.length; i++ ) {
			btn_room[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for( int i = 0; i < btn_room.length; i++ ) {
						//���õɶ�
						if( e.getComponent() == btn_room[i] ) {
							e.getComponent().setBackground(Color.YELLOW);
							//1ȣĭ
							if( i == 0 ) {
								new SeatButton0(va, cs);
							//2ȣĭ
							}else if( i == 1 ) {
								new SeatButton1(va, cs);
							//3ȣĭ
							}else if( i == 2 ) {
								new SeatButton2(va, cs);
							//4ȣĭ
							}else if( i == 3 ) {
								new SeatButton3(va, cs);
							//5ȣĭ
							}else if( i == 4 ) {
								new SeatButton4(va, cs);
							//6ȣĭ
							}else if( i == 5 ) {
								new SeatButton5(va, cs);
							//7ȣĭ
							}else if( i == 6 ) {
								new SeatButton6(va, cs);
							//8ȣĭ
							}else {
								new SeatButton7(va, cs);
							}
						//���õȰ��� �ƴ� ���͵�
						}else {
							btn_room[i].setBackground(Color.GREEN);
						}//if
					}//inner for
				}//mouseClicked
			});//addMouseListener
		}//outer for
		//--------------------------------------------------
		//�����ϱ� ��ư ����
		Button btn_finish = new Button("�����ϱ�");
		btn_finish.setBounds(295, 795, 150, 50);
		btn_finish.setBackground(Color.LIGHT_GRAY);
		f.add(btn_finish);
		//--------------------------------------------------
		//�����ϱ� ��ư Ŭ���� �׼�
		btn_finish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//���õ� �¼� �������� �Է�
				for( int i = 0; i < cs.seat_name.length; i++ ) {
					for( int j = 0; j < cs.seat_name[i].length; j++ ) {
						if( cs.seat_name[i][j] != null ) {
							va.setSeat_name(va.getSeat_name() + cs.seat_name[i][j] + " ");
						}//if
					}//inner for
				}//outer for
				//���õ� ���� ���� ����
				if( va.getStation1() == "���￪" ) {
					if( va.getStation2() == "������" ) {
						va.setAdult_price(8400);
						va.setChild_price(4200);
					}else if( va.getStation2() == "������" ) {
						va.setAdult_price(23700);
						va.setChild_price(11850);
					}else if( va.getStation2() == "�λ꿪" ) {
						va.setAdult_price(59800);
						va.setChild_price(29900);
					}
				}else if( va.getStation1() == "������" ) {
					if( va.getStation2() == "���￪" ) {
						va.setAdult_price(8400);
						va.setChild_price(4200);
					}else if( va.getStation2() == "������" ) {
						va.setAdult_price(12900);
						va.setChild_price(6450);
					}else if( va.getStation2() == "�λ꿪" ) {
						va.setAdult_price(46300);
						va.setChild_price(23150);
					}
				}else if( va.getStation1() == "������" ) {
					if( va.getStation2() == "������" ) {
						va.setAdult_price(12900);
						va.setChild_price(6450);
					}else if( va.getStation2() == "���￪" ) {
						va.setAdult_price(23700);
						va.setChild_price(11850);
					}else if( va.getStation2() == "�λ꿪" ) {
						va.setAdult_price(36200);
						va.setChild_price(18100);
					}
				}else if( va.getStation1() == "�λ꿪" ) {
					if( va.getStation2() == "������" ) {
						va.setAdult_price(46300);
						va.setChild_price(23150);
					}else if( va.getStation2() == "������" ) {
						va.setAdult_price(36200);
						va.setChild_price(18100);
					}else if( va.getStation2() == "���￪" ) {
						va.setAdult_price(59800);
						va.setChild_price(29900);
					}
				}//if
				//�����¼��� ���õ��¼��� ���� �´��� Ȯ���ϰ� ������ true, Ʋ���� false
				if( va.getSeat() == (va.getAdult() + va.getChild()) ) {
					va.setCheck(true);
				}
				//true�϶�
				if(va.isCheck()) {
					JOptionPane.showMessageDialog(null, "���� ���õ� �¼��� " + va.getSeat_name() + " �Դϴ�\n" + "�����ø� Ȯ�ι�ư�� �����ּ���");
					JOptionPane.showMessageDialog(null, "����â���� �Ѿ�ϴ�");
					f.dispose();
					new Charge(va);
				//false�϶�
				}else {
					JOptionPane.showMessageDialog(null, "�¼������� �Ϸ���� �ʾҽ��ϴ�\n�ٽ� �������ֽñ� �ٶ��ϴ�");
				}
			}
		});
		//--------------------------------------------------
		f.setVisible(true);
		//--------------------------------------------------
		//���� �����
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				f.dispose();
			}
		});
		//--------------------------------------------------
	}//main
}
