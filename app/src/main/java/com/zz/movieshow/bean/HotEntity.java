package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by wyz on 2016/4/11.
 */
public class HotEntity {
    /**
     * status : 0
     * msg : OK
     * data : [{"postid":"48754","title":"全球励志短片第一人最新作品《信念》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-31/56fc0a33f0d0d_cut.jpeg","rating":"8.9","duration":"230","publish_time":"1459398600","like_num":"1915","share_num":"3182"},{"postid":"48764","title":"淘宝败家VR发布短片《Buy+》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-01/56fe351b0e972_cut.jpeg","rating":"6.0","duration":"201","publish_time":"1459509070","like_num":"1107","share_num":"2920"},{"postid":"48735","title":"超创意视错定格短片《恋爱犀牛》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-30/56fb31f348ce5_cut.jpeg","rating":"9.0","duration":"900","publish_time":"1459312200","like_num":"1459","share_num":"2467"},{"postid":"48777","title":"超震撼CG特效概念短片《毁灭》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-07/5705c40ca7195_cut.jpeg","rating":"8.0","duration":"248","publish_time":"1460000372","like_num":"1074","share_num":"1970"},{"postid":"48769","title":"一霎清明雨，诗酒趁年华 | 踏青行摄专题","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-01/56fe361caf7f3_cut.jpeg","rating":"8.0","duration":"309","publish_time":"1459604661","like_num":"1087","share_num":"2562"},{"postid":"48787","title":"激情高燃超震撼旅行片《不盲不爱》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-07/57060a0dd19c1_cut.jpeg","rating":"8.5","duration":"219","publish_time":"1460108940","like_num":"908","share_num":"1697"},{"postid":"48795","title":"科比亲自撰写脚本耐克广告《恨我别爱我》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-08/5707544e884bb_cut.jpeg","rating":"8.0","duration":"60","publish_time":"1460092585","like_num":"825","share_num":"1732"},{"postid":"48741","title":"深度解析有理有据《你为何选择单身》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-29/56f9f71c00390_cut.jpeg","rating":"7.3","duration":"237","publish_time":"1459307700","like_num":"1160","share_num":"2253"},{"postid":"48704","title":"心有灵犀暖心小反转短片《奇怪的爱》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-22/56f0e2f3e50c4_cut.jpeg","rating":"7.8","duration":"60","publish_time":"1459656000","like_num":"1186","share_num":"2148"},{"postid":"48749","title":"极限作死超燃短片《人类如此伟大》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-30/56fb88c9a707f_cut.jpeg","rating":"7.9","duration":"228","publish_time":"1459476264","like_num":"1121","share_num":"2225"}]
     */

    private String status;
    private String msg;
    /**
     * postid : 48754
     * title : 全球励志短片第一人最新作品《信念》
     * pid : 1
     * is_xpc : 0
     * is_promote : 0
     * is_xpc_zp : 0
     * is_xpc_cp : 0
     * is_xpc_fx : 0
     * tags :
     * recent_hot : 0
     * discussion : 0
     * image : http://cs.vmoiver.com/Uploads/cover/2016-03-31/56fc0a33f0d0d_cut.jpeg
     * rating : 8.9
     * duration : 230
     * publish_time : 1459398600
     * like_num : 1915
     * share_num : 3182
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
