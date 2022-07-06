package ma.hamzaezzakri.springboot.swagger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hamza Ezzakri
 * @CreatedAt 7/6/2022 3:09 PM
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation("shows hello world")
    @GetMapping("/")
    public ResponseEntity<String> hello(){

        return ResponseEntity.ok("Hello World");
    }
}
