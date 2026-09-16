
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
 */

package org.knime.pythontypeexample.core;

import org.knime.core.data.DataCell;
import org.knime.core.data.v2.ReadValue;
import org.knime.core.data.v2.ValueFactory;
import org.knime.core.data.v2.WriteValue;
import org.knime.core.table.access.DoubleAccess.DoubleReadAccess;
import org.knime.core.table.access.DoubleAccess.DoubleWriteAccess;
import org.knime.core.table.access.StructAccess.StructReadAccess;
import org.knime.core.table.access.StructAccess.StructWriteAccess;
import org.knime.core.table.schema.DataSpec;
import org.knime.core.table.schema.StructDataSpec;

/**
 * {@link ValueFactory} implementation for ExampleDataCell
 *
 * @author Carsten Haubold, KNIME GmbH, Konstanz, Germany
 */
public final class ExampleValueFactory implements ValueFactory<StructReadAccess, StructWriteAccess> {

    /** A stateless instance of {@link ExampleValueFactory} */
    public static final ExampleValueFactory INSTANCE = new ExampleValueFactory();

    @Override
    public ReadValue createReadValue(final StructReadAccess access) {
        return new DefaultExampleReadValue(access);
    }

    @Override
    public WriteValue<ExampleDataValue> createWriteValue(final StructWriteAccess access) {
        return new DefaultExampleWriteValue(access);
    }

    @Override
    public StructDataSpec getSpec() {
        return new StructDataSpec(DataSpec.doubleSpec(), DataSpec.doubleSpec(), DataSpec.doubleSpec());
    }

    private static final class DefaultExampleReadValue implements ReadValue, ExampleDataValue {
        private final DoubleReadAccess m_width;
        private final DoubleReadAccess m_height;
        private final DoubleReadAccess m_depth;

        private DefaultExampleReadValue(final StructReadAccess access) {
            m_width = access.getAccess(0);
            m_height = access.getAccess(1);
            m_depth = access.getAccess(2);
        }

        @Override
        public DataCell getDataCell() {
            return new ExampleDataCell(m_width.getDoubleValue(), m_height.getDoubleValue(), m_depth.getDoubleValue());
        }

        @Override
        public double getHeight() {
            return m_height.getDoubleValue();
        }

        @Override
        public double getWidth() {
            return m_width.getDoubleValue();
        }

        @Override
        public double getDepth() {
            return m_depth.getDoubleValue();
        }

        @Override
        public double getVolume() {
            return m_width.getDoubleValue() * m_height.getDoubleValue() * m_depth.getDoubleValue();
        }
    }

    private static final class DefaultExampleWriteValue implements WriteValue<ExampleDataValue> {

        private final DoubleWriteAccess m_width;
        private final DoubleWriteAccess m_height;
        private final DoubleWriteAccess m_depth;

        private DefaultExampleWriteValue(final StructWriteAccess access) {
            m_width = access.getWriteAccess(0);
            m_height = access.getWriteAccess(1);
            m_depth = access.getWriteAccess(2);
        }

        @Override
        public void setValue(final ExampleDataValue value) {
            m_width.setDoubleValue(value.getWidth());
            m_height.setDoubleValue(value.getHeight());
            m_depth.setDoubleValue(value.getDepth());
        }

    }
}