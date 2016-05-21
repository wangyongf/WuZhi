/*
 * Copyright (C) 1996-2016 YONGF Inc.All Rights Reserved.
 * Scott Wang blog.54yongf.com | blog.csdn.net/yongf2014	
 * 文件名: GetPostAnswers						
 * 描述: 								
 * 修改历史: 
 * 版本号    作者                日期              简要介绍相关操作
 *  1.0         Scott Wang     16-5-21       新增：Create	
 */

package com.yongf.wuzhi.bean;

import java.util.List;

/**
 * GetPostAnswersBean
 *
 * @author Scott Wang
 * @version 1.0, 16-5-21
 * @see
 * @since WuZhi V0.1
 */
public class GetPostAnswersBean {

    /**
     * error :
     * count : 32
     * answers : [{"title":"...
     */

    private String error;
    private int count;
    /**
     * title : 每天坚持跑步，或者慢跑真正带给你了什么？
     * time : 2016-03-23 18:18:05
     * summary :  ....
     * questionid : 41380989
     * answerid : 92035419
     * authorname : 陈玥
     * authorhash : ce8fdf98c48d60322d23481855969d19
     * avatar : https://pic3.zhimg.com/dc3d7ea15cbeb29ce5ce4a7eeb9e691e_l.jpg
     * vote : 1284
     */

    private List<AnswersBean> answers;

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

    public List<AnswersBean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersBean> answers) {
        this.answers = answers;
    }

    public static class AnswersBean {
        private String title;
        private String time;
        private String summary;
        private String questionid;
        private String answerid;
        private String authorname;
        private String authorhash;
        private String avatar;
        private String vote;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getQuestionid() {
            return questionid;
        }

        public void setQuestionid(String questionid) {
            this.questionid = questionid;
        }

        public String getAnswerid() {
            return answerid;
        }

        public void setAnswerid(String answerid) {
            this.answerid = answerid;
        }

        public String getAuthorname() {
            return authorname;
        }

        public void setAuthorname(String authorname) {
            this.authorname = authorname;
        }

        public String getAuthorhash() {
            return authorhash;
        }

        public void setAuthorhash(String authorhash) {
            this.authorhash = authorhash;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getVote() {
            return vote;
        }

        public void setVote(String vote) {
            this.vote = vote;
        }
    }
}
