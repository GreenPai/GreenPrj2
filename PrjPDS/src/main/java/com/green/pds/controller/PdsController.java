package com.green.pds.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.menu.service.MenuService;
import com.green.menu.vo.MenuVo;
import com.green.pds.service.PdsService;
import com.green.pds.vo.FilesVo;
import com.green.pds.vo.PdsVo;

@Controller
@RequestMapping("/Pds")
public class PdsController {
	
	@Autowired	
	private   MenuService  menuService;
	
	@Autowired
	private   PdsService   pdsService;
	
	// /Pds/List?menu_id=MENU01
	@RequestMapping("/List")
	public   ModelAndView   list(
		@RequestParam  HashMap<String, Object>  map	
			) {
		
		// 메뉴 목록
		List<MenuVo>  menuList  =  menuService.getMenuList();
		
		String        menu_id   =  String.valueOf( map.get("menu_id") );		
		String        menuname  =  menuService.getMenu_name(menu_id);
		map.put("menuname", menuname);
		
		// 게시물 목록
		List<PdsVo>   pdsList   =  pdsService.getPdsList(menu_id); 
				
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("pds/list");  
		mv.addObject("menuList", menuList );
		mv.addObject("pdsList",  pdsList );
		mv.addObject("map",      map );
		return  mv;		
	
	}
	
	// 새글: /Pds/WriteForm?menu_id=MENU01&bnum=0
	// 답글: /Pds/WriteForm?menu_id=MENU01&idx=13&bnum=13&lvl=1&step=1&nref=13
	@RequestMapping("/WriteForm")
	public  ModelAndView   writeForm(
		@RequestParam  HashMap<String, Object>  map) {
				
		// 메뉴 목록
		List<MenuVo>  menuList  =  menuService.getMenuList(); 
		
		PdsVo         pdsVo     =  null;
		if( map.get("idx") != null  ) {   // 답글 처리
			// pdsVo  =  pdsService.getView(   )
		}
		
		String   menu_id   =  String.valueOf( map.get("menu_id") );
		String   menuname  =  menuService.getMenu_name( menu_id );
		map.put("menuname", menuname);
		
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("pds/write");
		mv.addObject("menuList", menuList );
		mv.addObject("vo",  pdsVo  );  // 답글처리를 위해
		mv.addObject("map", map );
		return mv;
	}
	
	// /Pds/Write 
	@RequestMapping("/Write")
	public  ModelAndView   write(
		@RequestParam  HashMap<String, Object> map,    // String 정보
		HttpServletRequest   request                   // String + File(Binary)
			) {
		// 넘어온 정보
		System.out.println( map );
		// {lvl=, nref=, bnum=0, step=, writer=aaa, title=aaa, cont=aaaa, menu_id=MENU01}
				
		// 저장
		// map 정보
		// 1. 새글(답글) 글저장 -> Board table  저장 
		
		// request 정보활용
		// 2. 파일 정보 저장    -> Files table  저장 
		// 3. 실제 파일 저장    -> d:\dev\data\ 저장 : fileupload library
		
		pdsService.setWrite(map, request);		
		
		String  menu_id =  String.valueOf( map.get("menu_id") );
		
		ModelAndView  mv  =  new ModelAndView();
		mv.setViewName("redirect:/Pds/List?menu_id=" + menu_id);
		mv.addObject("map", map);
		return  mv;
	}
	
	// /Pds/View?menu_id=${ pds.menu_id }&idx=${ pds.idx }
	@RequestMapping("/View")
	public  ModelAndView   view(
		@RequestParam  HashMap<String, Object>  map	
			) {
		
		// 메뉴 목록
		List<MenuVo>   menuList  =  menuService.getMenuList();
		
		// 조회할 정보 : Board -> pdsVo
		 PdsVo         pdsVo     =  pdsService.getView( map );
		
		// 조회할 파일정보 : Files -> filesVo
		List<FilesVo>  fileList  =  pdsService.getFileList( map );
		
		// 현재 메뉴이름
		String         menu_id   =  pdsVo.getMenu_id();
		String         menuname  =  menuService.getMenu_name(menu_id);
		
		ModelAndView   mv  =   new ModelAndView();
		mv.setViewName("pds/view");
		mv.addObject("menuList",  menuList );
		mv.addObject("vo",        pdsVo );
		mv.addObject("fileList",  fileList );
		mv.addObject("menuname",  menuname );
		mv.addObject("map", map );
		
		return  mv;
	}
	
