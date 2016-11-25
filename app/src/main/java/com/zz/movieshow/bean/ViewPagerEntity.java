package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by zhangzhen on 2016/4/11.
 */
public class ViewPagerEntity {

    /**
     * status : 0
     * msg : OK
     * data : [{"bannerid":"905","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/04/08/5707256b2b0e6.jpg","description":"","addtime":"1460086124","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"48777\"}","end_time":"0"},{"bannerid":"897","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/04/07/570641be7843f.jpg","description":"","addtime":"1460031046","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"48781\"}","end_time":"0"},{"bannerid":"901","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/04/07/570623e8af549.jpg","description":"","addtime":"1460020204","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"48744\"}","end_time":"0"},{"bannerid":"893","title":"","image":"http://cs.vmoiver.com/Uploads/Banner/2016/04/02/56ff2a7b256ce.jpg","description":"","addtime":"1459563131","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"48754\"}","end_time":"0"}]
     */

    private String status;
    private String msg;
    /**
     * bannerid : 905
     * title :
     * image : http://cs.vmoiver.com/Uploads/Banner/2016/04/08/5707256b2b0e6.jpg
     * description :
     * addtime : 1460086124
     * extra : {"app_banner_type":"2","app_banner_param":"48777"}
     * end_time : 0
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
        private String bannerid;
        private String title;
        private String image;
        private String description;
        private String addtime;
        private String extra;
        private String end_time;

        public String getBannerid() {
            return bannerid;
        }

        public void setBannerid(String bannerid) {
            this.bannerid = bannerid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }
}
