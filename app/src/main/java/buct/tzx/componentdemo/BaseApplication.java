package buct.tzx.componentdemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import buct.tzx.buctbus.BuctBus;
import buct.tzx.routerapi.BuctRouter;
import buct.tzx.servicemanager_api.ServiceManager;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BuctRouter.getInstance().setIsauto(true);
        BuctRouter.getInstance().init(this);
        ServiceManager.setApplication(this);
        new BuctBus.builder()
                .setDebugMode(true)
                .setEnablePostSticky(true)
                .setEnableThread(true)
                .build();
        Fresco.initialize(this);
    }
}
