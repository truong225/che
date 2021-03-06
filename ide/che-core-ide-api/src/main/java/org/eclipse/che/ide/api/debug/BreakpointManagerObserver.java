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
package org.eclipse.che.ide.api.debug;

import org.eclipse.che.api.debug.shared.model.Breakpoint;

/** @author Anatoliy Bazko */
public interface BreakpointManagerObserver {

  /** Event happens when breakpoint added. */
  void onBreakpointAdded(Breakpoint breakpoint);

  /** Event happens when breakpoint updated. */
  void onBreakpointUpdated(Breakpoint breakpoint);

  /** Event happens when breakpoint deleted. */
  void onBreakpointDeleted(Breakpoint breakpoint);

  /** Event happens when all breakpoint deleted. */
  void onAllBreakpointsDeleted();
}
