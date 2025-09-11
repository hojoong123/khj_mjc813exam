package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class BoardController {

    private final BoardRepository repo;

    public BoardController(BoardRepository repo) {
        this.repo = repo;
    }

    // 기본 목록 + 페이지네이션
    @GetMapping("/")
    public String list(@RequestParam(value = "page", defaultValue = "0") int page,
                       Model model) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("eventDate").descending());
        Page<Board> boards = repo.findAll(pageable);

        model.addAttribute("boards", boards.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boards.getTotalPages());
        return "list";
    }

    // 검색 (제목, 작성자, 장소)
    @GetMapping("/search")
    public String search(@RequestParam("field") String field,
                         @RequestParam("keyword") String keyword,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         Model model) {

        List<Board> results;
        switch (field) {
            case "title":
                results = repo.findByTitleContaining(keyword);
                break;
            case "writer":
                results = repo.findByWriterContaining(keyword);
                break;
            case "location":
                results = repo.findByLocationContaining(keyword);
                break;
            default:
                results = repo.findAll();
        }

        // 페이지네이션 수동 처리
        int pageSize = 10;
        int start = page * pageSize;
        int end = Math.min(start + pageSize, results.size());
        List<Board> pagedResults = results.subList(start, end);
        int totalPages = (int) Math.ceil((double) results.size() / pageSize);

        model.addAttribute("boards", pagedResults);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("field", field);
        model.addAttribute("keyword", keyword);
        return "list";
    }

    // 날짜 범위 검색 + 페이지네이션
    @GetMapping("/searchByDate")
    public String searchByDate(
            @RequestParam(value = "startDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "page", defaultValue = "0") int page,
            Model model) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by("eventDate").descending());
        Page<Board> boards;

        if (startDate != null && endDate != null) {
            boards = repo.findByEventDateBetween(startDate, endDate, pageable);
        } else {
            boards = repo.findAll(pageable);
        }

        model.addAttribute("boards", boards.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", boards.getTotalPages());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "list";
    }

    // CRUD: 작성, 조회, 수정, 삭제
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("board", new Board());
        return "form";
    }

    @PostMapping("/new")
    public String add(Board board) {
        repo.save(board);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Board board = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        model.addAttribute("board", board);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Board board = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);
        return "edit";
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
        return "redirect:/";
    }


}
