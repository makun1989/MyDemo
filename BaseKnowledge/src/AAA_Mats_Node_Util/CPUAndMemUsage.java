package AAA_Mats_Node_Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CPUAndMemUsage {
	private static final String FILE_TYPE = ".txt";
	
	public static void main(String[] args) throws Exception {
		Map<String ,Object> resolvedParams =new HashMap<String,Object>();
		resolvedParams.put("preUsageFile", "/home/makun/Downloads/CPU_usage1.txt");
		resolvedParams.put("postUsageFile", "/home/makun/Downloads/CPU_usage1.txt");
		doAction(resolvedParams);
	}

	public static void doAction(Map<String, Object> resolvedParams) throws Exception {
		String preUsageFile = (String) resolvedParams.get("preUsageFile");
		String postUsageFile = (String) resolvedParams.get("postUsageFile");
		String preStr = null;
		String postStr = null;
		String compStr = null;

		try {
			preStr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(preUsageFile)))).readLine();
			postStr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(postUsageFile))))
					.readLine();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] preList = preStr.trim().split(" ");
		String[] postList = postStr.trim().split(" ");

		if ((preList.length == postList.length) && ((preList.length == 7) || (preList.length == 11))) {
			if (preList.length == 7) {
				compStr = getCompareUsage(preList, postList, false);
			} else if (preList.length == 11) {
				compStr = getCompareUsage(preList, postList, true);
			}

		}

		String newLine = System.getProperty("line.separator");
		System.out.println(preStr);
		System.out.println(newLine);
		System.out.println(postStr);
		System.out.println(newLine);
		System.out.println(compStr);

//		this.getClass().getSimpleName();
//		List<String> stdOutput = new ArrayList<String>();
//		String newLine = System.getProperty("line.separator");
//		stdOutput.add(preStr);
//		stdOutput.add(newLine);
//		stdOutput.add(postStr);
//		stdOutput.add(newLine);
//		stdOutput.add(compStr);

	}

	private static  String getCompareUsage(String[] preList, String[] postList, boolean isCpu) {
		// mem:length 7 , change 0 kb
		// cpu:length 11 ,change 0,2,5 %
		
		StringBuilder sb = new StringBuilder();
		sb.append("change:");

		for (int i = 0; i < preList.length; i++) {
			if (isCpu && ((i == 2) || (i == 0) || (i == 5))) {
				sb.append((Double.parseDouble(postList[i].replace("%", "")) - Double.parseDouble(preList[i].replace("%", ""))) + "% ");
			} else if (!isCpu && (i == 0)) {
				sb.append((Integer.parseInt(postList[i]) - Integer.parseInt(preList[i])) + " ");
			} else {
				sb.append(preList[i]+" ");
			}
		}

		return sb.toString();

	}

}
