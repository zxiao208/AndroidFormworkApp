package vip.zhaoxiao.androidformworkapp.model;

import vip.zhaoxiao.androidformworkapp.model.bean.CommentBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.DetailExtraBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GankItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GankSearchItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GoldListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GoldManagerBean;
import vip.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.NodeBean;
import vip.zhaoxiao.androidformworkapp.model.bean.NodeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.RealmLikeBean;
import vip.zhaoxiao.androidformworkapp.model.bean.RepliesListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.SectionListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ThemeChildListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ThemeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.VersionBean;
import vip.zhaoxiao.androidformworkapp.model.bean.WXItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.WelcomeBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;
import vip.zhaoxiao.androidformworkapp.model.db.DBHelper;
import vip.zhaoxiao.androidformworkapp.model.http.HttpHelper;
import vip.zhaoxiao.androidformworkapp.model.http.response.GankHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.http.response.GoldHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.http.response.MyHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.http.response.WXHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.prefs.PreferencesHelper;

import java.util.List;

import io.reactivex.Flowable;
import vip.zhaoxiao.androidformworkapp.model.bean.DailyBeforeListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GankItemBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GoldListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.GoldManagerBean;
import vip.zhaoxiao.androidformworkapp.model.bean.HotListBean;
import vip.zhaoxiao.androidformworkapp.model.bean.VersionBean;
import vip.zhaoxiao.androidformworkapp.model.bean.ZhihuDetailBean;
import vip.zhaoxiao.androidformworkapp.model.http.response.GoldHttpResponse;
import vip.zhaoxiao.androidformworkapp.model.prefs.PreferencesHelper;

/**
 *
 */

