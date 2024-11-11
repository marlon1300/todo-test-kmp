package com.todo.app.model

import com.todo.app.SharedRes
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource

data class OnboardingData(
    val res: ImageResource,
    val title: StringResource,
    val body: StringResource,
) {
    companion object {
        fun initData(): List<OnboardingData> {
            return listOf(
                OnboardingData(
                    res = SharedRes.images.vec_ic_onboarding_1,
                    title = SharedRes.strings.onboarding_title_1,
                    body = SharedRes.strings.onboarding_body_1
                ),
                OnboardingData(
                    res = SharedRes.images.vec_ic_onboarding_2,
                    title = SharedRes.strings.onboarding_title_2,
                    body = SharedRes.strings.onboarding_body_2
                ),
                OnboardingData(
                    res = SharedRes.images.vec_ic_onboarding_3,
                    title = SharedRes.strings.onboarding_title_3,
                    body = SharedRes.strings.onboarding_body_3
                )
            )
        }
    }
}