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
package org.eclipse.che.security.oauth;

import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.che.api.auth.shared.dto.OAuthToken;
import org.eclipse.che.security.oauth.shared.OAuthTokenProvider;

/** Retrieves oAuth token with help of OAuthAuthenticatorProvider. */
@Singleton
public class OAuthAuthenticatorTokenProvider implements OAuthTokenProvider {
  private final OAuthAuthenticatorProvider oAuthAuthenticatorProvider;

  @Inject
  public OAuthAuthenticatorTokenProvider(OAuthAuthenticatorProvider oAuthAuthenticatorProvider) {
    this.oAuthAuthenticatorProvider = oAuthAuthenticatorProvider;
  }

  @Override
  public OAuthToken getToken(String oauthProviderName, String userId) throws IOException {
    OAuthAuthenticator oAuthAuthenticator =
        oAuthAuthenticatorProvider.getAuthenticator(oauthProviderName);
    OAuthToken token;
    if (oAuthAuthenticator != null && (token = oAuthAuthenticator.getToken(userId)) != null) {
      return token;
    }
    return null;
  }
}
