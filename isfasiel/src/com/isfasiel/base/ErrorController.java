/**
 * 
 */
package com.isfasiel.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.isfasiel.util.file.UploadedFile;

/**
 * @author ¹èº´¼±
 *
 */
@Controller
public class ErrorController implements HandlerExceptionResolver {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	/*** Trap Exceptions during the upload and show errors back in view form ***/
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
	{		
		Map<Object, Object> model = new HashMap<Object, Object>();
		if (exception instanceof MaxUploadSizeExceededException)
		{
			model.put("errors", exception.getMessage());
			model.put("fileList", "'empty'");
			model.put("uploadedFile", new UploadedFile());
			return new ModelAndView("file/upload", (Map)model);
		} else {
			exception.printStackTrace();
			return null;
			//model.put("errors", "Unexpected error: " + exception.getMessage());
		}
	}
}
