package com.green.board.service;

import java.util.List;

import com.green.board.vo.BoardVo;

public interface BoardService {

	List<BoardVo> getBoardList(BoardVo vo);

	void insertBoard(BoardVo vo);

	BoardVo getView(BoardVo vo);

	void updateBoard(BoardVo vo);

	void deleteBoard(BoardVo vo);

}
