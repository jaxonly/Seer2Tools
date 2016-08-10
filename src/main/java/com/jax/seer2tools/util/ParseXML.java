package com.jax.seer2tools.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jax.seer2tools.entity.EmblemInfo;
import com.jax.seer2tools.entity.EmblemTwoInfo;
import com.jax.seer2tools.entity.HideMoveInfo;
import com.jax.seer2tools.entity.MonsterInfo;
import com.jax.seer2tools.entity.PetDictionary;
import com.jax.seer2tools.entity.SkillInfo;
import com.jax.seer2tools.entity.SkillMonster;

public class ParseXML {
	public ParseXML() throws Exception {
		dropTableData();
		parseHideMovesXML();
		parseSkillXML();
		parseEmblemXML();
		parseEmblemTwoXML();
		parsePetXML();
		parsePetDictionaryXML();
	}

	// 57_com.taomee.seer2.app.config.PetConfig__petXmlClass_com.taomee.seer2.app.config.PetConfig__petXmlClass.bin
	public void parsePetXML() throws Exception {
		System.out.println("parsePetXML() Start....");
		try {
			Connection conn = getConn();
			
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(
					"src/main/resources/xml/57_com.taomee.seer2.app.config.PetConfig__petXmlClass_com.taomee.seer2.app.config.PetConfig__petXmlClass.bin"));
			Element root = xmlDoc.getRootElement();
			Iterator it = root.elementIterator("Monster");
			Iterator it2 = root.elementIterator("Monster");
			
			
			
			PreparedStatement ps3 = conn.prepareStatement(
					"INSERT INTO `monster_info`.`monster` (`id`, `def_name`, `type` , `star`) VALUES (?, ?,?,?);");
			while (it2.hasNext()) {
				Element monster = (Element) it2.next();
				ps3.setShort(1, Short.parseShort(replaceNull(monster.attributeValue("ID"))));
				ps3.setString(2, monster.attributeValue("DefName"));
				ps3.setByte(3, Byte.parseByte(replaceNull(monster.attributeValue("Type"))));
				ps3.setByte(4, Byte.parseByte(replaceNull(monster.attributeValue("StarLv"))));
				ps3.execute();
			}
			
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO monster_info (`numbers_id`, `id`, `def_name`, `growth_type`, `hp`, `atk`, `def`, `sp_atk`, `sp_def`, `spd`, `yielding_exp`, `yielding_ev`, `evolves_from`, `evolves_to`, `evolves_lv`, `type`, `catch_rat`, `evolv_flag`, `free_forbidden`, `height`, `weight`, `gender`, `features`, `ride`, `use_num`, `chg_mon_id`,`star`)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			PreparedStatement ps2 = conn.prepareStatement(
					"INSERT INTO skill_monster (`monster_id`, `Learning_Lv`, `skill_id`) VALUES (?, ?, ?)");
			while (it.hasNext()) {
				Element monster = (Element) it.next();
				ps.setInt(1, Integer.parseInt(replaceNull(monster.attributeValue("NumbersID"))));
				ps.setShort(2, Short.parseShort(replaceNull(monster.attributeValue("ID"))));
				ps.setString(3, monster.attributeValue("DefName"));
				ps.setByte(4, Byte.parseByte(replaceNull(monster.attributeValue("GrowthType"))));
				ps.setShort(5, Short.parseShort(replaceNull(monster.attributeValue("HP"))));
				ps.setShort(6, Short.parseShort(replaceNull(monster.attributeValue("Atk"))));
				ps.setShort(7, Short.parseShort(replaceNull(monster.attributeValue("Def"))));
				ps.setShort(8, Short.parseShort(replaceNull(monster.attributeValue("SpAtk"))));
				ps.setShort(9, Short.parseShort(replaceNull(monster.attributeValue("SpDef"))));
				ps.setShort(10, Short.parseShort(replaceNull(monster.attributeValue("Spd"))));
				ps.setShort(11, Short.parseShort(replaceNull(monster.attributeValue("YieldingExp"))));
				ps.setShort(12, Short.parseShort(replaceNull(monster.attributeValue("YieldingEV"))));
				ps.setShort(13, Short.parseShort(replaceNull(monster.attributeValue("EvolvesFrom"))));
				ps.setShort(14, Short.parseShort(replaceNull(monster.attributeValue("EvolvesTo"))));
				ps.setShort(15, Short.parseShort(replaceNull(monster.attributeValue("EvolvingLv"))));
				ps.setByte(16, Byte.parseByte(replaceNull(monster.attributeValue("Type"))));
				ps.setShort(17, Short.parseShort(replaceNull(monster.attributeValue("CatchRate"))));
				ps.setShort(18, Short.parseShort(replaceNull(monster.attributeValue("EvolvFlag"))));
				ps.setByte(19, Byte.parseByte(replaceNull(monster.attributeValue("FreeForbidden"))));
				ps.setString(20, monster.attributeValue("Height"));
				ps.setString(21, monster.attributeValue("Weight"));
				ps.setString(22, monster.attributeValue("Gender"));
				ps.setShort(23, Short.parseShort(replaceNull(monster.attributeValue("Features"))));
				ps.setByte(24, Byte.parseByte(replaceNull(monster.attributeValue("ride"))));
				ps.setByte(25, Byte.parseByte(replaceNull(monster.attributeValue("use_num"))));
				ps.setShort(26, Short.parseShort(replaceNull(monster.attributeValue("ChgMonId"))));
				ps.setByte(27, Byte.parseByte(replaceNull(monster.attributeValue("StarLv"))));
				try {
					ps.execute();
				} catch (Exception e) {
					if (e.getMessage().indexOf("evolves_from") > 0) {
						ps.setShort(13, (short) 0);
					}
					if (e.getMessage().indexOf("evolves_to") > 0) {
						ps.setShort(14, (short) 0);
					}
					ps.execute();
				}
				Element LearnableMoves = monster.element("LearnableMoves");
				List<Element> Moves = LearnableMoves.elements();
				for (Element Move : Moves) {
					ps2.setShort(1, Short.parseShort(replaceNull(monster.attributeValue("ID"))));
					ps2.setShort(2, Short.parseShort(replaceNull(Move.attributeValue("LearningLv"))));
					ps2.setShort(3, Short.parseShort(replaceNull(Move.attributeValue("ID"))));
					try{
					ps2.execute();
					}catch (Exception e) {}
				}
			}
			ps.close();
			ps2.close();
			ps3.close();
			conn.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("parsePetXML() Stop");
	}

