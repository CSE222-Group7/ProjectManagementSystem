package ProjectManagementSystem;

import java.io.Serializable;
import java.util.List;

public class ProjectMember extends BoardMember implements Serializable{
    private Project project;
    public ProjectMember( String username,String fullname, int contact, String teams,
                         Project project, List<Board> assignedBoards){
        super(username,fullname,contact,teams,assignedBoards);
        this.project = project;
    }
    public ProjectMember( String username, String fullname, String password) {
        super( username, fullname, password);
    }
    public ProjectMember( String username,String fullname, int contact, 
                         String teams, Project project, Board assignedBoard){
        super( username, fullname, contact, teams);   
        this.project = project;  
        addBoard(assignedBoard);        
    }
    public void viewBacklog(){
        if(project == null || project.getBacklog() == null){
            System.out.println("There is no backlog to view.");
        }
        else{
            System.out.println(project.getBacklog().toString());
        }
    }
    public void addBoard(Board board){
        if(project == null){
            System.out.println("No project found, board couldn't be added");
        }else{
            project.setBoard(board);
        }
    }
    public void setProject(Project project){
        this.project = project;
    }
    public Project getAssignedProject(){return project;}

    public void viewProject(){
        if(project == null){
            System.out.println("There is no project to view");
            return;
        }
        System.out.println("Project name: "+project.getName());
        System.out.println("Project id: "+project.getId());
        System.out.println("Project key: "+project.getKey());
        System.out.println("Project type: "+project.getType());
        System.out.println("Project Manager of the project: "+project.getProjectManager());
        // binary search tree toString() should be implemented
      //  System.out.println("Project members: "+project.getProjectMembers().toString());
    }
}