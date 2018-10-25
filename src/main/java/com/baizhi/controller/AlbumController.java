package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
@Controller
@RequestMapping("/main")
public class AlbumController {
    @Autowired
    private AlbumSevice albumSevice;

    @RequestMapping("/selectAllAlbum")
    public @ResponseBody
    List<Album> selectAllAlbum() {

        return albumSevice.selectAllAlbum();
    }

    //添加专辑
    @RequestMapping("/insertAlbum")
    public @ResponseBody
    boolean insertAlbum(Album album,
                        MultipartFile file1, HttpSession session, HttpServletRequest request) throws IOException {
        System.out.println(album);
        boolean data = false;
        if (!file1.isEmpty()) {
            System.out.println(file1);
            //1.得到文件的原始名字
            String filename = file1.getOriginalFilename();
            //2.给文件定义一个新的名字，避免被覆盖
            String newName = new Date().getTime() + "-" + filename;
            //3.设置文件上传的绝对路径
            String readPath = request.getRealPath("/upload");
            System.out.println("************" + readPath);
            //4.将文件上传到这个绝对路径中
            File file = new File(readPath + "/" + newName);
            //5.将字符串形式的文件,转换成文件格式
            file1.transferTo(file);
            System.out.println(file1);
            album.setCoverImg(newName);
            data = albumSevice.insertAlbum(album);
            int id= albumSevice.selectOneAlbum(album.getTitle());
            session.setAttribute("albumId", id);
        }
        return data;
    }
}
