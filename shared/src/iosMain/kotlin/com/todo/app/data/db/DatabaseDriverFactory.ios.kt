//package com.todo.app.data.db
//
//import com.squareup.sqldelight.db.SqlDriver
//import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
//import com.todo.app.database.ToDoDatabase
//
//@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
//actual class DatabaseDriverFactory {
//    actual fun createDriver(): SqlDriver {
//        return NativeSqliteDriver(ToDoDatabase.Schema, "todo.db")
//    }
//}