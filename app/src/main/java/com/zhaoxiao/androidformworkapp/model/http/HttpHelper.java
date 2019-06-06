package com.zhaoxiao.androidformworkapp.model.http;


import com.zhaoxiao.androidformworkapp.model.bean.CommentBean;
import com.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import com.zhaoxiao.androidformworkapp.model.bean.DailyListBean;
import com.zhaoxiao.androidformworkapp.model.bean.DetailExtraBean;
import com.zhaoxiao.androidformworkapp.model.bean.GankItemBean;
import com.zhaoxiao.androidformworkapp.model.bean.GankSearchItemBean;
import com.zhaoxiao.androidformworkapp.model.bean.GoldListBean;
import com.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import com.zhaoxiao.androidformworkapp.model.bean.NodeBean;
import com.zhaoxiao.androidformworkapp.model.bean.NodeListBean;
import com.zhaoxiao.androidformworkapp.model.bean.RepliesListBean;
import com.zhaoxiao.androidformworkapp.model.bean.SectionChildListBean;
import com.zhaoxiao.androidformworkapp.model.bean.SectionListBean;
import com.zhaoxiao.androidformworkapp.model.bean.ThemeChildListBean;
import com.zhaoxiao.androidformworkapp.model.bean.ThemeListBean;
import com.zhaoxiao.androidformworkapp.model.bean.VersionBean;
import com.zhaoxiao.androidformworkapp.model.bean.WXItemBean;
import com.zhaoxiao.androidformworkapp.model.bean.WelcomeBean;
import com.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;
import com.zhaoxiao.androidformworkapp.model.http.response.GankHttpResponse;
import com.zhaoxiao.androidformworkapp.model.http.response.GoldHttpResponse;
import com.zhaoxiao.androidformworkapp.model.http.response.MyHttpResponse;
import com.zhaoxiao.androidformworkapp.model.http.response.WXHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {

    Flowable<DailyListBean> fetchDailyListInfo();

    Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date);

    Flowable<ThemeListBean> fetchDailyThemeListInfo();

    Flowable<ThemeChildListBean> fetchThemeChildListInfo(int id);

    Flowable<SectionListBean> fetchSectionListInfo();

    Flowable<SectionChildListBean> fetchSectionChildListInfo(int id);

    Flowable<ZhihuDetailBean> fetchDetailInfo(int id);

    Flowable<DetailExtraBean> fetchDetailExtraInfo(int id);

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);

    Flowable<CommentBean> fetchLongCommentInfo(int id);

    Flowable<CommentBean> fetchShortCommentInfo(int id);

    Flowable<HotListBean> fetchHotListInfo();

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page);

    Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num);

    Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page);

    Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page);

    Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word);

    Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo();

    Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldList(String type, int num, int page);

    Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldHotList(String type, String dataTime, int limit);

    Flowable<NodeBean> fetchNodeInfo(String name);

    Flowable<List<NodeListBean>> fetchTopicList(String name);

    Flowable<List<NodeListBean>> fetchTopicInfo(String id);

    Flowable<List<RepliesListBean>> fetchRepliesList(String id);
}
