package com.controller;

import com.com.service.bo.SearchCardioBO;
import com.pojo.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Arpit on 4/8/2018.
 */
@RestController
public class RestFulController {

    @Autowired
    SearchCardioBO searchCardioBO;

    @RequestMapping("/challenges/search/{input}")
    public ResponseEntity<List<Exercise>> searchChallenges(@PathVariable("input") String input){

        return new ResponseEntity<List<Exercise>>(getSearchCardioBO().searchChallenges("",input), HttpStatus.OK);
    }

    @RequestMapping("/challenges/beginners")
    public ResponseEntity<List<Exercise>> searchChallengesBeginners(@RequestParam("input") String input){
        System.out.print(input);
        return new ResponseEntity<List<Exercise>>(getSearchCardioBO().searchChallenges(Exercise.BEGINNER,input), HttpStatus.OK);
    }
    @RequestMapping("/challenges/intermediate")
    public ResponseEntity<List<Exercise>> searchChallengesIntermediate(@RequestParam("input") String input){
        return new ResponseEntity<List<Exercise>>(getSearchCardioBO().searchChallenges(Exercise.INTERMEDIATE,input), HttpStatus.OK);
    }
    @RequestMapping("/challenges/advance")
    public ResponseEntity<List<Exercise>> searchChallengesAdvance(@RequestParam("input") String input){
        return new ResponseEntity<List<Exercise>>(getSearchCardioBO().searchChallenges(Exercise.ADVANCE,input), HttpStatus.OK);
    }

    public SearchCardioBO getSearchCardioBO() {
        return searchCardioBO;
    }

    public void setSearchCardioBO(SearchCardioBO searchCardioBO) {
        this.searchCardioBO = searchCardioBO;
    }
}
