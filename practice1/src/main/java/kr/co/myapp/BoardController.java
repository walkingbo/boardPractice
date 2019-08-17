package kr.co.myapp;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.myapp.domain.Board;
import kr.co.myapp.domain.SearchCriteriaEX;
import kr.co.myapp.domain.Criteria.Criteria;
import kr.co.myapp.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(Model model) {
		return "board/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, RedirectAttributes attr) {
		int result = boardService.register(request);
		System.out.println("글쓰기에 성공여부 :" + result);
		// 성공한 경우는 board/list로 리다이렉트 
		if (result > 0) {
			attr.addFlashAttribute("msg", "글쓰기 성공");
			return "redirect:list";
		}
		// 실패한다면 글쓰기 요청으로 돌아가기 
		else {
			attr.addFlashAttribute("msg", "글쓰기 실패");
			return "redirect:register";
		}
	}

	// 글 목록을 요청할 때
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteriaEX criteria, Model model) {
	Map<String, Object> map = boardService.list(criteria);
	model.addAttribute("map", map);
	return "board/list";
	}
	
	@RequestMapping(value = "detail/{bno}", method = RequestMethod.GET)
	public String detail(@PathVariable("bno") int bno, Model model) {
		Board board = boardService.detail(bno);
		model.addAttribute("vo", board);
		return "board/detail";
	}
	
	@RequestMapping(value = "update/{bno}", method = RequestMethod.GET)
	public String update(@PathVariable("bno") int bno, Model model) {
		Board board = boardService.updateView(bno);
		model.addAttribute("vo", board);
		return "board/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Board board, Model model, RedirectAttributes attr) {
		int result = boardService.update(board);
		if (result > 0) {
			attr.addFlashAttribute("msg", "수정 성공");
			return "redirect:/board/list";
		} else {
			return "redirect:/board/update";
		}
	}
	
	
	@RequestMapping(value = "delete/{bno}", method = RequestMethod.POST)
	public String delete(@PathVariable("bno") int bno, Model model, RedirectAttributes attr) {
		int result = boardService.delete(bno);
		if (result > 0) {
			attr.addFlashAttribute("msg", "삭제 성공");
			return "redirect:/board/list";
		} else {
			return "redirect:/board/delete";
		}
	}
}
