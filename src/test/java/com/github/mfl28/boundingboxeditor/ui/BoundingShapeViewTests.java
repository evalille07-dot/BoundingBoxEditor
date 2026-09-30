/*
 * Copyright (C) 2022 Markus Fleischhacker <markus.fleischhacker28@gmail.com>
 *
 * This file is part of Bounding Box Editor
 *
 * Bounding Box Editor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bounding Box Editor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Bounding Box Editor. If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.mfl28.boundingboxeditor.ui;

import com.github.mfl28.boundingboxeditor.model.data.ObjectCategory;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

@Tag("unit")
@ExtendWith(ApplicationExtension.class)
class BoundingShapeViewTests {
    @Test
    void onBoundingBoxMovedAfterTagAdded_ShouldUpdateBoundsOfNodeGroup() {
        final BoundingBoxView boundingBox = new BoundingBoxView(new ObjectCategory("foo", Color.RED));
        boundingBox.setWidth(10);
        boundingBox.setHeight(10);

        final Group nodeGroup = boundingBox.getViewData().getNodeGroup();
        Assertions.assertTrue(nodeGroup.getBoundsInLocal().contains(5, 5));

        boundingBox.getTags().add("tag");
        boundingBox.setX(100);
        boundingBox.setY(100);

        Assertions.assertTrue(nodeGroup.getBoundsInLocal().contains(105, 105), nodeGroup.getBoundsInLocal().toString());

        boundingBox.setX(200);

        Assertions.assertTrue(nodeGroup.getBoundsInLocal().contains(205, 105), nodeGroup.getBoundsInLocal().toString());
    }
}
