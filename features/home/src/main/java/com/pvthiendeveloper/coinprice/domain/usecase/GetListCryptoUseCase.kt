package com.pvthiendeveloper.coinprice.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.pvthiendeveloper.coinprice.domain.HomeRepository
import com.pvthiendeveloper.coinprice.domain.model.Crypto
import com.pvthiendeveloper.coinprice.utilities.coroutines.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/*
* Domain Layer:
* - It avoids code duplication and improves readability by use use case
* - Testability, split responsibilities
* - Avoids code duplication
*
* Dependencies of use case:
* - They can use repository and may also use other use cases
*
* Lifecycle:
*  - They don't have lifecycle. Instead, they're scoped to the class that uses them
*
* Threading:
* - Use cases from the domain layer must be main-safe
* */
internal class GetListCryptoUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: HomeRepository
) {
     operator fun invoke(pageSize: Int): Flow<PagingData<Crypto>> {
        return repository.getListCrypto(pageSize)
            .map { source -> source.map { it.toDomain() } }
            .flowOn(dispatcher)
    }
}