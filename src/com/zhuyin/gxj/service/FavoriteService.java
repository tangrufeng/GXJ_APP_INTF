package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

public interface FavoriteService {

	public int addCatalog( String userId,String name);
	
	public int deleteCatelog(String userId,String id);
	
	public int addAudio(String userId,String catalogId,String audioId);

	public int deleteAudio(String userId,String dirId,String audioId);
	
	public List<Map<String,String>> getCollectDirList(String userId);
	
	public List<Map<String,String>> getCollectAudioList(String userId,String dirId);
}