	// http://localhost:8080/Pds/Delete?menu_id=MENU01&idx=23
	// 삭제
	@RequestMapping("/Delete")
	public  ModelAndView   delete(
		@RequestParam  HashMap<String, Object>  map	) {
		
		pdsService.setDelete( map );
		
		String  menu_id =  String.valueOf( map.get("menu_id") );		
		
		ModelAndView  mv   =  new ModelAndView();
		mv.setViewName("redirect:/Pds/List?menu_id=" + menu_id);		
		return  mv;
		
	}
	
	
	// /Pds/UpdateForm?menu_id=MENU01&idx=22
	// 수정
    @RequestMapping("/updateForm")
    public ModelAndView updateForm(
    		@RequestParam HashMap<String,Object > map){
    	
    	// 메뉴 목록
    	List<MenuVo> menuList  = menuService.getMenuList();
    	
    	// 수정할 자료 조회
    	PdsVo          pdsVo   = pdsService.getView( map ); 
    	
    	// 메뉴이름
    	String       menu_id   = String.valueOf(map.get("menu_id"));
    	String       menuname  = menuService.getMenu_name(menu_id);
    	map.put("menu_id", menuname);
    	
    	// fileList
    	List<FilesVo> fileList = pdsService.getFileList(map);
    	
    	ModelAndView mv =   new ModelAndView();
    	mv.setViewName("pds/update");
    	mv.addObject("menuList", menuList);
    	mv.addObject("vo"      , pdsVo);
    	mv.addObject("fileList", fileList );
    	mv.addObject("map"     , map );
    	return mv;
    }
	
	
	
		
   //---------------------------------------------------
   // 다운로드
   // type : external, internal
   // 정규식
   // {sfile}     - .jpg 와 같이 . 포함된 문자가 들어오면 문자를 무시 : .인식하지 않는다 : 사용금지
   // {sfile:.+}  - .+ : . 이 한 개 이상
   //               반드시 . 을 포함해야 한다
   @RequestMapping(value  = "/download/{type}/{sfile:.+}",
                 method = RequestMethod.GET )
   public   void   downloadFile(
         @PathVariable("type")   String type,
         @PathVariable("sfile")  String sfile,
         HttpServletResponse     response
         ) throws IOException {
      
      String     INTERNAL_FILE         =  sfile;
      String     EXTERNAL_FILE_PATH    =  "d:\\dev\\data\\" + sfile;
            
      File       file  =  null;
      if ( type.equalsIgnoreCase("internal")  ) {
         ClassLoader   classLoader = 
            Thread.currentThread().getContextClassLoader();
         file   = new File( classLoader.getResource(INTERNAL_FILE).getPath() ); 
      } else {
         file   = new File( EXTERNAL_FILE_PATH );
      }
      
      if( !file.exists()  ) {
         String errorMessage = "죄송합니다.파일이 없습니다";
         System.out.println( errorMessage );
         OutputStream  outputStream = response.getOutputStream();
         outputStream.write(  errorMessage.getBytes(Charset.forName("UTF-8")) );
         outputStream.close();
         return;
      }
      
      // 실제 다운로드
     // String  mimeType = URLConnection.guessContentTypeFromName(file.getName());
      String   mimeType   =  "application/octet-stream";   // 무조건 다운로드
      
      // 파일명의 한글처리 - 한글파일명이 깨지지 않도록 하기위해     
      String   fname   = new String( 
            file.getName().getBytes("UTF-8"), "ISO-8859-1" );
      
      response.setContentType( mimeType );
      response.setHeader("Content-Disposition",
          String.format("inline; filename=\"" + fname + "\"" ));
      
      response.setContentLength( (int) file.length() );
      
      InputStream   inputStream  = new BufferedInputStream(
         new FileInputStream( file )   );
      
      FileCopyUtils.copy( inputStream, response.getOutputStream() );
      
      inputStream.close();
      
      
   }
} 









