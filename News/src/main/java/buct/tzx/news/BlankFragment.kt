package buct.tzx.news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import buct.tzx.base.Event.NewsEvent
import buct.tzx.buctbus.BuctBus
import buct.tzx.buctbus.ThreadMode
import buct.tzx.buctbus.annotation.Subscribe
import buct.tzx.news.adapter.DemoAdapter
import buct.tzx.news.model.NewsApi
import buct.tzx.news.model.NewsModel
import buct.tzx.news.model.NewsReq
import buct.tzx.routerannotation.Router
import buct.tzx.routerapi.BuctRouter
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Router(Path = "/main/feed")
class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }

    private lateinit var viewModel: BlankViewModel
    private lateinit var  adapter:DemoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.blank_fragment, container, false)
        var button = view.findViewById<Button>(R.id.button)
        var res = view.findViewById<RecyclerView>(R.id.rec)
         adapter=DemoAdapter(R.layout.cell)
        res.layoutManager=LinearLayoutManager(activity)
        res.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            Toast.makeText(context,(adapter.getItem(position) as NewsModel).path, Toast.LENGTH_SHORT).show()
        }
        BuctBus.getInstance().register(this)
        button.setOnClickListener {
//            viewModel.setReso()
            BuctBus.getInstance().post(NewsEvent())
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        viewModel.resp.observe(this, object : Observer<NewsReq> {
            override fun onChanged(t: NewsReq?) {
                Log.d("tzx", "onChanged: "+t?.message)
                adapter.setNewData(t?.result)
                adapter.notifyDataSetChanged()
            }

        })
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun dealThings(event: NewsEvent){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.apiopen.top/") //设置网络请求的Url地址
            .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
        var apis = retrofit.create(NewsApi::class.java)
        var res=apis.getNews(10)
        var body = res.execute()
        var resq = Gson().fromJson(body.body().string(),NewsReq::class.java)
        activity?.runOnUiThread {
            viewModel.resp.value=resq
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        BuctBus.getInstance().unregister(this)
    }
}