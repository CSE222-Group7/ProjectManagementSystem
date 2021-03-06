package ProjectManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import BST.AVLTree;
import BST.BinarySearchTree;

public class Board implements Serializable{
    private int id;
    private static int instanceCount = 0;
    String name = "";
    private List<IssueList> listOfIssueList = new ArrayList<>();
    private AVLTree<User> members = new AVLTree<>();

    public Board() {
        this.id = ++instanceCount;
    }
    public Board(String name){
        this();
        this.name = name;
    }

    public Board(String name, ArrayList<IssueList> issues, AVLTree<User> members) {
        this();
        this.name = name;
        this.listOfIssueList = issues;
        this.members = members;
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /** 
     * @return List<IssueList>
     */
    public List<IssueList> getIssues() {
        return this.listOfIssueList;
    }

    public Issue getIssueByID(int id) {
        for(IssueList issueList : listOfIssueList){
            for(Issue issue : issueList.getIssues()){
                if(issue.getId() == id){
                    return issue;
                }
            }
        }
        return null;
    }

    
    /** 
     * @return AVLTree<User>
     */
    public AVLTree<User> getMembers() {
        return this.members;
    }

    
    /** 
     * @param id
     * @return Board
     */
    public Board id(int id) {
        setId(id);
        return this;
    }

    
    /** 
     * @param issueTitle
     * @return Issue
     */
    public Issue searchIssue(String issueTitle) {
        for (IssueList issueList : listOfIssueList) {
            Issue found = issueList.searchInIssueList(issueTitle);
            if (found != null)
                return found;
        }
        return null;
    }

    
    /** 
     * @param issueList
     * @return boolean
     */
    public boolean addIssueList(IssueList issueList) {
        return listOfIssueList.add(issueList);
    }

    
    /** 
     * @param issue
     * @param index
     * @return boolean
     */
    public boolean addIssue(Issue issue, int index) {
        if (index < listOfIssueList.size()) {
            return listOfIssueList.get(index).addIssue(issue);
        }
        return false;
    }

    
    /** 
     * @param issue
     * @param index
     * @return boolean
     */
    public boolean removeIssue(Issue issue, int index) {
        if (index < listOfIssueList.size()) {
            return listOfIssueList.get(index).deleteIssue(issue.getId());
        }
        return false;
    }

    
    /** 
     * @param target
     * @return BoardMember
     */
    public BoardMember searchMember(BoardMember target) {
        return (BoardMember) members.find(target);
    }

    
    /** 
     * @param member
     * @return boolean
     */
    public boolean addMember(BoardMember member) {
        return members.add(member);
    }

    
    /** 
     * @param member
     * @return boolean
     */
    public boolean removeMember(BoardMember member) {
        return members.remove(member);
    }

    
    /** 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Board)) {
            return false;
        }
        Board board = (Board) o;
        return id == board.id && Objects.equals(listOfIssueList, board.listOfIssueList)
                && Objects.equals(members, board.members);
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, listOfIssueList, members);
    }

    public String membersToString() {
        return getMembers().toString();
    }

    public String boardListToString(List<Board> boards) {
        StringBuilder sb = new StringBuilder();
        for (Board board : boards) {
            sb.append(board.toString(true) + "\n");
        }
        return sb.toString();
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "\\".repeat(38) + "   BoardID: " + getId() + "   " + "/".repeat(38));
        for (IssueList issueList : listOfIssueList) {
            sb.append(issueList.toString() + "\n");
        }
        return sb.toString();
    }

    public String toString(boolean isShort) {
        StringBuilder sb = new StringBuilder();
        sb.append("BoardID: " + getId() + "; Issue Lists: ");
        for (IssueList issueList : listOfIssueList) {
            sb.append(issueList.getTitle() + ", ");
        }
        return sb.toString();
    }

}