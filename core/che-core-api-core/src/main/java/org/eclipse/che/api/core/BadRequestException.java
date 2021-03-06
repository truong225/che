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
package org.eclipse.che.api.core;

import org.eclipse.che.api.core.rest.shared.dto.ServiceError;

/**
 * A {@code BadRequestException} should be thrown when server receives invalid input parameter or
 * missed it.
 *
 * <p>Typically in REST API such errors are converted in HTTP response with status 400.
 *
 * @author Sergii Leschenko
 */
public class BadRequestException extends ApiException {
  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException(ServiceError serviceError) {
    super(serviceError);
  }
}
