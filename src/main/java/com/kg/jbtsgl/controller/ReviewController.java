package com.kg.jbtsgl.controller;

import java.util.List;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kg.jbtsgl.pojo.Review;

@Controller
public class ReviewController extends BaseController{
	@RequestMapping(value="selectReviewByNid")
	public ModelAndView selectReviewByNid(String nid){
		ModelAndView mView = new ModelAndView();
		List<Review> selectReviewByNid = reviewService.selectReviewByNid(Integer.parseInt(nid));
		mView.addObject("review",selectReviewByNid);
		mView.setViewName("Info.jsp");
		return mView;
	}
}
