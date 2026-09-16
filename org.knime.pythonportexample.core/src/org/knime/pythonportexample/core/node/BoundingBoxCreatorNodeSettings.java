/* ------------------------------------------------------------------
 * Copyright (c) KNIME AG, Zurich, Switzerland. All rights reserved.
 *
 * This source code, its documentation and all appendant files
 * are protected by copyright law. All rights reserved.
 *
 * Confidential and proprietary information of KNIME AG.
 * Unauthorized copying, distribution, or use of this file, via
 * any medium, is strictly prohibited without prior written
 * consent from KNIME AG.
 * ---------------------------------------------------------------------
 *
 * History
 *   10 Jul 2025 (chaubold): created
 */
package org.knime.pythonportexample.core.node;

import org.knime.node.parameters.NodeParameters;
import org.knime.node.parameters.Widget;

/**
 * The settings of the Bounding Box Creator Node
 *
 * @author Carsten Haubold, KNIME GmbH, Konstanz, Germany
 */
public class BoundingBoxCreatorNodeSettings implements NodeParameters {

    @Widget(title = "Min X", description = "The lower X coordinate of the bounding box")
    double minX = 0;

    @Widget(title = "Min Y", description = "The lower Y coordinate of the bounding box")
    double minY = 0;

    @Widget(title = "Min Z", description = "The lower Z coordinate of the bounding box")
    double minZ = 0;

    @Widget(title = "Max X", description = "The upper X coordinate of the bounding box")
    double maxX = 0;

    @Widget(title = "Max Y", description = "The upper Y coordinate of the bounding box")
    double maxY = 0;

    @Widget(title = "Max Z", description = "The upper Z coordinate of the bounding box")
    double maxZ = 0;
}