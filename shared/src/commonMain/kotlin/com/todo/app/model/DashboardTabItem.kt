package com.todo.app.model

import com.todo.app.SharedRes
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource

data class DashboardTabItem(
    val title: StringResource,
    val selectedIcon: ImageResource,
    val unselectedIcon: ImageResource,
    val badgeAmount: Int? = null,
) {
    companion object {
        fun initData(): List<DashboardTabItem> {
            return listOf(
                DashboardTabItem(
                    title = SharedRes.strings.dashboard_tab_home,
                    selectedIcon = SharedRes.images.vec_ic_tab_home_selected,
                    unselectedIcon = SharedRes.images.vec_ic_tab_home
                ),
                DashboardTabItem(
                    title = SharedRes.strings.dashboard_tab_filter,
                    selectedIcon = SharedRes.images.vec_ic_tab_filter_selected,
                    unselectedIcon = SharedRes.images.vec_ic_tab_filter
                ),
                DashboardTabItem(
                    title = SharedRes.strings.dashboard_tab_notification,
                    selectedIcon = SharedRes.images.vec_ic_tab_notification_selected,
                    unselectedIcon = SharedRes.images.vec_ic_tab_notification
                ),
                DashboardTabItem(
                    title = SharedRes.strings.dashboard_tab_profile,
                    selectedIcon = SharedRes.images.vec_ic_tab_profile_selected,
                    unselectedIcon = SharedRes.images.vec_ic_tab_profile
                )
            )
        }
    }
}