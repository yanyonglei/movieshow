package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/12.
 */
public class DetailBean {

    /**
     * status : 0
     * msg : OK
     * data : {"postid":"48630","title":"【电影自习室2】VR全景视频制作前后期流程","intro":"","count_comment":"65","is_collect":"0","content":{"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-03-10/56e157f0e0b51_cut.jpeg","title":"【电影自习室2】VR全景视频制作前后期流程","duration":"560","filesize":"112145823","source_link":"http://v.youku.com/v_show/id_XMTQ5NTA2NjgyOA==.html?from=y1.7-2","qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e15778d4164.mp4"},{"image":"http://r1.ykimg.com/0541040856E1526B6A0A4E5F3D87151D","title":"【电影自习室第二季】第二期 VR全景视频后期入门","duration":"309","filesize":"44703899","source_link":"http://v.youku.com/v_show/id_XMTQ5NjAzNTQ0MA==.html","qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e16bb8bffc5.mp4"},{"image":"http://r3.ykimg.com/0541040856E151496A0A440B0B033B74","title":"test2","duration":"86","filesize":"15448570","source_link":"http://v.youku.com/v_show/id_XMTQ5NTk0MDE0MA==.html","qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e158008b322.mp4"}]},"image":"http://cs.vmoiver.com/Uploads/cover/2016-03-10/56e157f0e0b51_cut.jpeg","rating":"0.0","publish_time":"1457608680","cate":["拍摄","综述","后期","器材","电影自习室"],"share_link":{"sweibo":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_qq"},"tags":""}
     */

    private String status;
    private String msg;
    /**
     * postid : 48630
     * title : 【电影自习室2】VR全景视频制作前后期流程
     * intro :
     * count_comment : 65
     * is_collect : 0
     * content : {"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-03-10/56e157f0e0b51_cut.jpeg","title":"【电影自习室2】VR全景视频制作前后期流程","duration":"560","filesize":"112145823","source_link":"http://v.youku.com/v_show/id_XMTQ5NTA2NjgyOA==.html?from=y1.7-2","qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e15778d4164.mp4"},{"image":"http://r1.ykimg.com/0541040856E1526B6A0A4E5F3D87151D","title":"【电影自习室第二季】第二期 VR全景视频后期入门","duration":"309","filesize":"44703899","source_link":"http://v.youku.com/v_show/id_XMTQ5NjAzNTQ0MA==.html","qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e16bb8bffc5.mp4"},{"image":"http://r3.ykimg.com/0541040856E151496A0A440B0B033B74","title":"test2","duration":"86","filesize":"15448570","source_link":"http://v.youku.com/v_show/id_XMTQ5NTk0MDE0MA==.html","qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e158008b322.mp4"}]}
     * image : http://cs.vmoiver.com/Uploads/cover/2016-03-10/56e157f0e0b51_cut.jpeg
     * rating : 0.0
     * publish_time : 1457608680
     * cate : ["拍摄","综述","后期","器材","电影自习室"]
     * share_link : {"sweibo":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_qq"}
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
         * sweibo : http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_sweibo
         * weixin : http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_weixin
         * qzone : http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_qzone
         * qq : http://www.vmovier.com/48630?debug=1&_vfrom=VmovierApp_qq
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
             * image : http://cs.vmoiver.com/Uploads/cover/2016-03-10/56e157f0e0b51_cut.jpeg
             * title : 【电影自习室2】VR全景视频制作前后期流程
             * duration : 560
             * filesize : 112145823
             * source_link : http://v.youku.com/v_show/id_XMTQ5NTA2NjgyOA==.html?from=y1.7-2
             * qiniu_url : http://7ryl2t.com2.z0.glb.qiniucdn.com/56e15778d4164.mp4
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
