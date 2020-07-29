package com.github.jaceed.extender.view

import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Jacee.
 * Date: 2020.07.29
 */

/**
 * Whether the view is visually visible or completed gone
 */
var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

/**
 * [TextView]'s text value, if null or empty, it will be set gone automatically
 */
var TextView.content: CharSequence?
    get() = text
    set(value) {
        text = value
        visible = !value.isNullOrEmpty()
    }

/**
 * Parse all the child view of a [ViewGroup] if necessary. Each item will be handled by a block.
 * @param recursive Whether recursive enabled
 * @param block handle function for every child view
 */
fun ViewGroup.forEach(recursive: Boolean, block: (View) -> Unit) {
    var child: View
    for (i in 0 until childCount) {
        child = getChildAt(i)
        block(child)
        if (recursive && child is ViewGroup) {
            child.forEach(recursive, block)
        }
    }
}