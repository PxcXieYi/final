package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/25.
 */
@Controller
@RequestMapping("/main")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/insertChapter")
    public @ResponseBody boolean insertChapter(Chapter chapter, HttpSession session){
        System.out.println(chapter);
        chapter.setId((int)new Date().getTime());
        int id = (Integer)session.getAttribute("albumId");
        chapter.setAblumId(id);
        return chapterService.insertChapter(chapter);
    }
}
