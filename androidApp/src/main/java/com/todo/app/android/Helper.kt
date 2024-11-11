package com.todo.app.android

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.todo.app.Strings
import dev.icerock.moko.resources.StringResource

@Composable
fun stringResource(id:StringResource, vararg args: Any):String {
    return Strings(LocalContext.current).get(id,args.toList())
}

fun stringResource(id:StringResource, vararg args: Any, context: Context):String {
    return Strings(context).get(id,args.toList())
}