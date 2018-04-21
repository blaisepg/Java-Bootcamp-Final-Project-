package com.gc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gc.model.DAOItemImpl;
import com.gc.model.DAOUserImpl;
import com.gc.model.Item;
import com.gc.model.User;
import com.gc.util.API;
import com.gc.util.ApiCredentials;
import com.gc.util.Apparel;

/**
 * 
 * author: WeatherOrNot
 *
 * 
 */
// wunderground api key: be4423cb67742fcc

@Controller
public class HomeController {

	private static final String PIC_PATH = "resources/";
	// DAO USER IMPLEMENTATION OBJECT
	DAOUserImpl usr = new DAOUserImpl();
	// DAO ITEM IMPLEMENTATION OBJECT
	DAOItemImpl itm = new DAOItemImpl();

	// API OBJECT - VALUES ING API CALL
	API ourAPI = new API();

	@RequestMapping(value = {"/", "getLoginPage"})
	public String getLogin() {
		return "Login";
	}

	User currentUser;
	
	@RequestMapping("existingUserLogin")
	public ModelAndView loginUser( @RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		System.out.println("existingUserLogin called");
		
		String pageToReturn = "Login";
		String msg;

		try {
			User userTryingToLogIn = usr.getUser(email);
			System.out.println(userTryingToLogIn);

			if (userTryingToLogIn.getPassword().equals(password)) {
				pageToReturn = "askLocation";
				msg = userTryingToLogIn.getFirstName();
				currentUser = userTryingToLogIn;
			} else {
				pageToReturn = "Login";
				msg = "Incorrect password.";
			}
		}

		catch (Exception e) {
			msg = "Account with that email address not found.";
		}
		
		return new ModelAndView(pageToReturn, "msg", msg);
	}
	
