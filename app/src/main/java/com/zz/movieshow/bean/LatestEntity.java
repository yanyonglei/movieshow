package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/11.
 */
public class LatestEntity {

    /**
     * status : 0
     * msg : OK
     * data : [{"postid":"48649","title":"女性情感伤痛短片《无因的愤怒》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-11/570b03db8d6f8_cut.jpeg","rating":"7.8","duration":"813","publish_time":"1460358119","like_num":"29","share_num":"60"},{"postid":"48803","title":"发人深省对话短片《你最想回到人生哪个阶段？》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-08/570781e807486_cut.jpeg","rating":"7.0","duration":"229","publish_time":"1460353558","like_num":"64","share_num":"115"},{"postid":"48232","title":"反思现实治愈动画《重新信任一个人》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-11/570b02848754f_cut.jpeg","rating":"8.0","duration":"415","publish_time":"1460349000","like_num":"74","share_num":"120"},{"postid":"48804","title":"落魄中年男子的荒诞温情短片《寂静街》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-08/570797c4e4a7d_cut.jpeg","rating":"8.1","duration":"282","publish_time":"1460344500","like_num":"78","share_num":"156"},{"postid":"48802","title":"网红超励志健身短片《为你自己而战》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-11/570b03359fd80_cut.jpeg","rating":"8.3","duration":"298","publish_time":"1460340518","like_num":"154","share_num":"265"},{"postid":"48727","title":"白烟缭绕伤感动画《It's Fine》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-25/56f501c099796_cut.jpeg","rating":"8.0","duration":"293","publish_time":"1460266907","like_num":"358","share_num":"738"},{"postid":"48645","title":"全汪星人出演魔性MV《Dogs》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-03-11/56e2a7f57519c_cut.jpeg","rating":"6.0","duration":"180","publish_time":"1460266399","like_num":"344","share_num":"762"},{"postid":"48776","title":"英国电影学院获奖剧情短片《接线员》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-06/5704bb6b6ead3_cut.jpeg","rating":"8.8","duration":"391","publish_time":"1460261700","like_num":"410","share_num":"725"},{"postid":"48780","title":"双重视角爱情独白短片《他，她》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-10/5709aed303301_cut.jpeg","rating":"7.7","duration":"540","publish_time":"1460257200","like_num":"470","share_num":"921"},{"postid":"48788","title":"非法移民爱与痛纪实短片《望眼欲穿》","pid":"1","is_xpc":"0","is_promote":"0","is_xpc_zp":"0","is_xpc_cp":"0","is_xpc_fx":"0","tags":"","recent_hot":"0","discussion":"0","image":"http://cs.vmoiver.com/Uploads/cover/2016-04-07/5706141727408_cut.jpeg","rating":"7.8","duration":"359","publish_time":"1460252339","like_num":"356","share_num":"749"}]
     */

    private String status;
    private String msg;
    /**
     * postid : 48649
     * title : 女性情感伤痛短片《无因的愤怒》
     * pid : 1
     * is_xpc : 0
     * is_promote : 0
     * is_xpc_zp : 0
     * is_xpc_cp : 0
     * is_xpc_fx : 0
     * tags :
     * recent_hot : 0
     * discussion : 0
     * image : http://cs.vmoiver.com/Uploads/cover/2016-04-11/570b03db8d6f8_cut.jpeg
     * rating : 7.8
     * duration : 813
     * publish_time : 1460358119
     * like_num : 29
     * share_num : 60
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
