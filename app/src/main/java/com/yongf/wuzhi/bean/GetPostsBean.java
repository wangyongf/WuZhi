/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: GetPostsBean						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-21       新增：Create	
 */

package com.yongf.wuzhi.bean;

import java.util.List;

/**
 * getposts的bean
 *
 * @author Scott Wang
 * @version 1.0, 16-5-21
 * @see
 * @since WuZhi V0.1
 */
public class GetPostsBean {


    /**
     * error :
     * count : 10
     * posts : ...
     */

    private String error;
    private int count;
    /**
     * id : 2133
     * date : 2016-05-21
     * name : archive
     * pic : http://www.kanzhihu.com/wp-content/uploads/2016/05/archive-2016-05-21.jpg
     * publishtime : 1463821200
     * count : 32
     * excerpt : 摘录了『每天坚持跑步...
     */

    private List<PostsBean> posts;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public static class PostsBean {
        private String id;
        private String date;
        private String name;
        private String pic;
        private String publishtime;
        private int count;
        private String excerpt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }
    }
}
