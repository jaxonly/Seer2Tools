package com.jax.seer2tools.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class parseXML {
	public static void main(String[] args) {
//		parsePetXML();
//		parseHideMovesXML();
//		parseSkillXML();
//		parsePetDictionaryXML();
//		parseEmblemXML();
//		parseEmblemTwoXML();
	}
	public static void parsePetXML(){  
	    try {  
	        SAXReader sax = new SAXReader();  
	        Document xmlDoc = sax.read(new File("src/main/resources/xml/Pet.xml"));  
	        Element root = xmlDoc.getRootElement(); 
	        Iterator it = root.elementIterator("Monster");  
	        while(it.hasNext()){  
	            Element monster = (Element)it.next();
	            System.out.println(monster.attributeValue("NumbersID"));
	            System.out.println(monster.attributeValue("ID"));
	            System.out.println(monster.attributeValue("DefName"));
	            System.out.println(monster.attributeValue("GrowthType"));
	            System.out.println(monster.attributeValue("HP"));
	            System.out.println(monster.attributeValue("Atk"));
	            System.out.println(monster.attributeValue("Def"));
	            System.out.println(monster.attributeValue("SpAtk"));
	            System.out.println(monster.attributeValue("SpDef"));
	            System.out.println(monster.attributeValue("Spd"));
	            System.out.println(monster.attributeValue("YieldingExp"));
	            System.out.println(monster.attributeValue("YieldingEV"));
	            System.out.println(monster.attributeValue("EvolvesFrom"));
	            System.out.println(monster.attributeValue("EvolvesTo"));
	            System.out.println(monster.attributeValue("EvolvingLv"));
	            System.out.println(monster.attributeValue("Type"));
	            System.out.println(monster.attributeValue("CatchRat"));
	            System.out.println(monster.attributeValue("EvolvFlag"));
	            System.out.println(monster.attributeValue("FreeForbidden"));
	            System.out.println(monster.attributeValue("Height"));
	            System.out.println(monster.attributeValue("Weight"));
	            System.out.println(monster.attributeValue("Gender"));
	            System.out.println(monster.attributeValue("Features"));
	            System.out.println(monster.attributeValue("ride"));
	            System.out.println(monster.attributeValue("use_num"));
	            System.out.println(monster.attributeValue("ChgMonId"));
	        }  
	    } catch (DocumentException e) {  
	        e.printStackTrace();  
	    }  
	}
	
	public static void parseHideMovesXML(){  
	    try {  
	        SAXReader sax = new SAXReader();  
	        Document xmlDoc = sax.read(new File("src/main/resources/xml/HideMoves.xml"));  
	        Element root = xmlDoc.getRootElement(); 
	        Element HideMoves = root.element("HideMoves");
	        Iterator it = HideMoves.elementIterator("HideMove");  
	        while(it.hasNext()){  
	            Element monster = (Element)it.next();
	            System.out.println(monster.attributeValue("ID"));
	            System.out.println(monster.attributeValue("Tips"));
	        }  
	    } catch (DocumentException e) {  
	        e.printStackTrace();  
	    }  
	}
	
	public static void parseSkillXML(){  
	    try {  
	        SAXReader sax = new SAXReader();  
	        Document xmlDoc = sax.read(new File("src/main/resources/xml/Skill.xml"));  
	        Element root = xmlDoc.getRootElement(); 
	        Element moves = root.element("Moves");
	        Iterator it = moves.elementIterator("Move");  
	        while(it.hasNext()){  
	            Element monster = (Element)it.next();
	            System.out.println(monster.attributeValue("ID"));
	            System.out.println(monster.attributeValue("Name"));
	            System.out.println(monster.attributeValue("Category"));
	            System.out.println(monster.attributeValue("Type"));
	            System.out.println(monster.attributeValue("Power"));
	            System.out.println(monster.attributeValue("Accuracy"));
	            System.out.println(monster.attributeValue("Anger"));
	            System.out.println(monster.attributeValue("Tips"));
	            System.out.println(monster.attributeValue("ChgMoveId"));
	        }  
	    } catch (DocumentException e) {  
	        e.printStackTrace();  
	    }  
	}
	
	public static void parsePetDictionaryXML(){  
	    try {  
	        SAXReader sax = new SAXReader();  
	        Document xmlDoc = sax.read(new File("src/main/resources/xml/PetDictionary.xml"));  
	        Element root = xmlDoc.getRootElement(); 
	        Iterator it = root.elementIterator("Monster");  
	        while(it.hasNext()){
	            Element monster = (Element)it.next();
	            System.out.println("--------");
	            System.out.println(monster.attributeValue("NumbersID"));
	            System.out.println(monster.attributeValue("emblemID"));
	            System.out.println(monster.attributeValue("DefName"));
	            System.out.println(monster.attributeValue("Type"));
	            System.out.println(monster.attributeValue("Height"));
	            System.out.println(monster.attributeValue("Weight"));
	            System.out.println(monster.attributeValue("Foundin"));
	            System.out.println(monster.attributeValue("isNew"));
	            System.out.println(monster.attributeValue("Features"));
	            System.out.println(monster.attributeValue("intro"));
	            System.out.println(monster.attributeValue("chara"));
	            System.out.println(monster.attributeValue("charaPoint"));
	            System.out.println(monster.attributeValue("recommendQuality"));
	            System.out.println(monster.attributeValue("recommendSkill"));
	            System.out.println(monster.attributeValue("getWay"));
	            System.out.println(monster.attributeValue("isClose"));
	            System.out.println(monster.attributeValue("changeTip"));
	        }  
	    } catch (DocumentException e) {  
	        e.printStackTrace();  
	    }  
	}
	
	public static void parseEmblemXML(){  
	    try {  
	        SAXReader sax = new SAXReader();  
	        Document xmlDoc = sax.read(new File("src/main/resources/xml/ItemConfig.xml"));  
	        Element root = xmlDoc.getRootElement(); 
	        Iterator it = root.elementIterator("Cat");  
	        while(it.hasNext()){
	        	Element emblem = (Element)it.next();
	        	if (emblem.attributeValue("ID").equals("3")) {
	        		List<Element> items = emblem.elements("Item");
	        		for (Element item : items) {
	        			System.out.println(item.attributeValue("ID"));
	        			System.out.println(item.attributeValue("Name"));
	        			System.out.println(item.attributeValue("NumbersID"));
	        			System.out.println(item.attributeValue("HonorPrice"));
	        			System.out.println(item.attributeValue("MiBuyID"));
	        			System.out.println(item.element("Tip").getText());
					}
				}
	        }  
	    } catch (DocumentException e) {  
	        e.printStackTrace();  
	    }  
	}
	public static void parseEmblemTwoXML(){  
	    try {  
	        SAXReader sax = new SAXReader();  
	        Document xmlDoc = sax.read(new File("src/main/resources/xml/ItemConfig.xml"));  
	        Element root = xmlDoc.getRootElement(); 
	        Iterator it = root.elementIterator("Cat");  
	        while(it.hasNext()){
	        	Element emblem = (Element)it.next();
	        	if (emblem.attributeValue("ID").equals("7")) {
	        		List<Element> items = emblem.elements("Item");
	        		for (Element item : items) {
	        			System.out.println(item.attributeValue("ID"));
	        			System.out.println(item.attributeValue("Name"));
	        			System.out.println(item.attributeValue("Type"));
	        			System.out.println(item.attributeValue("NumbersID"));
	        			System.out.println(item.element("Tip").getText());
					}
				}
	        }  
	    } catch (DocumentException e) {  
	        e.printStackTrace();  
	    }  
	}
}
