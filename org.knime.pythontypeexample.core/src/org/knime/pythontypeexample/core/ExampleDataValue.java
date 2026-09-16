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

import org.knime.core.data.DataValue;


/**
 * ExampleDataValue with box dimensions.
 *
 * @author Carsten Haubold, KNIME GmbH, Konstanz, Germany
 */
public interface ExampleDataValue extends DataValue {
	/**
	 * @return height in m
	 */
	double getHeight();

	/**
	 * @return width in m
	 */
	double getWidth();

	/**
	 * @return depth in m
	 */
	double getDepth();

	/**
	 * @return volume in m^3
	 */
	double getVolume();
}
