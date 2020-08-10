package com.github.jaceed.extender.standard

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Created by Jacee.
 * Date: 2020.08.10
 */

@ExperimentalContracts
inline fun <R> String?.available(block: (String) -> R?): R? {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return if (!isNullOrEmpty()) {
        block(this!!)
    } else null
}