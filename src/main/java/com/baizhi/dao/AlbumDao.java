package com.baizhi.dao;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
public interface AlbumDao {
    //查询所有专辑
    List<Album> selectAllAlbum();

    boolean insertAlbum(Album album);

    int selectOneAlbum(String title);
}
