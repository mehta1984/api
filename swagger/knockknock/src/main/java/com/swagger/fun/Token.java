package com.swagger.fun;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class Token {
	
	@ApiOperation(notes = "Your Tokens", 
			   response = Long.class, value = "Your Token")
	@RequestMapping(method = RequestMethod.GET, path ={ "/api/token","/api/token"}, 
	              produces = {"application/json","text/json"})
	@ApiResponses(value = 
               { @ApiResponse(code = 200, message = "Success", response = Long.class) })
	public ResponseEntity<String> getToken() {
		return ResponseEntity.ok().body("\"0c29f3ac-86d3-460a-8990-b9e9b320c807\"");
	}


}
