package com.pvthiendeveloper.coinprice.home.domain.usecase

import com.pvthiendeveloper.coinprice.home.domain.HomeRepository
import com.pvthiendeveloper.coinprice.home.domain.model.Crypto
import com.pvthiendeveloper.coinprice.utilities.coroutines.IoDispatcher
import com.pvthiendeveloper.coinprice.utilities.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
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
class GetListCryptoUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Result<List<Crypto>> {
        return withContext(dispatcher) {
            try {
                Result.Success(repository.getListCrypto())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}