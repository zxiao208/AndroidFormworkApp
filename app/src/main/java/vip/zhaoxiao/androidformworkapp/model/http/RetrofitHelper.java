package vip.zhaoxiao.androidformworkapp.model.http;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import vip.zhaoxiao.androidformworkapp.base.Constants;
import vip.zhaoxiao.androidformworkapp.model.bean.CommentBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DetailExtraBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GankItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GankSearchItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GoldListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.NodeBean;
import vip.zhaoxiao.androidformworkapp.model.bean.NodeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.RepliesListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ThemeChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ThemeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.VersionBean;
import vip.zhaoxiao.androidformworkapp.model.bean.WXItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.WelcomeBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;
import vip.zhaoxiao.androidformworkapp.model.http.api.GankApis;
import vip.zhaoxiao.androidformworkapp.model.http.api.GoldApis;
import vip.zhaoxiao.androidformworkapp.model.http.api.MyApis;
import vip.zhaoxiao.androidformworkapp.model.http.api.VtexApis;
import vip.zhaoxiao.androidformworkapp.model.http.api.WeChatApis;
import vip.zhaoxiao.androidformworkapp.model.http.api.ZhihuApis;
import vip.zhaoxiao.androidformworkapp.model.http.response.GankHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.http.response.GoldHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.http.response.MyHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.http.response.WXHttpResponse;

/**
 */
public class RetrofitHelper implements HttpHelper {

    private ZhihuApis mZhihuApiService;
    private GankApis mGankApiService;
    private WeChatApis mWechatApiService;
    private MyApis mMyApiService;
    private GoldApis mGoldApiService;
    private VtexApis mVtexApiService;

    @Inject
    public RetrofitHelper(ZhihuApis zhihuApiService, GankApis gankApiService, WeChatApis wechatApiService,
                          MyApis myApiService, GoldApis goldApiService, VtexApis vtexApiService) {
        this.mZhihuApiService = zhihuApiService;
        this.mGankApiService = gankApiService;
        this.mWechatApiService = wechatApiService;
        this.mMyApiService = myApiService;
        this.mGoldApiService = goldApiService;
        this.mVtexApiService = vtexApiService;
    }

    @Override
    public Flowable<DailyListBean> fetchDailyListInfo() {
        return mZhihuApiService.getDailyList();
    }

    @Override
    public Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date) {
        return mZhihuApiService.getDailyBeforeList(date);
    }

    @Override
    public Flowable<ThemeListBean> fetchDailyThemeListInfo() {
        return mZhihuApiService.getThemeList();
    }

    @Override
    public Flowable<ThemeChildListBean> fetchThemeChildListInfo(int id) {
        return mZhihuApiService.getThemeChildList(id);
    }

    @Override
    public Flowable<SectionListBean> fetchSectionListInfo() {
        return mZhihuApiService.getSectionList();
    }

    @Override
    public Flowable<SectionChildListBean> fetchSectionChildListInfo(int id) {
        return mZhihuApiService.getSectionChildList(id);
    }

    @Override
    public Flowable<ZhihuDetailBean> fetchDetailInfo(int id) {
        return mZhihuApiService.getDetailInfo(id);
    }

    @Override
    public Flowable<DetailExtraBean> fetchDetailExtraInfo(int id) {
        return mZhihuApiService.getDetailExtraInfo(id);
    }

    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }

    @Override
    public Flowable<CommentBean> fetchLongCommentInfo(int id) {
        return mZhihuApiService.getLongCommentInfo(id);
    }

    @Override
    public Flowable<CommentBean> fetchShortCommentInfo(int id) {
        return mZhihuApiService.getShortCommentInfo(id);
    }

    @Override
    public Flowable<HotListBean> fetchHotListInfo() {
        return mZhihuApiService.getHotList();
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return mGankApiService.getTechList(tech, num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return mGankApiService.getGirlList(num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
        return mGankApiService.getRandomGirl(num);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page) {
        return mGankApiService.getSearchList(query,type,num,page);
    }

    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
        return mWechatApiService.getWXHot(Constants.KEY_API, num, page);
    }

    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word) {
        return mWechatApiService.getWXHotSearch(Constants.KEY_API, num, page, word);
    }

    @Override
    public Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo() {
        return mMyApiService.getVersionInfo();
    }

    @Override
    public Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldList(String type, int num, int page) {
        return mGoldApiService.getGoldList(Constants.LEANCLOUD_ID, Constants.LEANCLOUD_SIGN,
                "{\"category\":\"" + type + "\"}", "-createdAt", "user,user.installation", num, page * num);
    }

    @Override
    public Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldHotList(String type, String dataTime, int limit) {
        return mGoldApiService.getGoldHot(Constants.LEANCLOUD_ID, Constants.LEANCLOUD_SIGN,
                "{\"category\":\"" + type + "\",\"createdAt\":{\"$gt\":{\"__type\":\"Date\",\"iso\":\"" + dataTime + "T00:00:00.000Z\"}},\"objectId\":{\"$nin\":[\"58362f160ce463005890753e\",\"583659fcc59e0d005775cc8c\",\"5836b7358ac2470065d3df62\"]}}",
                "-hotIndex", "user,user.installation", limit);
    }

    @Override
    public Flowable<NodeBean> fetchNodeInfo(String name) {
        return mVtexApiService.getNodeInfo(name);
    }

    @Override
    public Flowable<List<NodeListBean>> fetchTopicList(String name) {
        return mVtexApiService.getTopicList(name);
    }

    @Override
    public Flowable<List<NodeListBean>> fetchTopicInfo(String id) {
        return mVtexApiService.getTopicInfo(id);
    }

    @Override
    public Flowable<List<RepliesListBean>> fetchRepliesList(String id){
        return mVtexApiService.getRepliesList(id);
    }
}
