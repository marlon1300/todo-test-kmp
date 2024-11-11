package com.todo.app.di

import com.todo.app.data.TodoRepositoryImpl
import com.todo.app.data.api.ToDoApiImpl
import com.todo.app.domain.ToDoRepository
import com.todo.app.viewmodel.ToDoViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

//expect val platformModule: Module

val sharedModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        explicitNulls = false
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    singleOf(::ToDoApiImpl).bind<ToDoApiImpl>()
    singleOf(::TodoRepositoryImpl).bind<ToDoRepository>()
    viewModelOf(::ToDoViewModel)
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule)
    }
}