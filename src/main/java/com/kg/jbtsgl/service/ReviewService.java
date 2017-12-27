package com.kg.jbtsgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.jbtsgl.dao.ReviewDao;
import com.kg.jbtsgl.pojo.Review;

@Service 
public class ReviewService extends BaseService {
	@Autowired
	private ReviewDao reviewDao;
	public List<Review> selectReviewByNid(Integer nid){
		
		return reviewDao.selectReviewByNid(nid);
		
	}
}
