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
package org.eclipse.che.api.git;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.che.api.git.exception.GitException;
import org.eclipse.che.api.git.shared.ProviderInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Load credentials
 *
 * @author Eugene Voevodin
 */
@Singleton
public class CredentialsLoader {

  private static final Logger LOG = LoggerFactory.getLogger(CredentialsLoader.class);

  private Map<String, CredentialsProvider> credentialsProviders;

  @Inject
  public CredentialsLoader(Set<CredentialsProvider> credentialsProviders) {

    this.credentialsProviders = new HashMap<>(credentialsProviders.size());
    for (CredentialsProvider credentialsProvider : credentialsProviders) {
      this.credentialsProviders.put(credentialsProvider.getId(), credentialsProvider);
    }
  }

  /**
   * Searches for CredentialsProvider instances and if needed instance exists, it return given
   * credentials, else null;
   *
   * @param url given URL
   * @return credentials from provider
   * @throws GitException when it is not possible to store credentials
   */
  public UserCredential getUserCredential(String url) throws GitException {
    for (CredentialsProvider cp : credentialsProviders.values()) {
      if (url != null && cp.canProvideCredentials(url)) {
        UserCredential commandCredentials = cp.getUserCredential();
        if (commandCredentials != null && !commandCredentials.getProviderId().equals(cp.getId())) {
          throw new GitException(
              "Provider "
                  + cp.getId()
                  + " returned credential with wrong id "
                  + commandCredentials.getProviderId());
        }
        LOG.debug("Url {} user {}", url, commandCredentials);
        return commandCredentials;
      }
    }

    return null;
  }

  /**
   * Searches for CredentialsProvider instances by url and if needed instance exists, it asks for
   * info, or return null otherwise.
   *
   * @param url given URL
   * @return credentials from provider
   */
  public ProviderInfo getProviderInfo(String url) {
    for (CredentialsProvider cp : credentialsProviders.values()) {
      if (url != null && cp.canProvideCredentials(url)) {
        return cp.getProviderInfo();
      }
    }
    return null;
  }
}
