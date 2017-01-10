package com.niit.shoppingcart.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private static Logger log = LoggerFactory.logger(FileUtil.class);

	public static void upload(String path, MultipartFile file, String fileName) {
		log.debug("starting of the method upload");
		log.debug("path:" + path);
		log.debug("fileName:" + fileName);
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// creating the directory to store file
				File dir = new File(path);
				if (!dir.exists())
					dir.mkdirs();

				// create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				log.info("server File Location =" + serverFile.getAbsolutePath());

			} catch (Exception e)

			{
				e.printStackTrace();

			}

		}

		log.debug("enging of th method upload");
	}

	// get current date
	public static String getCurrentDate() {
		String date_value = null;
		try {
			GregorianCalendar date = new GregorianCalendar();
			int day = date.get(Calendar.DAY_OF_MONTH);
			int month = date.get(Calendar.MONTH);
			int year = date.get(Calendar.YEAR);
			date_value = day + "_" + (month + 1) + "_" + year;
		} catch (Exception ex) {
			System.out.println("Exception getCurrentDate( : " + ex.getMessage());
		}
		return date_value;
	}

	public static int getRandomNumber() {
		
		int randomNum = 0;
		int max = 99999;
		int min = 1;
		try {
			Random rand = new Random();
			randomNum = rand.nextInt((max - min) + 1) + min;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomNum;
	}

}
