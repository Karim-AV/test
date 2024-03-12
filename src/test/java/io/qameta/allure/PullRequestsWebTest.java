package io.qameta.allure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Layer("web")
@Owner("eroshenkoam")
@Feature("Pull Requests")
public class PullRequestsWebTest {

    private static final String OWNER = "allure-framework";
    private static final String REPO = "allure2";

    private static final String BRANCH = "new-feature";

    private final WebSteps steps = new WebSteps();

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }
    
    @Test
    @Microservice("Diamond")
    @Story("Create new brilliant request")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @DisplayName("Creating new brilliant request by authorized user")
    public void shouldCreateBrilliantPullRequest() {
        steps.openBrilliantPullRequestsPage(REPO);
        steps.createBrilliantPullRequestFromBranch();
        steps.shouldSeeBrilliantPullRequestForBranch();
    }
    
    @Test
    @TM4J("AE-T6")
    @Microservice("Billing")
    @Story("Create new pull request")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("smoke")})
    @JiraIssues({@JiraIssue("AE-3")})
    @DisplayName("Creating new pull request by authorized user")
    public void shouldCreatePullRequest() {
        steps.openPullRequestsPage(OWNER, REPO);
        steps.createPullRequestFromBranch(BRANCH);
        steps.shouldSeePullRequestForBranch(BRANCH);
    }

    @Test
    @TM4J("AE-T7")
    @JiraIssue("AE-4")
    @Microservice("Repository")
    @Story("Close existing pull request")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Deleting pull request by authorized user")
    public void shouldClosePullRequest() {
        steps.openPullRequestsPage(OWNER, REPO);
        steps.createPullRequestFromBranch(BRANCH);
        steps.closePullRequestForBranch(BRANCH);
        steps.shouldNotSeePullRequestForBranch(BRANCH);
    }

    @AfterEach
    public void stopDriver() {
        steps.stopDriver();
    }

}
