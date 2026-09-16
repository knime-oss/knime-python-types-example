# -*- coding: utf-8 -*-
# ------------------------------------------------------------------------
#  Copyright (c) KNIME AG, Zurich, Switzerland. All rights reserved.
#
#  This source code, its documentation and all appendant files
#  are protected by copyright law. All rights reserved.
#
#  Confidential and proprietary information of KNIME AG.
#  Unauthorized copying, distribution, or use of this file, via
#  any medium, is strictly prohibited without prior written
#  consent from KNIME AG.
# ------------------------------------------------------------------------

"""
PythonValueFactory implementations for pythontypeexample KNIME types.

@author Carsten Haubold, KNIME GmbH, Konstanz, Germany
"""
import knime.api.types as kt


class ExampleValue:
    def __init__(self, width, height, depth):
        self.width = width
        self.height = height
        self.depth = depth

    @property
    def volume(self):
        return self.width * self.height * self.depth

    def __str__(self):
        return f"ExampleValue(width={self.width}m x height={self.height}m x depth={self.depth}m)"


class ExampleValueFactory(kt.PythonValueFactory):
    def __init__(self):
        kt.PythonValueFactory.__init__(self, ExampleValue)

    def decode(self, storage):
        if storage is None:
            return None
        
        # storage is a dictionary here with the struct contents
        return ExampleValue(storage["0"], storage["1"], storage["2"])

    def encode(self, value):
        if value is None:
            return None
        return {"0": value.width, "1": value.height, "2": value.depth}
