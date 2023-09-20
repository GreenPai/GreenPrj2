package com.green.pds.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.pds.dao.PdsDao;
import com.green.pds.service.PdsService;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService {

	@Autowired
	private   PdsDao  pdsDao;
	
	@Override
	public List<PdsVo> getPdsList(String menu_id) {
		
		List<PdsVo>  pdsList  =  pdsDao.getPdsList( menu_id );  
		
		return pdsList;
	}
	
	@Override
	public void setWrite(
			HashMap<String, Object> map, 
			HttpServletRequest request) {
        
		System.out.println("1:" + map);
		
		// 자료실 글쓰기 + 파일 저장
		// 1. 파일 저장 
		//  request  처리 - 넘어온 파일들을  d:\dev\data\ 에 저장
		PdsFile.save( map, request );  // map + fileList
		// 자바에서 파라미터가 객체일 경우 함수안에서 변경된 파라미터 인자는
		//  함수 종료후 돌아와도 변경된 값을 유지한다 - call by reference
		
		System.out.println("2:" + map);
				
		// 2. 자료실 글쓰기 
		// Board( <- map), Files( <- map 안의 fileList )
		pdsDao.setWrite( map );
		
	}

	@Override
	public PdsVo getView(HashMap<String, Object> map) {
		
		PdsVo   pdsVo  =  pdsDao.getView( map );
		
		return  pdsVo;
	}

	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
		
		List<FilesVo>  fileList  =  pdsDao.getFileList( map );
		
		return   fileList;
	}

	@Override
	public void setDelete(HashMap<String, Object> map) {
		
		System.out.println("map1:" + map);

		pdsDao.setDelete( map ); // BOARD, FILES 의 IDX 번째 자료를 삭제
		
		System.out.println("map2:" + map);
		
		// idx 에 해당하는 파일 정보들
		List<FilesVo>  fileList  =  (List<FilesVo>) map.get("fileList"); 
		// IDX 에 해당 파일을 삭제
		PdsFile.delete( fileList );
		
	}

}





