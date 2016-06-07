package com.example.my.liwushuo.constant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/5/31.
 */
public class Constant {

    public static List<UrlInfo> urlInfos=new ArrayList<>();

    public static final String REMEN_PATH = "http://api.liwushuo.com/v2/items?gender=1&limit=20&offset=0&generation=2";
    //加载更多     offset = 20 40 60
    //分类
    public static final String ZHUANTI_PATH = "http://api.liwushuo.com/v2/collections?limit=10&offset=0";//专题
    public static final String PINLEI_PATH = "http://api.liwushuo.com/v2/channel_groups/all";//品类及下面所有
    public static final String LIWU_PATH = "http://api.liwushuo.com/v2/item_categories/tree";//礼物

    //所有精选页面中的左右滑动时的网络请求
    //"http://api.liwushuo.com/v2/channels/" + getId() +"/items?gender=1&limit=20&offset=0&generation=2"
    //加载更多时 改变  offset = 20 40 60 等

    //指南
    static {
        urlInfos.add(new UrlInfo(0,"精选","http://api.liwushuo.com/v2/channels/101/items?ad=2&gender=1&generation=2&limit=20&offset=0"));
        urlInfos.add(new UrlInfo(4,"精选2","http://api.liwushuo.com/v2/channels/101/items?ad=2&gender=1&generation=2&limit=10&offset=10"));
        urlInfos.add(new UrlInfo(1,"海淘","http://api.liwushuo.com/v2/channels/129/items?gender=1&limit=20&offset=0&generation=2"));
        urlInfos.add(new UrlInfo(5,"海淘2","http://api.liwushuo.com/v2/channels/129/items?gender=1&limit=20&offset=20&generation=2"));
        urlInfos.add(new UrlInfo(2,"涨姿势","http://api.liwushuo.com/v2/channels/120/items?gender=1&limit=20&offset=0&generation=2"));
        urlInfos.add(new UrlInfo(6,"涨姿势2","http://api.liwushuo.com/v2/channels/120/items?gender=1&limit=20&offset=20&generation=2"));
        urlInfos.add(new UrlInfo(3,"创意生活","http://api.liwushuo.com/v2/channels/125/items?gender=1&limit=20&offset=0&generation=2"));
        urlInfos.add(new UrlInfo(7,"创意生活2","http://api.liwushuo.com/v2/channels/125/items?gender=1&limit=20&offset=20&generation=2"));
    }

    public static class UrlInfo implements Serializable
    {
        private int id;
        private String title;
        private String url;

        public UrlInfo(int id, String title, String url) {
            this.id = id;
            this.title = title;
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
