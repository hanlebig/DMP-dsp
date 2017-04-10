package com.taiyear.dsp.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.taiyear.dsp.marketing.entity.thread.ResultJson;


public class BaseController {
	protected ResultJson upload(int fileSize,MultipartFile multifile, HttpServletRequest request) {
		ResultJson res = new ResultJson();
		Date date = new Date();
		// 获取年 月 日
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		String stryear = year.format(date);
		SimpleDateFormat month = new SimpleDateFormat("MM");
		String strmonth = month.format(date);
		SimpleDateFormat day = new SimpleDateFormat("dd");
		String strday = day.format(date);
		String uploadHome = "";
		String newFileName = "";
		String msg = "";
		String relativeFilePath = "";
		String path = "";
		if (multifile.getSize() > fileSize) {
			msg = "文件大于"+ multifile.getSize() +"k,请重新上传文件";
			res.setSuccess(false);
			res.setMsg(msg);
			return res;
		} else {
			String filename = multifile.getOriginalFilename();
			String fileSuffix = filename.substring(filename.lastIndexOf("."),
					filename.length());
			String relativePath = File.separator + stryear + File.separator + strmonth + File.separator + strday
					+ File.separator;
			String serverPath = request.getSession().getServletContext()
					.getRealPath("/upload_files");
			uploadHome = serverPath + relativePath;
			newFileName = UUID.randomUUID().toString() + fileSuffix;
			relativeFilePath = relativePath + newFileName;
			if (multifile != null) {
				try {
					path = saveFileToServer(multifile, uploadHome, newFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		res.setSuccess(true);
		res.setObj(path);
		res.setMsg("上传成功");
		return res;
	}
	
	/**
	 * 保存文件到指定目录
	 * 
	 * @param multifile
	 * @param path
	 * @param filename
	 * @throws IOException
	 */
	protected  String saveFileToServer(MultipartFile multifile, String path,
			String filename) throws IOException {
		// 创建目录
		File dir = new File(path + filename);
		if (dir.getParentFile().exists()) {
			dir.createNewFile();
		} else if (!dir.getParentFile().exists()) {
			dir.getParentFile().mkdirs();
			dir.createNewFile();
		}
		// 读取文件流并保持在指定路径
		InputStream inputStream = multifile.getInputStream();
		OutputStream outputStream = new FileOutputStream(path + filename);
		byte[] buffer = multifile.getBytes();

		int byteread = 0;
		while ((byteread = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, byteread);
			outputStream.flush();
		}
		outputStream.close();
		inputStream.close();
		return path + filename;
	}	
	
}
