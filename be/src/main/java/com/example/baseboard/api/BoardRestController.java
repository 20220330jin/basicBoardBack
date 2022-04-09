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
public class BoardRestController {

    final BoardService boardService;

    @GetMapping("/boardList")
    public List<BoardDto.boardList> boardList(@ModelAttribute BoardDto.boardListParam params){
        return boardService.boardList(params);
    }

    @GetMapping("/detail")
    public BoardDto.boardInfo boardInfo(@ModelAttribute BoardDto.boardInfoParam param){
        return boardService.boardInfo(param);
//        return null;
    }
}
