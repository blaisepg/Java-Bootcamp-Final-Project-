package com.gc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.springframework.web.servlet.ModelAndView;

import com.gc.model.DAOItemImpl;
import com.gc.model.Item;
import com.gc.model.User;

public class Apparel {
	
	public static HashMap<String, ArrayList<Item>> getClosetMap(DAOItemImpl itm, User currentUser) {
		ArrayList<Item> userCloset = itm.getClosetItems(currentUser);
		ArrayList<Item> userTops = new ArrayList<Item>();
		ArrayList<Item> userSweaters = new ArrayList<Item>();	
		ArrayList<Item> userBottoms = new ArrayList<Item>();	
		ArrayList<Item> userOuterwear = new ArrayList<Item>();	
		ArrayList<Item> userShoes = new ArrayList<Item>();	
		ArrayList<Item> userAccessories = new ArrayList<Item>();
				
		for (Item item : userCloset) {
			if (item.getCategory().equals("TOP")) {
				userTops.add(item);
			}
			if (item.getCategory().equals("SWEATER")) {
				userSweaters.add(item);
			}
			if (item.getCategory().equals("BOTTOM")) {
				userBottoms.add(item);
			}
			if (item.getCategory().equals("OUTERWEAR")) {
				userOuterwear.add(item);
			}
			if (item.getCategory().equals("SHOE")) {
				userShoes.add(item);
			}
			if (item.getCategory().equals("ACCESSORY")) {
				userAccessories.add(item);
			}
		}
		
		HashMap<String, ArrayList<Item>> clothesInCloset = new HashMap<String, ArrayList<Item>>();
		clothesInCloset.put("Tops", userTops);
		clothesInCloset.put("Bottoms", userBottoms);
		clothesInCloset.put("Sweaters", userSweaters);
		clothesInCloset.put("Outerwear", userOuterwear);
		clothesInCloset.put("Shoes", userShoes);
		clothesInCloset.put("Accessories", userAccessories);
		
		return clothesInCloset;
	}
	
