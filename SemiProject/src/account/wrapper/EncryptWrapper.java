package account.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import common.Utils;

public class EncryptWrapper extends HttpServletRequestWrapper{

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
		
	}

	@Override
	public String getParameter(String key) {
		String value = ""; 
		
		if(key != null && (key.equals("password") || key.equals("newPassword"))) {
			value = Utils.getSha512(super.getParameter(key));
		} else {
			value = super.getParameter(key);
		}
		return value;
	}

}
