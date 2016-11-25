package com.zz.movieshow.bean;

/**
 * Created by wyz on 2016/4/12.
 */
public class SerDatailEntity2 {
    /**
     * status : 0
     * msg : ok
     * data : {"title":"VR全景视频制作前后期流程2","seriesid":"45","series_postid":"1717","video_link":"http://v.youku.com/v_show/id_XMTQ5NjAzNTQ0MA==.html","episode":"76","count_comment":"58","share_link":{"sweibo":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_qq"},"qiniu_url":"http://7ryl2t.com2.z0.glb.qiniucdn.com/56e16bb8bffc5.mp4"}
     */

    private String status;
    private String msg;
    /**
     * title : VR全景视频制作前后期流程2
     * seriesid : 45
     * series_postid : 1717
     * video_link : http://v.youku.com/v_show/id_XMTQ5NjAzNTQ0MA==.html
     * episode : 76
     * count_comment : 58
     * share_link : {"sweibo":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_qq"}
     * qiniu_url : http://7ryl2t.com2.z0.glb.qiniucdn.com/56e16bb8bffc5.mp4
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
        private String title;
        private String seriesid;
        private String series_postid;
        private String video_link;
        private String episode;
        private String count_comment;
        /**
         * sweibo : http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_sweibo
         * weixin : http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_weixin
         * qzone : http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_qzone
         * qq : http://www.vmovier.com/series/45/76?debug=1&_vfrom=VmovierApp_qq
         */

        private ShareLinkBean share_link;
        private String qiniu_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSeriesid() {
            return seriesid;
        }

        public void setSeriesid(String seriesid) {
            this.seriesid = seriesid;
        }

        public String getSeries_postid() {
            return series_postid;
        }

        public void setSeries_postid(String series_postid) {
            this.series_postid = series_postid;
        }

        public String getVideo_link() {
            return video_link;
        }

        public void setVideo_link(String video_link) {
            this.video_link = video_link;
        }

        public String getEpisode() {
            return episode;
        }

        public void setEpisode(String episode) {
            this.episode = episode;
        }

        public String getCount_comment() {
            return count_comment;
        }

        public void setCount_comment(String count_comment) {
            this.count_comment = count_comment;
        }

        public ShareLinkBean getShare_link() {
            return share_link;
        }

        public void setShare_link(ShareLinkBean share_link) {
            this.share_link = share_link;
        }

        public String getQiniu_url() {
            return qiniu_url;
        }

        public void setQiniu_url(String qiniu_url) {
            this.qiniu_url = qiniu_url;
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