	public static HashMap<String, ArrayList<Item>> getHamperMap(DAOItemImpl itm, User currentUser) {
		ArrayList<Item> userHamper = itm.getHamperItems(currentUser);
		ArrayList<Item> userTops = new ArrayList<Item>();
		ArrayList<Item> userSweaters = new ArrayList<Item>();	
		ArrayList<Item> userBottoms = new ArrayList<Item>();	
		ArrayList<Item> userOuterwear = new ArrayList<Item>();	
		ArrayList<Item> userShoes = new ArrayList<Item>();	
		ArrayList<Item> userAccessories = new ArrayList<Item>();
				
		for (Item item : userHamper) {
			if (item.getCategory().equals("TOP")) {
				userTops.add(item);
			}
			if (item.getCategory().equals("SWEATER")) {
				userSweaters.add(item);
			}
			if (item.getCategory().equals("BOTTOM")) {
				userBottoms.add(item);
			}
			if (item.getCategory().equals("OUTERWEAR")) {
				userOuterwear.add(item);
			}
			if (item.getCategory().equals("SHOE")) {
				userShoes.add(item);
			}
			if (item.getCategory().equals("ACCESSORY")) {
				userAccessories.add(item);
			}
		}
		
		HashMap<String, ArrayList<Item>> clothesInHamper = new HashMap<String, ArrayList<Item>>();
		clothesInHamper.put("Tops", userTops);
		clothesInHamper.put("Bottoms", userBottoms);
		clothesInHamper.put("Sweaters", userSweaters);
		clothesInHamper.put("Outerwear", userOuterwear);
		clothesInHamper.put("Shoes", userShoes);
		clothesInHamper.put("Accessories", userAccessories);
		
		return clothesInHamper;
	}
	
	
	//TO GENERATE SUGGESTED OUTFIT
	public static ArrayList<Item> generateOutfit(DAOItemImpl itm, User currentUser, API ourAPI){

		ArrayList<Item> allItems = itm.getClosetItems(currentUser);
		ArrayList<Item> predictedOutfit = new ArrayList<Item>();

		Random randomGenerator;
		randomGenerator = new Random();

		try {
			if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
				
				for (Item item : allItems) {
					if (item.getType().equals("umbrella")) {
						predictedOutfit.add(item);
						break;
					}
				}
			}

			// HOT
			if (ourAPI.getTemp_f() >= 80.0) {
				ArrayList<Item> hotTops = new ArrayList<Item>();
				ArrayList<Item> hotBottoms = new ArrayList<Item>();
				ArrayList<Item> hotShoes = new ArrayList<Item>();
				ArrayList<Item> hotOuterwear = new ArrayList<Item>();

				//IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							hotShoes.add(item);
						}
						else if (item.getType().equals("rainCoat")) {
							hotOuterwear.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {
					for (Item item : allItems) {
						if (item.getType().equals("sandals")) {
							hotShoes.add(item);
						} else if (item.getType().equals("sneakers")) {
							hotShoes.add(item);
						} else if (item.getType().equals("flats")) {
							hotShoes.add(item);
						}
					}
				}

				for (Item item : allItems) {
					
					if (item.getType().equals("tankTop")) {
						hotTops.add(item);
					} else if (item.getType().equals("tshirt")) {
						hotTops.add(item);
					}
					
					else if (item.getType().equals("shorts")) {
						hotBottoms.add(item);
					} else if (item.getType().equals("skirt")) {
						hotBottoms.add(item);
					}

				}

				int index = randomGenerator.nextInt(hotTops.size());
				Item hotTopPick = hotTops.get(index);
				predictedOutfit.add(hotTopPick);

				index = randomGenerator.nextInt(hotBottoms.size());
				Item hotBottomsPick = hotBottoms.get(index);
				predictedOutfit.add(hotBottomsPick);

				index = randomGenerator.nextInt(hotShoes.size());
				Item hotShoesPick = hotShoes.get(index);
				predictedOutfit.add(hotShoesPick);
				
				index = randomGenerator.nextInt(hotOuterwear.size());
				Item hotOuterwearPick = hotOuterwear.get(index);
				predictedOutfit.add(hotOuterwearPick);

			}

			// WARM
			else if (ourAPI.getTemp_f() >= 70.0) {
				ArrayList<Item> warmTops = new ArrayList<Item>();
				ArrayList<Item> warmBottoms = new ArrayList<Item>();
				ArrayList<Item> warmShoes = new ArrayList<Item>();
				ArrayList<Item> warmOuterwear = new ArrayList<Item>();
				
				// IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
				
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							warmShoes.add(item);
						}
						
						else if (item.getType().equals("rainCoat")) {
							warmOuterwear.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {

					for (Item item : allItems) {
						if (item.getType().equals("sandals")) {
							warmShoes.add(item);
						} else if (item.getType().equals("sneakers")) {
							warmShoes.add(item);
						} else if (item.getType().equals("flats")) {
							warmShoes.add(item);
						}
					}
				}

				for (Item item : allItems) {
					
					if (item.getType().equals("tshirt")) {
						warmTops.add(item);
					}
				
					else if (item.getType().equals("shorts")) {
						warmBottoms.add(item);
					} else if (item.getType().equals("skirt")) {
						warmBottoms.add(item);
					} else if (item.getType().equals("capris")) {
						warmBottoms.add(item);
					}
				}

				int index = randomGenerator.nextInt(warmTops.size());
				Item warmTopPick = warmTops.get(index);
				predictedOutfit.add(warmTopPick);

				index = randomGenerator.nextInt(warmBottoms.size());
				Item warmBottomsPick = warmBottoms.get(index);
				predictedOutfit.add(warmBottomsPick);

				index = randomGenerator.nextInt(warmShoes.size());
				Item warmShoesPick = warmShoes.get(index);
				predictedOutfit.add(warmShoesPick);

				index = randomGenerator.nextInt(warmOuterwear.size());
				Item warmOuterwearPick = warmOuterwear.get(index);
				predictedOutfit.add(warmOuterwearPick);
			}

			// MILD
			else if (ourAPI.getTemp_f() >= 60.0) {
				ArrayList<Item> mildTops = new ArrayList<Item>();
				ArrayList<Item> mildBottoms = new ArrayList<Item>();
				ArrayList<Item> mildShoes = new ArrayList<Item>();
				ArrayList<Item> mildLayers = new ArrayList<Item>();
				ArrayList<Item> mildOuterwear = new ArrayList<Item>();

				// IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
					
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							mildShoes.add(item);
						}
						else if (item.getType().equals("rainCoat")) {
							mildOuterwear.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {
					for (Item item : allItems) {
						if (item.getType().equals("boots")) {
							mildShoes.add(item);
						} else if (item.getType().equals("sneakers")) {
							mildShoes.add(item);
						}
					}
				}
				
				for (Item item : allItems) {
					
					if (item.getType().equals("tshirt")) {
						mildTops.add(item);
					}
					else if (item.getType().equals("blouse")) {
						mildTops.add(item);
					}
					else if (item.getType().equals("buttonDown")) {
						mildTops.add(item);
					}
					else if (item.getType().equals("polo")) {
						mildTops.add(item);
					}
					
					
					else if (item.getType().equals("capris")) {
						mildBottoms.add(item);
					} else if (item.getType().equals("pants")) {
						mildBottoms.add(item);
					} else if (item.getType().equals("jeans")) {
						mildBottoms.add(item);
					} else if (item.getType().equals("leggings")) {
						mildBottoms.add(item);
					}

				
					else if (item.getType().equals("zipUp")) {
						mildLayers.add(item);
					} else if (item.getType().equals("cardigan")) {
						mildLayers.add(item);
					}

				}

				int index = randomGenerator.nextInt(mildTops.size());
				Item mildTopPick = mildTops.get(index);
				predictedOutfit.add(mildTopPick);

				index = randomGenerator.nextInt(mildBottoms.size());
				Item mildBottomsPick = mildBottoms.get(index);
				predictedOutfit.add(mildBottomsPick);

				index = randomGenerator.nextInt(mildShoes.size());
				Item mildShoesPick = mildShoes.get(index);
				predictedOutfit.add(mildShoesPick);

				index = randomGenerator.nextInt(mildLayers.size());
				Item mildLayerPick = mildLayers.get(index);
				predictedOutfit.add(mildLayerPick);
				
				index = randomGenerator.nextInt(mildOuterwear.size());
				Item mildOuterwearPick = mildOuterwear.get(index);
				predictedOutfit.add(mildOuterwearPick);

			}

			// CRISP
			else if (ourAPI.getTemp_f() >= 50.0) {
				ArrayList<Item> crispTops = new ArrayList<Item>();
				ArrayList<Item> crispBottoms = new ArrayList<Item>();
				ArrayList<Item> crispShoes = new ArrayList<Item>();
				ArrayList<Item> crispOuterwear = new ArrayList<>();
				ArrayList<Item> crispAccessories = new ArrayList<>();

				// IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
					
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							crispShoes.add(item);
						}
						else if (item.getType().equals("umbrella")) {
							crispAccessories.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {
					
					for (Item item : allItems) {
						if (item.getType().equals("boots")) {
							crispShoes.add(item);
						} else if (item.getType().equals("sneakers")) {
							crispShoes.add(item);
						}
					}
				}
				
				for (Item item : allItems) {
					
					if (item.getType().equals("tshirt")) {
						crispTops.add(item);
					}
					else if (item.getType().equals("blouse")) {
						crispTops.add(item);
					}
					else if (item.getType().equals("buttonDown")) {
						crispTops.add(item);
					}
					else if (item.getType().equals("polo")) {
						crispTops.add(item);
					}
					else if (item.getType().equals("longSleeve")) {
						crispTops.add(item);
					}
					
					else if (item.getType().equals("pants")) {
						crispBottoms.add(item);
					} else if (item.getType().equals("jeans")) {
						crispBottoms.add(item);
					} else if (item.getType().equals("leggings")) {
						crispBottoms.add(item);
					}

					else if (item.getType().equals("jacket")) {
						crispOuterwear.add(item);
					} else if (item.getType().equals("leatherJacket")) {
						crispOuterwear.add(item);
					} else if (item.getType().equals("fleeceJacket")) {
						crispOuterwear.add(item);
					}
					
					
				}

				int index = randomGenerator.nextInt(crispTops.size());
				Item crispTopPick = crispTops.get(index);
				predictedOutfit.add(crispTopPick);

				index = randomGenerator.nextInt(crispBottoms.size());
				Item crispBottomsPick = crispBottoms.get(index);
				predictedOutfit.add(crispBottomsPick);

				index = randomGenerator.nextInt(crispShoes.size());
				Item crispShoesPick = crispShoes.get(index);
				predictedOutfit.add(crispShoesPick);

				index = randomGenerator.nextInt(crispOuterwear.size());
				Item crispOuterwearPick = crispOuterwear.get(index);
				predictedOutfit.add(crispOuterwearPick);
				
				index = randomGenerator.nextInt(crispAccessories.size());
				Item crispAccessoriesPick = crispAccessories.get(index);
				predictedOutfit.add(crispAccessoriesPick);

			}

			// COOL
			else if (ourAPI.getTemp_f() >= 40.0) {
				ArrayList<Item> coolTops = new ArrayList<Item>();
				ArrayList<Item> coolBottoms = new ArrayList<Item>();
				ArrayList<Item> coolShoes = new ArrayList<Item>();
				ArrayList<Item> coolLayer = new ArrayList<Item>();
				ArrayList<Item> coolOuterwear = new ArrayList<Item>();
				ArrayList<Item> coolAccessories = new ArrayList<Item>();
				
				// IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							coolShoes.add(item);
						}
						else if (item.getType().equals("umbrella")) {
							coolAccessories.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {
					for (Item item : allItems) {
						if (item.getType().equals("boots")) {
							coolShoes.add(item);
						}
					}
				}

				for (Item item : allItems) {
					
					if (item.getType().equals("tshirt")) {
						coolTops.add(item);
					}
					else if (item.getType().equals("blouse")) {
						coolTops.add(item);
					}
					else if (item.getType().equals("buttonDown")) {
						coolTops.add(item);
					}
					else if (item.getType().equals("polo")) {
						coolTops.add(item);
					}
					else if (item.getType().equals("longSleeve")) {
						coolTops.add(item);
					}

					
					else if (item.getType().equals("pants")) {
						coolBottoms.add(item);
					} else if (item.getType().equals("jeans")) {
						coolBottoms.add(item);
					}

					
					else if (item.getType().equals("zipUp")) {
						coolLayer.add(item);
					} else if (item.getType().equals("cardigan")) {
						coolLayer.add(item);
					}
				
					else if (item.getType().equals("winterCoat")) {
						coolOuterwear.add(item);
					}
					else if (item.getType().equals("fleeceJacket")) {
						coolOuterwear.add(item);
					}
					else if (item.getType().equals("leatherJacket")) {
						coolOuterwear.add(item);
					}
					else if (item.getType().equals("jacket")) {
						coolOuterwear.add(item);
					}
					else if (item.getType().equals("peaCoat")) {
						coolOuterwear.add(item);
					}

				}
				int index = randomGenerator.nextInt(coolTops.size());
				Item coolTopPick = coolTops.get(index);
				predictedOutfit.add(coolTopPick);

				index = randomGenerator.nextInt(coolBottoms.size());
				Item coolBottomsPick = coolBottoms.get(index);
				predictedOutfit.add(coolBottomsPick);

				index = randomGenerator.nextInt(coolShoes.size());
				Item coolShoesPick = coolShoes.get(index);
				predictedOutfit.add(coolShoesPick);

				index = randomGenerator.nextInt(coolLayer.size());
				Item coolLayerPick = coolLayer.get(index);
				predictedOutfit.add(coolLayerPick);

				index = randomGenerator.nextInt(coolOuterwear.size());
				Item coolOuterwearPick = coolOuterwear.get(index);
				predictedOutfit.add(coolOuterwearPick);

				index = randomGenerator.nextInt(coolAccessories.size());
				Item coolAccessoriesPick = coolAccessories.get(index);
				predictedOutfit.add(coolAccessoriesPick);
			}

			// COLD
			else if (ourAPI.getTemp_f() >= 30.0) {
				ArrayList<Item> coldTops = new ArrayList<Item>();
				ArrayList<Item> coldBottoms = new ArrayList<Item>();
				ArrayList<Item> coldShoes = new ArrayList<Item>();
				ArrayList<Item> coldLayer = new ArrayList<Item>();
				ArrayList<Item> coldOuterwear = new ArrayList<Item>();
				ArrayList<Item> coldAccessories = new ArrayList<Item>();
				
				// IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
					
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							coldShoes.add(item);
						}
						else if (item.getType().equals("umbrealla")) {
							coldAccessories.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {
				
					for (Item item : allItems) {
						if (item.getType().equals("boots")) {
							coldShoes.add(item);
						}
					}
				}
				
				for (Item item : allItems) {
					
					if (item.getType().equals("tshirt")) {
						coldTops.add(item);
					}
					else if (item.getType().equals("blouse")) {
						coldTops.add(item);
					}
					else if (item.getType().equals("buttonDown")) {
						coldTops.add(item);
					}
					else if (item.getType().equals("polo")) {
						coldTops.add(item);
					}
					else if (item.getType().equals("longSleeve")) {
						coldTops.add(item);
					}
					
					
					else if (item.getType().equals("pants")) {
						coldBottoms.add(item);
					} else if (item.getType().equals("jeans")) {
						coldBottoms.add(item);
					}

					
					else if (item.getType().equals("zipUp")) {
						coldLayer.add(item);
					} else if (item.getType().equals("cardigan")) {
						coldLayer.add(item);
					} else if (item.getType().equals("crewneck")) {
						coldLayer.add(item);
					} else if (item.getType().equals("hoody")) {
						coldLayer.add(item);
					} else if (item.getType().equals("sweatshirt")) {
						coldLayer.add(item);
					}

					
					else if (item.getType().equals("winterCoat")) {
						coldOuterwear.add(item);
					} else if (item.getType().equals("parka")) {
						coldOuterwear.add(item);
					}
					else if (item.getType().equals("furCoat")) {
						coldOuterwear.add(item);
					}
					else if (item.getType().equals("peaCoat")) {
						coldOuterwear.add(item);
					}
					
					
					else if (item.getType().equals("gloves")) {
						coldAccessories.add(item);
					}
					else if (item.getType().equals("hat")) {
						coldAccessories.add(item);
					}
					else if (item.getType().equals("scarf")) {
						coldAccessories.add(item);
					}

				}
				int index = randomGenerator.nextInt(coldTops.size());
				Item coldTopPick = coldTops.get(index);
				predictedOutfit.add(coldTopPick);

				index = randomGenerator.nextInt(coldBottoms.size());
				Item coldBottomsPick = coldBottoms.get(index);
				predictedOutfit.add(coldBottomsPick);

				index = randomGenerator.nextInt(coldShoes.size());
				Item coldShoesPick = coldShoes.get(index);
				predictedOutfit.add(coldShoesPick);

				index = randomGenerator.nextInt(coldLayer.size());
				Item coldLayerPick = coldLayer.get(index);
				predictedOutfit.add(coldLayerPick);

				index = randomGenerator.nextInt(coldOuterwear.size());
				Item coldOuterwearPick = coldOuterwear.get(index);
				predictedOutfit.add(coldOuterwearPick);
				
				index = randomGenerator.nextInt(coldAccessories.size());
				Item coldAccessoriesPick = coldAccessories.get(index);
				predictedOutfit.add(coldAccessoriesPick);

			}

			// FREEZING AND BEYOND
			else if (ourAPI.getTemp_f() < 30.0) {
				ArrayList<Item> freezingTops = new ArrayList<Item>();
				ArrayList<Item> freezingBottoms = new ArrayList<Item>();
				ArrayList<Item> freezingShoes = new ArrayList<Item>();
				ArrayList<Item> freezingLayer = new ArrayList<Item>();
				ArrayList<Item> freezingOuterwear = new ArrayList<Item>();
				ArrayList<Item> freezingAccessories = new ArrayList<Item>();
				
				// IF PRECIPITATION
				if (Double.parseDouble(ourAPI.getPrecip_today_in()) > 0.0) {
					
					for (Item item : allItems) {
						if (item.getType().equals("waterproofBoots")) {
							freezingShoes.add(item);
						}
					}
				}
				// ELSE IF NO PRECIPITATION
				else {
					
					for (Item item : allItems) {
						if (item.getType().equals("boots")) {
							freezingShoes.add(item);
						}
					}
				}
				
				for (Item item : allItems) {
					
					if (item.getType().equals("tshirt")) {
						freezingTops.add(item);
					}
					else if (item.getType().equals("blouse")) {
						freezingTops.add(item);
					}
					else if (item.getType().equals("buttonDown")) {
						freezingTops.add(item);
					}
					else if (item.getType().equals("polo")) {
						freezingTops.add(item);
					}
					else if (item.getType().equals("longSleeve")) {
						freezingTops.add(item);
					}
					
					
					else if (item.getType().equals("pants")) {
						freezingBottoms.add(item);
					} else if (item.getType().equals("jeans")) {
						freezingBottoms.add(item);
					}

					
					else if (item.getType().equals("zipUp")) {
						freezingLayer.add(item);
					} else if (item.getType().equals("cardigan")) {
						freezingLayer.add(item);
					} else if (item.getType().equals("crewneck")) {
						freezingLayer.add(item);
					} else if (item.getType().equals("hoody")) {
						freezingLayer.add(item);
					} else if (item.getType().equals("sweatshirt")) {
						freezingLayer.add(item);
					}

					
					else if (item.getType().equals("parka")) {
						freezingOuterwear.add(item);
					}
					else if (item.getType().equals("winterCoat")) {
						freezingOuterwear.add(item);
					}
					else if (item.getType().equals("furCoat")) {
						freezingOuterwear.add(item);
					}
					else if (item.getType().equals("peaCoat")) {
						freezingOuterwear.add(item);
					}
					
					
					else if (item.getType().equals("gloves")) {
						freezingAccessories.add(item);
					}
					else if (item.getType().equals("hat")) {
						freezingAccessories.add(item);
					}
					else if (item.getType().equals("scarf")) {
						freezingAccessories.add(item);
					}
					
				}

				int index = randomGenerator.nextInt(freezingTops.size());
				Item freezingTopPick = freezingTops.get(index);
				predictedOutfit.add(freezingTopPick);

				index = randomGenerator.nextInt(freezingBottoms.size());
				Item freezingBottomsPick = freezingBottoms.get(index);
				predictedOutfit.add(freezingBottomsPick);

				index = randomGenerator.nextInt(freezingShoes.size());
				Item freezingShoesPick = freezingShoes.get(index);
				predictedOutfit.add(freezingShoesPick);

				index = randomGenerator.nextInt(freezingLayer.size());
				Item freezingLayerPick = freezingLayer.get(index);
				predictedOutfit.add(freezingLayerPick);
				
				index = randomGenerator.nextInt(freezingOuterwear.size());
				Item freezingOuterwearPick = freezingOuterwear.get(index);
				predictedOutfit.add(freezingOuterwearPick);
				
				index = randomGenerator.nextInt(freezingAccessories.size());
				Item freezingAccessoriesPick = freezingAccessories.get(index);
				predictedOutfit.add(freezingAccessoriesPick);

			}
		} catch (NullPointerException e) {
			System.out.println("Sorry all your clothes got infested with lice");
			e.printStackTrace();
		} catch(IllegalArgumentException i) {
			System.out.println("error");
		}
		
		return predictedOutfit;
	}

}
