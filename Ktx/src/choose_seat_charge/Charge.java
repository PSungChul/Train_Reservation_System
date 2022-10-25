package choose_seat_charge;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import ticket.TrainMain;
import variable.Variable;

public class Charge{
	public Charge() {
		//생성자
	}//Charge
	public Charge(Variable va) {
		//--------------------------------------------------
		//프레임 생성
		Frame f = new Frame();
		f.setSize(500, 800);
		f.setLocation(700, 100);
		f.setLayout(null);
		f.setTitle("결제 내역");
		//--------------------------------------------------
		//폰트 설정
		Font font = new Font("", Font.BOLD, 30);
		//--------------------------------------------------
		//내역서 작성
		Label course = new Label("노선 : " + va.getStation1() + " ~ " + va.getStation2());
		course.setBounds(10, 50, 500, 50);
		course.setFont(font);
		
		Label day_time = new Label("날짜 : " + va.getDay() + " " + va.getTime());
		day_time.setBounds(10, 150, 500, 50);
		day_time.setFont(font);
		
		Label people = new Label("어른 : " + va.getAdult() + "명 " + "아이 : " + va.getChild() + "명");
		people.setBounds(10, 250, 500, 50);
		people.setFont(font);
		
		Label seat_name = new Label("역명 : " + va.getSeat_name().trim());
		seat_name.setBounds(10, 350, 500, 50);
		seat_name.setFont(font);
		
		Label charge = new Label("가격 : " + (va.getAdult_price() * va.getAdult() + va.getChild_price() * va.getChild()) + "원");
		charge.setBounds(10, 450, 500, 50);
		charge.setFont(font);
		
		//--------------------------------------------------
		//결제버튼
		Button btn_pay = new Button("결제");
		btn_pay.setBounds(350, 700, 100, 50);
		//결제버튼 클릭시 이벤트
		btn_pay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "가격은 " + (va.getAdult_price() * va.getAdult() + va.getChild_price() * va.getChild()) + "원 입니다\n결제하시겠습니까?");
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다");
				f.dispose();
			}
		});
		//--------------------------------------------------
		//추가
		f.add(btn_pay);
		f.add(course);
		f.add(day_time);
		f.add(people);
		f.add(seat_name);
		f.add(charge);
		//--------------------------------------------------
		f.setVisible(true);
		//--------------------------------------------------
		//종료 어댑터
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				f.dispose();
				
			}
		});
		//--------------------------------------------------
	}//Charge
}
