/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevalpatel2106.pastryshop.repository.db

import android.arch.persistence.room.TypeConverter
import android.text.TextUtils


/**
 * Created by Keval on 01/06/18.
 * [TypeConverter] for room database.
 *
 * @author <a href="https://github.com/kevalpatel2106">kevalpatel2106</a>
 */
class ImageListConverter {

    /**
     * Convert the comma separated string [value], into the [ArrayList] of string.
     */
    @TypeConverter
    fun toImageList(value: String?): ArrayList<String> {
        return if (value == null) {
            ArrayList()
        } else {
            ArrayList(value.split(",").toList())
        }
    }

    /**
     * Convert the [arrayList] into the comma separated string.
     */
    @TypeConverter
    fun fromImageList(arrayList: ArrayList<String>): String {
        return TextUtils.join(",", arrayList)
    }
}