package com.demo.cogent;

public class ConstructorQuestionSet {

}
class A{
    A(){
        System.out.println("A()");
    }
    A(int i){
        System.out.println("A(int)");
    }
}
class F extends A {
    F(){
        System.out.println("F()");
    }
//    F(int i){
//        System.out.println("F(int)");
//    }
    public static void main(String[] args) {
        F f= new F();


    }

}


//25: error
//26: success
//27: iib1 -> iib2 -> D() --- iib1 -> iib2 -> D() ---
//28: iib -> C() -> ---- iib -> C(int) -> ----
//30: 0, 0
//31: test1, test2, 0, 0
//32: I(), ---, I() J()
//33: ----, E(int), ----, -----, E() F(int)
//34:
//35
//36: error need the super() or default constructor
//37:
//38: error
//39: C++ is interesting
//30