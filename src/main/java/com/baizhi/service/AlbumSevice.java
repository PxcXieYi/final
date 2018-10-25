package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
public interface AlbumSevice {
    List<Album> selectAllAlbum();

    boolean insertAlbum(Album album);

    int selectOneAlbum(String title);
}
