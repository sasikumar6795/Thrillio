package com.sasi.exceptions;

public class APIParser {
	public static int parseSendResponseCode(String response, String data, String partner) throws APIFormatChangeException {
		int responseCode = -1;
		try {
			String startTag = "<code>";
			String endTag = "</code>";
			if (response.contains(startTag)) {
				int beginIndex = response.indexOf(startTag) + startTag.length();
				System.out.println(beginIndex);
				int endIndex = response.indexOf(endTag);
				System.out.println(endIndex);
				System.out.println("code: " + response.substring(beginIndex, endIndex));
				responseCode = Integer.parseInt(response.substring(beginIndex, endIndex));
				System.out.println(responseCode);
			}
		} catch (NumberFormatException e) {
			//throw new APIFormatChangeException(response, "code", partner);
			throw new APIFormatChangeException(response, "code", partner, e);
			//APIFormatChangeException e1 = new APIFormatChangeException(response, "code", partner);
			//e1.initCause(e);
			//throw e1;
		}
		
		return responseCode;
	}
}
