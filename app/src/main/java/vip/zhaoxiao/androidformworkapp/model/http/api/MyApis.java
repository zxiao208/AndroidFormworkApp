package vip.zhaoxiao.androidformworkapp.model.http.api;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import vip.zhaoxiao.androidformworkapp.model.bean.VersionBean;
import vip.zhaoxiao.androidformworkapp.model.http.response.MyHttpResponse;

/**
 * Created by codeest on 16/10/10.
 * https://github.com/codeestX/my-restful-api
 */

public interface MyApis {

    String HOST = "http://codeest.me/api/geeknews/";

    String APK_DOWNLOAD_URL = "http://codeest.me/apk/geeknews.apk";

    /**
     * 获取最新版本信息
     * @return
     */
    @GET("version")
    Flowable<MyHttpResponse<VersionBean>> getVersionInfo();

}
