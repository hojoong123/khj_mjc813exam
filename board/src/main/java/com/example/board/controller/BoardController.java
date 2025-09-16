package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BoardController {

    private final BoardRepository repo;

    public BoardController(BoardRepository repo) {
        this.repo = repo;
    }

    // ----------------------
    // 메인 홈 화면
    // ----------------------
    @GetMapping("/index")
    public String home() {
        return "index"; // index.html
    }

    // ----------------------
    // 밴드 소개 페이지
    // ----------------------
    @GetMapping("/intro")
    public String bandIntro() {
        return "intro"; // bandIntro.html
    }

    // ----------------------
    // 일정 관리 게시판
    // ----------------------
    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "0") int page,
                       Model model) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("eventDate").descending());
        Page<Board> boards = repo.findAll(pageable);

        model.addAttribute("boards", boards.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boards.getTotalPages());
        return "list"; // list.html
    }

    // ----------------------
    // 검색: 제목, 작성자, 장소
    // ----------------------
    @GetMapping("/search")
    public String search(@RequestParam String field,
                         @RequestParam String keyword,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         Model model) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by("eventDate").descending());
        Page<Board> boards;

        switch (field) {
            case "title":
                boards = repo.findByTitleContainingIgnoreCase(keyword, pageable);
                break;
            case "writer":
                boards = repo.findByWriterContainingIgnoreCase(keyword, pageable);
                break;
            case "location":
                boards = repo.findByLocationContainingIgnoreCase(keyword, pageable);
                break;
            default:
                boards = repo.findAll(pageable);
        }

        model.addAttribute("boards", boards.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boards.getTotalPages());
        model.addAttribute("field", field);
        model.addAttribute("keyword", keyword);

        return "list"; // list.html
    }

    // ----------------------
    // 날짜 범위 검색
    // ----------------------
    @GetMapping("/searchByDate")
    public String searchByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            Model model) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by("eventDate").descending());
        Page<Board> boards = repo.findByEventDateBetween(startDate, endDate, pageable);

        model.addAttribute("boards", boards.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boards.getTotalPages());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "list"; // list.html
    }
    // 검색 / 날짜 범위 검색 등은 기존 BoardController 코드 그대로 사용
    // ...

    // ----------------------
    // CRUD: 작성, 조회, 수정, 삭제
    // ----------------------
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("board", new Board());
        return "form"; // form.html
    }

    @PostMapping("/new")
    public String add(Board board) {
        repo.save(board);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Board board = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("board", board);
        return "view"; // view.html
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Board board = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);
        return "edit"; // edit.html
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, Board updatedBoard) {
        Board board = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        board.setTitle(updatedBoard.getTitle());
        board.setContent(updatedBoard.getContent());
        board.setWriter(updatedBoard.getWriter());
        board.setEventDate(updatedBoard.getEventDate());
        board.setEventTime(updatedBoard.getEventTime());
        board.setLocation(updatedBoard.getLocation());
        repo.save(board);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/list";
    }

    // ----------------------
    // 캘린더 페이지
    // ----------------------
    @GetMapping("/calendar")
    public String calendar() {
        return "calendar"; // calendar.html
    }

}
