/*
 * Copyright (c) 201 yvolk (Yuri Volkov), http://yurivolkov.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.andstatus.app.graphics;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * @author yvolk@yurivolkov.com
 */
class StaticCachedDrawable extends CachedDrawable {
    private final Drawable source;

    StaticCachedDrawable(@NonNull Drawable source) {
        super(BitmapDrawable.class.isAssignableFrom(source.getClass()) ?
                ((BitmapDrawable) source).getBitmap() : EMPTY_BITMAP,
                new Rect(0, 0, source.getIntrinsicWidth(), source.getIntrinsicHeight()));
        this.source = source;
    }

    @Override
    public void draw(Canvas canvas) {
        source.draw(canvas);
    }

    @Override
    boolean isBitmapRecyclable() {
        return false;
    }

    @Override
    public Drawable getDrawable() {
        return source;
    }
}