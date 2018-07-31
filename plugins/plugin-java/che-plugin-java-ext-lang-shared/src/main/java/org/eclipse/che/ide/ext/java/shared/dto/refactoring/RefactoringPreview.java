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
package org.eclipse.che.ide.ext.java.shared.dto.refactoring;

import java.util.List;
import org.eclipse.che.dto.shared.DTO;

/**
 * Object represent single change during refactoring.
 *
 * @author Evgen Vidolob
 */
@DTO
public interface RefactoringPreview {

  String getId();

  void setId(String id);

  /** Test description of this change */
  String getText();

  void setText(String text);

  /** image for this change */
  String getImage();

  void setImage(String image);

  boolean isEnabled();

  void setEnabled(boolean enabled);

  /** Childrens of this this change, may be null if this change doesn't contains other changes. */
  List<RefactoringPreview> getChildrens();

  void setChildrens(List<RefactoringPreview> childrens);
}
