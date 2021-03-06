package test;

import ProjectManagementSystem.ProjectMember;

import java.util.Calendar;
import java.util.Stack;

import ProjectManagementSystem.Backlog;
import ProjectManagementSystem.Project;
import ProjectManagementSystem.Issue;
import ProjectManagementSystem.Board;

public class ProjectMemberTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DATE, 05);
        c.set(Calendar.YEAR, 2025);
        Stack<Issue> issues = new Stack<>();
        Issue issue1 = new Issue("title0", Issue.Status.development, Issue.Type.bug);
        issue1.setDueDate(c.getTime());
        issue1.setPriority(Issue.Priority.High);
        issue1.setDescription("description1");
        Issue issue2 = new Issue("title1", Issue.Status.development, Issue.Type.bug);
        issue2.setDueDate(c.getTime());
        issue2.setPriority(Issue.Priority.High);
        issue2.setDescription("description2");
        Issue issue3 = new Issue("title2", Issue.Status.development, Issue.Type.bug);
        issue3.setDueDate(c.getTime());
        issue3.setPriority(Issue.Priority.High);
        issue3.setDescription("description3");
        Issue issue4 = new Issue("title3", Issue.Status.development, Issue.Type.bug);
        issue4.setDueDate(c.getTime());
        issue4.setPriority(Issue.Priority.High);
        issue4.setDescription("description4");
        issues.push(issue1);
        issues.push(issue2);
        issues.push(issue3);
        issues.push(issue4);
        Backlog backlog = new Backlog(issues);
        Project project3 = null;
        Project project2 = new Project();
        Project project = new Project(1, "key", "name", "type", null, null,
                null, backlog);
        ProjectMember projectMember = new ProjectMember("username", "fullname",
                1, "teams", project, new Board());
        projectMember.viewBacklog();
        ProjectMember projectMember2 = new ProjectMember("username", "fullname",
                1, "teams", project2, new Board());
        ProjectMember projectMember3 = new ProjectMember("username", "fullname",
                1, "teams", project3, new Board());
        try {
            projectMember2.viewBacklog();
        } catch (Exception e) {
            System.err.println("An error occured when displaying backlog");
        }
        try {
            projectMember.viewProject();
        } catch (Exception e) {
            System.err.println("An error occured when displaying project");
        }
        try {
            projectMember3.viewProject();
        } catch (Exception e) {
            System.err.println("An error occured when displaying project");
        }
    }
}
