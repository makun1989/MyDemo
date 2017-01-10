

import java.util.Map;


public class GetDiffUsageAction {
	public static void main(String[] args) throws Exception{
		new GetDiffUsageAction().doAction(null);
	}

	public void doAction(Map<String, Object> resolvedParams) throws Exception {
//		String preUsageFile=(String) resolvedParams.get("preUsageFile");
//		String postUsageFile=(String) resolvedParams.get("postUsageFile");
		System.out.println();
		
		
	}

	
	
	
	private void writeToFile(String fileName){

//		PrintWriter writer = null;
//		try {
//			File[] logFiles = getCurrentCase().getCaseFolder().listFiles(new FileFilter() {
//				@Override
//				public boolean accept(File file) {
//					return file.getName().startsWith(fileName);
//				}
//			});
//			int index = logFiles.length + 1;
//			File file = new File(getCurrentCase().getCaseFolder(), fileName + index + FILE_TYPE);
//			if (!file.exists()) {
//				file.getParentFile().mkdirs();
//			}
//			
//			writer = new PrintWriter(new FileOutputStream(file));
//			if (result.exitValue() == 0) {
//				for (String line : result.getStandardOutput()) {
//					writer.println(line);
//				}
//			} else {
//				for (String line : result.getErrorOutput()) {
//					writer.println(line);
//				}
//			}
//			writer.flush();
//		} catch (IOException e) {
//			log.error("print output error!", e);
//			throw new ActionException.Builder().title(BleeActionException.TITLE_IO_ERROR)
//					.details(BleeActionException.DETAIL_PRINT_ERROR).params(e.getMessage()).build();
//		} finally {
//			if (writer != null) {
//				writer.close();
//			}
//		}
//	
	}
}
