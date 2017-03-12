package com.supermario.common.controller;

import com.supermario.common.exceptions.CustomizedException;
import com.supermario.common.response.ResponseWrapper;
import com.supermario.common.utils.StatusUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {

		model.addAttribute("movie", name);
		return "list";

	}

	@ResponseBody
	@RequestMapping(value = "/test/{title}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity getJson(@PathVariable String title) {

		try {
			String retString = requestSometing(title);
			ResponseWrapper responseWrapper = new ResponseWrapper(1234, title, "ok", HttpStatus.OK.value());

			//return new ResponseEntity(responseWrapper, HttpStatus.OK);

			return ResponseEntity.status(HttpStatus.OK).body(responseWrapper);
		} catch (Exception e) {
			HttpStatus httpStatus = StatusUtils.handleResponseStatus(e);
			ResponseWrapper responseWrapper = new ResponseWrapper(9876, title, ((CustomizedException) e).getErrorCode().getMsg(), httpStatus.value());
			//return new ResponseEntity(responseWrapper, HttpStatus.ACCEPTED);
			return ResponseEntity.status(httpStatus).body(responseWrapper);
		}
	}


	private String requestSometing(String something) throws CustomizedException {
		if (something.equalsIgnoreCase("title")) {
			throw new CustomizedException(CustomizedException.ErrorCode.HTTP_CLIENT_ERROR);
		} else {
			return "title";
		}
	}
}