package ktx_LoginPage;

import java.util.ArrayList;
import java.util.HashMap;

public class Map {
	
	static HashMap<Integer, UserInformation> map = new HashMap<Integer, UserInformation>();
	UserInformation ui = new UserInformation();	
	
	public ArrayList<UserInformation> userList(){
		//맵의 모든 값들을 어레이리스트에 넣기
		return new ArrayList<UserInformation>(map.values());
	}
	
}
