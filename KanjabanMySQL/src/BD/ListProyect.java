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
class NodeP{
  private String data;
  private NodeP next;
  
  public NodeP(){
      this.data = "";
      this.next = null;
  }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeP getNext() {
        return next;
    }

    public void setNext(NodeP next) {
        this.next = next;
    }
}


public class ListProyect {
    public NodeP start;
    private int elements;
    
    public ListProyect(){
        start = null;
        elements = 0;
    }
    
    public void insertLatest(String d){
        NodeP newNode = new NodeP(); 
        newNode.setData(d);
        if(empty()){
            start = newNode;
        }else{
            
            NodeP aux = start;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(newNode);
            
        }
        elements++;
    }
    
     
     
    public void editForReferent(String r ,String d){
        if(searchReferent(r)){
           NodeP aux = start;
            
            while(aux.getData()!= r){
                aux = aux.getNext();
            }
            
            aux.setData(d);
        }else{
            
            System.err.println("No existe la referencia dentro de la lista");
            
            
            
        }
        
    }
    
    public String deleteForReferent(String r) throws Exception{
        NodeP aux = start;
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
        NodeP aux = start;
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
            
    
        
        
    
}
