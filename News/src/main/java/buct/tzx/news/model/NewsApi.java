package buct.tzx.news.model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NewsApi {
    @POST("/getWangYiNews")
    @FormUrlEncoded
    Call<ResponseBody> getNews(@Field("count") int count);

}
