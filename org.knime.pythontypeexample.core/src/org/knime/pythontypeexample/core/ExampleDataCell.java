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

import java.io.IOException;
import java.util.Objects;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataCellDataInput;
import org.knime.core.data.DataCellDataOutput;
import org.knime.core.data.DataCellSerializer;

/**
 * Example DataCell that should also be accessible from Python.
 *
 * @author Carsten Haubold, KNIME GmbH, Konstanz, Germany
 */
public final class ExampleDataCell extends DataCell implements ExampleDataValue {

    private static final long serialVersionUID = 1L;

    private final double m_width;

    private final double m_height;

    private final double m_depth;

    /**
     * Create an ExampleDataCell
     * @param width
     * @param height
     * @param depth
     */
    public ExampleDataCell(final double width, final double height, final double depth) {
        m_width = width;
        m_height = height;
        m_depth = depth;
    }

    @Override
    public double getHeight() {
        return m_height;
    }

    @Override
    public double getWidth() {
        return m_width;
    }

    @Override
    public double getDepth() {
        return m_depth;
    }

    @Override
    public double getVolume() {
        return m_width * m_height * m_depth;
    }

    @Override
    public String toString() {
        return String.format("%fm x %fm x %fm", m_width, m_height, m_depth);
    }

    @Override
    protected boolean equalsDataCell(final DataCell dc) {
        var edc = (ExampleDataCell)dc;
        return m_width == edc.m_width && m_height == edc.m_height && m_depth == edc.m_depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_width, m_height, m_depth);
    }

    /**
     * Serializer for {@link ExampleDataCells}s.
     *
     * @noreference This class is not intended to be referenced by clients.
     */
    public static final class CellSerializer implements DataCellSerializer<ExampleDataCell> {
        @Override
        public void serialize(final ExampleDataCell cell, final DataCellDataOutput output) throws IOException {
            output.writeDouble(cell.getWidth());
            output.writeDouble(cell.getHeight());
            output.writeDouble(cell.getDepth());

        }

        @Override
        public ExampleDataCell deserialize(final DataCellDataInput input) throws IOException {
            return new ExampleDataCell(input.readDouble(), input.readDouble(), input.readDouble());
        }
    }

}