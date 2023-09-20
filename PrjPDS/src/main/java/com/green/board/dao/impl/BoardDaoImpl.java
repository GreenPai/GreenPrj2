package com.green.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.board.dao.BoardDao;
import com.green.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private  SqlSession  sqlSession;
	
	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		
		List<BoardVo>  boardList  = sqlSession.selectList("Board.BoardList", vo);
				
		return    boardList;
	}

	@Override
	public void insertBoard(BoardVo vo) {
		
		if( vo.getBnum() == 0  ) { 	// 새글저장
			sqlSession.insert("Board.BoardInsert", vo);
		} else { //	답글 저장
			sqlSession.update("Board.StepUpdate", vo);
			sqlSession.insert("Board.BoardReply", vo);
		}
	}

	@Override
	public BoardVo getView(BoardVo vo) {
		
		BoardVo   boardVo  =  sqlSession.selectOne("Board.BoardView", vo);		
		
		return    boardVo;
	}

	@Override
	public void updateBoard(BoardVo vo) {
		
		sqlSession.update("Board.BoardUpdate", vo);
		
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		
		sqlSession.delete("Board.BoardDelete", vo);
		
	}

}




