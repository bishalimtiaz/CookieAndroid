package com.cookieTech.cookieandroid.core.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

abstract class BaseScreen {

    @Composable
    abstract fun Body()

    @Composable
    fun Screen(){
        ScreenBody {
            Body()
        }
    }

    @Preview(showBackground = true)
    @Composable
    open fun PreviewScreen(){
        Screen()
    }
}