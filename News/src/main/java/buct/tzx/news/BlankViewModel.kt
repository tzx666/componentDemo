package buct.tzx.news

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buct.tzx.news.model.NewsApi
import buct.tzx.news.model.NewsReq
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class BlankViewModel : ViewModel() {
    public var resp=MutableLiveData<NewsReq>()
    fun getresp():MutableLiveData<NewsReq>{
        return  resp
    }
    fun setReso(){
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.apiopen.top/") //设置网络请求的Url地址
//            .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            .build()
//        var apis = retrofit.create(NewsApi::class.java)
//        var res=apis.getNews(10)
//        res.execute()

    }
}