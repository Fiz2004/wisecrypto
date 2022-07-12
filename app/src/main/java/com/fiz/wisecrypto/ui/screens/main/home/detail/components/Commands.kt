package com.fiz.wisecrypto.ui.screens.main.home.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fiz.wisecrypto.R
import com.fiz.wisecrypto.ui.components.WiseCryptoButton

@Composable
fun Commands(
    onClickButtonSell: () -> Unit = {},
    onClickButtonBuy: () -> Unit = {},
) {
    // Если поменяется высота Commands, изменить Spacer в HomeDetailScreen
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        WiseCryptoButton(
            modifier = Modifier.weight(0.5f),
            text = R.string.detail_sell,
            color = MaterialTheme.colorScheme.secondary,
            onClick = onClickButtonSell
        )
        Spacer(modifier = Modifier.width(16.dp))
        WiseCryptoButton(
            modifier = Modifier.weight(0.5f),
            text = R.string.detail_buy,
            onClick = onClickButtonBuy
        )
    }
}