import java.util.HashMap;
import java.util.Map;

public class TestInteger {
	public static void main(String[] args) {
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("abc",0.4);
		Integer i=null;
		Object timeObj = map.get("abc");
//		if(timeObj instanceof Double)
//			i=Integer.valueOf((int)(double)timeObj);
//		else
//			i=(Integer) timeObj;
		
		i=(Integer)timeObj;
		
		
	}
}
