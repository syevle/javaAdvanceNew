package javaPractice.sunPractice;


// Q: 1 Given
// 10. class Foo {
// 11. static void alpha() { /* more code here */ }
//        12. void beta() { /* more code here */ }Page 1 of 182Attention:
//        13. }
//        Which two statements are true? (Choose two.)
//        A. Foo.beta() is a valid invocation of beta().
//        B. Foo.alpha() is a valid invocation of alpha().
//        C. Method beta() can directly call method alpha().
//        D. Method alpha() can directly call method beta().
//        Answer: B, C


class Foo {
    static void alpha() { /* more code here */ }
    void beta() {
        alpha();
    }

    public static void main(String sa[]){
        Foo.alpha();
    }
}

