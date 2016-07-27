package com.zhuyin.gxj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuyin.gxj.dao.FavoriteDAO;
import com.zhuyin.gxj.service.FavoriteService;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	FavoriteDAO fDAO;
	
	@Override
	public int addCatalog(String userId, String name) {
		return fDAO.addCatalog(userId, name);
	}

	@Override
	public int deleteCatelog(String userId, String id) {
		return fDAO.deleteCatelog(userId, id);
	}

	@Override
	public int addAudio(String userId, String catalogId, String audioId) {
		return fDAO.addAudio(userId, catalogId, audioId);
	}

	@Override
	public int deleteAudio(String userId, String dirId, String audioId) {
		return fDAO.deleteAudio(userId, dirId, audioId);
	}

	@Override
	public List<Map<String, String>> getCollectDirList(String userId) {
		return fDAO.getCollectDirList(userId);
	}

	@Override
	public List<Map<String, String>> getCollectAudioList(String userId,
			String dirId) {
		return fDAO.getCollectAudioList(userId, dirId);
	}

}
