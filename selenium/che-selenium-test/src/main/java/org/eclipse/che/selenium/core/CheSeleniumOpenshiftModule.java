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
package org.eclipse.che.selenium.core;

import com.google.inject.AbstractModule;
import org.eclipse.che.selenium.core.client.keycloak.cli.KeycloakCliCommandExecutor;
import org.eclipse.che.selenium.core.client.keycloak.cli.OpenShiftKeycloakCliCommandExecutor;
import org.eclipse.che.selenium.core.workspace.CheTestOpenshiftWorkspaceLogsReader;
import org.eclipse.che.selenium.core.workspace.TestWorkspaceLogsReader;

/** @author Dmytro Nochevnov */
public class CheSeleniumOpenshiftModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TestWorkspaceLogsReader.class).to(CheTestOpenshiftWorkspaceLogsReader.class);
    bind(KeycloakCliCommandExecutor.class).to(OpenShiftKeycloakCliCommandExecutor.class);
  }
}
