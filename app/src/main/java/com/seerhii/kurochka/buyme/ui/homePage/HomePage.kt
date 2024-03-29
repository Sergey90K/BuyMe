package com.seerhii.kurochka.buyme.ui.homePage

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Shortcut
import androidx.compose.material.icons.automirrored.outlined.Sort
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.DoneOutline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExpandCircleDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.seerhii.kurochka.buyme.R
import com.seerhii.kurochka.buyme.ui.theme.BuyMeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionMenu() {
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5") // owner list
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_small)),
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .clip(CircleShape),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            //label = { Text("Label") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            textStyle = MaterialTheme.typography.labelMedium
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Composable
fun SortedMenu() {
    OutlinedButton(
        onClick = {},
        Modifier
            .size(
                width = dimensionResource(id = R.dimen.icon_width),
                height = dimensionResource(id = R.dimen.icon_height)
            )
            .padding(all = dimensionResource(id = R.dimen.padding_small))
    ) {
        Text(
            stringResource(R.string.most_urgent),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Icon(
            Icons.AutoMirrored.Outlined.Sort,
            contentDescription = stringResource(R.string.most_urgent_icon),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun FirstTape() {
    Row(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            )
            .fillMaxWidth(1f),
        verticalAlignment = Alignment.CenterVertically
        // horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(Modifier.weight(3f, true)) {
            SelectionMenu()
        }
        Row(Modifier.weight(0.5f, true)) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ExpandCircleDown,
                    contentDescription = stringResource(R.string.more_options)
                )
            }
        }
    }
}

@Composable
fun SecondTape() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_medium))
    ) {
        Row(Modifier.weight(1f, true)) {
            SelectionMenu()
        }
        Row(Modifier.weight(1f, true)) {
            SortedMenu()
        }
    }
}

@Composable
fun FirstCard() {
    val data = listOf<Item>(
        Item(
            "Sam text for think",
            "120 pcs",
            "20.03.2024",
            "Stas V",
            "You need to buy something and so on. It is also fashionable for the inscription to be larger than one page."
        ),
        Item(
            "Sam text for think 2",
            "12 pcs",
            "5.05.2020",
            "Serhii V",
            "You need to buy something and so on. It is also fashionable for the inscription to be larger than one page."
        ),
        Item(
            "Sam text for think 3",
            "20 pcs",
            "6.08.2014",
            "Vasja M",
            "You need to buy something and so on. It is also fashionable for the inscription to be larger than one page."
        ),
        Item(
            "Sam text for think 4",
            "50 pcs",
            "29.09.2028",
            "Katja S",
            "You need to buy something and so on. It is also fashionable for the inscription to be larger than one page."
        ),
    )
    Card(
        Modifier.padding(
            start = dimensionResource(id = R.dimen.padding_small),
            end = dimensionResource(id = R.dimen.padding_small),
            top = dimensionResource(id = R.dimen.padding_medium),
            bottom = dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.padding(all = dimensionResource(id = R.dimen.padding_big))) {
                Text(
                    text = stringResource(R.string.to_buy),
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Card(
                Modifier
                    //.fillMaxWidth()
                    .padding(all = dimensionResource(id = R.dimen.padding_medium)),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
            ) {
                Column() {
                    for (it in data) {
                        InnerCardFirst(
                            firstField = it.firstField,
                            secondField = it.secondField,
                            timeField = it.timeField,
                            receiverField = it.receiverField,
                            description = it.descriptionField
                        )
                        HorizontalDivider(thickness = dimensionResource(id = R.dimen.padding_min))
                    }
                }
            }
        }
    }
}

@Composable
fun InnerCardFirst(
    firstField: String,
    secondField: String,
    timeField: String,
    receiverField: String,
    description: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(all = dimensionResource(id = R.dimen.padding_medium))
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = firstField,
                style = MaterialTheme.typography.labelMedium
            )
            Text(text = secondField, style = MaterialTheme.typography.bodyLarge)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Icon(
                imageVector = Icons.Filled.AccessTime,
                contentDescription = stringResource(R.string.execution_time)
            )
            Text(
                text = timeField,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(Modifier.weight(0.5f, true)) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Shortcut,
                    contentDescription = stringResource(R.string.task_received_icon)
                )
                Text(
                    text = receiverField,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
                )
            }
            Row(Modifier.weight(0.5f, true), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.DoneOutline,
                        contentDescription = stringResource(R.string.done_icon)
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(R.string.edit_icon)
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = stringResource(R.string.delete_icon)
                    )
                }
            }
        }
        Text(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_medium)),
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            // color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun InnerCardSecond(
    firstField: String,
    checkboxData: Boolean,
    secondField: String,
    costValue: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_medium)
            )
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = firstField,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
            )
            Checkbox(
                checked = checkboxData,
                onCheckedChange = { },
                modifier = Modifier.paddingFromBaseline(
                    top = dimensionResource(id = R.dimen.padding_zero),
                    bottom = dimensionResource(id = R.dimen.padding_zero)
                ),
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(
                    bottom = dimensionResource(id = R.dimen.padding_big),
                    end = dimensionResource(id = R.dimen.padding_medium)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = secondField,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(text = costValue, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun SecondCard() {
    val data = listOf<ItemBuyed>(
        ItemBuyed("Sams for me", true, " for friend Stas", "$ 5000"),
        ItemBuyed("Sams for me2", false, " for friend Stas2", "$ 50"),
        ItemBuyed("Sams for me3", true, " for friend Stas3", "$ 200"),
        ItemBuyed("Sams for me4", false, " for friend Stas4", "$ 5"),
    )
    Card(
        Modifier.padding(
            start = dimensionResource(id = R.dimen.padding_small),
            end = dimensionResource(id = R.dimen.padding_small),
            top = dimensionResource(id = R.dimen.padding_medium),
            bottom = dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.padding(all = dimensionResource(id = R.dimen.padding_big))) {
                Text(
                    text = stringResource(R.string.buyed),
                    style = MaterialTheme.typography.labelLarge
                )
            }
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(all = dimensionResource(id = R.dimen.padding_medium)),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.scrim)
            ) {
                Column() {
                    for (it in data) {
                        InnerCardSecond(
                            firstField = it.firstField,
                            checkboxData = it.checkboxData,
                            secondField = it.secondField,
                            costValue = it.costValue
                        )
                        HorizontalDivider(thickness = dimensionResource(id = R.dimen.padding_min))
                    }
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    LazyColumn() {
       // item { FirstTape() }
        item { SecondTape() }
        item { FirstCard() }
        item { SecondCard() }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun GreetingPreviewTopPanel() {
    BuyMeTheme {
        HomePage()
    }
}

data class Item(
    val firstField: String,
    val secondField: String,
    val timeField: String,
    val receiverField: String,
    val descriptionField: String
);
data class ItemBuyed(
    val firstField: String,
    val checkboxData: Boolean,
    val secondField: String,
    val costValue: String
);