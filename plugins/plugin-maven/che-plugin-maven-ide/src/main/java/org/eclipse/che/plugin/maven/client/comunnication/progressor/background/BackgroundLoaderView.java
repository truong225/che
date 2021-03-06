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
package org.eclipse.che.plugin.maven.client.comunnication.progressor.background;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

/**
 * View of {@link BackgroundLoaderPresenter}.
 *
 * @author Valeriy Svydenko
 */
@ImplementedBy(BackgroundLoaderViewImpl.class)
public interface BackgroundLoaderView extends IsWidget {
  interface ActionDelegate {
    /**
     * Performs any actions appropriate in response to the user having clicked the status label.
     * Show more detailed information about the process of resolving.
     */
    void showResolverInfo();
  }

  /** Sets the delegate to receive events from this view. */
  void setDelegate(ActionDelegate delegate);

  /** Hides the loader. */
  void hide();

  /** Shows the loader. */
  void show();

  /**
   * Set label into loader which describes current state of loader.
   *
   * @param text message of the status
   */
  void setOperationLabel(String text);

  /**
   * Change the value of resolved modules of the project.
   *
   * @param percentage value of resolved modules
   */
  void updateProgressBar(int percentage);
}
