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
package org.eclipse.che.ide.macro.chooser;

import com.google.gwt.view.client.ListDataProvider;
import org.eclipse.che.ide.api.macro.Macro;
import org.eclipse.che.ide.api.mvp.View;

/**
 * Defines requirements for the view for the macros explorer.
 *
 * @author Artem Zatsarynnyi
 */
public interface MacroChooserView extends View<MacroChooserView.ActionDelegate> {

  /** Show the view. */
  void showDialog();

  /** Close the view. */
  void close();

  /** Bind the given {@code dataProvider} to the view. */
  void bindMacrosList(ListDataProvider<Macro> dataProvider);

  /** The delegate to receive events from this view. */
  interface ActionDelegate {

    /**
     * Called when macro has been chosen.
     *
     * @param macro {@link Macro} which has been chosen
     */
    void onMacroChosen(Macro macro);

    /**
     * Called when filtering macros list is requested.
     *
     * @param filterValue value for filtering the macros list
     */
    void onFilterChanged(String filterValue);
  }
}
