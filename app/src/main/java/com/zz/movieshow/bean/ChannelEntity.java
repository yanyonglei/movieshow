package com.zz.movieshow.bean;

import java.util.List;

/**
 * Created by zhang on 2016/4/11.
 */
public class ChannelEntity {

    /**
     * orderid : 1
     * cateid : 12
     * catename : 爱情
     * alias : Love
     * icon : http://cs.vmovier.com/Uploads/Series/2015-12-30/5683c184c69ce.jpg
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String orderid;
        private String cateid;
        private String catename;
        private String alias;
        private String icon;

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getCateid() {
            return cateid;
        }

        public void setCateid(String cateid) {
            this.cateid = cateid;
        }

        public String getCatename() {
            return catename;
        }

        public void setCatename(String catename) {
            this.catename = catename;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
