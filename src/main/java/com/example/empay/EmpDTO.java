package com.example.empay;
public class EmpDTO {
   private String name;
   private int sal;
   public EmpDTO() {}
   public EmpDTO(String name, int sal) {
       this.name = name;
       this.sal = sal;
   }
   public String getName() {
       return name;
   }
   public int getSal() {
       return sal;
   }
   public void setName(String name) {
       this.name = name;
   }
   public void setSal(int sal) {
       this.sal = sal;
   }
   @Override
   public String toString() {
       return "EmpDTO{name='" + name + "', sal=" + sal + '}';
   }
}
