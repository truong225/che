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
package org.eclipse.che.selenium.core.utils;

import java.net.MalformedURLException;
import java.net.URL;

/** @author Alexander Garagatyi */
public class UrlUtil {
  private static final int DEFAULT_HTTP_PORT = 80;
  private static final int DEFAULT_HTTPS_PORT = 443;

  /**
   * Creates {@link URL} using provided parameters.
   *
   * @throws IllegalArgumentException in case URL creation fails because of provided parameters
   */
  public static URL url(String protocol, String host, int port, String path)
      throws IllegalArgumentException {
    if ((DEFAULT_HTTP_PORT == port && "http".equals(protocol))
        || (DEFAULT_HTTPS_PORT == port && "https".equals(protocol))) {
      // prettify URL in case of default port for the protocol
      // -1 should be used in case port is equal to protocol's default one
      port = -1;
    }
    try {
      return new URL(protocol, host, port, path);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private UrlUtil() {}
}
