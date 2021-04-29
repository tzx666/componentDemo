package buct.tzx.news.adapter;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import buct.tzx.news.R;
import buct.tzx.news.model.NewsModel;
import buct.tzx.news.model.NewsReq;

public class DemoAdapter extends BaseQuickAdapter<NewsModel, BaseViewHolder> {

    /**
     * 构造方法，此示例中，在实例化Adapter时就传入了一个List。
     * 如果后期设置数据，不需要传入初始List，直接调用 super(layoutResId); 即可
     */
    public DemoAdapter(int id) {
        super(id);
    }

    /**
     * 在此方法中设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewsModel newsModel) {
        Log.d("tzx", "convert: "+newsModel.getImage());
        ImageView draweeView=baseViewHolder.findView(R.id.my_image_view);
        Log.d("tzx", String.valueOf(draweeView.getId()));
        Glide.with(getContext()).load(newsModel.getImage()).into(draweeView);
        baseViewHolder.setText(R.id.textView,newsModel.getTitle());
        baseViewHolder.setText(R.id.textView1,newsModel.getPasstime());
    }
}
