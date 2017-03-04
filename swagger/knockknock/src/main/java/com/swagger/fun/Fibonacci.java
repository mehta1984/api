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
public class Fibonacci {

	@ApiOperation(notes = "Returns the nth number in the fibonacci sequence", 
			   response = Long.class, value = "Returns the nth fibonacci number.")
	@RequestMapping(method = RequestMethod.GET, path = {"/api/Fibonacci","/api/fibonacci"}, 
	              produces = {"application/json","text/json"})
	@ApiImplicitParams({
			@ApiImplicitParam(name = "n", value = "The index (n) of the fibonacci sequence", 
					 required = true, dataType = "long", paramType = "query") })
	@ApiResponses(value = 
                  { @ApiResponse(code = 200, message = "Success", response = Long.class) })
	public ResponseEntity<Long> getFibonacci(@RequestParam(required = true) long n) {
		if((n>=0 && n<93) || (n<=0 && n>-93) ){
			return ResponseEntity.ok().body(fibonacciLoop(n));
		}else {
			return ResponseEntity.status(400).build();
		}
	}

	public static long getFibonacciOf(long n) {
		
		
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return getFibonacciOf(n - 2) + getFibonacciOf(n - 1);
		}
	}

	public static long fibonacciLoop(long number) {
		
		if (number == 0) {
			return 0;
		}
		if (number == 1 || number == 2) {
			return 1;
		}
		long fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (long i = 3; i <= number; i++) {
			fibonacci = fibo1 + fibo2; // Fibonacci number is sum of previous
										// two Fibonacci number
			fibo1 = fibo2;
			fibo2 = fibonacci;

		}
		return fibonacci; // Fibonacci number
	}

}
