import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerInfo {

	private static String macAddressStr = null;

	private static final String[] windowsCommand = { "ipconfig", "/all" };
	private static final String[] linuxCommand = { "/sbin/ifconfig", "-a" };
	private static final Pattern macPattern = Pattern.compile(".*((:?[0-9a-f]{2}[-:]){5}[0-9a-f]{2}).*",
			Pattern.CASE_INSENSITIVE);

	private final static List<String> getMacAddressList() throws IOException {
		final ArrayList<String> macAddressList = new ArrayList<String>();
		final String os = System.getProperty("os.name");
		final String command[];

		if (os.startsWith("Windows")) {
			command = windowsCommand;
		} else if (os.startsWith("Linux")) {
			command = linuxCommand;
		} else {
			throw new IOException("Unknow operating system:" + os);
		}

		final Process process = Runtime.getRuntime().exec(command);

		BufferedReader bufReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		for (String line = null; (line = bufReader.readLine()) != null;) {
			Matcher matcher = macPattern.matcher(line);
			if (matcher.matches()) {
				macAddressList.add(matcher.group(1));
				// macAddressList.add(matcher.group(1).replaceAll("[-:]",
				// ""));//去掉MAC中的“-”
			}
		}

		process.destroy();
		bufReader.close();
		return macAddressList;
	}

	public static String getMacAddress() {
		if (macAddressStr == null || macAddressStr.equals("")) {
			StringBuffer sb = new StringBuffer(); // 存放多个网卡地址用，目前只取一个非0000000000E0隧道的值
			try {
				List<String> macList = getMacAddressList();
//				for (Iterator<String> iter = macList.iterator(); iter.hasNext();) {
//					String amac = iter.next();
////					if (!amac.equals("0000000000E0")) {
//						sb.append(amac);
//						break;
////					}
//				}
				sb.append(macList.iterator().next());
			} catch (IOException e) {
				e.printStackTrace();
			}
			macAddressStr = sb.toString();
		}

		return macAddressStr;
	}

	private ComputerInfo() {

	}

	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		System.out.println(ComputerInfo.getMacAddress());
		System.out.println(getMd5(ComputerInfo.getMacAddress()));

	}
}
