package com.sandhirizki0088.skorutbk.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sandhirizki0088.skorutbk.R
import com.sandhirizki0088.skorutbk.ui.theme.SkorutbkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        ScreenContent(Modifier.padding((innerPadding)))
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    var tpa1 by remember { mutableStateOf("") }
    var tpa2 by remember { mutableStateOf("") }
    var tpa3 by remember { mutableStateOf("") }
    var tpa4 by remember { mutableStateOf("") }
    var rataRata by remember { mutableStateOf<String?>(null) }
    var done by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.utbk_intro),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = tpa1,
            onValueChange = { tpa1 = it },
            label = { Text(text = stringResource(R.string.tpa1)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = tpa2,
            onValueChange = { tpa2 = it },
            label = { Text(text = stringResource(R.string.tpa2)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = tpa3,
            onValueChange = { tpa3 = it },
            label = { Text(text = stringResource(R.string.tpa3)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = tpa4,
            onValueChange = { tpa4 = it },
            label = { Text(text = stringResource(R.string.tpa4)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()

        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Checkbox(
                checked = done,
                onCheckedChange = { done = it }
            )
            Text(text = stringResource(R.string.done))
        }
        Button(
            onClick = {
                val nilaiList = listOf(tpa1, tpa2, tpa3, tpa4).map { it.toFloatOrNull() }
                if (nilaiList.all { it != null }) {
                    val rata = nilaiList.filterNotNull().average()
                    rataRata = "Rata-rata = %.2f".format(rata)
                } else {
                    rataRata = "Masukkan semua nilai dengan benar!"
                }
            },
            enabled = done,
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(text = rataRata ?: stringResource(R.string.hitung))
        }




    }

}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GreetingPreview() {
    SkorutbkTheme {
        MainScreen()
    }
}