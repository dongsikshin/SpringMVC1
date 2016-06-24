package com.mvc.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.board.model.Board;
import com.mvc.board.model.BoardDAOMybatis;

@Controller
@RequestMapping("/board")
public class BoardController {
	private BoardDAOMybatis boardDAO;
	
	//�Ϲ� �޼��忡 ���� ����!! (Injection)
	public void setBoardDAO(BoardDAOMybatis boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	//��Ͽ�û�� ó��
	@RequestMapping("/list.do")
	public ModelAndView getList(){
		List list=boardDAO.selectAll(); //3�ܰ� 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list); //request.setAttribute(); �� ����
		mav.setViewName("board/list");		
		return mav;
	}
	
	//�۾��� ��ûó�� 
	@RequestMapping("/write.do")
	public String insert(Board board){
		
		boardDAO.insert(board);
		
		return "redirect:/board/list.do";
	}
	
	//�󼼺��� ��û ó�� 
	@RequestMapping("/detail.do")
	public ModelAndView select(int board_id){
		Board board=boardDAO.select(board_id); //3�ܰ�..
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board",board); //4�ܰ�..
		return mav;
	}
	
	//������û ó�� 
	@RequestMapping("/delete.do")
	public String delete(int board_id){		
		boardDAO.delete(board_id);
		return "redirect:/board/list.do";
	}
	
	//������û ó�� 
	@RequestMapping("/edit.do")
	public ModelAndView edit(Board board){
		boardDAO.update(board);
		
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("board", board);
		return mav;
	}
}





