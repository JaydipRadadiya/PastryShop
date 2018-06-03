/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevalpatel2106.pastryshop

import android.arch.persistence.room.Room
import com.kevalpatel2106.pastryshop.di.DaggerRootComponent
import com.kevalpatel2106.pastryshop.di.RootComponent
import com.kevalpatel2106.pastryshop.di.RootDiModule
import com.kevalpatel2106.pastryshop.repository.db.PSDatabase
import com.kevalpatel2106.pastryshop.utils.BaseApplication

/**
 * Created by Keval on 01/06/18.
 *
 * @author <a href="https://github.com/kevalpatel2106">kevalpatel2106</a>
 */
internal class PSApplication : BaseApplication() {
    override fun prepareBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun prepareDatabase(): PSDatabase {
        return Room.databaseBuilder(
                this@PSApplication,
                PSDatabase::class.java,
                PSDatabase.DB_NAME
        ).build()
    }

    override fun prepareRootComponent(): RootComponent {
        return DaggerRootComponent.builder()
                .rootDiModule(RootDiModule(this@PSApplication))
                .build()
    }

    override fun injectRootComponent() {
        rootComponent.inject(this@PSApplication)
    }
}