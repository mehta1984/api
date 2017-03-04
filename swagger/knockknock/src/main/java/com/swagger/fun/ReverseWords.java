package com.swagger.fun;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ReverseWords {

	@ApiOperation(notes = "Reverses the letters of each word in a sentence", 
					value = "Reverses the letters of each word in a sentence")
	@RequestMapping(method = RequestMethod.GET, path = {"/api/ReverseWords","/api/reversewords"}, 
					produces = { "application/json","text/json" })
	@ApiImplicitParams({
			    @ApiImplicitParam(name = "sentence", value = "Reverses the letters of each word in a sentence", 
					required = true, dataType = "string", paramType = "query") 
			         })
	@ApiResponses(value = 
                    { @ApiResponse(code = 200, message = "Success", response = Integer.class)})
	public ResponseEntity<String> getReverserWords(@RequestParam(required = true) String sentence) {
		return ResponseEntity.ok().body("\""+reverse(sentence)+"\"");
	}

	public static String reverse(String s) {
		String rtnString = "";
		if(s!=null && s.length()>0){
		char[] array = s.toCharArray();
		char tmp;
		for (int i = array.length / 2; i >= 0; i--) {
			tmp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = tmp;
		}
		 rtnString =  new String(array);
		}
		return rtnString;
	}
}
