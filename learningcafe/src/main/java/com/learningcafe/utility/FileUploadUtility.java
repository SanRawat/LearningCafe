package com.learningcafe.utility;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "G:\\Projects\\Spring\\LearningCafe\\learningcafe\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";

	private static Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub

		// get real path

		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);

		/*
		 * to make sure all the directories exists make directories
		 */

		if (!new File(ABS_PATH).exists()) {

			new File(ABS_PATH).mkdirs();
		}

		if (!new File(REAL_PATH).exists()) {

			new File(REAL_PATH).mkdirs();
		}
		
		try {
			// server uplaod
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//project direcory upload
			file.transferTo(new File(ABS_PATH+code+".jpg"));
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
