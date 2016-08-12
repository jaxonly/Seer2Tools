package com.jax.seer2tools.util;

import static org.junit.Assert.*;

import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Test;

public class ParseSWFTest {

	@Test
	public void testSWF() throws Exception {
		ParseSWF ps = new ParseSWF();
	}
	
	@Test
	public void testXML() throws Exception {
		ParseXML ps = new ParseXML();
	}

	@Test
	public void test() throws Exception {
	System.out.println(System.getProperties().getProperty("os.name"));
	}
	@Test
	public void testURL() throws Exception {
		URL url = new URL("http://seer2.61.com/version/zzz_config.txt");
		InputStreamReader isr = new InputStreamReader(url.openStream());
		char[] chars = new char[12];
		isr.read(chars);
		String str = new String(chars);
	}
	
}
