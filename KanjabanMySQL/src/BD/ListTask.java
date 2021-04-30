/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author GON
 */
class Node{
  private String data;
  private Node next;
  
  public Node(){
      this.data = "";
      this.next = null;
  }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


public class ListTask {
    private Node start;
    private int elements;
    
    public ListTask(){
        start = null;
        elements = 0;
    }
    
    public void insertFirst(String d){
        Node newNode = new Node(); 
        newNode.setData(d);
        if(empty()){
            start = newNode;
        }else{
            newNode.setNext(start);
            start = newNode;
        }
        elements++;
    }
    
    public void insertLatest(String d){
        Node newNode = new Node(); 
        newNode.setData(d);
        if(empty()){
            start = newNode;
        }else{
            
            Node aux = start;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(newNode);
            
        }
        elements++;
    }
    
     public void insertForReferent(String r ,String d){
        Node newNode = new Node(); 
        newNode.setData(d);
        if(searchReferent(r)){
           Node aux = start;
            
            while(aux.getData()!= r){
                aux = aux.getNext();
            }
            Node auxNext = aux.getNext();
            newNode.setNext(auxNext);
            aux.setNext(newNode);
        }else{
            
            System.err.println("No existe la referencia dentro de la lista");
            
            
            
        }
        elements++;
    }
     
    public void editForReferent(String r ,String d){
        if(searchReferent(r)){
           Node aux = start;
            
            while(aux.getData()!= r){
                aux = aux.getNext();
            }
            
            aux.setData(d);
        }else{
            
            System.err.println("No existe la referencia dentro de la lista");
            
            
            
        }
        
    }
    
    public String deleteForReferent(String r) throws Exception{
        Node aux = start;
        if(start.getData().equals(r)){
            start = aux.getNext();
            return r;
        }else{
            if(searchReferent(r)){
            
            while(aux.getNext().getData() != r){
                aux = aux.getNext();
            }
            aux.setNext(aux.getNext().getNext());
            
            
            return r;
           }else{
              System.err.println("No existe la referencia");
              throw new Exception("no existe la referencia");
            }
        }
        
        
        
    }
     
     
    public boolean empty(){
        return start == null;
    }
    
    public boolean searchReferent(String r){
        Node aux = start;
        boolean search = false;
        if(r.equals(aux.getData())){
           return true;
        }else{
            while(aux.getNext()!=null && r!=aux.getData()){
                aux = aux.getNext();
            }
            if(aux.getData().equals(r)){
                search = true;
            }
            return search;
        }
    }
            
    public void viewList(){
        
        if(empty()){
            System.err.println("Lista Vacia");
        }else{
            Node aux = start;
            System.err.println("[Lista]");
            int count = 1;
            while(aux!=null){
            System.err.println(count+") " +aux.getData());
            count++;
            aux = aux.getNext();
            
        }
        }
        
        
    }
}
