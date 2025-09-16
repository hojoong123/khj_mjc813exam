package com.example.board.repository;

import com.example.board.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleContaining(String keyword);
    List<Board> findByWriterContaining(String keyword);
    List<Board> findByLocationContaining(String keyword);

    // 날짜 범위 검색 + 페이지네이션
    Page<Board> findByEventDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Board> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findByWriterContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Board> findByLocationContainingIgnoreCase(String keyword, Pageable pageable);
}



