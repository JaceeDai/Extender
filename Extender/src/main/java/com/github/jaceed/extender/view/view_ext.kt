package com.github.jaceed.extender.view

import android.os.SystemClock
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

internal const val CLICK_PROTECTED_DELAY = 1000L

/**
 *  Protected click listener, no response until a delay is over. Default delay is [CLICK_PROTECTED_DELAY]
 */
fun View.setOnProtectedClickListener(delay: Long = CLICK_PROTECTED_DELAY, l: (View) -> Unit) {
    var time: Long = 0
    setOnClickListener {
        val cur = SystemClock.elapsedRealtime()
        if (time == 0L || time + delay < cur) {
            l(it)
            time = cur
        }
    }
}

/**
 *  Protected click listener, no response until a delay is over. Default delay is [CLICK_PROTECTED_DELAY]
 */
fun View.setOnProtectedClickListener(l: View.OnClickListener, delay: Long = CLICK_PROTECTED_DELAY) {
    var time: Long = 0
    setOnClickListener {
        val cur = SystemClock.elapsedRealtime()
        if (time == 0L || time + delay < cur) {
            l.onClick(it)
            time = cur
        }
    }
}

/**
 *  Protected click listeners for a view array, no response until a delay is over. Default delay is [CLICK_PROTECTED_DELAY]
 */
fun Array<out View>.setOnProtectedClickListener(delay: Long = CLICK_PROTECTED_DELAY, l: (View) -> Unit) {
    forEach {
        it.setOnProtectedClickListener(delay) { v -> l(v) }
    }
}

/**
 *  Protected click listeners for a view array, no response until a delay is over. Default delay is [CLICK_PROTECTED_DELAY]
 */
fun Array<out View>.setOnProtectedClickListener(l: View.OnClickListener, delay: Long = CLICK_PROTECTED_DELAY) {
    forEach {
        it.setOnProtectedClickListener(l, delay)
    }
}