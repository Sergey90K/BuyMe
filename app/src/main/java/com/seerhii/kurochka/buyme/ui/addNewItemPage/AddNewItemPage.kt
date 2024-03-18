package com.seerhii.kurochka.buyme.ui.addNewItemPage

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.seerhii.kurochka.buyme.R
import com.seerhii.kurochka.buyme.ui.theme.BuyMeTheme

@Composable
fun AddNewItemPage() {
    LazyColumn {
        item { ShowAddNameField() }
        item { ChoiceQuantity() }
        item { ShowWhenNedIt() }
        item { ShowSomeDetails() }
        item { ShowButtonAddNewItem() }
    }
}

@Composable
fun ShowAddNameField() {
    Row(modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_medium))) {
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = stringResource(R.string.what_you_need_to_buy),
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ChoiceQuantity() {
    Column(Modifier.fillMaxWidth(1F)) {
        Row(
            Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                end = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_double_big),
                bottom = dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            Text(
                text = stringResource(R.string.choice_quantity),
                // style = MaterialTheme.typography.bodyMedium
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundButton(buttonText = stringResource(R.string._1))
            RoundButton(buttonText = stringResource(R.string._2))
            RoundButton(buttonText = stringResource(R.string._3))
            RoundButton(buttonText = stringResource(R.string._4))
            RoundButton(buttonText = stringResource(R.string._5))
            RoundButton(buttonText = stringResource(R.string._6))
            RoundButton(buttonText = stringResource(R.string._7))
        }
        Row(
            Modifier
                .padding(all = dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundBigButton(buttonText = stringResource(R.string._10))
            RoundBigButton(buttonText = stringResource(R.string.x10))
            Row(Modifier.weight(1f, true)) {
                ShowQuantityField()
            }
            Row(Modifier.weight(1f, true)) {
                SelectionMenuChoice()
            }
        }
    }
}

@Composable
fun ShowWhenNedIt() {
    Column() {
        Row(
            Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_medium),
                    top = dimensionResource(id = R.dimen.padding_double_big),
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                )
        ) {
            Text(text = stringResource(R.string.when_do_you_need_it))
        }
        Row(
            Modifier
                .padding(all = dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(stringResource(R.string.someday), style = MaterialTheme.typography.bodyMedium)
                Icon(
                    imageVector = Icons.Filled.Timelapse,
                    contentDescription = stringResource(R.string.someday_icon),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
                )
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = stringResource(R.string.pick_date_icon),
                    modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium))
                )
                Text(
                    stringResource(R.string.pick_date),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ShowSomeDetails() {
    Column {
        Row(
            Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_medium),
                    end = dimensionResource(id = R.dimen.padding_medium),
                    top = dimensionResource(id = R.dimen.padding_double_big),
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                )
        ) {
            Text(text = stringResource(R.string.some_details))
        }
        Row(Modifier.fillMaxWidth()) {
            TextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        text = stringResource(R.string.input_field),
                        style = MaterialTheme.typography.bodyMedium
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = dimensionResource(id = R.dimen.padding_medium))
                    .height(dimensionResource(id = R.dimen.height_input)),
                maxLines = 4
            )
        }
    }
}

@Composable
fun ShowButtonAddNewItem() {
    Row(
        Modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_big),
                end = dimensionResource(id = R.dimen.padding_big),
                top = dimensionResource(id = R.dimen.padding_double_big),
                bottom = dimensionResource(id = R.dimen.padding_big)
            )
            .fillMaxWidth(),
    ) {
        Button(onClick = { }, modifier = Modifier.fillMaxWidth(1f)) {
            Text(text = stringResource(R.string.add_new_items))
        }
    }
}

@Composable
fun ShowQuantityField() {
    TextField(
        value = "500",
        onValueChange = {},
        //shape = CircleShape,
        modifier = Modifier
            .padding(start = dimensionResource(id = R.dimen.padding_small))
            .clip(CircleShape),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowUpward,
                contentDescription = stringResource(R.string.value_icon)
            )
        }
    )
}

@Composable
fun RoundButton(buttonText: String) {
    ElevatedButton(
        onClick = { },
        shape = CircleShape,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.padding_elevated_button))
            .padding(all = dimensionResource(id = R.dimen.padding_one)),
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        Text(buttonText, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun RoundBigButton(buttonText: String) {
    ElevatedButton(
        onClick = { },
        shape = CircleShape,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.padding_round_button))
            .padding(all = dimensionResource(id = R.dimen.padding_one)),
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
    ) {
        Text(buttonText, style = MaterialTheme.typography.bodyMedium)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectionMenuChoice() {
    val options = listOf("pcs", "kg", "m", "sm", "$")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }
    ExposedDropdownMenuBox(
        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
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
            // colors = ExposedDropdownMenuDefaults.textFieldColors(),
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

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun GreetingPreviewTopPanel() {
    BuyMeTheme {
        AddNewItemPage()
    }
}