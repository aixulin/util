package upload;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class UploadFileUtils {

	public static String executeUpload(String outDir, MultipartFile file) throws Exception
	{
		File outDirFile = new File(outDir);
		//插件上传文件夹不存在时进行创建
		if (!outDirFile.exists()){
			outDirFile.mkdirs();
		}
		//文件后缀名
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		//存储在服务器上的文件名
		String filename = file.getOriginalFilename();
		//存储在服务器全路径
		String filePath = outDir + File.separator + filename;
		//服务器端保存的文件对象
		File serverFile = new File(filePath);
		//将上传的文件写入到服务器端文件内
		file.transferTo(serverFile);
		return filePath;
	}
}
