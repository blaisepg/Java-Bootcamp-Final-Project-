package com.gc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gc.model.Item;

/**
 * This controller class is for photo uploads
 *
 */
@Controller
public class UploadController {


    /* Class fields */
    private static final String UPLOAD_DIRECTORY = "images";  // Directory path of uploads
    private static final String TEMP_DIRECTORY = "temp";      // Temporary directory
	private static final String CUSTOMERID = "224";
	private static final String PIC_PATH = "resources/userimages/";
    private final double[] DEFAULT_PHOTO_LOCATION = {42.3314, -83.0458}; // In center of Detroit
    private final double[] LAT_COORDINATE_LIMIT = {42.30, 42.40};
    private final double[] LNG_COORDINATE_LIMIT = {-83.13, -82.96};
    private static byte[] tempFile = null;
    private static String tempFileName = null;
	
	/**
	 * This method creates a new images directory if it doesn't already exist
	 *
	 */
	private static boolean createDirectory(String path) {
		
		// define the directory
		File directory = new File(path);
		System.out.println(directory.isAbsolute());
		// If the directory doesn't exist it is created
		if (!directory.exists()) {
			System.out.println(directory.getName() + " directory doesn't exist.  Creating directory...");
			try {
				directory.mkdir();
				System.out.println("Directory successfully created!");
				return true;
			} catch (SecurityException se) {
				System.out.println(directory.getName() + " directory could not be created!");
				return false;
			}
		}
		return true;
	}

	/**
	 * This method will save the file to the path with filename
	 * 
	 * @param file CommonsMultipartFile from user
	 * @param path String of path to save
	 * @param filename String of filename to save
	 * @return boolean true if save successfully, false otherwise
	 */
	public static boolean saveImageToDirectory(byte[] file, String path, String filename) {
		// Create a new directory, if creation fails, show error page
		if (!createDirectory(path)) {
			return false;
		}
		// attempt to store file path
		System.out.println("Attempting to store to " + path);
		try {
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + filename)));
			stream.write(file);
			stream.flush();
			stream.close();
			System.out.println(filename + "successfully stored!");

			return true;
		} catch (IOException e) {
			System.out.println("Error saving file...");
			e.printStackTrace();
			return false;
		}
	}		
		
	@RequestMapping(value="download", method=RequestMethod.POST)
	public String showUploadPreview(@RequestParam("file") CommonsMultipartFile file,
									@RequestParam("category") Item category,
									HttpSession session,
									HttpServletRequest request,
									Model model) {
		
			tempFile = null;
			tempFile = file.getBytes();
			tempFileName = file.getOriginalFilename();
			
			String currentPath = request.getScheme() + "://" +
					request.getServerName() + ":" +
					request.getServerPort() + "/";
			
			model.addAttribute("imageURL", currentPath + "temp/" + file.getOriginalFilename());
			model.addAttribute("category", category);
			
		return "preview-upload";
	}
	
	
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String uploadPhoto(@RequestParam("imageURL") MultipartFile file) {
		//public String uploadPhoto(@RequestParam("imageURL") String file) {		
		//String fileName = file.getOriginalFilename();
		//encodedFileName = Base64.getEncoder().encodeToString(fileName.getBytes());
		//String encodedFileName =  PIC_PATH + fileName;
		
		System.out.println(file.getOriginalFilename());
	
		//Define the file path and name
		
		
		//
		
		return "itemAdded";
	}
	
	//file:///users/saclauw/Desktop/Program/Eclipse.app/Contents/MacOS/resources/IMG_1086.jpg
}
