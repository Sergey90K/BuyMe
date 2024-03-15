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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Row(modifier = Modifier.padding(all = 5.dp)) {
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text(
                    text = "Input what want buy",
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
        Row(Modifier.padding(start = 5.dp, end = 5.dp, top = 35.dp, bottom = 5.dp)) {
            Text(
                text = "Choice quantity",
                //    style = MaterialTheme.typography.bodyMedium
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(all = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundButton(buttonText = "1")
            RoundButton(buttonText = "2")
            RoundButton(buttonText = "3")
            RoundButton(buttonText = "4")
            RoundButton(buttonText = "5")
            RoundButton(buttonText = "6")
            RoundButton(buttonText = "7")
        }
        Row(
            Modifier
                .padding(all = 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundBigButton(buttonText = "+10")
            RoundBigButton(buttonText = "x10")
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
                .padding(start = 5.dp, end = 5.dp, top = 35.dp, bottom = 5.dp)
        ) {
            Text(text = "When do you need it?")
        }
        Row(
            Modifier
                .padding(all = 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 5.dp)
            ) {
                Text("Samtimes", style = MaterialTheme.typography.bodyMedium)
                Icon(
                    imageVector = Icons.Filled.Timelapse,
                    contentDescription = "Localized description",
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = "Localized description",
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text("Pick date", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun ShowSomeDetails() {
    Column {
        Row(
            Modifier
                .padding(start = 5.dp, end = 5.dp, top = 35.dp, bottom = 5.dp)
        ) {
            Text(text = "Some details")
        }
        Row(Modifier.fillMaxWidth()) {
            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Inpun Field", style = MaterialTheme.typography.bodyMedium) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp)
                    .height(150.dp),
                maxLines = 4
            )
        }
    }
}

@Composable
fun ShowButtonAddNewItem() {
    Row(
        Modifier
            .padding(start = 10.dp, end = 10.dp, top = 35.dp, bottom = 10.dp)
            .fillMaxWidth(),
    ) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(1f)) {
            Text(text = "Add new Items")
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
            .padding(start = 2.dp)
            .clip(CircleShape),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowUpward,
                contentDescription = "Localized description"
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
            .size(50.dp)
            .padding(all = 1.dp),
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
            .size(60.dp)
            .padding(all = 1.dp),
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
// We want to react on tap/press on TextField to show menu
    ExposedDropdownMenuBox(
        modifier = Modifier.padding(start = 2.dp),
        expanded = expanded,
        onExpandedChange = { expanded = it },
    ) {
        TextField(
            // The `menuAnchor` modifier must be passed to the text field for correctness.
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