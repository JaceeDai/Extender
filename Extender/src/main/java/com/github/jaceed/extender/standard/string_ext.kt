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
inline fun <R> String?.available(block: (String) -> R?): R? {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return if (!isNullOrEmpty()) {
        block(this!!)
    } else null
}

fun String?.availableWith(default: String): String {
    return available {
        it
    } ?: default.available {
        it
    } ?: run {
        check(default.isNotEmpty())
        ""
    }
}

infix fun String?.orBy(default: String?): String {
    return if (isNullOrEmpty()) default ?: "" else this!!
}