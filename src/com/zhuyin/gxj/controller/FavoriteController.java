package com.zhuyin.gxj.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.ResultBean;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.AudioService;
import com.zhuyin.gxj.service.FavoriteService;
import com.zhuyin.gxj.service.UserService;

@Controller
public class FavoriteController {

	@Autowired
	FavoriteService fService;

	@Autowired
	UserService userService;
	
	@Autowired
	AudioService audioService;
	
	@RequestMapping("/user/addCollectDir")
	@ResponseBody
	public ResultBean addCatalog(@RequestBody Map<String, String> map) {
		ResultBean rb = new ResultBean();
		if (!map.containsKey("userToken") || !map.containsKey("name")) {
			rb.setErrCode(Common.ERRCODE_COMMON);
			rb.setErrMsg("参数不全");
			return rb;
		}
		String userToken = map.get("userToken");
		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rb;
		}
		int rst= fService.addCatalog(userId, map.get("name"));
		return rb;
	}

	@RequestMapping("/user/delCollectDir")
	@ResponseBody
	public ResultBean deleteCatelog(@RequestBody Map<String, String> map) {
		ResultBean rb = new ResultBean();
		if (!map.containsKey("userToken") || !map.containsKey("dirId")) {
			rb.setErrCode(Common.ERRCODE_COMMON);
			rb.setErrMsg("参数不全");
			return rb;
		}
		String userToken = map.get("userToken");
		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rb;
		}
		int rst= fService.deleteCatelog(userId, map.get("dirId"));
		return rb;
	}

	@RequestMapping("/user/addCollectAudio")
	@ResponseBody
	public ResultBean addAudio(@RequestBody Map<String, Object> map) {
		ResultBean rb = new ResultBean();
		if (!map.containsKey("userToken") || !map.containsKey("dirId")|| !map.containsKey("musics")) {
			rb.setErrCode(Common.ERRCODE_COMMON);
			rb.setErrMsg("参数不全");
			return rb;
		}
		String userToken = String.valueOf(map.get("userToken"));
		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rb;
		}
		String dirId=String.valueOf(map.get("dirId"));
		List<Map<String,String>> musics=(List<Map<String, String>>) map.get("musics");
		for(Map<String,String> m:musics){
			String id=m.get("id");
			String type=m.get("type");
			if("1".equals(type)){
				fService.addAudio(userId, dirId, id);
			}else if("2".equals(type)){
				List<Map<String,String>> audios=audioService.getAudioList(id);
				for(Map<String,String> a:audios){
					fService.addAudio(userId, dirId, String.valueOf(a.get("id")));
				}
			}
		}
		
		return rb;
	}

	@RequestMapping("/user/delCollectAudio")
	@ResponseBody
	public ResultBean deleteAudio(@RequestBody Map<String, Object> map) {
		ResultBean rb = new ResultBean();
		if (!map.containsKey("userToken") || !map.containsKey("dirId")|| !map.containsKey("music")) {
			rb.setErrCode(Common.ERRCODE_COMMON);
			rb.setErrMsg("参数不全");
			return rb;
		}
		String userToken = String.valueOf(map.get("userToken"));
		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rb;
		}
		String dirId=String.valueOf(map.get("dirId"));
		List<Map<String,String>> musics=(List<Map<String, String>>) map.get("musics");
		for(Map<String,String> m:musics){
			String id=m.get("id");
			fService.deleteAudio(userId, dirId, id);
		}
		return rb;
	}

	@RequestMapping("/user/getCollectDirList")
	@ResponseBody
	public ResultListBean getCollectDirList(@RequestParam("userToken") String userToken) {
		ResultListBean rlb=new ResultListBean();

		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rlb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rlb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rlb;
		}
		List<Map<String, String>> list= fService.getCollectDirList(userId);
		rlb.getList().addAll(list);
		rlb.setCnt(list.size());
		return rlb;
	}

	@RequestMapping("/user/getCollectAudioList")
	@ResponseBody
	public ResultListBean getCollectAudioList(@RequestParam("userToken") String userToken,
			@RequestParam("dirId")String dirId) {
		ResultListBean rlb=new ResultListBean();

		String userId = userService.getUserIdByToken(userToken);
		if (StringUtils.isEmpty(userId)) {
			rlb.setErrCode(Common.ERRCODE_NEEDLOGIN);
			rlb.setErrMsg(Common.ERRMSG_NEEDLOGIN);
			return rlb;
		}
		List<Map<String, String>> list= fService.getCollectAudioList(userId, dirId);
		rlb.getList().addAll(list);
		rlb.setCnt(list.size());
		return rlb;
	}
}
