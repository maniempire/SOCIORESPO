package com.sociorespo.bl;

import java.util.List;

import com.sociorespo.dao.HomeDAO;
import com.sociorespo.dto.HomeDTO;

public class HomeBL {

	public HomeDTO getinsertTag(HomeDTO homeDTO) {
		
		HomeDAO homeDAO = new HomeDAO();
		
		homeDTO = homeDAO.insertPostTage(homeDTO);
		
		
		return homeDTO;
	}

	public List getTags(HomeDTO homeDTO) {
		
		HomeDAO homeDAO = new HomeDAO();
		List userTags;
		
		userTags = homeDAO.getPostTage(homeDTO);
		
		
		return userTags;
	}

}
