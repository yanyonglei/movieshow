package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/12.
 */
public class ArticleEntity {

    /**
     * status : 0
     * msg : OK
     * data : [{"postid":"48673","title":"《生活大爆炸》中真实的原型人物原来这么牛","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-17/56ea4e6d6c8a3_cut.jpeg","rating":"0.0","duration":"1","publish_time":"1458196674","like_num":"944","share_num":"1865"},{"postid":"48630","title":"【电影自习室2】VR全景视频制作前后期流程","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-10/56e157f0e0b51_cut.jpeg","rating":"0.0","duration":"560","publish_time":"1457608680","like_num":"1079","share_num":"2141"},{"postid":"48562","title":"奥斯卡特辑之令主创精疲力竭的那些《星球大战》视觉特效","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-03/56d7a81f2276c_cut.jpeg","rating":"0.0","duration":"1","publish_time":"1456974236","like_num":"982","share_num":"1885"},{"postid":"48549","title":"专访 ｜《长江图》导演杨超：《长江图》来自中国，面对中国！","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-01/56d56be7301d4_cut.jpeg","rating":"0.0","duration":"1","publish_time":"1456828222","like_num":"968","share_num":"1953"},{"postid":"48538","title":"奥斯卡特辑之《聚焦》：托马斯·麦卡锡编剧作品只有四部，但是最次的都是被大奖提名的级别","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-02-29/56d3fbd304054_cut.jpeg","rating":"0.0","duration":"1","publish_time":"1456733717","like_num":"948","share_num":"1923"},{"postid":"48535","title":"小李梦圆奥斯卡！感觉整个世界都要沸腾了","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-02-29/56d3d17eae3a0_cut.jpeg","rating":"0.0","duration":"1","publish_time":"1456723450","like_num":"936","share_num":"1956"},{"postid":"48341","title":"【电影自习室】达芬奇调色之美食调色小技巧","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-01-28/56a9edae01789_cut.jpeg","rating":"0.0","duration":"493","publish_time":"1453977080","like_num":"1017","share_num":"1961"},{"postid":"48282","title":"【电影自习室】利用particular与Form插件制作雨雪效果","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmovier.com/Uploads/cover/2016-01-21/56a0b83b5ec89_cut.jpeg","rating":"0.0","duration":"526","publish_time":"1453375878","like_num":"1057","share_num":"2076"},{"postid":"48266","title":"专访 | 金马最佳短片《保全员之死》导演程伟豪:「审丑观」电影才最接近真实","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmovier.com/Uploads/cover/2016-01-20/569ef58a99d6e_cut.jpeg","rating":"0.0","duration":"66","publish_time":"1453259234","like_num":"618","share_num":"1210"},{"postid":"48249","title":"专访 | 《太子妃升职记》监制甘薇，如何在大结局前打造点击量21亿的神话","pid":"","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmovier.com/Uploads/cover/2016-01-15/5698f8d1a6328_cut.jpeg","rating":"0.0","duration":"1","publish_time":"1452866537","like_num":"106","share_num":"277"}]
     */

    private String status;
    private String msg;
    /**
     * postid : 48673
     * title : 《生活大爆炸》中真实的原型人物原来这么牛
     * pid :
     * is_xpc : 0
     * is_promote : 0
     * is_xpc_zp : 0
     * is_xpc_cp : 0
     * is_xpc_fx : 0
     * tags :
     * recent_hot : 0
     * discussion : 0
     * image : http://cs.vmoiver.com/Uploads/cover/2016-03-17/56ea4e6d6c8a3_cut.jpeg
     * rating : 0.0
     * duration : 1
     * publish_time : 1458196674
     * like_num : 944
     * share_num : 1865
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String postid;
        private String title;
        private String pid;
        private String is_xpc;
        private String is_promote;
        private String is_xpc_zp;
        private String is_xpc_cp;
        private String is_xpc_fx;
        private String tags;
        private String recent_hot;
        private String discussion;
        private String image;
        private String rating;
        private String duration;
        private String publish_time;
        private String like_num;
        private String share_num;

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

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getIs_xpc() {
            return is_xpc;
        }

        public void setIs_xpc(String is_xpc) {
            this.is_xpc = is_xpc;
        }

        public String getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(String is_promote) {
            this.is_promote = is_promote;
        }

        public String getIs_xpc_zp() {
            return is_xpc_zp;
        }

        public void setIs_xpc_zp(String is_xpc_zp) {
            this.is_xpc_zp = is_xpc_zp;
        }

        public String getIs_xpc_cp() {
            return is_xpc_cp;
        }

        public void setIs_xpc_cp(String is_xpc_cp) {
            this.is_xpc_cp = is_xpc_cp;
        }

        public String getIs_xpc_fx() {
            return is_xpc_fx;
        }

        public void setIs_xpc_fx(String is_xpc_fx) {
            this.is_xpc_fx = is_xpc_fx;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getRecent_hot() {
            return recent_hot;
        }

        public void setRecent_hot(String recent_hot) {
            this.recent_hot = recent_hot;
        }

        public String getDiscussion() {
            return discussion;
        }

        public void setDiscussion(String discussion) {
            this.discussion = discussion;
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

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getLike_num() {
            return like_num;
        }

        public void setLike_num(String like_num) {
            this.like_num = like_num;
        }

        public String getShare_num() {
            return share_num;
        }

        public void setShare_num(String share_num) {
            this.share_num = share_num;
        }
    }
}
