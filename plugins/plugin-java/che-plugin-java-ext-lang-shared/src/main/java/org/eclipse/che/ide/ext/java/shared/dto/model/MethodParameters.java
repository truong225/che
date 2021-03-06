/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which is available at http://www.eclipse.org/legal/epl-2.0.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ext.java.shared.dto.model;

import org.eclipse.che.dto.shared.DTO;

/**
 * The class provides method parameters (e.g. parameterType parameterName, otherType otherName)
 *
 * @author Dmitry Shnurenko
 */
@DTO
public interface MethodParameters {

  String getMethodName();

  void setMethodName(String methodName);

  /**
   * Returns method parameters. Each parameter of method contains parameter type and parameter name.
   * All parameters are represented as string.
   *
   * @return string representation of parameters (e.g. char x, long y, SomeType z)
   */
  String getParameters();

  void setParameters(String parameters);
}
