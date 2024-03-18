package com.seerhii.kurochka.buyme.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.seerhii.kurochka.buyme.ui.appointToBuyPage.AppointToBuyPage
import com.seerhii.kurochka.buyme.ui.approveDialog.ApproveDialog
import com.seerhii.kurochka.buyme.ui.homePage.HomePage
import com.seerhii.kurochka.buyme.ui.theme.BuyMeTheme
import com.seerhii.kurochka.buyme.ui.topAndBottomPanel.BottomPanel
import com.seerhii.kurochka.buyme.ui.topAndBottomPanel.TopPanel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyMeApp() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopPanel(scrollBehavior) },
        {
            BottomAppBar {
                BottomPanel()
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            HomePage()
           // AddNewItemPage()
           // AppointToBuyPage()
           // ApproveDialog()
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
        BuyMeApp()
    }
}