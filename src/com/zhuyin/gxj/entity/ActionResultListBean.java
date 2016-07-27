package com.zhuyin.gxj.entity;

import java.util.ArrayList;
import java.util.List;

public class ActionResultListBean extends ActionResultBean {
	

	private List<ActionBean> actions =new ArrayList<ActionBean>();

	public List<ActionBean> getActions() {
		return actions;
	}

	public void setActions(List<ActionBean> actions) {
		this.actions = actions;
	}


	@Override
	public String toString() {
		return "ActionResultListBean{" +
				"actions=" + actions +
				"} " + super.toString();
	}
}
