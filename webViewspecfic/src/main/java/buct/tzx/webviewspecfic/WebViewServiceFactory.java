package buct.tzx.webviewspecfic;

import android.app.Application;

import buct.tzx.servicemanager_annotaion.ServiceFactory;
import buct.tzx.servicemanager_api.IFactory;
import buct.tzx.webviewprotool.WebViewService;
@ServiceFactory(protool = "buct.tzx.webviewprotool.WebViewService")
public class WebViewServiceFactory implements IFactory<WebViewService> {
    @Override
    public WebViewService CreateFactory(Application application) {
        return new WebViewServiceImpl();
    }
}
