package com.dino.unsplash.shared.domain.base

import com.dino.unsplash.shared.data.model.response.ApiException
import com.dino.unsplash.shared.domain.model.ApiError
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesIgnore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

@NativeCoroutinesIgnore
fun <T>execute(
    context: CoroutineContext = Dispatchers.Default,
    block: suspend () -> T
): Flow<T> {
    return flow {
        try {
            val out = block.invoke()
            emit(out)
        } catch (e: ApiException) {
            throw ApiError(e.errors.orEmpty())
        }
        catch (e: Throwable) {
            throw e
        }
    }.flowOn(context)
}