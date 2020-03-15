package com.gottaboy.iching.mybatis.example;

import com.gottaboy.iching.mybatis.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TextEditorConfig.class);
        TextEditor te = ctx.getBean(TextEditor.class);
        te.spellCheck();

        ApplicationContext ctx1 = new AnnotationConfigApplicationContext(ConfigB.class);
        // now both beans A and B will be available...
        SpellChecker a = ctx.getBean(SpellChecker.class);
        Student b = ctx.getBean(Student.class);
    }
}
