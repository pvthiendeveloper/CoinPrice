package com.pvthiendeveloper.coinprice.home.presentation.model.mappers

/*
* Mapping data to avoid every time you will need to modify your model, all your app need to be updated.
*
* If you just use one user model:
* Everything looks great!, right? well, lets considered next problems:
*    - Imagine the data base should be modified because the user contains more data.
*    - Imagine you need to add a RESTFULL API data source.
*    - Imagine that the UI could not handle the data types that the data base use.
*
* This useful if you have a lot of mappers and want to make sure
* they all follow the same contract.
* */
internal interface UiStateMapper<D, V> {

    fun mapToUiState(input: D): V
}