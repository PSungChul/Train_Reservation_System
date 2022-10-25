package seat_btn;

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

import choose_seat_charge.ChooseSeatMain;
import variable.Variable;

public class SeatButton1 extends Frame{
	public SeatButton1() {
		// TODO Auto-generated constructor stub
	}
	//--------------------------------------------------
	//������
	Variable va = new Variable();//���� Ŭ���� ����
	ChooseSeatMain cs = new ChooseSeatMain();//����Ŭ����
	//--------------------------------------------------	
	//�¼� ��ȣ
	public String[] btn_seat_name = {"1A", "1B", "1C", "1D",
			  						 "2A", "2B", "2C", "2D",
			  						 "3A", "3B", "3C", "3D",
			  						 "4A", "4B", "4C", "4D",
			  						 "5A", "5B", "5C", "5D",
			  						 "6A", "6B", "6C", "6D",
			  						 "7A", "7B", "7C", "7D",
			  						 "8A", "8B", "8C", "8D"};//�¼� ��ȣ ����
	public Button[] btn_seat = new Button[32];//�¼� ��ư ����
	String[] seat_name = new String[32];//���� �¼� �迭
	//--------------------------------------------------
	public SeatButton1(Variable va, ChooseSeatMain cs) {
		//������ ����
		Frame f = new Frame("2ȣ��");
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
		//�¼� ��ȣ ����
		for( int i = 0; i < btn_seat.length; i++ ) {
			btn_seat[i] = new Button(btn_seat_name[i]);
			btn_seat[i].setBackground(Color.LIGHT_GRAY);
		}//for
		//1
		btn_seat[0].setBounds(25, 100, 75, 75);
		btn_seat[1].setBounds(110, 100, 75, 75);
		btn_seat[2].setBounds(285, 100, 75, 75);
		btn_seat[3].setBounds(370, 100, 75, 75);
		//2
		btn_seat[4].setBounds(25, 185, 75, 75);
		btn_seat[5].setBounds(110, 185, 75, 75);
		btn_seat[6].setBounds(285, 185, 75, 75);
		btn_seat[7].setBounds(370, 185, 75, 75);
		//3
		btn_seat[8].setBounds(25, 270, 75, 75);
		btn_seat[9].setBounds(110, 270, 75, 75);
		btn_seat[10].setBounds(285, 270, 75, 75);
		btn_seat[11].setBounds(370, 270, 75, 75);
		//4
		btn_seat[12].setBounds(25, 355, 75, 75);
		btn_seat[13].setBounds(110, 355, 75, 75);
		btn_seat[14].setBounds(285, 355, 75, 75);
		btn_seat[15].setBounds(370, 355, 75, 75);
		//5
		btn_seat[16].setBounds(25, 440, 75, 75);
		btn_seat[17].setBounds(110, 440, 75, 75);
		btn_seat[18].setBounds(285, 440, 75, 75);
		btn_seat[19].setBounds(370, 440, 75, 75);
		//6
		btn_seat[20].setBounds(25, 525, 75, 75);
		btn_seat[21].setBounds(110, 525, 75, 75);
		btn_seat[22].setBounds(285, 525, 75, 75);
		btn_seat[23].setBounds(370, 525, 75, 75);
		//7
		btn_seat[24].setBounds(25, 610, 75, 75);
		btn_seat[25].setBounds(110, 610, 75, 75);
		btn_seat[26].setBounds(285, 610, 75, 75);
		btn_seat[27].setBounds(370, 610, 75, 75);
		//8
		btn_seat[28].setBounds(25, 695, 75, 75);
		btn_seat[29].setBounds(110, 695, 75, 75);
		btn_seat[30].setBounds(285, 695, 75, 75);
		btn_seat[31].setBounds(370, 695, 75, 75);
		for( int i = 0; i < btn_seat.length; i++ ) {
			f.add(btn_seat[i]);
		}
		//�����¼� üũ
		for( int i = 0; i < btn_seat.length; i++ ) {
			if( ("2-" + btn_seat_name[i]).equals(cs.seat_name[1][i]) ) {
				btn_seat[i].setBackground(Color.CYAN);
			}//if
		}//for
		//--------------------------------------------------
		//�¼���ư Ŭ���� �׼�
		for( int i = 0; i < btn_seat.length; i++ ) {
			btn_seat[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//�¼��� ���É��� ��
					if( e.getComponent().getBackground() == Color.LIGHT_GRAY ) {
						for( int i = 0; i < btn_seat.length; i++ ) {
							if( e.getComponent() == btn_seat[i] ) {
								e.getComponent().setBackground(Color.YELLOW);
								va.setSeat(va.getSeat() + 1);
								seat_name[i] = "2-" + btn_seat_name[i];
								cs.seat_name[1][i] = "2-" + btn_seat_name[i];
							}//inner if
						}//inner for
						//�¼������� �������ں��� ������ ��
						if( va.getSeat() > (va.getAdult() + va.getChild()) ) {
							e.getComponent().setBackground(Color.LIGHT_GRAY);
							va.setSeat(va.getSeat() - 1);
							for( int i = 0; i < btn_seat.length; i++ ) {
								if( e.getComponent() == btn_seat[i] ) {
									seat_name[i] = null;
									cs.seat_name[1][i] = null;
								}//inner if
							}//inner for
							JOptionPane.showMessageDialog(null, "�¼������� ��� �Ϸ�Ǿ����ϴ�\n�����ϱ� ��ư�� �����ּ���");
						}//inner if
					//�¼������� ������ ��
					}else if( e.getComponent().getBackground() == Color.YELLOW ) {
						e.getComponent().setBackground(Color.LIGHT_GRAY);
						va.setSeat(va.getSeat() - 1);
						for( int i = 0; i < btn_seat.length; i++ ) {
							if( e.getComponent() == btn_seat[i] ) {
								seat_name[i] = null;
								cs.seat_name[1][i] = null;
							}//inner if
						}//inner for
						va.setCheck(false);
					}//outer if
					//�����¼� ���É��� ��
					if( e.getComponent().getBackground() == Color.CYAN ) {
						for( int i = 0; i < btn_seat.length; i++ ) {
							//����� �¼� üũ
							if( e.getComponent() == btn_seat[i] ) {
								if( ("2-" + btn_seat_name[i]).equals(cs.seat_name[1][i]) ) {
									JOptionPane.showMessageDialog(null, "�̹� ����� �¼��Դϴ�");
									JOptionPane.showMessageDialog(null, "���� �¼��� ����Ͻðڽ��ϱ�?");
									va.setSeat(va.getSeat() - 1);
									seat_name[i] = null;
									cs.seat_name[1][i] = null;
									e.getComponent().setBackground(Color.LIGHT_GRAY);
								}//inner if
							}//middle if
						}//for
					}//outer if
				}//mouseClicked
			});//addMouseListener
		}//outer for
		//--------------------------------------------------
		//Ȯ�ι�ư
		Button btn_confirm = new Button("Ȯ��");
		btn_confirm.setBounds(295, 795, 150, 50);
		btn_confirm.setBackground(Color.LIGHT_GRAY);
		f.add(btn_confirm);
		//--------------------------------------------------
		//Ȯ�ι�ư Ŭ���� �׼�
		btn_confirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.dispose();
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
	}//SeatButton1
	//--------------------------------------------------
}//SeatButton1
