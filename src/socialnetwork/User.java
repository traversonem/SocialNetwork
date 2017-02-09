/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;


public class User {
    protected long id;
    protected String name;
    protected String password;
    
    
    public User(long id,String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    
    public void showProfile() {
        System.out.println("Mi chiamo " + name + ". Il mio id e' " + id);
    }
    
    public void showAvatar() {
        System.out.println("*** " + name + " ***");
    }
}
