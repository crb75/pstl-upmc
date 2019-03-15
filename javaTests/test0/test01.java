package p;
        
class A { public void ma(){} }
        
class B {
        
            private A a;
        
            public void mb(){ a.ma(); }
}