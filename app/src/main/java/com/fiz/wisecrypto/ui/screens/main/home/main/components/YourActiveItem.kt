package com.fiz.wisecrypto.ui.screens.main.home.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fiz.wisecrypto.R
import com.fiz.wisecrypto.ui.screens.main.home.components.RelativeLabel
import com.fiz.wisecrypto.ui.screens.main.models.ActiveUi
import com.fiz.wisecrypto.ui.theme.MulishBold
import com.fiz.wisecrypto.ui.theme.hint
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun YourActiveItem(
    active: ActiveUi
) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = MaterialTheme.colorScheme.surface)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                GlideImage(
                    modifier = Modifier
                        .size(28.dp),
                    imageModel = active.icon,
                    contentScale = ContentScale.Crop,
                    placeHolder = painterResource(id = R.drawable.placeholder_loading),
                    error = painterResource(id = R.drawable.placeholder_error),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = active.abbreviated,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = active.name,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.width(24.dp))

            RelativeLabel(up = active.isUpDirectChangePercentage, value = active.changePercentage)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Divider(
                modifier = Modifier.weight(1f),
                thickness = 0.3.dp,
                color = MaterialTheme.colorScheme.hint
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stringResource(R.string.home_portfolio),
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Normal),
                    color = MaterialTheme.colorScheme.hint
                )
                Text(
                    text = active.portfolio,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = MulishBold,
                        //                                    fontWeight = FontWeight.Bold,
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.align(Alignment.Bottom),
                text = active.equivalent,
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = MulishBold),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}