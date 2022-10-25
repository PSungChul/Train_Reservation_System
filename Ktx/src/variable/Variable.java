package variable;

public class Variable{
	//변수
	int seat = 0;//좌석수
	boolean isCheck = false;//좌석체크
	static int adult = 0;//어른 수
	int adult_price = 0;//어른 가격
	static int child = 0;//아이 수
	int child_price = 0;//아이 가격
	int money = 0;//가격
	static String day = "";//날짜
	static String time = "";//시간
	static String station1 = "";
	static String station2 = "";
	String seat_name = "";//체크좌석
	//--------------------------------------------------
	//get && set
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public boolean isCheck() {
		return isCheck;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getSeat_name() {
		return seat_name;
	}
	public void setSeat_name(String seat_name) {
		this.seat_name = seat_name;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStation1() {
		return station1;
	}
	public void setStation1(String station1) {
		this.station1 = station1;
	}
	public String getStation2() {
		return station2;
	}
	public void setStation2(String station2) {
		this.station2 = station2;
	}
	public int getAdult_price() {
		return adult_price;
	}
	public void setAdult_price(int adult_price) {
		this.adult_price = adult_price;
	}
	public int getChild_price() {
		return child_price;
	}
	public void setChild_price(int child_price) {
		this.child_price = child_price;
	}
	//--------------------------------------------------
}//Variable
