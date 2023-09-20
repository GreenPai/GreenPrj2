package com.green.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsVo;

public interface PdsDao {

	List<PdsVo> getPdsList(String menu_id);

	void setWrite(HashMap<String, Object> map);

	PdsVo getView(HashMap<String, Object> map);

	List<FilesVo> getFileList(HashMap<String, Object> map);

	void setDelete(HashMap<String, Object> map);

}