	@RequestMapping("getWelcomePage")
	public ModelAndView getWelcome(Model model, @RequestParam("city") String city, @RequestParam("state") String state){
		try {
			// the HttpClient Interface represents the contract for the HTTP request
			// execution
			HttpClient http = HttpClientBuilder.create().build();

			// HttpHost holds the variables needed for the connections
			// default port for http is 80
			// default port for https is 443

			HttpHost host = new HttpHost("api.wunderground.com", 80, "http");

			// HttpGet retrieves the info identified by the request url (returns as an
			// entity)
			
			city = city.replaceAll(" ", "_");
			
			HttpGet getPage = new HttpGet("/api.wunderground.com/api/83ee1eafa5306085/conditions/q/" + state +"/" + city +".json");

			HttpResponse resp = http.execute(host, getPage);

			// casting the entity returned to a string
			String jsonString = EntityUtils.toString(resp.getEntity());

			System.out.println(jsonString);

			// assign the returned result to a json object
			JSONObject json = new JSONObject(jsonString);
			JSONObject currentObs = json.getJSONObject("current_observation");

			// SETTING OURAPI VARIABLES TO RETRIEVE LATER WITH GETTERS
			ourAPI.setWeather(currentObs.getString("weather"));
			ourAPI.setIcon_URL(currentObs.getString("icon_url"));
			ourAPI.setTemp_f(currentObs.getDouble("temp_f"));
			ourAPI.setPrecip_today_in(currentObs.getString("precip_today_in"));
			ourAPI.setRelative_humidity(currentObs.getString("relative_humidity"));
			ourAPI.setCityState(currentObs.getJSONObject("display_location").getString("full"));

			// this is a test print to our console to make sure we are communicating with
			// the API (response code should be 200)
			System.out.println("Response code: " + resp.getStatusLine().getStatusCode());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("cityState", ourAPI.getCityState());
		model.addAttribute("temp", ourAPI.getTemp_f());
		model.addAttribute("icon_url", ourAPI.getIcon_URL());
					
		return new ModelAndView("welcome", "msg", currentUser.getFirstName());
		
	}
	

	@RequestMapping("getsignup")
	public String giveSignUp() {
		return "signupform";
	}

	@RequestMapping("createUser")
	public ModelAndView createUser(@RequestParam("fname") String firstName,
			@RequestParam("lname") String lastName, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("city") String city, @RequestParam("state") String state) {

		User tempUser = new User(firstName, lastName, email, password);
		usr.createUser(tempUser);
		currentUser = tempUser;
		
		
		try {
			// the HttpClient Interface represents the contract for the HTTP request
			// execution
			HttpClient http = HttpClientBuilder.create().build();

			// HttpHost holds the variables needed for the connections
			// default port for http is 80
			// default port for https is 443

			HttpHost host = new HttpHost("api.wunderground.com", 80, "http");

			// HttpGet retrieves the info identified by the request url (returns as an
			// entity)
			
			city = city.replaceAll(" ", "_");
			
			HttpGet getPage = new HttpGet("/api.wunderground.com/api/83ee1eafa5306085/conditions/q/" + state +"/" + city +".json");

			HttpResponse resp = http.execute(host, getPage);

			// casting the entity returned to a string
			String jsonString = EntityUtils.toString(resp.getEntity());

			System.out.println(jsonString);

			// assign the returned result to a json object
			JSONObject json = new JSONObject(jsonString);
			JSONObject currentObs = json.getJSONObject("current_observation");

			// SETTING OURAPI VARIABLES TO RETRIEVE LATER WITH GETTERS
			ourAPI.setWeather(currentObs.getString("weather"));
			ourAPI.setIcon_URL(currentObs.getString("icon_url"));
			ourAPI.setTemp_f(currentObs.getDouble("temp_f"));
			ourAPI.setPrecip_today_in(currentObs.getString("precip_today_in"));
			ourAPI.setRelative_humidity(currentObs.getString("relative_humidity"));
			ourAPI.setCityState(currentObs.getJSONObject("display_location").getString("full"));

			// this is a test print to our console to make sure we are communicating with
			// the API (response code should be 200)
			System.out.println("Response code: " + resp.getStatusLine().getStatusCode());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("fillCloset", "name", firstName);
	}
	
	@RequestMapping("addToCloset")
	public ModelAndView giveFillClosetPage() {
		return new ModelAndView("fillCloset", "name", currentUser.getFirstName());
	}

	@RequestMapping("getItemInputForm")
	public String getItemInputForm(@RequestParam("itemOfClothing") String itemChosen) {
		String formToReturn;

		switch (itemChosen) {
		case "top":
			formToReturn = "topform";
			break;
		case "sweater":
			formToReturn = "sweaterForm";
			break;
		case "outerwear":
			formToReturn = "outerwearForm";
			break;
		case "bottom":
			formToReturn = "bottomForm";
			break;
		case "dress":
			formToReturn = "dressForm";
			break;
		case "shoe":
			formToReturn = "shoeForm";
			break;
		case "accessory":
			formToReturn = "accessoryForm";
			break;
		default:
			formToReturn = "fillCloset";

		}

		return formToReturn;
	}

	@RequestMapping(value="dressForm", method=RequestMethod.GET)
	public String dressForm() {
		return "dressForm";
	}
	
	@RequestMapping(value="addItem", method=RequestMethod.POST)
	public String addItem( @RequestParam("imageURL") MultipartFile file,
			@RequestParam("type") String type, @RequestParam("description") String desc, @RequestParam("category") String cat) {

		String fileName = file.getOriginalFilename();
		//encodedFileName = Base64.getEncoder().encodeToString(fileName.getBytes());
		String url = null;

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", ApiCredentials.CLOUDNAME,
				  "api_key", ApiCredentials.APIKEY,
				  "api_secret", ApiCredentials.APISECRET));
		
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			url = (String) uploadResult.get("url");
			System.out.println(uploadResult.get("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Item tempItem = new Item("F", currentUser.getUserId(), type, desc, url, cat);
		System.out.println(tempItem.getCategory());

		itm.addItem(tempItem);
		

		return "itemAdded";
	}

	@RequestMapping("addAnother")
	public String giveClosetFormAgain() {
		return "fillCloset";
	}

	@RequestMapping("viewCloset")
	public ModelAndView viewCloset(Model model) {

		model.addAttribute("clothesMap", Apparel.getClosetMap(itm, currentUser));
		
		return new ModelAndView("closet", "name", currentUser.getFirstName());
	}


	@RequestMapping("deleteItem")
	// THIS 'ID' PARAM SNEAKILY PASSED IN FROM FORM USING ~URL ENCODING~
	public ModelAndView deleteItem(@RequestParam("id") int id, Model model) {

		Item tempItem = new Item();
		tempItem.setItemId(id);
		itm.deleteItem(tempItem);
			
		model.addAttribute("clothesMap", Apparel.getClosetMap(itm, currentUser));

		return new ModelAndView("closet", "name", currentUser.getFirstName());
	}

	@RequestMapping("putInHamp")
	// THIS 'ID' PARAM SNEAKILY PASSED IN FROM FORM USING ~URL ENCODING~
	public ModelAndView putInHamp(@RequestParam("id") int id, Model model) {
		
		model.addAttribute("name", currentUser.getFirstName());
		System.out.println(id);
		
		Item itemToModify;
		itemToModify = itm.getItem(id);
		itm.changeHampStatus(itemToModify);

		return new ModelAndView("hamper", "hamperItems", Apparel.getHamperMap(itm, currentUser));
	}

	@RequestMapping("viewHamp")
	public ModelAndView viewHamper(Model model) {

		model.addAttribute("name", currentUser.getFirstName());
		
		return new ModelAndView("hamper", "hamperItems", Apparel.getHamperMap(itm, currentUser));

	}
	

	@RequestMapping("putInCloset")
	// THIS 'ID' PARAM SNEAKILY PASSED IN FROM FORM USING ~URL ENCODING~
	public ModelAndView putInCloset(@RequestParam("id") int id, Model model) {
		
		Item itemToModify;
		itemToModify = itm.getItem(id);
		itm.changeHampStatus(itemToModify);
	
		model.addAttribute("clothesMap", Apparel.getClosetMap(itm, currentUser));
		
		return new ModelAndView("closet", "name", currentUser.getFirstName());
	}

	ArrayList<Item> predictedOutfit = null;

	@RequestMapping("home")
	public ModelAndView getFashionCast(Model model) {

		model.addAttribute("cityState", ourAPI.getCityState());
		model.addAttribute("temp", ourAPI.getTemp_f());
		model.addAttribute("precip", ourAPI.getPrecip_today_in());
		model.addAttribute("weather", ourAPI.getWeather());
		model.addAttribute("icon_url", ourAPI.getIcon_URL());
		model.addAttribute("humidity", ourAPI.getRelative_humidity());
		
		ArrayList<Item> predictedOutfit = Apparel.generateOutfit(itm, currentUser, ourAPI);
		
		model.addAttribute("name", currentUser.getFirstName());

		return new ModelAndView("fashionCast", "outfitItems", predictedOutfit);

	}


}