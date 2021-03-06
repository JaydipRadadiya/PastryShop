/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevalpatel2106.pastryshop.utils

import android.content.Context
import android.support.v7.widget.LinearLayoutManager

/**
 * Created by Keval on 01/06/18.
 * Custom [LinearLayoutManager].
 *
 * @author <a href="https://github.com/kevalpatel2106">kevalpatel2106</a>
 */
class PSLinearLayoutManager(context: Context,
                            orientation: Int = LinearLayoutManager.VERTICAL,
                            reverseLayout: Boolean = false) : LinearLayoutManager(context, orientation, reverseLayout) {
    /**
     * True to allow [PSLinearLayoutManager] to scroll the recycler view.
     */
    var isScrollEnabled = true

    override fun canScrollVertically(): Boolean {
        return isScrollEnabled && super.canScrollVertically()
    }

    override fun canScrollHorizontally(): Boolean {
        return isScrollEnabled && super.canScrollHorizontally()
    }
}