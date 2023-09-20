package com.green.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.green.board.service.BoardService;
import com.green.board.vo.BoardVo;
import com.green.menu.service.MenuService;
import com.green.menu.vo.MenuVo;

@Controller
@RequestMapping("/Board")
public class BoardController {

	@Autowired
	private   MenuService    menuService;
	
	@Autowired
	private   BoardService   boardService;
	
	// /Board/List?menu_id=MENU01
	@RequestMapping("/List")
	public  ModelAndView   list(BoardVo vo) {
		
		// 메뉴 목록
		List<MenuVo>   menuList   =  menuService.getMenuList();
		
		// 현재 메뉴이름조회 menu_id
		String  menu_id    =  vo.getMenu_id();
		String  menu_name  =  menuService.getMenu_name(menu_id);
		
		// 게시물 목록		
		List<BoardVo>  boardList  =  boardService.getBoardList( vo );
				
		ModelAndView   mv         =  new ModelAndView();		
		mv.addObject("menu_name", menu_name);
		mv.addObject("menuList", menuList);
		mv.addObject("boardList", boardList );		
		mv.setViewName("board/list");
		return mv;
	}
	
	//  새글쓰기 : /Board/WriteForm?menu_id=MENU01 
	//  답글쓰기 : /Board/WriteForm?menu_id=MENU01&idx=11&bnum=7&lvl=2&step=2&nref=7
	@RequestMapping("/WriteForm")
	public  ModelAndView   writeForm( BoardVo vo ) {
		
		// 메뉴 목록 조회
		List<MenuVo>  menuList  =  menuService.getMenuList();
		
		// 답글일 경유  : 내용을 조회해서 미리 출력
		if( vo.getBnum() > 0 ) {
			BoardVo  boardVo = boardService.getView( vo );
			vo               = boardVo;
			vo.setCont( vo.getCont() + "\n\n------------------\n");
		}
		
		ModelAndView  mv  = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("vo", vo);
		mv.setViewName("board/write");
		return  mv;		
	} 
	
	@RequestMapping("/Write")
	public  ModelAndView   write( BoardVo vo ) {
			
		// System.out.println("cont write vo:" + vo);		
		// vo:BoardVo [menu_id=MENU01, title=aaa, cont=aaa, writer=aaa]
		// 새글
		boardService.insertBoard( vo );		
		
		ModelAndView  mv  = new ModelAndView();		
		mv.setViewName("redirect:/Board/List?menu_id=" + vo.getMenu_id() );
		return  mv;		
	} 
	
	// /Board/View?idx=4&menu_id=MENU01
	@RequestMapping("/View")
	public  ModelAndView   view( BoardVo vo ) {
		
		// 메뉴 목록 조회
		List<MenuVo>  menuList  =  menuService.getMenuList();
		
		// 보여줄 게시물 내용을 조회
		BoardVo       boardVo  =   boardService.getView( vo );
		
		String        cont     =   boardVo.getCont().replace("\n", "<br>") ;
		boardVo.setCont(cont);
		
		ModelAndView  mv  =  new ModelAndView();
		mv.addObject("menuList",  menuList);
		mv.addObject("vo", boardVo);
		mv.setViewName("board/view");
		return mv;
		
	}
	
	// /Board/UpdateForm?menu_id=MENU01&idx=6
	@RequestMapping("/UpdateForm")
	public  ModelAndView   updateForm( BoardVo vo ) {
				
		BoardVo       boardVo  =  boardService.getView( vo );  
		
		ModelAndView  mv       =  new ModelAndView();
		mv.addObject("vo", boardVo );
		mv.setViewName("board/update");
		return   mv;
	}
	
	// /Board/Update
	@RequestMapping("/Update")
	public  ModelAndView   update( BoardVo vo ) {
		
		System.out.println("updateVo:" + vo);
		// 게시글 수정
		boardService.updateBoard( vo );
		
		// 수정후 이동할 페이지
		ModelAndView   mv  =  new ModelAndView();		
		mv.setViewName("redirect:/Board/List?menu_id=" + vo.getMenu_id());
		return  mv;
	}
	
	// /Board/Delete?menu_id=MENU01&idx=5
	@RequestMapping("/Delete")
	public  ModelAndView  delete(  BoardVo  vo  ) {
		
		// idx 로 게시물을 삭제
		boardService.deleteBoard( vo );
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("redirect:/Board/List?menu_id=" + vo.getMenu_id() );
		return   mv;		
	}
	
}














