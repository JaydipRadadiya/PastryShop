/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevalpatel2106.pastryshop.pageDetail

import android.arch.lifecycle.MutableLiveData
import com.kevalpatel2106.pastryshop.bin.Pages
import com.kevalpatel2106.pastryshop.repository.Repository
import com.kevalpatel2106.pastryshop.utils.BaseViewModel
import com.kevalpatel2106.pastryshop.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Keval on 02/06/18.
 * View model for the [DetailFragment].
 *
 * @author <a href="https://github.com/kevalpatel2106">kevalpatel2106</a>
 */
class DetailViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {

    /**
     * [MutableLiveData] of the name/title of the page.
     */
    internal val name = MutableLiveData<String>()

    /**
     * [MutableLiveData] for the description test of the page.
     */
    internal val description = MutableLiveData<String>()

    /**
     * [MutableLiveData] for the list of images urls.
     */
    internal val image = MutableLiveData<ArrayList<String>>()

    /**
     * [SingleLiveEvent] which contains the message for the error occurred while loading the page detail.
     */
    internal val errorLoadingPage = SingleLiveEvent<String>()

    init {
        // Initialize
        image.value = ArrayList()
    }

    /**
     * Observe the [Pages] with [pageId] for any changes in the database.
     */
    internal fun observePage(pageId: Long) {
        val d = repository.getPage(pageId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({

                    // Some changes occurred into the database
                    // Rebuild the pages list.
                    name.value = it.title
                    description.value = it.description
                    image.value = it.image
                }, {

                    // Error occurred
                    errorLoadingPage.value = it.message
                })

        addDisposable(d)
    }
}