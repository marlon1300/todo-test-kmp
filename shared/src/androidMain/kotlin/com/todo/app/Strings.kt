package com.todo.app

import android.content.Context
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.format

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Strings(
    private val context: Context,
) {
    actual fun get(id: StringResource, args: List<Any>): String {
        return if (args.isEmpty()) {
            StringDesc.Resource(id).toString(context = context)
        } else {
            id.format(*args.toTypedArray()).toString(context)
        }
    }
}