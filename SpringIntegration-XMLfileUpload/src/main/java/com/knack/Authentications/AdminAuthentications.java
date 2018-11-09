package com.knack.Authentications;

import java.util.Base64;

public class AdminAuthentications {
	public Boolean get_Auth(String authentications) {

		String[] typestr = authentications.split(" ");

		Base64.Decoder decoder = Base64.getDecoder();
		String userAuth = new String(decoder.decode(typestr[1].getBytes()));
		String[] idPass = userAuth.split(":");
		if (idPass[0].equals("admin") && idPass[1].equals("nimda")) {
			return true;
		} else

			return false;

	}

}
