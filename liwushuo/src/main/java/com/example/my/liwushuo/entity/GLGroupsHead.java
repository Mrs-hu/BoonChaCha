package com.example.my.liwushuo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class GLGroupsHead {


    /**
     * code : 200
     * data : {"collections":[{"banner_image_url":"http://img02.liwushuo.com/image/160531/nbrhjg3v6.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160531/nbrhjg3v6.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160531/xvdeuq0r8.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160531/xvdeuq0r8.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464659436,"id":301,"order":0,"posts_count":8,"status":0,"subtitle":"将生活过成诗的文艺风家居","title":"文艺家生活","updated_at":1464659436},{"banner_image_url":"http://img01.liwushuo.com/image/160525/az0729t55.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160525/az0729t55.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160525/7lfkrq7vr.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160525/7lfkrq7vr.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464172509,"id":294,"order":0,"posts_count":11,"status":0,"subtitle":"六一献礼","title":"本宝宝这么萌，当然要过儿童节","updated_at":1464172509},{"banner_image_url":"http://img01.liwushuo.com/image/160525/o7w1va186.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160525/o7w1va186.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160525/cxycmyi5p.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160525/cxycmyi5p.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464141012,"id":293,"order":0,"posts_count":6,"status":0,"subtitle":"无论晴天雨天，我们不见不[伞]","title":"美貌晴雨伞","updated_at":1464141012},{"banner_image_url":"http://img03.liwushuo.com/image/160524/vraqe223q.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160524/vraqe223q.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160524/6cxt2g5kv.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160524/6cxt2g5kv.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464087738,"id":292,"order":0,"posts_count":6,"status":0,"subtitle":"这个会充电的宝宝，比男票更有安全感","title":"手机加油站","updated_at":1464087738},{"banner_image_url":"http://img02.liwushuo.com/image/160524/nrs9hktd7.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160524/nrs9hktd7.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160524/ny0qkxyne.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160524/ny0qkxyne.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464081364,"id":291,"order":0,"posts_count":8,"status":0,"subtitle":"细节提升你的美","title":"入夏轻饰品","updated_at":1464081364},{"banner_image_url":"http://img01.liwushuo.com/image/160517/e6kho2o7d.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160517/e6kho2o7d.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160517/7qz4zpyq6.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160517/7qz4zpyq6.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463484080,"id":290,"order":0,"posts_count":7,"status":0,"subtitle":"教你如何撩妹/撩汉","title":"520脱单计划","updated_at":1463484080},{"banner_image_url":"http://img03.liwushuo.com/image/160518/cdtoe36bq.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160518/cdtoe36bq.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160518/oi08k83ji.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160518/oi08k83ji.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452817,"id":288,"order":0,"posts_count":7,"status":0,"subtitle":"有整个夏天的味道","title":"腕间小清新","updated_at":1463452817},{"banner_image_url":"http://img02.liwushuo.com/image/160518/v8su6youf.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160518/v8su6youf.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160518/7doo6pm3c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160518/7doo6pm3c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452367,"id":286,"order":0,"posts_count":7,"status":0,"subtitle":"让你的时尚指数UP↑UP↑","title":"一周穿搭指南","updated_at":1463452367},{"banner_image_url":"http://img03.liwushuo.com/image/160414/kmgh8u9na.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160414/kmgh8u9na.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160414/124w00bln.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160414/124w00bln.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1460595547,"id":241,"order":0,"posts_count":6,"status":0,"subtitle":"拯救你的选礼困难症","title":"完美礼物指南","updated_at":1460595547},{"banner_image_url":"http://img01.liwushuo.com/image/160411/a5s6cg9jx.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160411/a5s6cg9jx.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160411/s8sotrj5j.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160411/s8sotrj5j.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1460368917,"id":231,"order":0,"posts_count":5,"status":0,"subtitle":"这里是抹茶控の理想国度","title":"抹茶控福音","updated_at":1460368917}],"paging":{"next_url":"http://api.liwushuo.com/v2/collections?limit=10&offset=10"}}
     * message : OK
     */

    @JSONField(name = "code")
    private int code;
    /**
     * collections : [{"banner_image_url":"http://img02.liwushuo.com/image/160531/nbrhjg3v6.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160531/nbrhjg3v6.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160531/xvdeuq0r8.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160531/xvdeuq0r8.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464659436,"id":301,"order":0,"posts_count":8,"status":0,"subtitle":"将生活过成诗的文艺风家居","title":"文艺家生活","updated_at":1464659436},{"banner_image_url":"http://img01.liwushuo.com/image/160525/az0729t55.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160525/az0729t55.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160525/7lfkrq7vr.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160525/7lfkrq7vr.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464172509,"id":294,"order":0,"posts_count":11,"status":0,"subtitle":"六一献礼","title":"本宝宝这么萌，当然要过儿童节","updated_at":1464172509},{"banner_image_url":"http://img01.liwushuo.com/image/160525/o7w1va186.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160525/o7w1va186.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160525/cxycmyi5p.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160525/cxycmyi5p.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464141012,"id":293,"order":0,"posts_count":6,"status":0,"subtitle":"无论晴天雨天，我们不见不[伞]","title":"美貌晴雨伞","updated_at":1464141012},{"banner_image_url":"http://img03.liwushuo.com/image/160524/vraqe223q.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160524/vraqe223q.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160524/6cxt2g5kv.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160524/6cxt2g5kv.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464087738,"id":292,"order":0,"posts_count":6,"status":0,"subtitle":"这个会充电的宝宝，比男票更有安全感","title":"手机加油站","updated_at":1464087738},{"banner_image_url":"http://img02.liwushuo.com/image/160524/nrs9hktd7.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160524/nrs9hktd7.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160524/ny0qkxyne.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160524/ny0qkxyne.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1464081364,"id":291,"order":0,"posts_count":8,"status":0,"subtitle":"细节提升你的美","title":"入夏轻饰品","updated_at":1464081364},{"banner_image_url":"http://img01.liwushuo.com/image/160517/e6kho2o7d.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160517/e6kho2o7d.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160517/7qz4zpyq6.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160517/7qz4zpyq6.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463484080,"id":290,"order":0,"posts_count":7,"status":0,"subtitle":"教你如何撩妹/撩汉","title":"520脱单计划","updated_at":1463484080},{"banner_image_url":"http://img03.liwushuo.com/image/160518/cdtoe36bq.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160518/cdtoe36bq.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img02.liwushuo.com/image/160518/oi08k83ji.jpg-w720","cover_webp_url":"http://img02.liwushuo.com/image/160518/oi08k83ji.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452817,"id":288,"order":0,"posts_count":7,"status":0,"subtitle":"有整个夏天的味道","title":"腕间小清新","updated_at":1463452817},{"banner_image_url":"http://img02.liwushuo.com/image/160518/v8su6youf.jpg-w300","banner_webp_url":"http://img02.liwushuo.com/image/160518/v8su6youf.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img01.liwushuo.com/image/160518/7doo6pm3c.jpg-w720","cover_webp_url":"http://img01.liwushuo.com/image/160518/7doo6pm3c.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1463452367,"id":286,"order":0,"posts_count":7,"status":0,"subtitle":"让你的时尚指数UP↑UP↑","title":"一周穿搭指南","updated_at":1463452367},{"banner_image_url":"http://img03.liwushuo.com/image/160414/kmgh8u9na.jpg-w300","banner_webp_url":"http://img03.liwushuo.com/image/160414/kmgh8u9na.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160414/124w00bln.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160414/124w00bln.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1460595547,"id":241,"order":0,"posts_count":6,"status":0,"subtitle":"拯救你的选礼困难症","title":"完美礼物指南","updated_at":1460595547},{"banner_image_url":"http://img01.liwushuo.com/image/160411/a5s6cg9jx.jpg-w300","banner_webp_url":"http://img01.liwushuo.com/image/160411/a5s6cg9jx.jpg?imageView2/2/w/300/q/85/format/webp","cover_image_url":"http://img03.liwushuo.com/image/160411/s8sotrj5j.jpg-w720","cover_webp_url":"http://img03.liwushuo.com/image/160411/s8sotrj5j.jpg?imageView2/2/w/720/q/85/format/webp","created_at":1460368917,"id":231,"order":0,"posts_count":5,"status":0,"subtitle":"这里是抹茶控の理想国度","title":"抹茶控福音","updated_at":1460368917}]
     * paging : {"next_url":"http://api.liwushuo.com/v2/collections?limit=10&offset=10"}
     */

    @JSONField(name = "data")
    private DataBean data;
    @JSONField(name = "message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * next_url : http://api.liwushuo.com/v2/collections?limit=10&offset=10
         */

        @JSONField(name = "paging")
        private PagingBean paging;
        /**
         * banner_image_url : http://img02.liwushuo.com/image/160531/nbrhjg3v6.jpg-w300
         * banner_webp_url : http://img02.liwushuo.com/image/160531/nbrhjg3v6.jpg?imageView2/2/w/300/q/85/format/webp
         * cover_image_url : http://img03.liwushuo.com/image/160531/xvdeuq0r8.jpg-w720
         * cover_webp_url : http://img03.liwushuo.com/image/160531/xvdeuq0r8.jpg?imageView2/2/w/720/q/85/format/webp
         * created_at : 1464659436
         * id : 301
         * order : 0
         * posts_count : 8
         * status : 0
         * subtitle : 将生活过成诗的文艺风家居
         * title : 文艺家生活
         * updated_at : 1464659436
         */

        @JSONField(name = "collections")
        private List<CollectionsBean> collections;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<CollectionsBean> getCollections() {
            return collections;
        }

        public void setCollections(List<CollectionsBean> collections) {
            this.collections = collections;
        }

        public static class PagingBean {
            @JSONField(name = "next_url")
            private String nextUrl;

            public String getNextUrl() {
                return nextUrl;
            }

            public void setNextUrl(String nextUrl) {
                this.nextUrl = nextUrl;
            }
        }

        public static class CollectionsBean {
            @JSONField(name = "banner_image_url")
            private String bannerImageUrl;
            @JSONField(name = "banner_webp_url")
            private String bannerWebpUrl;
            @JSONField(name = "cover_image_url")
            private String coverImageUrl;
            @JSONField(name = "cover_webp_url")
            private String coverWebpUrl;
            @JSONField(name = "created_at")
            private int createdAt;
            @JSONField(name = "id")
            private int id;
            @JSONField(name = "order")
            private int order;
            @JSONField(name = "posts_count")
            private int postsCount;
            @JSONField(name = "status")
            private int status;
            @JSONField(name = "subtitle")
            private String subtitle;
            @JSONField(name = "title")
            private String title;
            @JSONField(name = "updated_at")
            private int updatedAt;

            public String getBannerImageUrl() {
                return bannerImageUrl;
            }

            public void setBannerImageUrl(String bannerImageUrl) {
                this.bannerImageUrl = bannerImageUrl;
            }

            public String getBannerWebpUrl() {
                return bannerWebpUrl;
            }

            public void setBannerWebpUrl(String bannerWebpUrl) {
                this.bannerWebpUrl = bannerWebpUrl;
            }

            public String getCoverImageUrl() {
                return coverImageUrl;
            }

            public void setCoverImageUrl(String coverImageUrl) {
                this.coverImageUrl = coverImageUrl;
            }

            public String getCoverWebpUrl() {
                return coverWebpUrl;
            }

            public void setCoverWebpUrl(String coverWebpUrl) {
                this.coverWebpUrl = coverWebpUrl;
            }

            public int getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(int createdAt) {
                this.createdAt = createdAt;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getPostsCount() {
                return postsCount;
            }

            public void setPostsCount(int postsCount) {
                this.postsCount = postsCount;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(int updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
