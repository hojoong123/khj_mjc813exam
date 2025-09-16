package com.example.board.controller;

import com.example.board.model.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CalendarController {

    @Autowired
    private BoardRepository boardRepository;



    @GetMapping("/calendar/events")
    @ResponseBody
    public List<Map<String, String>> getEvents() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(b -> Map.of(
                "title", b.getTitle() + " (" + (b.getLocation() != null ? b.getLocation() : "") + ")",
                "start", b.getEventDate() != null ? b.getEventDate().toString() : LocalDate.now().toString()
        )).collect(Collectors.toList()).reversed();
    }
}
