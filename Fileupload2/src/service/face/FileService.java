package service.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
	
	/**
	 * File Upload <br>
	 * 	Commons-Fileupload Library 
	 * 
	 * @param req - Request Object
	 * @param resp - Response Object
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);

}
