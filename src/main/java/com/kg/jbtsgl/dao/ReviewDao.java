package com.kg.jbtsgl.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.kg.jbtsgl.pojo.Review;
@Repository
public class ReviewDao extends CommonDao {
	//根据nid查找review
	public List<Review> selectReviewByNid(Integer nid){
		String sql="select r from Review r where nid=:nid";
		Map<String, Object> params = new HashMap<>();
		params.put("nid", nid);
		List<Review> list = this.query(sql, Review.class, params);
		if(list!=null){
			return list;
		}
		return null;
		
	}
}
