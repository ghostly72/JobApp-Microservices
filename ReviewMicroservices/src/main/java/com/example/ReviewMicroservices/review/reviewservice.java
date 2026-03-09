package com.example.ReviewMicroservices.review;

import java.util.List;

public interface reviewservice {
    List<review> getallreviews(Long companyid);
    boolean addreview(Long companyid,review review);
    review getreview(Long reviewid);

    boolean updatereview(Long reviewid, review review);

    boolean deletereview(Long reviewid);
}
