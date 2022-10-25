package ticket;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import choose_seat_charge.ChooseSeatMain;
import variable.Variable;


public class TrainMain  {
	public static void main(String[] args) {
		Variable va = new Variable();
		//프레임 생성
		Frame f = new Frame("승차권 예매");
		f.setSize(650, 880);
		f.setLocation(700, 100);
		f.setLayout(null);
		
		Font font = new Font("", Font.BOLD, 30);
		
		// 출발지
		Label startLb = new Label("출발  : ");
		startLb.setBounds(50,150,100,75);
		startLb.setFont(font);
		f.add(startLb);
		String start[] = {"서울역", "수원역", "대전역", "부산역"};
		JComboBox<String> startCombo = new JComboBox<String>(start);
		startCombo.setBounds(150,175,150,30);
		f.add(startCombo);
		
		// 도착지
		Label arriveLb = new Label("도착 : ");
		arriveLb.setBounds(350,150,100,75);
		arriveLb.setFont(font);
		f.add(arriveLb);
		String arrive[] = {"서울역", "수원역", "대전역", "부산역"};
		JComboBox<String> arriveCombo = new JComboBox<String>(arrive);
		arriveCombo.setBounds(450,175,150,30);
		f.add(arriveCombo);
		
		// 날짜
		Label dateLb = new Label("출발일");
		dateLb.setBounds(275,250,100,75);
		dateLb.setFont(font);
		f.add(dateLb);
		String date[] = {"2022년 9월 19일 (월)", "2022년 9월 20일 (화)","2022년 9월 21일 (수)","2022년 9월 22일 (목)","2022년 9월 23일 (금)"};
		JComboBox<String> dateCombo = new JComboBox<String>(date);
		dateCombo.setBounds(150,350,150,30);
		f.add(dateCombo);
		String time[] = {"09:00", "12:00","15:00","18:00","21:00"};
		JComboBox<String> timeCombo = new JComboBox<String>(time);
		timeCombo.setBounds(350,350,150,30);
		f.add(timeCombo);
		
		// 나이 및 좌석수
		Label humanLb = new Label("승객 연령 및 좌석수");
		humanLb.setBounds(190,400,300,75);
		humanLb.setFont(font);
		f.add(humanLb);
		Label adultLb = new Label("어른 : ");
		adultLb.setBounds(150,500,150,30);
		f.add(adultLb);
		Label childLb = new Label("청소년 : ");
		childLb.setBounds(150,550,150,30);
		f.add(childLb);
		JComboBox<Integer> numCombo1 = new JComboBox<Integer>();
		numCombo1.setBounds(350,500,150,30);
		f.add(numCombo1);
		numCombo1.addItem(0);
		numCombo1.addItem(1);
		numCombo1.addItem(2);
		numCombo1.addItem(3);
		numCombo1.addItem(4);
		numCombo1.setSelectedIndex(1);
		JComboBox<Integer> numCombo2 = new JComboBox<Integer>();
		numCombo2.setBounds(350,550,150,30);
		f.add(numCombo2);
		numCombo2.addItem(0);
		numCombo2.addItem(1);
		numCombo2.addItem(2);
		numCombo2.addItem(3);
		numCombo2.addItem(4);
		numCombo2.setSelectedIndex(1);
		
		// 조회 버튼
		Button btn_inquiry = new Button("열차 조회하기");
		btn_inquiry.setBounds(275, 700, 100, 50);
		f.add(btn_inquiry);
		
		// 조회 완료시
		btn_inquiry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(startCombo.getSelectedItem().equals(arriveCombo.getSelectedItem())) {
					JOptionPane.showMessageDialog(null, "동일 지역이 선택 될 수 없습니다");
				} else {
					JOptionPane.showMessageDialog(null, "출발역 : " + startCombo.getSelectedItem() 
					+ "\n도착역 : " + arriveCombo.getSelectedItem() 
					+ "\n일시 : " + dateCombo.getSelectedItem() + timeCombo.getSelectedItem() 
					+ "\n인원 : 어른 : " + numCombo1.getSelectedItem() + "명 청소년 : " + numCombo2.getSelectedItem() + "명");
					va.setStation1(startCombo.getSelectedItem().toString());
					va.setStation2(arriveCombo.getSelectedItem().toString());
					va.setDay(dateCombo.getSelectedItem().toString());
					va.setTime(timeCombo.getSelectedItem().toString());
					va.setAdult(Integer.parseInt(numCombo1.getSelectedItem().toString()));
					va.setChild(Integer.parseInt(numCombo2.getSelectedItem().toString()));
					ChooseSeatMain.main(args);
				f.dispose();
				}
			}
		});
		
		f.setVisible(true);
		
		//종료 어댑터
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				f.dispose();
			}
		});
	} // main
}