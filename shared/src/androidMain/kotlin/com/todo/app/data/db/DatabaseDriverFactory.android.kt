//package com.todo.app.data.db
//
//import android.content.Context
//import com.squareup.sqldelight.android.AndroidSqliteDriver
//import com.squareup.sqldelight.db.SqlDriver
//import com.todo.app.database.ToDoDatabase
//
//@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
//actual class DatabaseDriverFactory(private val context: Context) {
//    actual fun createDriver(): SqlDriver {
//        return AndroidSqliteDriver(ToDoDatabase.Schema, context, "todo.db")
//    }
//}