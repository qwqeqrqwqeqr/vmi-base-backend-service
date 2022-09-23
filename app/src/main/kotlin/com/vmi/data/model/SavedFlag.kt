package com.vmi.data.model

/*
저장과 관련된 플래그를 관리하는 클래스
 */
enum class SavedFlag { SAVED, NOT_SAVED, TEMP_SAVED }


fun SavedFlag.savedFlagMapper() : Int = when(this){
    SavedFlag.NOT_SAVED -> 0
    SavedFlag.SAVED -> 1
    SavedFlag.TEMP_SAVED -> 2
}