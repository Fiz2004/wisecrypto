package com.fiz.wisecrypto.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fiz.wisecrypto.R
import com.fiz.wisecrypto.domain.models.Coin
import com.fiz.wisecrypto.ui.screens.main.home.main.components.RelativeLabel
import com.fiz.wisecrypto.ui.screens.main.models.toCoinUi
import com.fiz.wisecrypto.ui.theme.MulishBold
import com.fiz.wisecrypto.ui.theme.MulishRegular
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CoinColumn(coins: List<Coin>, moveHomeDetailScreen: (String) -> Unit) {
    LazyColumn {
        coins.forEach {
            item {
                CoinItem(it, moveHomeDetailScreen)
            }
        }
    }
}


@Composable
private fun CoinItem(coin: Coin, moveHomeDetailScreen: (String) -> Unit) {

    val coinUi = coin.toCoinUi()

    Row(
        modifier = Modifier
            .height(88.dp)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clickable { moveHomeDetailScreen(coin.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            GlideImage(
                modifier = Modifier
                    .size(40.dp),
                imageModel = coinUi.icon,
                contentScale = ContentScale.Crop,
                placeHolder = painterResource(id = R.drawable.placeholder_loading),
                error = painterResource(id = R.drawable.placeholder_error),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = coinUi.abbreviated.uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = coinUi.name,
                style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = MulishRegular
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = coinUi.cost,
                style = MaterialTheme.typography.displayMedium.copy(fontFamily = MulishBold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            RelativeLabel(Increased = coinUi.up, value = coinUi.value)
        }
    }

    Spacer(modifier = Modifier.height(8.dp))
}