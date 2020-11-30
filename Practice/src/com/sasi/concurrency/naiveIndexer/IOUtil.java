package com.sasi.concurrency.naiveIndexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class IOUtil {

	
	public static String read(InputStream inputStream) {
		StringBuilder text = new StringBuilder();
		try(BufferedReader br =  new BufferedReader(new InputStreamReader(inputStream, "UTF-8")))
		{
			String line;
			while((line = br.readLine())!=null)
			{
				text.append(line).append("\n");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text.toString();
	}

}
