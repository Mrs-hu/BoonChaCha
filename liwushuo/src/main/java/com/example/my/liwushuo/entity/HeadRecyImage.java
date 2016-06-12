package com.example.my.liwushuo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by my on 2016/6/12.
 */
public class HeadRecyImage {

    /**
     * code : 200
     * data : {"secondary_banners":[{"ad_monitors":[],"id":35,"image_url":"http://img01.liwushuo.com/image/160503/jj2y919zo.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=243","webp_url":"http://img01.liwushuo.com/image/160503/jj2y919zo.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":41,"image_url":"http://img03.liwushuo.com/image/160512/57v4i2z58.jpg-w720","target_url":"liwushuo:///page?url=http%3A%2F%2Fwww.liwushuo.com%2Fcredit%2Fmy_invitation&page_action=navigation&login=true&type=url","webp_url":"http://img03.liwushuo.com/image/160512/57v4i2z58.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":40,"image_url":"http://img01.liwushuo.com/image/160511/kamylr3s2.jpg-w720","target_url":"liwushuo:///page?type=url&url=http%3A//www.liwushuo.com/credit/sign&login=true&right_item_title=","webp_url":"http://img01.liwushuo.com/image/160511/kamylr3s2.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":43,"image_url":"http://img02.liwushuo.com/image/160517/8xb020ll2.jpg-w720","target_url":"liwushuo:///page?type=dailylucky","webp_url":"http://img02.liwushuo.com/image/160517/8xb020ll2.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":33,"image_url":"http://img01.liwushuo.com/image/160503/ydv76bnsp.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=246","webp_url":"http://img01.liwushuo.com/image/160503/ydv76bnsp.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":36,"image_url":"http://img02.liwushuo.com/image/160503/p3tkow02z.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=247","webp_url":"http://img02.liwushuo.com/image/160503/p3tkow02z.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":32,"image_url":"http://img03.liwushuo.com/image/160503/oe88p5q8w.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=244","webp_url":"http://img03.liwushuo.com/image/160503/oe88p5q8w.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":34,"image_url":"http://img01.liwushuo.com/image/160503/00qo7xn94.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=245","webp_url":"http://img01.liwushuo.com/image/160503/00qo7xn94.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":11,"image_url":"http://img02.liwushuo.com/image/160503/9jwasbbm5.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=174","webp_url":"http://img02.liwushuo.com/image/160503/9jwasbbm5.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"id":14,"image_url":"http://img03.liwushuo.com/image/160503/gm3pouiwu.jpg-w720","target_url":"liwushuo:///page?type=topic&topic_id=22","webp_url":"http://img03.liwushuo.com/image/160503/gm3pouiwu.jpg?imageView2/2/w/720/q/85/format/webp"}]}
     * message : OK
     */

    @JSONField(name = "code")
    private int code;
    @JSONField(name = "data")
    private Data data;
    @JSONField(name = "message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {
        /**
         * ad_monitors : []
         * id : 35
         * image_url : http://img01.liwushuo.com/image/160503/jj2y919zo.jpg-w720
         * target_url : liwushuo:///page?type=topic&topic_id=243
         * webp_url : http://img01.liwushuo.com/image/160503/jj2y919zo.jpg?imageView2/2/w/720/q/85/format/webp
         */

        @JSONField(name = "secondary_banners")
        private List<SecondaryBanners> secondaryBanners;

        public List<SecondaryBanners> getSecondaryBanners() {
            return secondaryBanners;
        }

        public void setSecondaryBanners(List<SecondaryBanners> secondaryBanners) {
            this.secondaryBanners = secondaryBanners;
        }

        public static class SecondaryBanners {
            @JSONField(name = "id")
            private int id;
            @JSONField(name = "image_url")
            private String imageUrl;
            @JSONField(name = "target_url")
            private String targetUrl;
            @JSONField(name = "webp_url")
            private String webpUrl;
            @JSONField(name = "ad_monitors")
            private List<?> adMonitors;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(String targetUrl) {
                this.targetUrl = targetUrl;
            }

            public String getWebpUrl() {
                return webpUrl;
            }

            public void setWebpUrl(String webpUrl) {
                this.webpUrl = webpUrl;
            }

            public List<?> getAdMonitors() {
                return adMonitors;
            }

            public void setAdMonitors(List<?> adMonitors) {
                this.adMonitors = adMonitors;
            }
        }
    }
}
