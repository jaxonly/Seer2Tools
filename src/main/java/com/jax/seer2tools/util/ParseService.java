package com.jax.seer2tools.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("ParseService")
public class ParseService {
	@Scheduled(cron = "0 * * ? * FRI") 
    public void ParseJob(){
		try {
			ParseSWF parseSWF = new ParseSWF();
			ParseXML parseXML = new ParseXML();
			if (parseSWF.isNewVersion(parseXML.getConn())) {
				parseSWF.ParseSWFStart();
				parseXML.ParseXMLStart();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("访问更新时间戳URL出错...");
		}
    }  
}
