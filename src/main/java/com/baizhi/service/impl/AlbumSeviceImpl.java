package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
@Service
public class AlbumSeviceImpl implements AlbumSevice {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public List<Album> selectAllAlbum() {
        return albumDao.selectAllAlbum();
    }

    @Override
    public boolean insertAlbum(Album album) {
        return albumDao.insertAlbum(album);
    }

    @Override
    public int selectOneAlbum(String title) {
        return albumDao.selectOneAlbum(title);
    }
}
