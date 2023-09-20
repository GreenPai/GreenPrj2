package com.green.board.dao;

import java.util.List;

import com.green.board.vo.BoardVo;

public interface BoardDao {

	List<BoardVo> getBoardList(BoardVo vo);

	void insertBoard(BoardVo vo);

	BoardVo getView(BoardVo vo);

	void updateBoard(BoardVo vo);

	void deleteBoard(BoardVo vo);

}
