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

import org.knime.core.node.ExecutionContext;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.port.PortObject;
import org.knime.core.node.port.PortObjectSpec;
import org.knime.node.parameters.legacy.nodeimpl.WebUINodeConfiguration;
import org.knime.node.parameters.legacy.nodeimpl.WebUINodeModel;
import org.knime.pythonportexample.core.BoundingBoxPortObject;
import org.knime.pythonportexample.core.BoundingBoxPortObject.Point3D;
import org.knime.pythonportexample.core.BoundingBoxPortObjectSpec;

/**
 * Simple node model that creates a port object from the configuration in the dialog
 *
 * @author Carsten Haubold, KNIME GmbH, Konstanz, Germany
 */
public class BoundingBoxCreatorNodeModel extends WebUINodeModel<BoundingBoxCreatorNodeSettings> {

    BoundingBoxCreatorNodeModel(final WebUINodeConfiguration configuration) {
        super(configuration, BoundingBoxCreatorNodeSettings.class);
    }

    @Override
    protected PortObject[] execute( //
        final PortObject[] inObjects, //
        final ExecutionContext exec, //
        final BoundingBoxCreatorNodeSettings modelSettings //
    ) throws Exception {
        return new PortObject[]{ //
            new BoundingBoxPortObject( //
                new Point3D(modelSettings.minX, modelSettings.minY, modelSettings.minZ), //
                new Point3D(modelSettings.maxX, modelSettings.maxY, modelSettings.maxZ) //
            ) //
        };
    }

    @Override
    protected PortObjectSpec[] configure(final PortObjectSpec[] inSpecs, final BoundingBoxCreatorNodeSettings modelSettings)
        throws InvalidSettingsException {
        return new PortObjectSpec[] { new BoundingBoxPortObjectSpec() };
    }
}
