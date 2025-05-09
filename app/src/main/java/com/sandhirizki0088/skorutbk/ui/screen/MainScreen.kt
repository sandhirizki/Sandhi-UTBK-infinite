package com.sandhirizki0088.skorutbk.ui.screen

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sandhirizki0088.skorutbk.R
import com.sandhirizki0088.skorutbk.model.Catatan
import com.sandhirizki0088.skorutbk.navigation.Screen
import com.sandhirizki0088.skorutbk.ui.theme.SkorutbkTheme
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val viewModel: MainViewModel = viewModel()
    val daftar = viewModel.catatanList
    Scaffold(

        topBar = {
            TopAppBar(

                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.About.route)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = stringResource(R.string.tentang_aplikasi),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("form/-1")
            }) {
                Icon(Icons.Default.Add, contentDescription = stringResource(R.string.tambah))
            }
        }

    ) { padding ->
        if (daftar.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(R.string.blank))
            }
        } else {
            LazyColumn(contentPadding = padding) {
                items(daftar) { catatan ->
                    ListItem(catatan = catatan, onClick = {
                        navController.navigate("form/${catatan.id}")
                    })
                }
            }
        }

    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    var tpa1 by rememberSaveable { mutableStateOf("") }
    var tpa1Error by rememberSaveable { mutableStateOf(false) }

    var tpa2 by rememberSaveable { mutableStateOf("") }
    var tpa2Error by rememberSaveable { mutableStateOf(false) }

    var tpa3 by rememberSaveable { mutableStateOf("") }
    var tpa3Error by rememberSaveable { mutableStateOf(false) }

    var tpa4 by rememberSaveable { mutableStateOf("") }
    var tpa4Error by rememberSaveable { mutableStateOf(false) }

    var rataRata by rememberSaveable { mutableStateOf<String?>(null) }
    var done by rememberSaveable { mutableStateOf(false) }

    val context = LocalContext.current
    val viewModel: MainViewModel = viewModel()




    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_snpmb),
            contentDescription = stringResource(R.string.logo),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(id = R.string.utbk_intro),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = tpa1,
            onValueChange = {
                tpa1 = it
                tpa1Error = it.isBlank()
            },
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
            onValueChange = {
                tpa2 = it
                tpa2Error = it.isBlank()
            },
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
            onValueChange = {
                tpa3 = it
                tpa3Error = it.isBlank()
            },
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
            onValueChange = {
                tpa4 = it
                tpa4Error = it.isBlank()
            },
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
        Button(
            onClick = {
                val message = if (rataRata != null) {
                    "Hasil rata-rata nilai UTBK-mu: $rataRata"
                } else {
                    "Kamu belum menghitung nilai UTBK-nya nih!"
                }
                shareData(
                    context = context,
                    message = message
                )
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(text = stringResource(R.string.bagikan))
        }


    }

}

@Composable
fun ListItem(catatan: Catatan, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)) {
        Text(catatan.judul, fontWeight = FontWeight.Bold)
        Text("Skor: ${catatan.skor}")
        Text("Tanggal: ${SimpleDateFormat("dd MMM yyyy").format(Date(catatan.tanggal))}")
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun GreetingPreview() {
    SkorutbkTheme {
        MainScreen(rememberNavController())
    }
}

private fun shareData(context: Context, message: String) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(shareIntent)
    }
}