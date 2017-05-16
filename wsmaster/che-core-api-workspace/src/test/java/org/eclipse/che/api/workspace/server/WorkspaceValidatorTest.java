/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.workspace.server;

import org.mockito.testng.MockitoTestNGListener;
import org.testng.annotations.Listeners;

/**
 * Tests for {@link WorkspaceValidator} and {@link WorkspaceValidator}
 *
 * @author Alexander Reshetnyak
 */
@Listeners(MockitoTestNGListener.class)
public class WorkspaceValidatorTest {
// FIXME: spi
//
//    @Mock
//    CheEnvironmentValidator environmentValidator;
//    @InjectMocks
//    WorkspaceValidator      wsValidator;
//
//    @Test
//    public void shouldValidateCorrectWorkspace() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Workspace name required")
//    public void shouldFailValidationIfNameIsNull() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.withName(null);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(dataProvider = "invalidNameProvider",
//          expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Incorrect workspace name, it must be between 3 and 20 characters and may contain digits, " +
//                                            "latin letters, underscores, dots, dashes and should start and end only with digits, " +
//                                            "latin letters or underscores")
//    public void shouldFailValidationIfNameIsInvalid(String name) throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.withName(name);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @DataProvider(name = "invalidNameProvider")
//    public static Object[][] invalidNameProvider() {
//        return new Object[][] {
//                {".name"},
//                {"name."},
//                {"-name"},
//                {"name-"},
//                {"long-name12345678901234567890"},
//                {"_name"},
//                {"name_"}
//        };
//    }
//
//    @Test(dataProvider = "validNameProvider")
//    public void shouldValidateCorrectWorkspaceName(String name) throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.withName(name);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @DataProvider(name = "validNameProvider")
//    public static Object[][] validNameProvider() {
//        return new Object[][] {
//                {"name"},
//                {"quiteLongName1234567"},
//                {"name-with-dashes"},
//                {"name.with.dots"},
//                {"name0with1digits"},
//                {"mixed-symbols.name12"},
//                {"123456"},
//                {"name_name"},
//                {"123-456.78"}
//        };
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Attribute name 'null' is not valid")
//    public void shouldFailValidationIfAttributeNameIsNull() throws Exception {
//        final AccountImpl account = new AccountImpl("accountId", "namespace", "test");
//        final WorkspaceImpl workspace = new WorkspaceImpl("id", account, createConfig());
//        workspace.getAttributes().put(null, "value1");
//
//
//        wsValidator.validateWorkspace(workspace);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Attribute name '' is not valid")
//    public void shouldFailValidationIfAttributeNameIsEmpty() throws Exception {
//        final AccountImpl account = new AccountImpl("accountId", "namespace", "test");
//        final WorkspaceImpl workspace = new WorkspaceImpl("id", account, createConfig());
//        workspace.getAttributes().put("", "value1");
//
//        wsValidator.validateWorkspace(workspace);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Attribute name '.*' is not valid")
//    public void shouldFailValidationIfAttributeNameStartsWithWordCodenvy() throws Exception {
//        final AccountImpl account = new AccountImpl("accountId", "namespace", "test");
//        final WorkspaceImpl workspace = new WorkspaceImpl("id", account, createConfig());
//        workspace.getAttributes().put("codenvy_key", "value1");
//
//        wsValidator.validateWorkspace(workspace);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Workspace default environment name required")
//    public void shouldFailValidationIfDefaultEnvNameIsNull() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.setDefaultEnv(null);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Workspace default environment name required")
//    public void shouldFailValidationIfDefaultEnvNameIsEmpty() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.setDefaultEnv("");
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Workspace default environment configuration required")
//    public void shouldFailValidationIfEnvWithDefaultEnvNameIsNull() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.setEnvironments(null);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Workspace ws-name contains command with null or empty name")
//    public void shouldFailValidationIfCommandNameIsNull() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.getCommands()
//              .get(0)
//              .withName(null);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Workspace ws-name contains command with null or empty name")
//    public void shouldFailValidationIfCommandNameIsEmpty() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.getCommands()
//              .get(0)
//              .withName(null);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Command line required for command '.*'")
//    public void shouldFailValidationIfCommandLineIsNull() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.getCommands()
//              .get(0)
//              .withCommandLine(null);
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    @Test(expectedExceptions = BadRequestException.class,
//          expectedExceptionsMessageRegExp = "Command line required for command '.*'")
//    public void shouldFailValidationIfCommandLineIsEmpty() throws Exception {
//        final WorkspaceConfigDto config = createConfig();
//        config.getCommands()
//              .get(0)
//              .withCommandLine("");
//
//
//        wsValidator.validateConfig(config);
//    }
//
//    private static WorkspaceConfigDto createConfig() {
//        final WorkspaceConfigDto workspaceConfigDto = newDto(WorkspaceConfigDto.class).withName("ws-name")
//                                                                                      .withDefaultEnv("dev-env");
//
//        MachineConfigDto extendedMachine =
//                newDto(MachineConfigDto.class).withAgents(singletonList("org.eclipse.che.ws-agent"))
//                                              .withServers(singletonMap("ref1",
//                                                                          newDto(ServerConfigDto.class).withPort("8080/tcp")
//                                                                                                       .withProtocol("https")))
//                                              .withAttributes(singletonMap("memoryLimitBytes", "1000000"));
//        EnvironmentDto env = newDto(EnvironmentDto.class).withMachines(singletonMap("devmachine1", extendedMachine))
//                                                         .withRecipe(newDto(RecipeDto.class).withType("type")
//                                                                                            .withContent("content")
//                                                                                            .withContentType("content type"));
//        workspaceConfigDto.setEnvironments(singletonMap("dev-env", env));
//
//        List<CommandDto> commandDtos = new ArrayList<>();
//        commandDtos.add(newDto(CommandDto.class).withName("command_name")
//                                                .withType("maven")
//                                                .withCommandLine("mvn clean install")
//                                                .withAttributes(new HashMap<>(singletonMap("cmd-attribute-name",
//                                                                                           "cmd-attribute-value"))));
//        workspaceConfigDto.setCommands(commandDtos);
//
//        return workspaceConfigDto;
//    }
}