	// 11_com.taomee.seer2.app.config.SkillConfig__hideMovesXmlClass_com.taomee.seer2.app.config.SkillConfig__hideMovesXmlClass.bin
	public void parseHideMovesXML() throws Exception {
		System.out.println("parseHideMovesXML() Start....");
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(
					"src/main/resources/xml/11_com.taomee.seer2.app.config.SkillConfig__hideMovesXmlClass_com.taomee.seer2.app.config.SkillConfig__hideMovesXmlClass.bin"));
			Element root = xmlDoc.getRootElement();
			Element HideMoves = root.element("HideMoves");
			Iterator it = HideMoves.elementIterator("HideMove");
			Connection conn = getConn();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO hide_move_info (`id`, `tips`) VALUES (?, ?)");
			while (it.hasNext()) {
				Element monster = (Element) it.next();
				ps.setInt(1, Integer.parseInt(replaceNull(monster.attributeValue("ID"))));
				ps.setString(2, monster.attributeValue("Tips"));
				try{
					ps.execute();
				}catch (Exception e) {
				}
			}
			ps.close();
			conn.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	// 79_com.taomee.seer2.app.config.SkillConfig__movesXmlClass_com.taomee.seer2.app.config.SkillConfig__movesXmlClass.bin
	public void parseSkillXML() throws Exception {
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(
					"src/main/resources/xml/79_com.taomee.seer2.app.config.SkillConfig__movesXmlClass_com.taomee.seer2.app.config.SkillConfig__movesXmlClass.bin"));
			Element root = xmlDoc.getRootElement();
			Element moves = root.element("Moves");
			Iterator it = moves.elementIterator("Move");
			Connection conn = getConn();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO skill_info (`id`, `name`, `category`, `type`, `power`, `accuracy`, `anger`, `tips`, `chg_move_id`) VALUES (?,?,?,?,?,?,?,?,?)");
			while (it.hasNext()) {
				Element monster = (Element) it.next();
				ps.setInt(1, Integer.parseInt(replaceNull(monster.attributeValue("ID"))));
				ps.setString(2, monster.attributeValue("Name"));
				ps.setByte(3, Byte.parseByte(replaceNull(monster.attributeValue("Category"))));
				ps.setByte(4, Byte.parseByte(replaceNull(monster.attributeValue("Type"))));
				ps.setInt(5, Integer.parseInt(replaceNull(monster.attributeValue("Power"))));
				ps.setShort(6, Short.parseShort(replaceNull(monster.attributeValue("Accuracy"))));
				ps.setByte(7, Byte.parseByte(replaceNull(monster.attributeValue("Anger"))));
				ps.setString(8, monster.attributeValue("Tips"));
				ps.setInt(9, Integer.parseInt(replaceNull(monster.attributeValue("ChgMoveId"))));
				try {
					ps.execute();
				} catch (Exception e) {
				}
			}
			ps.close();
			conn.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("parseHideMovesXML() Stop");
	}

	// new77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin
	public void parsePetDictionaryXML() throws Exception {
		System.out.println("parsePetDictionaryXML() Start....");
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(
					"src/main/resources/xml/new77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin"));
			Element root = xmlDoc.getRootElement();
			Iterator it = root.elementIterator("Monster");
			Connection conn = getConn();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO pet_dictionary (`Numbers_ID`, `emblem_ID`, `Def_Name`, `Type`, `Height`, `Weight`, `Foundin`, `is_New`, `Features`, `intro`, `chara`, `chara_Point`, `recommend_Quality`, `recommend_Skill`, `get_Way`, `is_Close`, `change_Tip`,`ID`,`superModule`)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps2 = conn.prepareStatement(
					"UPDATE `monster_info`.`monster` SET `is_new`=1 WHERE  `id`=?");
			while (it.hasNext()) {
				Element monster = (Element) it.next();
				ps.setShort(1, Short.parseShort(replaceNull(monster.attributeValue("NumbersID"))));
				ps.setInt(2, Integer.parseInt(replaceNull(monster.attributeValue("emblemID"))));
				ps.setString(3, monster.attributeValue("DefName"));
				ps.setString(4, monster.attributeValue("Type"));
				ps.setString(5, monster.attributeValue("Height"));
				ps.setString(6, monster.attributeValue("Weight"));
				ps.setString(7, monster.attributeValue("Foundin"));
				ps.setByte(8, Byte.parseByte(replaceNull(monster.attributeValue("isNew"))));
				ps.setString(9, monster.attributeValue("Features"));
				ps.setString(10, monster.attributeValue("intro"));
				ps.setString(11, monster.attributeValue("chara"));
				ps.setString(12, monster.attributeValue("charaPoint"));
				ps.setString(13, monster.attributeValue("recommendQuality"));
				ps.setString(14, monster.attributeValue("recommendSkill"));
				ps.setString(15, monster.attributeValue("getWay"));
				ps.setByte(16, Byte.parseByte(replaceNull(monster.attributeValue("isClose"))));
				ps.setString(17, monster.attributeValue("changeTip"));
				ps.setShort(18, Short.parseShort(replaceNull(monster.attributeValue("ID"))));
				ps.setString(19, monster.attributeValue("superModule"));
				if ("1".equals(monster.attributeValue("isNew"))) {
					ps2.setShort(1, Short.parseShort(replaceNull(monster.attributeValue("ID"))));
					ps2.execute();
				}
				try {
					ps.execute();
				} catch (Exception e) {
				}
			}
			ps.close();
			conn.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("parsePetDictionaryXML() Stop");
	}

	// 43_com.taomee.seer2.app.config.ItemConfig__itemXmlClass_com.taomee.seer2.app.config.ItemConfig__itemXmlClass.bin
	public void parseEmblemXML() throws Exception {
		System.out.println("parseEmblemXML() Start....");
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(
					"src/main/resources/xml/43_com.taomee.seer2.app.config.ItemConfig__itemXmlClass_com.taomee.seer2.app.config.ItemConfig__itemXmlClass.bin"));
			Element root = xmlDoc.getRootElement();
			Iterator it = root.elementIterator("Cat");
			Connection conn = getConn();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO emblem_info (`id`, `name`, `Numbers_ID`, `Honor_Price`, `Mi_Buy_ID`, `Tip`) VALUES (?,?,?,?,?,?)");
			while (it.hasNext()) {
				Element emblem = (Element) it.next();
				if (emblem.attributeValue("ID").equals("3")) {
					List<Element> items = emblem.elements("Item");
					for (Element item : items) {
						ps.setInt(1, Integer.parseInt(replaceNull(item.attributeValue("ID"))));
						ps.setString(2, item.attributeValue("Name"));
						ps.setShort(3, Short.parseShort(replaceNull(item.attributeValue("NumbersID"))));
						ps.setShort(4, Short.parseShort(replaceNull(item.attributeValue("HonorPrice"))));
						ps.setInt(5, Integer.parseInt(replaceNull(item.attributeValue("MiBuyID"))));
						ps.setString(6, item.element("Tip").getText());
						ps.execute();
					}
				}
			}
			ps.close();
			conn.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("parseEmblemXML() Stop");
	}

	// 43_com.taomee.seer2.app.config.ItemConfig__itemXmlClass_com.taomee.seer2.app.config.ItemConfig__itemXmlClass.bin
	public void parseEmblemTwoXML() throws Exception {
		System.out.println("parseEmblemTwoXML() Start....");
		try {
			SAXReader sax = new SAXReader();
			Document xmlDoc = sax.read(new File(
					"src/main/resources/xml/43_com.taomee.seer2.app.config.ItemConfig__itemXmlClass_com.taomee.seer2.app.config.ItemConfig__itemXmlClass.bin"));
			Element root = xmlDoc.getRootElement();
			Iterator it = root.elementIterator("Cat");
			Connection conn = getConn();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO `monster_info`.`emblem_two_info` (`id`, `name`, `type`, `Numbers_ID`, `Tip`) VALUES (?,?,?,?,?);");
			while (it.hasNext()) {
				Element emblem = (Element) it.next();
				if (emblem.attributeValue("ID").equals("7")) {
					List<Element> items = emblem.elements("Item");
					for (Element item : items) {
						ps.setInt(1, Integer.parseInt(replaceNull(item.attributeValue("ID"))));
						ps.setString(2, item.attributeValue("Name"));
						ps.setShort(3, Short.parseShort(replaceNull(item.attributeValue("Type"))));
						ps.setShort(4, Short.parseShort(replaceNull(item.attributeValue("NumbersID"))));
						ps.setString(5, item.element("Tip").getText());
						ps.execute();
					}
				}
			}
			ps.close();
			conn.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		System.out.println("parseEmblemTwoXML() Stop");
	}

	private String replaceNull(String str) {
		if (str == null || "".equals(str)) {
			return "0";
		}
		return str;
	}

	private Connection getConn() throws Exception {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/monster_info?useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, "root", "c7876ca1");
		return conn;
	}

	private void dropTableData() {
		System.out.println("dropTableData() Start....");
		Connection conn;
		try {
			conn = getConn();
			Statement st = conn.createStatement();
			st.execute("DELETE FROM skill_monster WHERE 1=1");
			st.execute("DELETE FROM pet_dictionary WHERE 1=1");
			st.execute("DELETE FROM monster_info WHERE 1=1");
			st.execute("DELETE FROM emblem_info WHERE id!=0");
			st.execute("DELETE FROM emblem_two_info WHERE 1=1");
			st.execute("DELETE FROM hide_move_info WHERE 1=1");
			st.execute("DELETE FROM monster WHERE id!=0");
			st.execute("DELETE FROM skill_info WHERE 1=1");
			st.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dropTableData() Stop");
	}
}
