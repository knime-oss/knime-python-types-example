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

import org.knime.node.parameters.legacy.nodeimpl.WebUINodeConfiguration;
import org.knime.node.parameters.legacy.nodeimpl.WebUINodeFactory;
import org.knime.pythonportexample.core.BoundingBoxPortObject;

/**
 * NodeFactory for the BoundingBox Creator Node
 *
 * @author Carsten Haubold, KNIME GmbH, Konstanz, Germany
 */
public class BoundingBoxCreatorNodeFactory extends WebUINodeFactory<BoundingBoxCreatorNodeModel> {
    private static final WebUINodeConfiguration CONFIGURATION = WebUINodeConfiguration.builder() //
        .name("Bounding Box Creator") //
        .icon("node-cog.png") //
        .shortDescription("Creates a BoundingBox with given extent") //
        .fullDescription("""
                Create a BoundingBox by providing the lower and upper bounding values in the dialog
                """) //
        .modelSettingsClass(BoundingBoxCreatorNodeSettings.class) //
        .addOutputPort("Output Bounding Box", BoundingBoxPortObject.TYPE, "Freshly created bounding box") //
        .build();

    /**
     * Default constructor for the node factory.
     */
    public BoundingBoxCreatorNodeFactory() {
        super(CONFIGURATION);
    }

    @Override
    public BoundingBoxCreatorNodeModel createNodeModel() {
        return new BoundingBoxCreatorNodeModel(CONFIGURATION);
    }
}
