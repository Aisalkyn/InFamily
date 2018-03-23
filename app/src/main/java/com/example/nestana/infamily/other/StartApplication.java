package com.example.nestana.infamily.other;

import android.app.Application;

import aisa.bishkek_course_neobis.other.ForumService;
import aisa.bishkek_course_neobis.other.Network;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import static aisa.bishkek_course_neobis.other.Const.BASE_URL;
import static com.example.nestana.infamily.other.Const.BASE_URL;

/**
 * Created by Alier on 7/29/2017.
 */

public class StartApplication extends Application {
    private ForumService service;
   // private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        service = Network.Companion.initService(BASE_URL);
       // realm = initRealm();
    }

//    synchronized private Realm initRealm() {
//        Realm.init(getApplicationContext());
//        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
//                .name("courses")
//                .deleteRealmIfMigrationNeeded()
//                .build());
//        return Realm.getDefaultInstance();
//    }

    public ForumService getService() {
        return service;
    }

   /* public Realm getRealm() {
        return realm;
    }*/
}