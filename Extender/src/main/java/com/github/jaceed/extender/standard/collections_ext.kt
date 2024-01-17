package com.github.jaceed.extender.standard

import kotlin.contracts.contract

/**
 * Created by Jacee.
 * Date: 2020.08.10
 */

/**
 * Calls the specified function [block] when `this` contains non-zero-size items, and `this` as its receiver
 */
inline fun <E, T: Collection<E>, R> T?.available(block: (T) -> R?): R? {
    contract {
        returnsNotNull() implies (this@available != null)
    }
    return if (this != null && this.isNotEmpty()) {
        block(this)
    } else null
}