/*
 * Copyright (c) 2020. Carlos René Ramos López. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.crrl.beatplayer.ui.transformers

import android.view.View
import com.crrl.beatplayer.ui.transformers.base.BaseTransformer
import kotlin.math.abs

class DepthPageTransformer : BaseTransformer() {

    private val MIN_SCALE = 0.75f

    override fun onTransform(view: View, position: Float) {
        if (position <= 0f) {
            view.translationX = 0f
            view.scaleX = 1f
            view.scaleY = 1f
        } else if (position <= 1f) {
            val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position))
            view.alpha = 1 - position
            view.pivotY = 0.5f * view.height
            view.translationX = view.width * -position
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
        }

    }

    override fun isPagingEnabled() = true
}