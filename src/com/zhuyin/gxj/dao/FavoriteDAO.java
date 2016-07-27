package com.zhuyin.gxj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("favoriteDAO")
public interface FavoriteDAO {

	@Insert("insert user_favorite_catalog (userId,name,createtime,updatetime) values (#{userId},#{name},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'))")
	public int addCatalog(@Param("userId") String userId,@Param("name") String name);
	
	@Delete("update user_favorite_catalog set status=1,updatetime=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where id=#{id} and userId=#{userId}")
	public int deleteCatelog(@Param("userId") String userId,@Param("id") String id);
	
	@Insert("INSERT INTO `user_favorite_audio`(`userId`,`catalogId`,`audioId`,`createtime`,`updatetime`) VALUES (#{userId},#{catalogId},#{audioId},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s')) on DUPLICATE KEY UPDATE status = 0,updatetime=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s');")
	public int addAudio(@Param("userId") String userId,@Param("catalogId") String catalogId,@Param("audioId") String audioId);

	@Delete("update user_favorite_audio set status=1,updatetime=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s') where catalogId=#{dirId} and userId=#{userId} and audioId=#{audioId}")
	public int deleteAudio(@Param("userId") String userId,@Param("dirId") String dirId,@Param("audioId") String audioId);
	
	@Select("select id,name from user_favorite_catalog where status=0 order by createtime desc")
	public List<Map<String,String>> getCollectDirList(String userId);
	
	@Select("select a.id,a.name,a.path from user_favorite_audio ufa,audio a where ufa.audioId=a.id and ufa.status=0 and ufa.catalogId=#{dirId} and ufa.userId=#{userId} order by a.name")
	public List<Map<String,String>> getCollectAudioList(@Param("userId") String userId,@Param("dirId") String dirId);
}
