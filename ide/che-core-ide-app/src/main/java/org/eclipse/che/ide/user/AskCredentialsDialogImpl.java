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
package org.eclipse.che.ide.user;

import static org.eclipse.che.api.promises.client.callback.AsyncPromiseHelper.createFromAsyncRequest;
import static org.eclipse.che.ide.util.StringUtils.isNullOrEmpty;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.api.auth.Credentials;
import org.eclipse.che.ide.ui.dialogs.askcredentials.AskCredentialsDialog;
import org.eclipse.che.ide.ui.window.Window;

/**
 * Implementation of {@link AskCredentialsDialog}.
 *
 * @author Igor Vinokur
 */
public class AskCredentialsDialogImpl extends Window implements AskCredentialsDialog {

  private CoreLocalizationConstant localizationConstant;

  interface AskAuthenticatorImplUiBinder extends UiBinder<Widget, AskCredentialsDialogImpl> {}

  private static AskAuthenticatorImplUiBinder uiBinder =
      GWT.create(AskAuthenticatorImplUiBinder.class);

  private AsyncCallback<Credentials> callback;

  @UiField TextBox usernameTextBox;
  @UiField PasswordTextBox passwordTextBox;

  private final Button authenticateButton;

  @Inject
  public AskCredentialsDialogImpl(CoreLocalizationConstant localizationConstant) {
    this.localizationConstant = localizationConstant;
    this.setWidget(uiBinder.createAndBindUi(this));
    this.setTitle(localizationConstant.authorizationDialogTitle());
    authenticateButton =
        addFooterButton(
            localizationConstant.authenticationDialogAuthenticate(),
            "authentication-dialog-authenticate-button",
            event -> onAuthenticateClicked(),
            true);
    addFooterButton(
        localizationConstant.cancel(),
        "authentication-dialog-cancel-button",
        event -> onCancelClicked());
  }

  @Override
  public Promise<Credentials> askCredentials() {
    cleanCredentials();
    showDialog();
    return createFromAsyncRequest(callback1 -> AskCredentialsDialogImpl.this.callback = callback1);
  }

  public void onCancelClicked() {
    callback.onFailure(new Exception(localizationConstant.authenticationDialogRejectedByUser()));
    closeDialog();
  }

  public void onAuthenticateClicked() {
    callback.onSuccess(new Credentials(getUsername(), getPassword()));
    closeDialog();
  }

  public void onCredentialsChanged() {
    setEnabledAuthenticateButton(!isNullOrEmpty(getUsername()) && !isNullOrEmpty(getPassword()));
  }

  public void showDialog() {
    show();
  }

  public void closeDialog() {
    hide();
  }

  public String getUsername() {
    return usernameTextBox.getText();
  }

  public String getPassword() {
    return passwordTextBox.getText();
  }

  public void cleanCredentials() {
    usernameTextBox.setText("");
    passwordTextBox.setText("");
    setEnabledAuthenticateButton(false);
  }

  @UiHandler({"usernameTextBox", "passwordTextBox"})
  void credentialChangeHandler(KeyUpEvent event) {
    onCredentialsChanged();
  }

  public void setEnabledAuthenticateButton(boolean enabled) {
    authenticateButton.setEnabled(enabled);
  }
}
