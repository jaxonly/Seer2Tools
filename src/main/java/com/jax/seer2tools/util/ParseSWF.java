package com.jax.seer2tools.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.zip.Inflater;

public class ParseSWF {

	String src;
	String separator = File.separator;
	public boolean isNewVersion(Connection conn) {
		URL url;
		try {
			Statement st = conn.createStatement();
			url = new URL("http://seer2.61.com/version/zzz_config.txt");
			InputStreamReader isr = new InputStreamReader(url.openStream());
			char[] chars = new char[12];
			isr.read(chars);
			String str = new String(chars).trim();
			System.out.println("-----版本时间戳:"+str+"-----");
			ResultSet rs = st.executeQuery("SELECT * FROM `monster_info`.`version` where version = '"+str+"'");
			if (rs.next()) {
				System.out.println("-----无新版本-----");
				return false;
			}
			st.execute("DELETE FROM version");
			st.execute("INSERT INTO `monster_info`.`version` (`version`) VALUES ('"+str+"')");
			System.out.println("-----"+str+"是新版本-----");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void ParseSWFStart() {
		try {
			src = this.getClass().getClassLoader().getResource("/").getPath();
			src.substring(1, src.length());
			downloadFile();
			byte[] data = get7Byte();
			// 解压
			byte[] finalByte = decompress(data);
			outPutFile(finalByte);
			parseSWFtoXML();
			deleteNoGuiFanXML();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteNoGuiFanXML() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		System.out.println("deleteNoGuiFanXML() start...");
		// 去除不规范的xml文件前缀
		while (true) {
			File newfile = new File(src
					+ "xml"+separator+"77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin");
			if (newfile.exists()) {
				BufferedReader bre = null;
				OutputStreamWriter pw = null;
				bre = new BufferedReader(new InputStreamReader(
						new FileInputStream(
								src + "xml"+separator+"77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin"),
						"UTF-8"));
				pw = new OutputStreamWriter(
						new FileOutputStream(
								src + "xml"+separator+"new77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin"),
						"UTF-8");
				String str = "";
				boolean flags = false;
				while ((str = bre.readLine()) != null) {
					if (str.indexOf("version") > 0) {
						flags = true;
					}
					if (flags) {
						pw.write(str);
					}
				}
				bre.close();
				pw.close();
				break;
			}
		}
		System.out.println("deleteNoGuiFanXML() stop...");
	}

	private void parseSWFtoXML() throws IOException {
		System.out.println("parseSWFtoXML() start...");
		String[] cmdA = { "/bin/sh", "-c", "java -jar "+src+"util"+separator+"ffdec.jar -export binaryData "+src+"xml "+src+"util"+separator+"new.swf" };
		if ("Windows 10".equals(System.getProperties().getProperty("os.name"))) {
			cmdA[0] = "cmd";
			cmdA[1] = "/c";
		}
		System.out.println(cmdA[2]);
		// 解析swf输出xml文件
		Runtime.getRuntime().exec(cmdA);
		System.out.println("parseSWFtoXML() stop...");
	}

	private void outPutFile(byte[] finalByte) throws FileNotFoundException, IOException {
		// 输出压缩后的文件
		OutputStream fos = new FileOutputStream(new File(src + "util"+separator+"new.swf"));
		fos.write(finalByte);
		fos.flush();
		fos.close();
	}

	private byte[] get7Byte() throws FileNotFoundException, IOException {
		System.out.println("get7Byte() start...");
		RandomAccessFile raFile = new RandomAccessFile(src + "util"+separator+"ClientAppDLL.swf", "rw");
		raFile.seek(7); // 定位到第8字节
		byte[] data = new byte[(int) raFile.length() - 7];
		raFile.read(data);
		System.out.println("get7Byte() stop...");
		return data;
	}

	private void downloadFile() throws MalformedURLException, IOException, FileNotFoundException {
		System.out.println("downloadFile() start...");
		int bytesum = 0;
		int byteread = 0;
		URL url = new URL("http://seer2.61.com/dll/ClientAppDLL.swf");
		URLConnection conn = url.openConnection();
		InputStream inStream = conn.getInputStream();
		FileOutputStream fs = new FileOutputStream(src + "util"+separator+"ClientAppDLL.swf");
		byte[] buffer = new byte[1024];
		int length;
		while ((byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
		}
		fs.close();
		inStream.close();
		System.out.println("downloadFile() stop...");
	}

	public static byte[] decompress(byte[] data) {
		System.out.println("decompress() start...");
		byte[] output = new byte[0];

		Inflater decompresser = new Inflater();
		decompresser.reset();
		decompresser.setInput(data);

		ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
		try {
			byte[] buf = new byte[1024];
			while (!decompresser.finished()) {
				int i = decompresser.inflate(buf);
				o.write(buf, 0, i);
			}
			output = o.toByteArray();
		} catch (Exception e) {
			output = data;
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		decompresser.end();
		System.out.println("decompress() stop...");
		return output;
	}
}
