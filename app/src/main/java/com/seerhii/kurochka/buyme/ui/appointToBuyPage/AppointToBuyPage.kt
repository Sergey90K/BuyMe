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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            .padding(all = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Selected 4/8", Modifier.paddingFromBaseline(top = 30.dp))
        IconButton(onClick = { /*TODO*/ }, Modifier.paddingFromBaseline(top = 0.dp)) {
            Icon(Icons.Outlined.Analytics, contentDescription = "Localized description")
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
            .padding(all = 5.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Column {
            for (list in data) {
                InnerPartOfTheCard(
                    alreadyCompleted = list.alreadyCompleted,
                    descriptionStr = list.descriptionStr,
                    quantityStr = list.quantityStr
                )
                Divider(thickness = 1.dp)
            }
        }
    }
}

@Composable
fun InnerPartOfTheCard(alreadyCompleted: Boolean, descriptionStr: String, quantityStr: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(all = 5.dp),
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
                Modifier.padding(top = 2.dp, end = 2.dp, bottom = 2.dp),
                colors = CheckboxDefaults.colors(MaterialTheme.colorScheme.onSurface)
            )
            Text(text = descriptionStr, Modifier.padding(all = 2.dp))
        }

        Text(
            text = quantityStr,
            Modifier.padding(start = 2.dp, top = 2.dp, end = 5.dp, bottom = 2.dp)
        )
    }
}

@Composable
fun ShowButton() {
    Row(
        Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
            .fillMaxWidth(),
    ) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(1f)) {
            Text(text = "Appoint")
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