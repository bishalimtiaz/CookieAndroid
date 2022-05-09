package com.cookieTech.cookieandroid.modules.search

import io.reactivex.subjects.PublishSubject

class RxSearchObservable {

    fun fromSearchText(query:String){
        val subject = PublishSubject.create<String>()
    }
}