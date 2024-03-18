package com.seerhii.kurochka.buyme.ui.appointToBuyPage

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.seerhii.kurochka.buyme.R
import com.seerhii.kurochka.buyme.ui.theme.BuyMeTheme

@Composable
fun AppointToBuyPage() {
    LazyColumn {
        item { ShowDescription() }
        item { ShowCardWitchItem() }
        item { ShowButton() }
    }
}

@Composable
fun ShowDescription() {
    Row(
        Modifier
            .padding(all = dimensionResource(id = R.dimen.padding_medium))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Selected 4/8", // inner text
            Modifier.paddingFromBaseline(top = dimensionResource(id = R.dimen.padding_zero))
        )
        IconButton(
            onClick = { },
            Modifier.paddingFromBaseline(top = dimensionResource(id = R.dimen.padding_zero))
        ) {
            Icon(
                Icons.Outlined.Analytics,
                contentDescription = stringResource(R.string.sorted_icon)
            )
        }
    }
}

@Composable
fun ShowCardWitchItem() {
    val data = listOf(
        Item(true, "Buy canned food", "1kg"),
        Item(true, "Buy auto parts", "1pcs"),
        Item(false, "Buy lineal", "5m"),
        Item(true, "Buy sam food", "5pcs"),
        Item(false, "Learn something. ", "1r"),
        Item(false, "Buy some drink", "5L"),
        Item(true, "Buy coffee", "1kg"),
        Item(false, "Buy potatoes", "10kg"),
    )
    Card(
        Modifier
            .padding(all = dimensionResource(id = R.dimen.padding_medium)),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Column {
            for (list in data) {
                InnerPartOfTheCard(
                    alreadyCompleted = list.alreadyCompleted,
                    descriptionStr = list.descriptionStr,
                    quantityStr = list.quantityStr
                )
                HorizontalDivider(thickness = dimensionResource(id = R.dimen.padding_min))
            }
        }
    }
}

@Composable
fun InnerPartOfTheCard(alreadyCompleted: Boolean, descriptionStr: String, quantityStr: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(all = dimensionResource(id = R.dimen.padding_medium)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = alreadyCompleted,
                onCheckedChange = {},
                Modifier.padding(
                    top = dimensionResource(id = R.dimen.padding_small),
                    end = dimensionResource(id = R.dimen.padding_small),
                    bottom = dimensionResource(id = R.dimen.padding_small)
                ),
                colors = CheckboxDefaults.colors(MaterialTheme.colorScheme.onSurface)
            )
            Text(
                text = descriptionStr,
                Modifier.padding(all = dimensionResource(id = R.dimen.padding_small))
            )
        }

        Text(
            text = quantityStr,
            Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_small),
                top = dimensionResource(id = R.dimen.padding_small),
                end = dimensionResource(id = R.dimen.padding_medium),
                bottom = dimensionResource(id = R.dimen.padding_small)
            )
        )
    }
}

@Composable
fun ShowButton() {
    Row(
        Modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_big),
                end = dimensionResource(id = R.dimen.padding_big),
                top = dimensionResource(id = R.dimen.padding_big),
                bottom = dimensionResource(id = R.dimen.padding_big)
            )
            .fillMaxWidth(),
    ) {
        Button(onClick = { }, modifier = Modifier.fillMaxWidth(1f)) {
            Text(text = stringResource(R.string.appoint))
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun GreetingPreview() {
    BuyMeTheme {
        AppointToBuyPage()
    }
}

data class Item(val alreadyCompleted: Boolean, val descriptionStr: String, val quantityStr: String)