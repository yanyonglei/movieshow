package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by zhang on 2016/4/12.
 */
public class VideoDetailsEntity {

    /**
     * status : 0
     * msg : ok
     * data : {"postid":"48780","title":"双重视角爱情独白短片《他，她》","intro":"他与她一见钟情，本片采用创意双重视角，讲述了一段恋情的发生、发展与死灭\u2026\u2026\n\n激情与愉悦，安稳与舒心，能够找到一个相爱的人，何其幸运，可她却同时爱上了两个人，该如何选择；而他无法入睡，他的大脑无法停止思念，即使入睡，梦里依旧是她，他不断拷问自己，自己究竟做错了什么？\n\n其实，遇见劈腿的恋人，你真的无能为力！Ta是你的唯一，而你只是Ta的其中之一。你喜欢的人，爱跟你玩失联；你等电话的焦急心情，Ta永远无法体会；Ta贪恋你的温柔体贴，却从来不想为你的幸福交保险\u2026\u2026\n\n随着年纪的增长，我们逐渐发现原来感情如此复杂，你的真爱，没有那么单纯简单，有时甚至与罪恶同在，但你只能爱得无能为力。","count_comment":"10","is_collect":"0","content":{"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-04-10/5709aed303301_cut.jpeg","title":"双重视角爱情独白短片《他，她》","duration":"540","filesize":"52474537","source_link":"http://v.youku.com/v_show/id_XMTUyNzQ4Mzc1Ng==.html","qiniu_url":"http://7rflo2.com2.z0.glb.qiniucdn.com/570741fc60065.mp4"}]},"image":"http://cs.vmoiver.com/Uploads/cover/2016-04-10/5709aed303301_cut.jpeg","rating":"7.7","publish_time":"1460257200","cate":["爱情"],"share_link":{"sweibo":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_qq"},"tags":""}
     */

    private String status;
    private String msg;
    /**
     * postid : 48780
     * title : 双重视角爱情独白短片《他，她》
     * intro : 他与她一见钟情，本片采用创意双重视角，讲述了一段恋情的发生、发展与死灭……

     激情与愉悦，安稳与舒心，能够找到一个相爱的人，何其幸运，可她却同时爱上了两个人，该如何选择；而他无法入睡，他的大脑无法停止思念，即使入睡，梦里依旧是她，他不断拷问自己，自己究竟做错了什么？

     其实，遇见劈腿的恋人，你真的无能为力！Ta是你的唯一，而你只是Ta的其中之一。你喜欢的人，爱跟你玩失联；你等电话的焦急心情，Ta永远无法体会；Ta贪恋你的温柔体贴，却从来不想为你的幸福交保险……

     随着年纪的增长，我们逐渐发现原来感情如此复杂，你的真爱，没有那么单纯简单，有时甚至与罪恶同在，但你只能爱得无能为力。
     * count_comment : 10
     * is_collect : 0
     * content : {"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-04-10/5709aed303301_cut.jpeg","title":"双重视角爱情独白短片《他，她》","duration":"540","filesize":"52474537","source_link":"http://v.youku.com/v_show/id_XMTUyNzQ4Mzc1Ng==.html","qiniu_url":"http://7rflo2.com2.z0.glb.qiniucdn.com/570741fc60065.mp4"}]}
     * image : http://cs.vmoiver.com/Uploads/cover/2016-04-10/5709aed303301_cut.jpeg
     * rating : 7.7
     * publish_time : 1460257200
     * cate : ["爱情"]
     * share_link : {"sweibo":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_qq"}
     * tags :
     */

    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String postid;
        private String title;
        private String intro;
        private String count_comment;
        private String is_collect;
        private ContentBean content;
        private String image;
        private String rating;
        private String publish_time;
        /**
         * sweibo : http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_sweibo
         * weixin : http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_weixin
         * qzone : http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_qzone
         * qq : http://www.vmovier.com/48780?debug=1&_vfrom=VmovierApp_qq
         */

        private ShareLinkBean share_link;
        private String tags;
        private List<String> cate;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getCount_comment() {
            return count_comment;
        }

        public void setCount_comment(String count_comment) {
            this.count_comment = count_comment;
        }

        public String getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(String is_collect) {
            this.is_collect = is_collect;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public ShareLinkBean getShare_link() {
            return share_link;
        }

        public void setShare_link(ShareLinkBean share_link) {
            this.share_link = share_link;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public List<String> getCate() {
            return cate;
        }

        public void setCate(List<String> cate) {
            this.cate = cate;
        }

        public static class ContentBean {
            /**
             * image : http://cs.vmoiver.com/Uploads/cover/2016-04-10/5709aed303301_cut.jpeg
             * title : 双重视角爱情独白短片《他，她》
             * duration : 540
             * filesize : 52474537
             * source_link : http://v.youku.com/v_show/id_XMTUyNzQ4Mzc1Ng==.html
             * qiniu_url : http://7rflo2.com2.z0.glb.qiniucdn.com/570741fc60065.mp4
             */

            private List<VideoBean> video;

            public List<VideoBean> getVideo() {
                return video;
            }

            public void setVideo(List<VideoBean> video) {
                this.video = video;
            }

            public static class VideoBean {
                private String image;
                private String title;
                private String duration;
                private String filesize;
                private String source_link;
                private String qiniu_url;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getFilesize() {
                    return filesize;
                }

                public void setFilesize(String filesize) {
                    this.filesize = filesize;
                }

                public String getSource_link() {
                    return source_link;
                }

                public void setSource_link(String source_link) {
                    this.source_link = source_link;
                }

                public String getQiniu_url() {
                    return qiniu_url;
                }

                public void setQiniu_url(String qiniu_url) {
                    this.qiniu_url = qiniu_url;
                }
            }
        }

        public static class ShareLinkBean {
            private String sweibo;
            private String weixin;
            private String qzone;
            private String qq;

            public String getSweibo() {
                return sweibo;
            }

            public void setSweibo(String sweibo) {
                this.sweibo = sweibo;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }

            public String getQzone() {
                return qzone;
            }

            public void setQzone(String qzone) {
                this.qzone = qzone;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }
        }
    }
}
