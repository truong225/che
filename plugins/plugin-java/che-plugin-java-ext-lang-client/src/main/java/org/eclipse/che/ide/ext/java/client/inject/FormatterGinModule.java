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
package org.eclipse.che.ide.ext.java.client.inject;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.multibindings.GinMultibinder;
import javax.inject.Singleton;
import org.eclipse.che.ide.api.preferences.PreferencePagePresenter;
import org.eclipse.che.ide.ext.java.client.formatter.preferences.FormatterPreferencePagePresenter;
import org.eclipse.che.ide.ext.java.client.formatter.preferences.FormatterPreferencePageView;
import org.eclipse.che.ide.ext.java.client.formatter.preferences.FormatterPreferencePageViewImpl;

public class FormatterGinModule extends AbstractGinModule {
  @Override
  protected void configure() {
    bind(FormatterPreferencePageView.class)
        .to(FormatterPreferencePageViewImpl.class)
        .in(Singleton.class);
    final GinMultibinder<PreferencePagePresenter> prefBinder =
        GinMultibinder.newSetBinder(binder(), PreferencePagePresenter.class);
    prefBinder.addBinding().to(FormatterPreferencePagePresenter.class);
  }
}
