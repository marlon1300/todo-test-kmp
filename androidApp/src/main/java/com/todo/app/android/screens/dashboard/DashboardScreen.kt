package com.todo.app.android.screens.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.todo.app.android.stringResource
import com.todo.app.model.DashboardTabItem
import com.todo.app.viewmodel.ToDoViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun DashboardScreen(logout: () -> Unit) {
    val tabBarItems = DashboardTabItem.initData()
    val navController = rememberNavController()
    val context = LocalContext.current
    Scaffold(
        bottomBar = { TabView(0, { }, tabBarItems, navController) },
        floatingActionButton = {
            Box {
                SmallFloatingActionButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(70.dp),
                    shape = CircleShape,
                ) {
                    Icon(Icons.Filled.Add, "")
                }
            }

        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        NavHost(
            navController = navController,
            startDestination = stringResource(tabBarItems[0].title, context = context)
        ) {
            composable(stringResource(tabBarItems[0].title, context = context)) {
                HomeTab()
            }
            composable(stringResource(tabBarItems[1].title, context = context)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(stringResource(tabBarItems[1].title, context = context))
                }
            }
            composable(stringResource(tabBarItems[2].title, context = context)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(stringResource(tabBarItems[2].title, context = context))
                }
            }
            composable(stringResource(tabBarItems[3].title, context = context)) {
                ProfileTab(logout = { logout() })
            }
        }
    }
}

@Composable
fun TabView(
    selectedTab: Int,
    setSelectedTabIndex: (Int) -> Unit,
    tabBarItems: List<DashboardTabItem>,
    navController: NavController,
) {
    var selectedTabIndex by remember { mutableIntStateOf(selectedTab) }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.5.dp)
            .background(MaterialTheme.colorScheme.background)
    )
    NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(selected = selectedTabIndex == index, onClick = {
                setSelectedTabIndex(index)
                selectedTabIndex = index
                navController.navigate(stringResource(tabBarItem.title, context = context))
            }, icon = {
                TabBarIconView(
                    isSelected = selectedTabIndex == index,
                    selectedIcon = tabBarItem.selectedIcon.drawableResId,
                    unselectedIcon = tabBarItem.unselectedIcon.drawableResId,
                    title = stringResource(tabBarItem.title),
                    badgeAmount = tabBarItem.badgeAmount
                )
            }, label = {
                Text(
                    text = stringResource(tabBarItem.title), style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight(400),
                        textAlign = TextAlign.Center,
                    )
                )
            }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Blue,
                selectedTextColor = Color.Blue,
                indicatorColor = Color.Transparent
            )
            )
        }
    }
}

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: Int,
    unselectedIcon: Int,
    title: String,
    badgeAmount: Int? = null,
) {
    BadgedBox(badge = { TabBarBadgeView(badgeAmount) }) {
        Icon(
            imageVector = if (isSelected) {
                ImageVector.vectorResource(selectedIcon)
            } else {
                ImageVector.vectorResource(unselectedIcon)
            }, contentDescription = title
        )
    }
}

@Composable
fun TabBarBadgeView(count: Int? = null) {
    if (count != null) {
        Badge {
            Text(count.toString())
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreen_Preview() {
    DashboardScreen {}
}