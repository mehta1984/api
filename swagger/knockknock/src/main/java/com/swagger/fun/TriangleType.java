package com.swagger.fun;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("TriangleType" )
public class TriangleType {
	@ApiOperation(notes = "Returns the type of triange given the lengths of its sides", 
			   response = Long.class, value = "Returns the type of triange given the lengths of its sides")
	@RequestMapping(method = RequestMethod.GET, path = {"/api/TriangleType","/api/triangletype"}, 
	              produces = {"application/json","text/json"})
	@ApiImplicitParams({
		@ApiImplicitParam(name = "a", value = "The length of side a", required = true, dataType = "int", paramType = "query"), 
		@ApiImplicitParam(name = "b", value = "The length of side b", required = true, dataType = "int", paramType = "query") ,
		@ApiImplicitParam(name = "c", value = "The length of side c", required = true, dataType = "int", paramType = "query") 
	   })
	@ApiResponses(value = 
            { @ApiResponse(code = 200, message = "Success", response = Integer.class) })
	public ResponseEntity<String> getToken(@RequestParam(required = true) Integer a,@RequestParam(required = true) Integer b,
			@RequestParam(required = true) Integer c) {
		
		PotentialTriangle potentialTriangle = new PotentialTriangle(a, b, c);
		String triangleType = TriangleTypeEnum.ofPotentialTriangle(potentialTriangle).toString();
		/*Response response = new Response();
		response.setResponse(triangleType);*/
		return ResponseEntity.ok().body("\""+triangleType+"\"");
	}

    
}
