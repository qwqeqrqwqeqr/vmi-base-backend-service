package com.vmi.data.model

enum class SavedFlag { SAVED, NOT_SAVED, TEMP_SAVED }


fun SavedFlag.savedFlagMapper() : Int = when(this){
    SavedFlag.NOT_SAVED -> 0
    SavedFlag.SAVED -> 1
    SavedFlag.TEMP_SAVED -> 2
}