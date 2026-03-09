package com.example.ReviewMicroservices.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class reviewcontroller {

    @Autowired
    private reviewservice reviewservice;

    @GetMapping
    public ResponseEntity<List<review>> getallreviews(@RequestParam Long companyid){
        return new ResponseEntity<>(reviewservice.getallreviews(companyid), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addreview(@RequestParam Long companyid,@RequestBody review review){
        boolean flag=reviewservice.addreview(companyid, review);
        if(flag)return new ResponseEntity<>("added successfully",HttpStatus.OK);
        return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewid}")
    public ResponseEntity<review> getreview(@PathVariable Long reviewid){
        review r=reviewservice.getreview(reviewid);
        if(r!=null)return new ResponseEntity<>(r,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewid}")
    public ResponseEntity<String> updatereview(@PathVariable Long reviewid,@RequestBody review review){
        boolean flag=reviewservice.updatereview( reviewid, review);
        if(flag)return new ResponseEntity<>("updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewid}")
    public ResponseEntity<String> deletereview(@PathVariable Long reviewid){
        boolean flag=reviewservice.deletereview( reviewid);
        if(flag)return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("id(s) not found",HttpStatus.NOT_FOUND);
    }

}
