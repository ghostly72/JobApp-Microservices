package com.example.ReviewMicroservices.review.impl;


import com.example.ReviewMicroservices.review.review;
import com.example.ReviewMicroservices.review.reviewrepo;
import com.example.ReviewMicroservices.review.reviewservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewserviceimpl implements reviewservice {

    @Autowired
    private reviewrepo reviewrepo;
//    @Autowired
//    private companyrepo companyrepo;
//
//    @Autowired
//    private companyservice companyservice;
    @Override
    public List<review> getallreviews(Long reviewid) {
        List<review> list=reviewrepo.findByCm_Id(companyid);
        return list;
    }

    @Override
    public boolean addreview(Long companyid, review review) {
//        company c=companyrepo.findById(companyid).orElse(null);
        if(companyid!=null){
            review.setCompanyid(companyid);
            reviewrepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public review getreview(Long reviewid) {
        return reviewrepo.findById(reviewid).orElse(null);

    }

    @Override
    public boolean updatereview(Long reviewid, review review) {
//        company c=companyrepo.findById(companyid).orElse(null);
        review r=reviewrepo.findById(reviewid).orElse(null);
        if(r!=null){
           r.setTitle(review.getTitle());
           r.setDescription(review.getDescription());
           r.setRating(review.getRating());
           r.setCompanyid(review.getCompanyid());
           reviewrepo.save(r);
           return true;
        }
        return false;
    }

    @Override
    public boolean deletereview( Long reviewid) {
//        company c=companyrepo.findById(companyid).orElse(null);
//        if(c!=null){
            review r=reviewrepo.findById(reviewid).orElse(null);
            if(r!=null){

                reviewrepo.deleteById(reviewid);
                return true;
            }
//        }
        return false;

    }
}
