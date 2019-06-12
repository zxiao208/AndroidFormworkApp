package vip.zhaoxiao.androidformworkapp.model.http.api;


import vip.zhaoxiao.androidformworkapp.model.bean.CommentBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DetailExtraBean;
import vip.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ThemeChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ThemeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.WelcomeBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vip.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;

/**
 * Created by codeest on 2016/8/2.
 * 知乎APIs
 */
public interface ZhihuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 启动界面图片
     */
    @GET("start-image/{res}")
    Flowable<WelcomeBean> getWelcomeInfo(@Path("res") String res);

    /**
     * 最新日报
     */
    @GET("news/latest")
    Flowable<DailyListBean> getDailyList();

    /**
     * 往期日报
     */
    @GET("news/before/{date}")
    Flowable<DailyBeforeListBean> getDailyBeforeList(@Path("date") String date);

    /**
     * 主题日报
     */
    @GET("themes")
    Flowable<ThemeListBean> getThemeList();

    /**
     * 主题日报详情
     */
    @GET("theme/{id}")
    Flowable<ThemeChildListBean> getThemeChildList(@Path("id") int id);

    /**
     * 专栏日报
     */
    @GET("sections")
    Flowable<SectionListBean> getSectionList();

    /**
     * 专栏日报详情
     */
    @GET("section/{id}")
    Flowable<SectionChildListBean> getSectionChildList(@Path("id") int id);

    /**
     * 热门日报
     */
    @GET("news/hot")
    Flowable<HotListBean> getHotList();

    /**
     * 日报详情
     */
    @GET("news/{id}")
    Flowable<ZhihuDetailBean> getDetailInfo(@Path("id") int id);

    /**
     * 日报的额外信息
     */
    @GET("story-extra/{id}")
    Flowable<DetailExtraBean> getDetailExtraInfo(@Path("id") int id);

    /**
     * 日报的长评论
     */
    @GET("story/{id}/long-comments")
    Flowable<CommentBean> getLongCommentInfo(@Path("id") int id);

    /**
     * 日报的短评论
     */
    @GET("story/{id}/short-comments")
    Flowable<CommentBean> getShortCommentInfo(@Path("id") int id);

//
//    /**
//     * 获取专栏的之前消息
//     *
//     * @param id
//     * @param timestamp
//     * @return
//     */
//    @GET("section/{id}/before/{timestamp}")
//    Flowable<SectionsDetails> getBeforeSectionsDetails(@Path("id") int id, @Path("timestamp") long timestamp);
//
}
