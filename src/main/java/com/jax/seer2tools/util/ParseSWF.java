package com.jax.seer2tools.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
import java.util.zip.Inflater;

public class ParseSWF {

	public ParseSWF() throws Exception {
		downloadFile();

		byte[] data = get7Byte();
		// 解压
		byte[] finalByte = decompress(data);

		outPutFile(finalByte);

		parseSWFtoXML();

		deleteNoGuiFanXML();
	}
	private void deleteNoGuiFanXML() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		// 去除不规范的xml文件前缀
		while (true) {
			File newfile = new File(
					"src/main/resources/xml/77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin");
			if (newfile.exists()) {
				BufferedReader bre = null;
				OutputStreamWriter pw = null;
				bre = new BufferedReader(new InputStreamReader(
						new FileInputStream(
								"src/main/resources/xml/77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin"),
						"UTF-8"));
				pw = new OutputStreamWriter(
						new FileOutputStream(
								"src/main/resources/xml/new77_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass_com.taomee.seer2.app.config.PetConfig__dictionaryXmlClass.bin"),
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
	}
	private void parseSWFtoXML() throws IOException {
		// 解析swf输出xml文件
		Runtime.getRuntime()
				.exec("cmd /c cd /d src/main/resources/util && java -jar ffdec.jar -export binaryData ../xml new.swf");
	}
	private void outPutFile(byte[] finalByte) throws FileNotFoundException, IOException {
		// 输出压缩后的文件
		OutputStream fos = new FileOutputStream(new File("src/main/resources/util/new.swf"));
		fos.write(finalByte);
		fos.flush();
		fos.close();
	}
	private byte[] get7Byte() throws FileNotFoundException, IOException {
		// 取出前7字节
		RandomAccessFile raFile = new RandomAccessFile("src/main/resources/util/ClientAppDLL.swf", "rw");
		raFile.seek(7); // 定位到第8字节
		byte[] data = new byte[(int) raFile.length() - 7];
		raFile.read(data);
		return data;
	}
	private void downloadFile() throws MalformedURLException, IOException, FileNotFoundException {
		int bytesum = 0;
		int byteread = 0;
		URL url = new URL("http://seer2.61.com/dll/ClientAppDLL.swf");
		URLConnection conn = url.openConnection();
		InputStream inStream = conn.getInputStream();
		FileOutputStream fs = new FileOutputStream("src/main/resources/util/ClientAppDLL.swf");
		byte[] buffer = new byte[1024];
		int length;
		while ((byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread;
			System.out.println(bytesum);
			fs.write(buffer, 0, byteread);
		}
		fs.close();
		inStream.close();
	}

	public static byte[] decompress(byte[] data) {
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
		return output;
	}
}