public class DataManager implements HttpHelper, DBHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public boolean getNightModeState() {
        return mPreferencesHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean state) {
        mPreferencesHelper.setNightModeState(state);
    }

    @Override
    public boolean getNoImageState() {
        return mPreferencesHelper.getNoImageState();
    }

    @Override
    public void setNoImageState(boolean state) {
        mPreferencesHelper.setNoImageState(state);
    }

    @Override
    public boolean getAutoCacheState() {
        return mPreferencesHelper.getAutoCacheState();
    }

    @Override
    public void setAutoCacheState(boolean state) {
        mPreferencesHelper.setAutoCacheState(state);
    }

    @Override
    public int getCurrentItem() {
        return mPreferencesHelper.getCurrentItem();
    }

    @Override
    public void setCurrentItem(int item) {
        mPreferencesHelper.setCurrentItem(item);
    }

    @Override
    public boolean getLikePoint() {
        return mPreferencesHelper.getLikePoint();
    }

    @Override
    public void setLikePoint(boolean isFirst) {
        mPreferencesHelper.setLikePoint(isFirst);
    }

    @Override
    public boolean getVersionPoint() {
        return mPreferencesHelper.getVersionPoint();
    }

    @Override
    public void setVersionPoint(boolean isFirst) {
        mPreferencesHelper.setVersionPoint(isFirst);
    }

    @Override
    public boolean getManagerPoint() {
        return mPreferencesHelper.getManagerPoint();
    }

    @Override
    public void setManagerPoint(boolean isFirst) {
        mPreferencesHelper.setManagerPoint(isFirst);
    }

    @Override
    public void insertNewsId(int id) {
        mDbHelper.insertNewsId(id);
    }

    @Override
    public boolean queryNewsId(int id) {
        return mDbHelper.queryNewsId(id);
    }

    @Override
    public void insertLikeBean(RealmLikeBean bean) {
        mDbHelper.insertLikeBean(bean);
    }

    @Override
    public void deleteLikeBean(String id) {
        mDbHelper.deleteLikeBean(id);
    }

    @Override
    public boolean queryLikeId(String id) {
        return mDbHelper.queryLikeId(id);
    }

    @Override
    public List<RealmLikeBean> getLikeList() {
        return mDbHelper.getLikeList();
    }

    @Override
    public void changeLikeTime(String id, long time, boolean isPlus) {
        mDbHelper.changeLikeTime(id, time, isPlus);
    }

    @Override
    public void updateGoldManagerList(GoldManagerBean bean) {
        mDbHelper.updateGoldManagerList(bean);
    }

    @Override
    public GoldManagerBean getGoldManagerList() {
        return mDbHelper.getGoldManagerList();
    }

    @Override
    public Flowable<DailyListBean> fetchDailyListInfo() {
        return mHttpHelper.fetchDailyListInfo();
    }

    @Override
    public Flowable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date) {
        return mHttpHelper.fetchDailyBeforeListInfo(date);
    }

    @Override
    public Flowable<ThemeListBean> fetchDailyThemeListInfo() {
        return mHttpHelper.fetchDailyThemeListInfo();
    }

    @Override
    public Flowable<ThemeChildListBean> fetchThemeChildListInfo(int id) {
        return mHttpHelper.fetchThemeChildListInfo(id);
    }

    @Override
    public Flowable<SectionListBean> fetchSectionListInfo() {
        return mHttpHelper.fetchSectionListInfo();
    }

    @Override
    public Flowable<SectionChildListBean> fetchSectionChildListInfo(int id) {
        return mHttpHelper.fetchSectionChildListInfo(id);
    }

    @Override
    public Flowable<ZhihuDetailBean> fetchDetailInfo(int id) {
        return mHttpHelper.fetchDetailInfo(id);
    }

    @Override
    public Flowable<DetailExtraBean> fetchDetailExtraInfo(int id) {
        return mHttpHelper.fetchDetailExtraInfo(id);
    }

    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mHttpHelper.fetchWelcomeInfo(res);
    }

    @Override
    public Flowable<CommentBean> fetchLongCommentInfo(int id) {
        return mHttpHelper.fetchLongCommentInfo(id);
    }

    @Override
    public Flowable<CommentBean> fetchShortCommentInfo(int id) {
        return mHttpHelper.fetchShortCommentInfo(id);
    }

    @Override
    public Flowable<HotListBean> fetchHotListInfo() {
        return mHttpHelper.fetchHotListInfo();
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
        return mHttpHelper.fetchTechList(tech, num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
        return mHttpHelper.fetchGirlList(num, page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
        return mHttpHelper.fetchRandomGirl(num);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query, String type, int num, int page) {
        return mHttpHelper.fetchGankSearchList(query, type, num, page);
    }

    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
        return mHttpHelper.fetchWechatListInfo(num, page);
    }

    @Override
    public Flowable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word) {
        return mHttpHelper.fetchWechatSearchListInfo(num, page, word);
    }

    @Override
    public Flowable<MyHttpResponse<VersionBean>> fetchVersionInfo() {
        return mHttpHelper.fetchVersionInfo();
    }

    @Override
    public Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldList(String type, int num, int page) {
        return mHttpHelper.fetchGoldList(type, num, page);
    }

    @Override
    public Flowable<GoldHttpResponse<List<GoldListBean>>> fetchGoldHotList(String type, String dataTime, int limit) {
        return mHttpHelper.fetchGoldHotList(type, dataTime, limit);
    }

    @Override
    public Flowable<NodeBean> fetchNodeInfo(String name) {
        return mHttpHelper.fetchNodeInfo(name);
    }

    @Override
    public Flowable<List<NodeListBean>> fetchTopicList(String name) {
        return mHttpHelper.fetchTopicList(name);
    }

    @Override
    public Flowable<List<NodeListBean>> fetchTopicInfo(String id) {
        return mHttpHelper.fetchTopicInfo(id);
    }

    @Override
    public Flowable<List<RepliesListBean>> fetchRepliesList(String id) {
        return mHttpHelper.fetchRepliesList(id);
    }
}
