package com.cookieTech.cookieandroid.Data.Converters

import junit.framework.Assert.assertEquals

import org.junit.Test
import java.util.*

class ConvertersTest {

    private val converters = Converters()
    private val cal = Calendar.getInstance().apply {
        set(Calendar.YEAR, 1998)
        set(Calendar.MONTH, Calendar.SEPTEMBER)
        set(Calendar.DAY_OF_MONTH, 4)
    }

    @Test
    fun calenderToDateStamp(){

        assertEquals(cal,converters.datestampToCalendar(cal.timeInMillis))
    }

    @Test
    fun datestampToCalendar(){
        assertEquals(cal.timeInMillis,converters.calendarToDatestamp(cal))
    }
}