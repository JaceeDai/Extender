package com.github.jaceed.extender.standard

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Created by Jacee.
 * Date: 2020.08.10
 */

/**
 * Calls the specified function [block] when `this` contains non-empty content, and `this` as its receiver
 */
inline fun <R> CharSequence?.available(block: (CharSequence) -> R?): R? {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return if (this != null && this.isNotEmpty()) {
        block(this)
    } else null
}

/**
 * Check such string available or not. If true, use it, or false to use [default].
 * IllegalStateException would be thrown if both are unavailable.
 */
fun CharSequence?.availableWith(default: CharSequence): CharSequence {
    return if (this != null && this.isNotEmpty())
        this
    else if (default.isNotEmpty())
        default
    else
        throw IllegalStateException("Not available")
}

/**
 * Use such string if it's available, or [default] instead.
 * NonNull will be returned.
 */
infix fun CharSequence?.orBy(default: CharSequence?): CharSequence {
    return if (this == null || this.isEmpty()) default ?: "" else this
}