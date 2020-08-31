package me.soomin.board.controller.rest;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j
public class RestControllers {

    @GetMapping("/test/rest")
    @ResponseBody
    public List<String> testRest(){
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("Hi");
        return list;
    }

    @GetMapping("/test/rest/body")
    @ResponseBody
    public ResponseEntity<List<String>> testRestBody(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("contentType","application/json; charset=UTF-8");
        List<String> list = new ArrayList<String>();
        list.add("Hello Maven");
        list.add("Hi Spring");
        ResponseEntity<List<String>> responseEntity = new ResponseEntity<List<String>>(list,headers,HttpStatus.OK);
        return responseEntity;
    }
}
