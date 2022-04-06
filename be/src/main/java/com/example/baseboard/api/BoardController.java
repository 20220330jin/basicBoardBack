package com.example.baseboard.api;

import com.example.baseboard.model.BoardDto;
import com.example.baseboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
@CrossOrigin("http://localhost:8080")
@RequiredArgsConstructor
public class BoardController {

    final BoardService boardService;

    @GetMapping("/boardList")
    public List<BoardDto.boardList> boardList(@ModelAttribute BoardDto.boardListParam params){
        return boardService.boardList(params);
    }
}
