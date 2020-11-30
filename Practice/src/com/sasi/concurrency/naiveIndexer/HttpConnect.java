package com.sasi.concurrency.naiveIndexer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class HttpConnect {
	public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
		System.out.println("Downloading: " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();

		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();

			if (responseCode >= 200 && responseCode < 300) { // ok
				return IOUtil.read(con.getInputStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static InputStream getInputStream(String sourceUrl) throws MalformedURLException, URISyntaxException {
		System.out.println("Downloading" + " " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();
		InputStream in = null;
		try {
			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			int responseCode = openConnection.getResponseCode();
			if(responseCode>=200 && responseCode<300)
			{
				in=openConnection.getInputStream();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return in;
		// TODO Auto-generated method stub
		
	}

	public static String download(InputStream in)  throws URISyntaxException, IOException {
		 	
		return IOUtil.read(in);
	}
}
