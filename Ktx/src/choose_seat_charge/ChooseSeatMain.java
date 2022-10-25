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
	public String[][] seat_name = new String[8][32];//선택좌석 생성
	public static void main(String[] args) {
		ChooseSeatMain cs = new ChooseSeatMain();
		Variable va = new Variable();//변수 클래스 생성
		SeatButton0 sb0 = new SeatButton0();//1호칸 좌석버튼 프레임 생성
		SeatButton1 sb1 = new SeatButton1();//2호칸 좌석버튼 프레임 생성
		SeatButton2 sb2 = new SeatButton2();//3호칸 좌석버튼 프레임 생성
		SeatButton3 sb3 = new SeatButton3();//4호칸 좌석버튼 프레임 생성
		SeatButton4 sb4 = new SeatButton4();//5호칸 좌석버튼 프레임 생성
		SeatButton5 sb5 = new SeatButton5();//6호칸 좌석버튼 프레임 생성
		SeatButton6 sb6 = new SeatButton6();//7호칸 좌석버튼 프레임 생성
		SeatButton7 sb7 = new SeatButton7();//8호칸 좌석버튼 프레임 생성
		//--------------------------------------------------
		//프레임 생성
		Frame f = new Frame("좌석 선택");
		f.setSize(650, 880);
		f.setLocation(700, 100);
		f.setLayout(null);
		//--------------------------------------------------
		//글자 입력
		Font font = new Font("", Font.BOLD, 30);
		Label passage = new Label("통로");
		passage.setBounds(200, 410, 75, 75);
		passage.setFont(font);
		Label front = new Label("앞");
		front.setBounds(220, 25, 75, 75);
		front.setFont(font);
		Label back = new Label("뒤");
		back.setBounds(220, 780, 75, 75);
		back.setFont(font);
		f.add(passage);
		f.add(front);
		f.add(back);
		//--------------------------------------------------
		//칸 번호
		String [] btn_room_number = {"1호차", "2호차", "3호차", "4호차", "5호차", "6호차", "7호차", "8호차"};//칸 번호 생성
		Button[] btn_room = new Button[8];
		//--------------------------------------------------
		//칸 번호 생성
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
		//칸 번호 좌석 프레임 생성
		for( int i = 0; i < btn_room.length; i++ ) {
			btn_room[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for( int i = 0; i < btn_room.length; i++ ) {
						//선택될때
						if( e.getComponent() == btn_room[i] ) {
							e.getComponent().setBackground(Color.YELLOW);
							//1호칸
							if( i == 0 ) {
								new SeatButton0(va, cs);
							//2호칸
							}else if( i == 1 ) {
								new SeatButton1(va, cs);
							//3호칸
							}else if( i == 2 ) {
								new SeatButton2(va, cs);
							//4호칸
							}else if( i == 3 ) {
								new SeatButton3(va, cs);
							//5호칸
							}else if( i == 4 ) {
								new SeatButton4(va, cs);
							//6호칸
							}else if( i == 5 ) {
								new SeatButton5(va, cs);
							//7호칸
							}else if( i == 6 ) {
								new SeatButton6(va, cs);
							//8호칸
							}else {
								new SeatButton7(va, cs);
							}
						//선택된것이 아닌 모든것들
						}else {
							btn_room[i].setBackground(Color.GREEN);
						}//if
					}//inner for
				}//mouseClicked
			});//addMouseListener
		}//outer for
		//--------------------------------------------------
		//예매하기 버튼 생성
		Button btn_finish = new Button("예매하기");
		btn_finish.setBounds(295, 795, 150, 50);
		btn_finish.setBackground(Color.LIGHT_GRAY);
		f.add(btn_finish);
		//--------------------------------------------------
		//예매하기 버튼 클릭시 액션
		btn_finish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//선택된 좌석 내역서에 입력
				for( int i = 0; i < cs.seat_name.length; i++ ) {
					for( int j = 0; j < cs.seat_name[i].length; j++ ) {
						if( cs.seat_name[i][j] != null ) {
							va.setSeat_name(va.getSeat_name() + cs.seat_name[i][j] + " ");
						}//if
					}//inner for
				}//outer for
				//선택된 역명에 따른 가격
				if( va.getStation1() == "서울역" ) {
					if( va.getStation2() == "수원역" ) {
						va.setAdult_price(8400);
						va.setChild_price(4200);
					}else if( va.getStation2() == "대전역" ) {
						va.setAdult_price(23700);
						va.setChild_price(11850);
					}else if( va.getStation2() == "부산역" ) {
						va.setAdult_price(59800);
						va.setChild_price(29900);
					}
				}else if( va.getStation1() == "수원역" ) {
					if( va.getStation2() == "서울역" ) {
						va.setAdult_price(8400);
						va.setChild_price(4200);
					}else if( va.getStation2() == "대전역" ) {
						va.setAdult_price(12900);
						va.setChild_price(6450);
					}else if( va.getStation2() == "부산역" ) {
						va.setAdult_price(46300);
						va.setChild_price(23150);
					}
				}else if( va.getStation1() == "대전역" ) {
					if( va.getStation2() == "수원역" ) {
						va.setAdult_price(12900);
						va.setChild_price(6450);
					}else if( va.getStation2() == "서울역" ) {
						va.setAdult_price(23700);
						va.setChild_price(11850);
					}else if( va.getStation2() == "부산역" ) {
						va.setAdult_price(36200);
						va.setChild_price(18100);
					}
				}else if( va.getStation1() == "부산역" ) {
					if( va.getStation2() == "수원역" ) {
						va.setAdult_price(46300);
						va.setChild_price(23150);
					}else if( va.getStation2() == "대전역" ) {
						va.setAdult_price(36200);
						va.setChild_price(18100);
					}else if( va.getStation2() == "서울역" ) {
						va.setAdult_price(59800);
						va.setChild_price(29900);
					}
				}//if
				//지정좌석과 선택된좌석의 수가 맞는지 확인하고 맞으면 true, 틀리면 false
				if( va.getSeat() == (va.getAdult() + va.getChild()) ) {
					va.setCheck(true);
				}
				//true일때
				if(va.isCheck()) {
					JOptionPane.showMessageDialog(null, "현제 선택된 좌석은 " + va.getSeat_name() + " 입니다\n" + "맞으시면 확인버튼을 눌러주세요");
					JOptionPane.showMessageDialog(null, "결제창으로 넘어갑니다");
					f.dispose();
					new Charge(va);
				//false일때
				}else {
					JOptionPane.showMessageDialog(null, "좌석선택이 완료되지 않았습니다\n다시 선택해주시기 바랍니다");
				}
			}
		});
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
	}//main
}
