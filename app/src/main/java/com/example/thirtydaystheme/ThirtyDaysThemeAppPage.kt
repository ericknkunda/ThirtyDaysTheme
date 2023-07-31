package com.example.thirtydaystheme

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaystheme.datasource.DaysDataSource
import com.example.thirtydaystheme.model.DaysModel
import com.example.thirtydaystheme.ui.theme.ThirtyDaysThemeTheme

class ThirtyDaysThemeAppPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysThemeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}
@Composable
fun ThirtyDaysApp(
    modifier: Modifier =Modifier
){
    ThirtyDaysComponents(dayModelList = DaysDataSource().daysDataSource())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysComponents(
    context : Context? =null,
   dayModelList:List<DaysModel> ,
   modifier: Modifier =Modifier
){
    var isClicked by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar={
           AppTopbar()
        }
    ) { it->
        LazyColumn( contentPadding =it,
            modifier = modifier,
        ) {
            items(dayModelList) { dayItem ->
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = modifier
                        .padding(
                            bottom = 16.dp
                        )
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { isClicked = !isClicked }
                        .background(
                            if (isClicked) {
                                MaterialTheme.colorScheme.onPrimaryContainer
//                                Toast.makeText(context, stringResource(dayItem.DayId)+"is clicked", Toast.LENGTH_LONG).show()
                            } else {
                                MaterialTheme.colorScheme.primary
                            }
                        ),

                    ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                start = 16.dp,
                                bottom = dimensionResource(R.dimen.padding_all),

                                )
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(dayItem.DayId),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(dayItem.DaySummary),
                            style = MaterialTheme.typography.displayMedium,
                            modifier = Modifier,
                        )
                        Box(
                            modifier = Modifier
                                .size(144.dp),
                        ) {
                            Image(
                                painter = painterResource(dayItem.DayImg),
                                contentDescription = stringResource(dayItem.DayId),
                                contentScale = ContentScale.FillWidth,
                                alignment = Alignment.Center,
                                modifier = Modifier
                                    .padding(
                                        top = dimensionResource(R.dimen.pad_top),
                                        bottom = dimensionResource(R.dimen.pad_bottom)
                                    )
                                    .clip(MaterialTheme.shapes.small),


                            )
                        }
                        Text(
                            text = stringResource(dayItem.DayDesc),
                            style = MaterialTheme.typography.displaySmall,
                            modifier = Modifier,
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopbar(
    modifier: Modifier =Modifier
){
    CenterAlignedTopAppBar(title = {
        Row(
            modifier = modifier,
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    })
}
@Preview(showBackground = true)
@Composable
fun DaysPreview(){
    ThirtyDaysThemeTheme {
        ThirtyDaysComponents(
            dayModelList  = DaysDataSource().daysDataSource()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DaysDarkPreview(){
    ThirtyDaysThemeTheme(darkTheme = true){
        ThirtyDaysComponents(
            dayModelList = DaysDataSource().daysDataSource()
            )
    }
}


