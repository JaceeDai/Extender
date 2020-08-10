package com.github.jaceed.extender.standard

import kotlin.contracts.contract

/**
 * Created by Jacee.
 * Date: 2020.08.10
 */

/**
 * Return [true] if the given item exists in the all-non-null-item array.
 */
infix fun <T> T?.anyOf(array: Array<T>): Boolean {
    contract {
        returns(true) implies (this@anyOf != null)
    }
    if (this == null) {
        return false
    }
    array.forEach {
        if (this == it) {
            return true
        }
    }
    return false
}