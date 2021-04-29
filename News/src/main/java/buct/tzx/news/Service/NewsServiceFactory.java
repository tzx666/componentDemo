package buct.tzx.news.Service;

import android.app.Application;

import buct.tzx.newsprotool.NewsService;
import buct.tzx.servicemanager_annotaion.ServiceFactory;
import buct.tzx.servicemanager_api.IFactory;

@ServiceFactory(protool = "buct.tzx.newsprotool.NewsService")
public class NewsServiceFactory implements IFactory<NewsService> {

    @Override
    public NewsService CreateFactory(Application application) {
        return new NewsSerivceImpl();
    }
}
